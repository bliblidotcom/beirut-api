package com.gdn.x.beirut.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdn.common.base.domainevent.publisher.DomainEventPublisher;
import com.gdn.common.base.mapper.GdnMapper;
import com.gdn.common.enums.ErrorCategory;
import com.gdn.common.exception.ApplicationException;
import com.gdn.x.beirut.dao.CandidateDAO;
import com.gdn.x.beirut.dao.PositionDAO;
import com.gdn.x.beirut.domain.event.model.CandidateNewInsert;
import com.gdn.x.beirut.domain.event.model.DomainEventName;
import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.CandidateDetail;
import com.gdn.x.beirut.entities.CandidatePosition;
import com.gdn.x.beirut.entities.Position;
import com.gdn.x.beirut.entities.Status;
import com.gdn.x.beirut.entities.StatusLog;

@Service(value = "candidateService")
@Transactional(readOnly = true)
public class CandidateServiceImpl implements CandidateService {

  public static final String ID_SHOULD_NOT_BE_EMPTY = "id should not be empty";

  private static final Logger LOG = LoggerFactory.getLogger(CandidateServiceImpl.class);

  @Autowired
  private CandidateDAO candidateDAO;

  @Autowired
  private PositionDAO positionDAO;

  @Autowired
  private DomainEventPublisher domainEventPublisher;

  @Autowired
  private GdnMapper gdnMapper;

  @Override
  @Transactional(readOnly = false)
  public Candidate applyNewPosition(String candidateId, List<String> positionIds) throws Exception {
    Candidate existingCandidate = getCandidate(candidateId);
    List<Position> positions = positionDAO.findAll(positionIds);
    for (Position position : positions) {
      existingCandidate.getCandidatePositions()
          .add(new CandidatePosition(existingCandidate, position, existingCandidate.getStoreId()));
    }
    return candidateDAO.save(existingCandidate);
  }

  @Override
  @Transactional(readOnly = false)
  public Candidate createNew(Candidate candidate, List<String> positionIds) throws Exception {
    List<Position> positions = positionDAO.findAll(positionIds);
    candidate.setCandidatePositions(new ArrayList<CandidatePosition>());
    if (positions == null || positions.size() == 0) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND, "position not found");
    }
    if (positionIds == null || positionIds.size() == 0) {
      throw new ApplicationException(ErrorCategory.REQUIRED_PARAMETER,
          "position id must not empty");
    }
    for (Position position : positions) {
      candidate.getCandidatePositions()
          .add(new CandidatePosition(candidate, position, candidate.getStoreId()));
    }
    try {
      List<CandidatePosition> candidatePositions = candidate.getCandidatePositions();
      Candidate newCandidate = candidateDAO.save(candidate);
      for (Position position : positions) {
        CandidateNewInsert candidateNewInsert = new CandidateNewInsert();
        BeanUtils.copyProperties(newCandidate, candidateNewInsert, "candidateDetail",
            "candidatePositions");
        BeanUtils.copyProperties(position, candidateNewInsert, "candidatePositions");
        candidateNewInsert.setIdCandidate(newCandidate.getId());
        candidateNewInsert.setIdPosition(position.getId());
        domainEventPublisher.publish(candidateNewInsert, DomainEventName.CANDIDATE_NEW_INSERT,
            CandidateNewInsert.class);
      }
      return newCandidate;
    } catch (RuntimeException e) {
      throw e;
    }
  }

  @Override
  @Deprecated
  public List<Candidate> getAllCandidates() {
    return candidateDAO.findAll();
  }

  @Override
  public Page<Candidate> getAllCandidatesByStoreIdAndMarkForDeletePageable(String storeId,
      boolean markForDelete, Pageable pageable) throws Exception {
    return this.candidateDAO.findByStoreIdAndMarkForDelete(storeId, markForDelete, pageable);
  }

  @Override
  public Page<Candidate> getAllCandidatesByStoreIdPageable(String storeId, Pageable pageable)
      throws Exception {
    return this.candidateDAO.findByStoreId(storeId, pageable);
  }

  @Override
  @Deprecated
  public Page<Candidate> getAllCandidatesWithPageable(String storeId, Pageable pageable) {
    return candidateDAO.findByStoreId(storeId, pageable);
  }

  @Override
  public Candidate getCandidate(String id) throws Exception {
    Candidate candidate = candidateDAO.findOne(id);
    if (candidate == null) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND);
    } else {
      return candidate;
    }
  }

  @Override
  public Candidate getCandidateByIdAndStoreIdEager(String id, String storeId) throws Exception {
    Candidate candidate = this.candidateDAO.findOne(id);
    if (candidate == null || candidate.equals(null)) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND, "id and storeId not found");
    } else {
      if (candidate.getStoreId().equals(storeId)) {
        Hibernate.initialize(candidate.getCandidatePositions());
        return candidate;
      } else {
        throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND, "id not found");
      }
    }
  }

  @Override
  public Candidate getCandidateByIdAndStoreIdLazy(String id, String storeId) throws Exception {
    Candidate candidate = this.candidateDAO.findOne(id);
    if (candidate == null || candidate.equals(null)) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND, "id not found in database");
    } else {
      if (candidate.getStoreId().equals(storeId)) {
        return candidate;
      } else {
        throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND, "id not found in database");
      }
    }
  }

  public CandidateDAO getCandidateDAO() {
    return candidateDAO;
  }

  @Override
  public CandidateDetail getCandidateDetailAndStoreId(String id, String storeId) throws Exception {
    Candidate candidate = getCandidate(id);
    if (candidate.getStoreId().equals(storeId)) {
      Hibernate.initialize(candidate.getCandidateDetail());
      return candidate.getCandidateDetail();
    } else {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND, "data not found, store id");
    }
  }

  @Override
  public CandidatePosition getCandidatePositionByStoreIdWithLogs(String idCandidate,
      String idPosition, String storeId) throws Exception {
    Candidate candidate = this.getCandidate(idCandidate);
    if (!candidate.getStoreId().equals(storeId)) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND,
          "candidate not found by store id");
    }
    Position position = this.positionDAO.findOne(idPosition);
    if (position == null || position.equals(null)) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND, "position not found");
    }
    if (!position.getStoreId().equals(storeId)) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND,
          "position not found by store id");
    }
    Hibernate.initialize(candidate.getCandidatePositions());
    for (CandidatePosition candidatePosition : candidate.getCandidatePositions()) {
      if (candidatePosition.getPosition().getId().equals(position.getId())) {
        Hibernate.initialize(candidatePosition.getStatusLogs());
        return candidatePosition;
      }
    }
    throw new ApplicationException(ErrorCategory.UNSPECIFIED,
        "didn't get equal position in candidate");
  }

  public GdnMapper getGdnMapper() {
    return gdnMapper;
  }

  public PositionDAO getPositionDAO() {
    return positionDAO;
  }

  // Bulk Delete
  @Override
  @Transactional(readOnly = false)
  public void markForDelete(List<String> ids) throws Exception {
    System.out.println(ids.toString());
    for (int i = 0; i < ids.size(); i++) {
      markForDelete(ids.get(i));
    }
  }

  @Override
  public void markForDelete(String id) throws Exception {
    Candidate candidate = this.candidateDAO.findByIdAndMarkForDelete(id, false);
    if (candidate == null) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND, "candidate not found");
    }
    Hibernate.initialize(candidate.getCandidatePositions());
    Iterator<CandidatePosition> iterator = candidate.getCandidatePositions().iterator();
    while (iterator.hasNext()) {
      CandidatePosition candidatePositon = iterator.next();
      candidatePositon.setMarkForDelete(true);
      Hibernate.initialize(candidatePositon.getStatusLogs());
      candidatePositon.getStatusLogs().stream().forEach(statusLog -> {
        statusLog.setMarkForDelete(true);
      });
    }
    candidate.setMarkForDelete(true);
    this.candidateDAO.save(candidate);
  }

  @Override
  public Page<Candidate> searchByCreatedDateBetweenAndStoreId(Date start, Date end, String storeId,
      Pageable pageable) {
    return candidateDAO.findByCreatedDateBetweenAndStoreId(start, end, storeId, pageable);
  }

  @Override
  public Page<Candidate> searchByFirstNameContainAndStoreId(String firstName, String storeId,
      Pageable pageable) throws Exception {
    return this.candidateDAO.findByFirstNameContainingAndStoreId(firstName, storeId, pageable);
  }

  @Override
  public Page<Candidate> searchByLastNameContainAndStoreId(String lastName, String storeId,
      Pageable pageable) {
    return candidateDAO.findByLastNameContainingAndStoreId(lastName, storeId, pageable);
  }


  @Override
  public Candidate searchCandidateByEmailAddressAndStoreId(String emailAddress, String storeId) {
    return candidateDAO.findByEmailAddressAndStoreId(emailAddress, storeId);
  }

  @Override
  @Deprecated
  public List<Candidate> searchCandidateByPhoneNumber(String phoneNumber) {
    return candidateDAO.findByPhoneNumber(phoneNumber);
  }

  @Override
  public Page<Candidate> searchCandidateByPhoneNumberContainAndStoreId(String phoneNumber,
      String storeId, Pageable pageable) {
    return candidateDAO.findByPhoneNumberContainingAndStoreId(phoneNumber, storeId, pageable);
  }

  public void setCandidateDAO(CandidateDAO candidateDAO) {
    this.candidateDAO = candidateDAO;
  }

  public void setGdnMapper(GdnMapper gdnMapper) {
    this.gdnMapper = gdnMapper;
  }

  public void setPositionDAO(PositionDAO positionDAO) {
    this.positionDAO = positionDAO;
  }

  @Override
  @Transactional(readOnly = false)
  public void updateCandidateDetail(String storeId, Candidate candidate) throws Exception {
    if (candidate.getId() != null) {
      Candidate existingCandidate = getCandidate(candidate.getId());
      if (!existingCandidate.getStoreId().equals(storeId)) {
        throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND,
            "data found but no store id match expected = " + existingCandidate.getStoreId()
                + " but was = " + storeId);
      }
      existingCandidate.setFirstName(candidate.getFirstName());
      existingCandidate.setLastName(candidate.getLastName());
      existingCandidate.setEmailAddress(candidate.getEmailAddress());
      existingCandidate.setPhoneNumber(candidate.getPhoneNumber());
      Hibernate.initialize(candidate.getCandidateDetail());
      CandidateDetail existingDetail = existingCandidate.getCandidateDetail();
      existingDetail.setContent(candidate.getCandidateDetail().getContent());
      candidateDAO.save(candidate);
    } else {
      throw new ApplicationException(ErrorCategory.VALIDATION, ID_SHOULD_NOT_BE_EMPTY);
    }
  }

  @Override
  @Transactional(readOnly = false)
  public void updateCandidateStatus(String storeId, String idCandidate, String idPosition,
      Status status) throws Exception {
    Candidate existingCandidate = getCandidate(idCandidate);
    if (!existingCandidate.getStoreId().equals(storeId)) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND,
          "data found but no store id match expected = " + existingCandidate.getStoreId()
              + " but was = " + storeId);
    }
    Position existingPosition = positionDAO.findOne(idPosition);
    Hibernate.initialize(existingCandidate.getCandidatePositions());
    existingCandidate.getCandidatePositions().stream()
        .filter(candidatePosition -> candidatePosition.getPosition().equals(existingPosition))
        .forEach(candidatePosition -> {
          candidatePosition.getStatusLogs().add(new StatusLog(candidatePosition, status));
          candidatePosition.setStatus(status); // add missing setter zal
        });
    candidateDAO.save(existingCandidate);
  }

  @Override
  @Transactional(readOnly = false)
  public void updateCandidateStatusBulk(String storeId, List<String> idCandidates,
      String idPosition, Status status) throws Exception {
    for (String id : idCandidates) {
      this.updateCandidateStatus(storeId, id, idPosition, status);
    }
  }

}

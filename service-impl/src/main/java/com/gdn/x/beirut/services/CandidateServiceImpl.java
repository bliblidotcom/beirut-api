package com.gdn.x.beirut.services;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdn.common.enums.ErrorCategory;
import com.gdn.common.exception.ApplicationException;
import com.gdn.x.beirut.dao.CandidateDAO;
import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.CandidateDetail;
=======
import com.gdn.common.enums.ErrorCategory;
import com.gdn.common.exception.ApplicationException;
import com.gdn.x.beirut.dao.CandidateDAO;
import com.gdn.x.beirut.dao.PositionDAO;
import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.CandidateDetail;
import com.gdn.x.beirut.entities.CandidatePosition;
import com.gdn.x.beirut.entities.Position;
import com.gdn.x.beirut.entities.Status;
import com.gdn.x.beirut.entities.StatusLog;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

@Service(value = "candidateService")
@Transactional(readOnly = true)
public class CandidateServiceImpl implements CandidateService {

<<<<<<< HEAD
  @Autowired
  CandidateDAO candidateDao;

  @Override
  public List<Candidate> findCandidateByEmailAddress(String emailAddress) {
    return this.candidateDao.findByEmailaddress(emailAddress);
  }

  @Override
  public Candidate findCandidateById(String id) {
    return this.candidateDao.findOne(id);
  }

  @Override
  public List<Candidate> findCandidateByPhoneNumber(String phoneNumber) {
    return this.candidateDao.findByPhonenumber(phoneNumber);
  }


  @Override
  public List<Candidate> getAllCandidates() {
    return this.candidateDao.findAll();
=======
  private static final Logger LOG = LoggerFactory.getLogger(CandidateServiceImpl.class);
  private static final String ID_SHOULD_EMPTY_FOR_NEW_RECORD = "id should empty for new record";
  private static final String ID_SHOULD_NOT_BE_EMPTY = "id should not be empty";

  @Autowired
  private CandidateDAO candidateDAO;

  @Autowired
  private PositionDAO positionDAO;

  @Override
  @Transactional(readOnly = false)
  public void applyNewPosition(Candidate candidate, Position position) throws Exception {
    Candidate existingCandidate = getCandidate(candidate.getId());
    existingCandidate.getCandidatePositions().add(new CandidatePosition(candidate, position));
    candidateDAO.save(existingCandidate);
  }

  @Override
  @Transactional(readOnly = false)
  public Candidate createNew(Candidate candidate, Position position) throws Exception {
    if (candidate.getId() == null) {
      CandidatePosition candidatePosition = new CandidatePosition();
      candidatePosition.setCandidate(candidate);
      candidatePosition.setPosition(position);
      candidate.getCandidatePositions().add(candidatePosition);
      return candidateDAO.save(candidate);
    }
    throw new ApplicationException(ErrorCategory.VALIDATION, ID_SHOULD_EMPTY_FOR_NEW_RECORD);
  }

  @Override
  public List<Candidate> getAllCandidateDetailStatus() {
    List<Candidate> candidates = getAllCandidates();
    for (Candidate candidate : candidates) {
      Hibernate.initialize(candidate.getCandidatePositions());
    }
    return candidates;
  }

  @Override
  public List<Candidate> getAllCandidates() {
    return candidateDAO.findAll();
  }

  @Override
  public Page<Candidate> getAllCandidatesWithPageable(Pageable pageable) {
    return candidateDAO.findAll(pageable);
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  @Override
  public Candidate getCandidate(String id) throws Exception {
<<<<<<< HEAD
    // TODO Auto-generated method stub
    final Candidate candidate = this.candidateDao.findOne(id);
=======
    Candidate candidate = candidateDAO.findOne(id);
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
    if (candidate == null) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND);
    } else {
      return candidate;
    }
  }

  @Override
  public CandidateDetail getCandidateDetail(String id) throws Exception {
<<<<<<< HEAD
    // TODO Auto-generated method stub
    final Candidate candidate = this.candidateDao.findOne(id);
    if (candidate == null) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND);
    } else {
      return candidate.getCandidatedetail();
    }
=======
    Candidate candidate = getCandidate(id);
    Hibernate.initialize(candidate.getCandidateDetail());
    return candidate.getCandidateDetail();
  }

  public CandidateDAO getCandidateDAO() {
    return candidateDAO;
  }

  public PositionDAO getPositionDAO() {
    return positionDAO;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  @Override
  @Transactional(readOnly = false)
<<<<<<< HEAD
  public List<Candidate> markForDelete(List<String> id) {
    List<Candidate> candidates = new ArrayList<Candidate>();
    for (int i = 0; i < id.size(); i++) {
      final Candidate candidate = this.candidateDao.findOne(id.get(i));
      candidate.setMarkForDelete(true);
      candidates.add(candidate);
      this.candidateDao.save(candidate);
    }
    return candidates;
  }

  @Override
  @Transactional(readOnly = false)
  public Candidate save(Candidate candidate) {
    return this.candidateDao.save(candidate);
  }

  @Override
  public List<Candidate> searchByFirstname(String firstname) {
    // TODO Auto-generated method stub
    List<Candidate> candidates = new ArrayList<Candidate>();
    candidates = this.candidateDao.findByFirstnameLike(firstname);
    return candidates;
  }

  @Override
  public List<Candidate> searchByLastname(String lastname) {
    // TODO Auto-generated method stub
    List<Candidate> candidates = new ArrayList<Candidate>();
    candidates = this.candidateDao.findByLastnameLike(lastname);
    return candidates;
=======
  public void markForDelete(String id) throws Exception {
    Candidate candidate = getCandidate(id);
    candidate.setMarkForDelete(true);
    candidateDAO.save(candidate);
  }

  @Override
  public List<Candidate> searchByCreatedDateBetween(Date start, Date end) {
    return candidateDAO.findByCreatedDateBetween(start, end);
  }

  @Override
  public List<Candidate> searchByFirstName(String firstname) {
    return candidateDAO.findByFirstNameLike(firstname);
  }

  @Override
  public List<Candidate> searchByLastName(String lastname) {
    return candidateDAO.findByLastNameLike(lastname);
  }

  @Override
  public List<Candidate> searchCandidateByEmailAddress(String emailAddress) {
    return candidateDAO.findByEmailAddress(emailAddress);
  }

  @Override
  public List<Candidate> searchCandidateByPhoneNumber(String phoneNumber) {
    return candidateDAO.findByPhoneNumber(phoneNumber);
  }

  @Override
  public List<Candidate> searchCandidateByPhoneNumberLike(String phoneNumber) {
    return candidateDAO.findByPhoneNumberLike(phoneNumber);
  }

  public void setCandidateDAO(CandidateDAO candidateDAO) {
    this.candidateDAO = candidateDAO;
  }

  public void setPositionDAO(PositionDAO positionDAO) {
    this.positionDAO = positionDAO;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  @Override
  @Transactional(readOnly = false)
<<<<<<< HEAD
  public void setCandidateDetail(String id, CandidateDetail candidateDetail) throws Exception {
    // TODO Auto-generated method stub
    final Candidate candidate = this.candidateDao.findOne(id);
    if (candidate == null) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND);
    } else {
      candidate.setCandidatedetail(candidateDetail);
      this.candidateDao.save(candidate);
    }
  }

=======
  public void updateCandidateDetail(Candidate candidate) throws Exception {
    if (candidate.getId() != null) {
      Candidate existingCandidate = getCandidate(candidate.getId());
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
  public void updateCandidateStatus(Candidate candidate, Position position, Status status) throws Exception {
    Candidate existingCandidate = getCandidate(candidate.getId());
    Position existingPosition = positionDAO.findOne(position.getId());
    Hibernate.initialize(existingCandidate.getCandidatePositions());
    existingCandidate.getCandidatePositions().stream().filter(candidatePosition -> candidatePosition.getPosition().equals(existingPosition)).forEach(candidatePosition -> {
      candidatePosition.getStatusLogs().add(new StatusLog(candidatePosition, status));
    });
    candidateDAO.save(existingCandidate);
  }

  // @Override
  // public boolean setCandidatePositionStatus(String idCandidatePosition, Status newStatus) {
  // // TODO Auto-generated method stub
  // // 1. insert new status log...
  // // 2. update status candidateposition (yang saat ini)
  // CandidatePosition candidatePostition =
  // candidateDAO.findCandidatePositionById(idCandidatePosition);
  // StatusLog newStatusLog = new StatusLog();
  // newStatusLog.setStatus(newStatus);
  // newStatusLog.setCandidatePositions(candidatePostition);
  // return false;
  // }

>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
}

package com.gdn.x.beirut.services;

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

@Service(value = "candidateService")
@Transactional(readOnly = true)
public class CandidateServiceImpl implements CandidateService {

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
  }

  @Override
  public Candidate getCandidate(String id) throws Exception {
    // TODO Auto-generated method stub
    final Candidate candidate = this.candidateDao.findOne(id);
    if (candidate == null) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND);
    } else {
      return candidate;
    }
  }

  @Override
  public CandidateDetail getCandidateDetail(String id) throws Exception {
    // TODO Auto-generated method stub
    final Candidate candidate = this.candidateDao.findOne(id);
    if (candidate == null) {
      throw new ApplicationException(ErrorCategory.DATA_NOT_FOUND);
    } else {
      return candidate.getCandidatedetail();
    }
  }

  @Override
  @Transactional(readOnly = false)
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
  }

  @Override
  @Transactional(readOnly = false)
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

}

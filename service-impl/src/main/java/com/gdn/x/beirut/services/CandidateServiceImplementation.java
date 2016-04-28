package com.gdn.x.beirut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdn.x.beirut.dao.CandidateDAO;
import com.gdn.x.beirut.entities.Candidate;


@Service(value = "candidateService")
@Transactional(readOnly = true)
public class CandidateServiceImplementation implements CandidateService {

  @Autowired
  private CandidateDAO candidateDao;

  @Override
  public List<Candidate> findCandidateByEmailAddress(String emailAddress) {
    return this.getCandidateDao().findByEmailaddress(emailAddress);
  }

  @Override
  public List<Candidate> findCandidateByPhoneNumber(String phoneNumber) {
    return this.getCandidateDao().findByPhonenumber(phoneNumber);
  }

  public CandidateDAO getCandidateDao() {
    return candidateDao;
  }


}

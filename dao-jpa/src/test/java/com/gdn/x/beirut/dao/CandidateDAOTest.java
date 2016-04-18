package com.gdn.x.beirut.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gdn.x.beirut.entity.Candidate;
import com.gdn.x.beirut.entity.CandidateDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
@Transactional(readOnly = false)
public class CandidateDAOTest {
  @Autowired
  private CandidateDAO candidateDAO;

  @Before
  public void initialize() {
    for (int i = 0; i < 10; i++) {
      Candidate newCandidate = new Candidate("1");
      newCandidate.setEmailaddress("egaprianto@asd.com");
      newCandidate.setFirstname("Ega" + i);
      newCandidate.setLastname("Prianto" + i);
      newCandidate.setPhonenumber("123456789" + i);
      CandidateDetail candDetail = new CandidateDetail("1");
      candDetail.setContent("ini PDF+i".getBytes());
      newCandidate.setCandidatedetail(candDetail);
      this.candidateDAO.save(newCandidate);
    }
  }

  @Test
  public void testFindByFirstname() {
    List<Candidate> res = this.candidateDAO.findByFirstname("Ega0");
    Hibernate.initialize(res.get(0).getCandidatedetail());
    Assert.notNull(res.get(0).getFirstname());
    Assert.notNull(res.get(0).getEmailaddress());
    Assert.notNull(res.get(0).getLastname());
    Assert.notNull(res.get(0).getPhonenumber());
    Assert.notNull(res.get(0).getCandidatedetail());
    Assert.isTrue(res.get(0).getFirstname().equals("Ega0"));
  }
}

package com.gdn.x.beirut.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.junit.Assert;
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

import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.CandidateDetail;

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
      candDetail.setContent(("ini PDF"+i).getBytes());
      newCandidate.setCandidatedetail(candDetail);
      this.candidateDAO.save(newCandidate);
    }
  }

  @Test
  public void testFindByFirstname() {
    List<Candidate> res = this.candidateDAO.findByFirstname("Ega0");
    Assert.assertNotNull(res.get(0).getFirstname());
    Assert.assertNotNull(res.get(0).getEmailaddress());
    Assert.assertNotNull(res.get(0).getLastname());
    Assert.assertNotNull(res.get(0).getPhonenumber());
    Assert.assertNotNull(res.get(0).getCandidatedetail());
    Assert.assertTrue(new String(res.get(0).getCandidatedetail().getContent()).equals("ini PDF0"));
    Assert.assertTrue(res.get(0).getFirstname().equals("Ega0"));
  }
  
  @Test(expected=IndexOutOfBoundsException.class)
  public void testFindByFirstnameNoResult(){
	  List<Candidate> res = this.candidateDAO.findByFirstname("asd");
	  res.get(0);
  }
  
  @Test
  public void testFindByEmailaddress(){
	  
  }
  
}

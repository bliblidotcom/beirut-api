package com.ega.dao;

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

import com.ega.entities.Mahasiswa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
@Transactional(readOnly = false)
public class MahasiswaDaoTest {

  @Autowired
  private MahasiswaDao mahasiswaDaoTest;

  private Mahasiswa mahasiswa1;
  private Mahasiswa mahasiswa2;

  @Before
  public void initialize() {
    this.mahasiswa1 = new Mahasiswa();
    this.mahasiswa1.setNama("Fahrizal");
    this.mahasiswa1.setNpm("2013730017");
    this.mahasiswaDaoTest.save(this.mahasiswa1);
    this.mahasiswa2 = new Mahasiswa();
    this.mahasiswa2.setNama("Mohamad");
    this.mahasiswa2.setNpm("2001");
    this.mahasiswaDaoTest.save(this.mahasiswa2);
  }

  @Test
  public void testFindByNama() {
    Assert.assertTrue(this.mahasiswaDaoTest.findByNama("Fahrizal").getNpm() == "2013730017");
    Assert.assertTrue(this.mahasiswaDaoTest.findByNama("Mohamad").getNpm() == "2001");
  }


}

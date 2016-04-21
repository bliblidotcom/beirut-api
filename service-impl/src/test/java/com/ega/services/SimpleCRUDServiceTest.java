package com.ega.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ega.dao.MahasiswaDao;
import com.ega.entities.Mahasiswa;


public class SimpleCRUDServiceTest {

  private static final String ID = "id";
  private static final String ID_ERR = "err";

  private Mahasiswa mahasiswa1;

  @Mock
  private MahasiswaDao mahasiswaDao;

  @InjectMocks
  private SimpleCRUDService simpleCRUD;

  @Before
  public void initialize() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.mahasiswa1 = new Mahasiswa();
    this.mahasiswa1.setNpm("2013");

    Mockito.when(this.mahasiswaDao.findOne(ID)).thenReturn(this.mahasiswa1);
    Mockito.doNothing().when(this.mahasiswaDao).delete(ID);

    Mockito.when(this.mahasiswaDao.findOne(ID_ERR)).thenReturn(null);

    // this.simpleCRUD.getMahasiswaDao(); ini untuk code coverage doang...supaya ke trigger
  }

  @Test
  public void testSimpleCRUDDeleteMahasiswaById() throws Exception {
    this.simpleCRUD.deleteMahasiswaById(ID);
    verify(this.mahasiswaDao, times(1)).delete(this.mahasiswa1);
  }

}

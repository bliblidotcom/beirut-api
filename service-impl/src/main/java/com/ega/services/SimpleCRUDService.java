package com.ega.services;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ega.dao.MahasiswaDao;
import com.ega.entities.Mahasiswa;

@Service(value = "simpleCRUD")
@Transactional(readOnly = true)
public class SimpleCRUDService implements SimpleCRUD {

  @Autowired
  private MahasiswaDao mahasiswaDao;

  @Override
  @Transactional(readOnly = false)
  public Mahasiswa deleteMahasiswaById(Integer id) {
    Mahasiswa tmp = new Mahasiswa();
    Mahasiswa target = this.mahasiswaDao.findOne(id);
    tmp.setId(target.getId());
    tmp.setMataKuliah(target.getMataKuliah());
    tmp.setNama(target.getNama());
    tmp.setNpm(target.getNpm());
    this.mahasiswaDao.delete(target);
    return tmp;
  }

  @Override
  public Mahasiswa findByNama(String nama) {
    return getMahasiswaDao().findByNama(nama);
  }

  @Override
  public Mahasiswa findMahasiswaById(Integer id) {
    return getMahasiswaDao().findOne(id);
  }

  @Override
  // @Transactional(readOnly = false)
  public Mahasiswa findMahasiswaDetail(Integer id) {
    System.out.println("ambil mahasiswa");
    Mahasiswa mahasiswa = mahasiswaDao.findOne(id);
    System.out.println("ambil relasi mahasiswa");
    Hibernate.initialize(mahasiswa.getMataKuliah());
    return mahasiswa;
  }

  @Override
  public List<Mahasiswa> getAllMahasiswa() {
    return this.mahasiswaDao.findAll();
  }

  public MahasiswaDao getMahasiswaDao() {
    return mahasiswaDao;
  }

  @Override
  @Transactional(readOnly = false)
  public void saveMahasiswa(Mahasiswa mahasiswa) {
    getMahasiswaDao().save(mahasiswa);
  }

  public void setMahasiswaDao(MahasiswaDao mahasiswaDao) {
    this.mahasiswaDao = mahasiswaDao;
  }



}

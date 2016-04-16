package com.ega.services;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ega.dao.MahasiswaDao;
import com.ega.dao.MataKuliahDao;
import com.ega.entities.Mahasiswa;
import com.ega.entities.MataKuliah;

@Service(value = "simpleCRUD")
@Transactional(readOnly = true)
public class SimpleCRUDService implements SimpleCRUD {

  @Autowired
  private MahasiswaDao mahasiswaDao;

  @Autowired
  private MataKuliahDao matakuliahDao;

  @Override
  @Transactional(readOnly = false)
  public Mahasiswa addNewMahasiswa(Mahasiswa mahasiswaIn) {
    Mahasiswa saved = this.mahasiswaDao.save(mahasiswaIn);
    return saved;
  }

  @Override
  public Mahasiswa createAndRegisterNewMatakuliahToMahasiswa(Mahasiswa mahasiswaIn,
      MataKuliah matakuliahIn) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  @Transactional(readOnly = false)
  public Mahasiswa deleteMahasiswaById(String id) {
    Mahasiswa tmp = new Mahasiswa();
    Mahasiswa target = this.mahasiswaDao.findOne(id);
    if (target == null) {
      return null;
    }
    tmp.setId(target.getId());
    tmp.setMatakuliahs(target.getMataKuliahs());
    tmp.setNama(target.getNama());
    tmp.setNpm(target.getNpm());
    this.mahasiswaDao.delete(target);
    return tmp;
  }

  @Override
  public Mahasiswa findByNama(String nama) {
    return this.mahasiswaDao.findByNama(nama);
  }

  @Override
  public Mahasiswa findMahasiswaById(String id) {
    return this.mahasiswaDao.findOne(id);
  }

  @Override
  // @Transactional(readOnly = false)
  public Mahasiswa findMahasiswaDetail(String id) {
    System.out.println("ambil mahasiswa");
    Mahasiswa mahasiswa = mahasiswaDao.findOne(id);
    System.out.println("ambil relasi mahasiswa");
    Hibernate.initialize(mahasiswa.getMataKuliahs());
    System.out.println("check get matkul hibernate");
    return mahasiswa;
  }

  @Override
  public List<Mahasiswa> getAllMahasiswa() {
    return this.mahasiswaDao.findAll();
  }

  @Override
  public List<MataKuliah> getAllMataKuliah() {
    // TODO Auto-generated method stub
    return this.matakuliahDao.findAll();
  }

  public MahasiswaDao getMahasiswaDao(String id) {
    return mahasiswaDao;
  }

  @Override
  public MataKuliah getMatakuliahDetail(String id) {
    MataKuliah matkul = this.matakuliahDao.findOne(id);
    if (matkul == null) {
      return null;
    }
    Hibernate.initialize(matkul.getMahasiswa());
    return matkul;
  }

  @Override
  @Transactional(readOnly = false)
  public void saveMahasiswa(Mahasiswa mahasiswa) {
    this.mahasiswaDao.save(mahasiswa);
  }

  @Override
  public void saveMatakuliah(MataKuliah matakuliah) {
    // TODO Auto-generated method stub
    this.matakuliahDao.save(matakuliah);
  }

  public void setMahasiswaDao(MahasiswaDao mahasiswaDao) {
    this.mahasiswaDao = mahasiswaDao;
  }

}

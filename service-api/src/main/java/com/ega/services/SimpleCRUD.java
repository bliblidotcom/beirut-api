package com.ega.services;



import java.util.List;

import com.ega.entities.Mahasiswa;

public interface SimpleCRUD {

  Mahasiswa deleteMahasiswaById(Integer id);

  Mahasiswa findByNama(String nama);

  Mahasiswa findMahasiswaById(Integer id);

  Mahasiswa findMahasiswaDetail(Integer id);

  List<Mahasiswa> getAllMahasiswa();

  void saveMahasiswa(Mahasiswa mahasiswa);
}

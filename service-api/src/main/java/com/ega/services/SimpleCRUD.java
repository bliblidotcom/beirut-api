package com.ega.services;

import java.util.List;

import com.ega.entities.Mahasiswa;

public interface SimpleCRUD {

  Mahasiswa findByNama(String nama);

  Mahasiswa findMahasiswaById(int id);

  Mahasiswa findMahasiswaDetail(int id);

  List<Mahasiswa> getAll();

  void saveMahasiswa(Mahasiswa mahasiswa);
}
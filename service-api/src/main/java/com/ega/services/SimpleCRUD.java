package com.ega.services;



import java.util.List;

import com.ega.entities.Mahasiswa;
import com.ega.entities.MataKuliah;

public interface SimpleCRUD {

  Mahasiswa addNewMahasiswa(Mahasiswa mahasiswaIn);

  Mahasiswa createAndRegisterNewMatakuliahToMahasiswa(Mahasiswa mahasiswaIn,
      MataKuliah matakuliahIn);

  Mahasiswa deleteMahasiswaById(Integer id);

  Mahasiswa findByNama(String nama);

  Mahasiswa findMahasiswaById(Integer id);

  Mahasiswa findMahasiswaDetail(Integer id);

  List<Mahasiswa> getAllMahasiswa();

  void saveMahasiswa(Mahasiswa mahasiswa);
}

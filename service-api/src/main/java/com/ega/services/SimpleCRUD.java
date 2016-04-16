package com.ega.services;



import java.util.List;

import com.ega.entities.Mahasiswa;
import com.ega.entities.MataKuliah;

public interface SimpleCRUD {

  Mahasiswa addNewMahasiswa(Mahasiswa mahasiswaIn);

  Mahasiswa createAndRegisterNewMatakuliahToMahasiswa(Mahasiswa mahasiswaIn,
      MataKuliah matakuliahIn);

  Mahasiswa deleteMahasiswaById(String id);

  Mahasiswa findByNama(String nama);

  Mahasiswa findMahasiswaById(String id);

  Mahasiswa findMahasiswaDetail(String id);

  List<Mahasiswa> getAllMahasiswa();

  List<MataKuliah> getAllMataKuliah();

  MataKuliah getMatakuliahDetail(String id);

  void saveMahasiswa(Mahasiswa mahasiswa);

  void saveMatakuliah(MataKuliah matakuliah);
}

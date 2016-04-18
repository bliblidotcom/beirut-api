package com.ega.helper;

import org.dozer.Mapper;

import com.ega.dto.request.MahasiswaDTORequest;
import com.ega.dto.request.MahasiswaDetailDTORequest;
import com.ega.dto.response.MahasiswaDTOResponse;
import com.ega.dto.response.MahasiswaDetailDTOResponse;
import com.ega.dto.response.MatakuliahDTOResponse;
import com.ega.entities.Mahasiswa;
import com.ega.entities.MataKuliah;

public class MyObjectMapper {


  public static void mapMahasiswaDetailDTORequestToEntity(Mapper dozerMapper,
      MahasiswaDetailDTORequest source, Mahasiswa destination) {
    dozerMapper.map(source, destination);
    if (!source.getMataKuliahs().isEmpty() || source.getMataKuliahs() != null) {
      for (MataKuliah matakuliah : destination.getMataKuliahs()) {
        matakuliah.setMahasiswa(destination);
      }
    }
  }

  public static void mapMahasiswaDTORequestToEntity(Mapper dozerMapper, MahasiswaDTORequest source,
      Mahasiswa destination) {
    dozerMapper.map(source, destination);
  }

  public static void mapMahasiswaEntityToDetailDTOResponse(Mapper dozerMapper, Mahasiswa source,
      MahasiswaDetailDTOResponse destination) {
    dozerMapper.map(source, destination);
    destination.setPrimaryKey(source.getId());
  }

  public static void mapMahasiswaEntityToDTOResponse(Mapper dozerMapper, Mahasiswa source,
      MahasiswaDTOResponse destination) {
    // System.out.println("masuk mapper");
    dozerMapper.map(source, destination);
    // System.out.println("udah di map: " + destination.getPrimaryKey());
    destination.setPrimaryKey(source.getId());
  }

  public static void mapMatakuliahEntityToDTOResponse(Mapper dozerMapper, MataKuliah source,
      MatakuliahDTOResponse destination) {
    dozerMapper.map(source, destination);
    destination.setPrimaryKey(source.getId());
    destination.getMahasiswa().setPrimaryKey(source.getMahasiswa().getId());
  }

}

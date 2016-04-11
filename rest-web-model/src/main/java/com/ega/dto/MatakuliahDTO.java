package com.ega.dto;

import com.gdn.common.web.base.BaseResponse;

public class MatakuliahDTO extends BaseResponse {

  private Integer primaryKey;

  private String nama;

  private String kode;

  private String namaDosen;

  private MahasiswaDTO mahasiswa;

  public MatakuliahDTO() {
    // nothing todo here
  }

  public MatakuliahDTO(String nama, String kode, String namaDosen) {
    this.nama = nama;
    this.kode = kode;
    this.namaDosen = namaDosen;
  }

  public String getKode() {
    return kode;
  }

  public MahasiswaDTO getMahasiswa() {
    return mahasiswa;
  }

  public String getNama() {
    return nama;
  }

  public String getNamaDosen() {
    return namaDosen;
  }

  public Integer getPrimaryKey() {
    return primaryKey;
  }

  public void setKode(String kode) {
    this.kode = kode;
  }

  public void setMahasiswa(MahasiswaDTO mahasiswa) {
    this.mahasiswa = mahasiswa;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public void setNamaDosen(String namaDosen) {
    this.namaDosen = namaDosen;
  }

  public void setPrimaryKey(Integer primaryKey) {
    this.primaryKey = primaryKey;
  }

}

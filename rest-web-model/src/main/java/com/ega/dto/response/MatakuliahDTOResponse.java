package com.ega.dto.response;

import com.gdn.common.web.base.BaseResponse;

public class MatakuliahDTOResponse extends BaseResponse {

  private String primaryKey;

  private String nama;

  private String kode;

  private String namaDosen;

  private MahasiswaDTOResponse mahasiswa;

  public MatakuliahDTOResponse() {
    // nothing todo here
  }

  public MatakuliahDTOResponse(String nama, String kode, String namaDosen) {
    this.nama = nama;
    this.kode = kode;
    this.namaDosen = namaDosen;
  }

  public String getKode() {
    return kode;
  }

  public MahasiswaDTOResponse getMahasiswa() {
    return mahasiswa;
  }

  public String getNama() {
    return nama;
  }

  public String getNamaDosen() {
    return namaDosen;
  }

  public String getPrimaryKey() {
    return primaryKey;
  }

  public void setKode(String kode) {
    this.kode = kode;
  }

  public void setMahasiswa(MahasiswaDTOResponse mahasiswa) {
    this.mahasiswa = mahasiswa;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public void setNamaDosen(String namaDosen) {
    this.namaDosen = namaDosen;
  }

  public void setPrimaryKey(String primaryKey) {
    this.primaryKey = primaryKey;
  }

}

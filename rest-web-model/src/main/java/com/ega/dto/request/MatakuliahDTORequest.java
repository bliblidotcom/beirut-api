package com.ega.dto.request;

import com.ega.dto.response.MahasiswaDTOResponse;
import com.gdn.common.web.base.BaseRequest;

public class MatakuliahDTORequest extends BaseRequest {

  /**
   *
   */
  private static final long serialVersionUID = 1535845237472987908L;

  private String primaryKey;

  private String nama;

  private String kode;

  private String namaDosen;

  private MahasiswaDTOResponse mahasiswa;

  public MatakuliahDTORequest() {
    // nothing todo here
  }

  public MatakuliahDTORequest(String nama, String kode, String namaDosen) {
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

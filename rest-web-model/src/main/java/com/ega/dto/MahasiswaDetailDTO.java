package com.ega.dto;

import java.util.HashSet;
import java.util.Set;

import com.gdn.common.web.base.BaseResponse;


public class MahasiswaDetailDTO extends BaseResponse {

  private Integer primaryKey;

  private String nama;

  private String npm;

  private Set<MatakuliahDTO> mataKuliah = new HashSet<MatakuliahDTO>();

  public MahasiswaDetailDTO() {
    // nothing to do here
  }

  public void addMatakuliah(MatakuliahDTO matakuliah) {
    this.mataKuliah.add(matakuliah);
  }

  public Set<MatakuliahDTO> getMataKuliah() {
    return mataKuliah;
  }

  public String getNama() {
    return nama;
  }

  public String getNpm() {
    return npm;
  }

  public Integer getPrimaryKey() {
    return primaryKey;
  }

  public void setMataKuliah(Set<MatakuliahDTO> mataKuliah) {
    this.mataKuliah = mataKuliah;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public void setNpm(String npm) {
    this.npm = npm;
  }

  public void setPrimaryKey(Integer primaryKey) {
    this.primaryKey = primaryKey;
  }
}

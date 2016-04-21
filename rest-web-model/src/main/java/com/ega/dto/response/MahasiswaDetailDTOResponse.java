package com.ega.dto.response;

import java.util.HashSet;
import java.util.Set;

import com.gdn.common.web.base.BaseResponse;


public class MahasiswaDetailDTOResponse extends BaseResponse {

  private String primaryKey;

  private String nama;

  private String npm;

  private Set<MatakuliahDTOResponse> mataKuliahs = new HashSet<MatakuliahDTOResponse>();

  public MahasiswaDetailDTOResponse() {
    // nothing to do here
  }

  public void addMatakuliah(MatakuliahDTOResponse matakuliah) {
    this.mataKuliahs.add(matakuliah);
  }

  public Set<MatakuliahDTOResponse> getMataKuliahs() {
    return mataKuliahs;
  }

  public String getNama() {
    return nama;
  }

  public String getNpm() {
    return npm;
  }

  public String getPrimaryKey() {
    return primaryKey;
  }

  public void setMataKuliahs(Set<MatakuliahDTOResponse> mataKuliah) {
    this.mataKuliahs = mataKuliah;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public void setNpm(String npm) {
    this.npm = npm;
  }

  public void setPrimaryKey(String primaryKey) {
    this.primaryKey = primaryKey;
  }
}

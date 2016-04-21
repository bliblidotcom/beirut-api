package com.ega.dto.request;

import java.util.HashSet;
import java.util.Set;

import com.gdn.common.web.base.BaseRequest;

public class MahasiswaDetailDTORequest extends BaseRequest {

  /**
   *
   */
  private static final long serialVersionUID = -5077199593730511946L;

  private String primaryKey;

  private String nama;

  private String npm;

  private Set<MatakuliahDTORequest> mataKuliahs = new HashSet<MatakuliahDTORequest>();

  public MahasiswaDetailDTORequest() {
    // nothing to do here
  }

  public void addMatakuliah(MatakuliahDTORequest matakuliah) {
    this.mataKuliahs.add(matakuliah);
  }

  public Set<MatakuliahDTORequest> getMataKuliahs() {
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

  public void setMataKuliahs(Set<MatakuliahDTORequest> mataKuliah) {
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

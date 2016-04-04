package com.ega.dto;

import com.gdn.common.web.base.BaseResponse;

public class MahasiswaDTO extends BaseResponse {
  private Integer primaryKey;

  private String nama;

  private String npm;

  public String getNama() {
    return nama;
  }

  public String getNpm() {
    return npm;
  }

  public Integer getPrimaryKey() {
    return primaryKey;
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

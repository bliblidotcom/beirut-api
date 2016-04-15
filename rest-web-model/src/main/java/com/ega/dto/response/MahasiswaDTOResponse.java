package com.ega.dto.response;

import com.gdn.common.web.base.BaseResponse;

public class MahasiswaDTOResponse extends BaseResponse {
  private String primaryKey;

  private String nama;

  private String npm;

  public String getNama() {
    return nama;
  }

  public String getNpm() {
    return npm;
  }

  public String getPrimaryKey() {
    return primaryKey;
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

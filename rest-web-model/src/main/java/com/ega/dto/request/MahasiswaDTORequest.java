package com.ega.dto.request;

import com.gdn.common.web.base.BaseRequest;

public class MahasiswaDTORequest extends BaseRequest {

  /**
   *
   */
  private static final long serialVersionUID = -1803163592138864832L;

  private String primaryKey;

  private String nama;

  private String npm;

  public MahasiswaDTORequest() {
    // nothing to do here
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

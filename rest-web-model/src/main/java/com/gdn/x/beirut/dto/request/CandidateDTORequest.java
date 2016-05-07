package com.gdn.x.beirut.dto.request;

import com.gdn.common.web.base.BaseRequest;

public class CandidateDTORequest extends BaseRequest {

  private String emailaddress;

  private String firstname;

  private String lastname;

  private String phonenumber;

  private final CandidateDetailDTORequest candidateDetail;

  public CandidateDTORequest(String emailaddress, String firstname, String lastname,
      String phonenumber, CandidateDetailDTORequest candidateDetail) {
    super();
    this.emailaddress = emailaddress;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phonenumber = phonenumber;
    this.candidateDetail = candidateDetail;
  }

  public CandidateDetailDTORequest getCandidateDetail() {
    return candidateDetail;
  }

  public String getEmailaddress() {
    return emailaddress;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setEmailaddress(String emailaddress) {
    this.emailaddress = emailaddress;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }


}

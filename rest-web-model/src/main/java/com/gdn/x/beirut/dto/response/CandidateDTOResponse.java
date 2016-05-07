package com.gdn.x.beirut.dto.response;

import com.gdn.common.web.base.BaseResponse;

public class CandidateDTOResponse extends BaseResponse {

  private String emailaddress;

  private String firstname;

  private String lastname;

  private String phonenumber;

  private CandidateDetailDTOResponse candidateDetail;


  public CandidateDTOResponse() {}

  public CandidateDTOResponse(String emailaddress, String firstname, String lastname,
      String phonenumber, CandidateDetailDTOResponse candidateDetail) {
    super();
    this.emailaddress = emailaddress;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phonenumber = phonenumber;
    this.candidateDetail = candidateDetail;
  }

  public CandidateDetailDTOResponse getCandidateDetail() {
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

package com.gdn.x.beirut.dto.response;

import com.gdn.common.web.base.BaseResponse;

public class CandidateDTOResponse extends BaseResponse {

<<<<<<< HEAD
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

=======
  private CandidateDetailDTOResponse candidateDetail;
  private String emailAddress;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private boolean markForDelete;
  // private Set<CandidatePositionDTOResponse> candidatePositions;

  public CandidateDetailDTOResponse getCandidateDetail() {
    return candidateDetail;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public boolean isMarkForDelete() {
    return markForDelete;
  }

  public void setCandidateDetail(CandidateDetailDTOResponse candidateDetail) {
    this.candidateDetail = candidateDetail;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setMarkForDelete(boolean markForDelete) {
    this.markForDelete = markForDelete;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

}

package com.gdn.x.beirut.dto.request;

import com.gdn.common.web.base.BaseRequest;

public class CandidateDTORequest extends BaseRequest {

<<<<<<< HEAD
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
=======
  private CandidateDetailDTORequest candidateDetail;
  private String emailAddress;
  private String firstName;
  private String lastName;
  private String phoneNumber;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

  public CandidateDetailDTORequest getCandidateDetail() {
    return candidateDetail;
  }

<<<<<<< HEAD
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

  public void setCandidateDetail(CandidateDetailDTORequest candidateDetail) {
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

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

}

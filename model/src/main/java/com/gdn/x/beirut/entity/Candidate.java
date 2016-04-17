
package com.gdn.x.beirut.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.gdn.common.base.entity.GdnBaseEntity;

@Entity
@Table(name = "Candidate")
public class Candidate extends GdnBaseEntity {

  public static final String EMAIL_ADDRESS = "EMAIL_ADDRESS";

  public static final String FIRST_NAME = "FIRST_NAME";

  public static final String LAST_NAME = "LAST_NAME";

  public static final String PHONE_NUMBER = "PHONE_NUMBER";

  @OneToOne(mappedBy = "Candidate")
  private CandidateDetail candidateDetail;

  @Column(name = Candidate.EMAIL_ADDRESS)
  private String emailAddress;

  @Column(name = Candidate.FIRST_NAME)
  private String firstName;

  @Column(name = Candidate.LAST_NAME)
  private String lastName;

  @Column(name = Candidate.PHONE_NUMBER)
  private String phoneNumber;

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
}

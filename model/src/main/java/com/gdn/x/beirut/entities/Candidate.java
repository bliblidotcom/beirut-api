package com.gdn.x.beirut.entities;

import com.gdn.common.base.entity.GdnBaseEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = Candidate.TABLE_NAME)
public class Candidate extends GdnBaseEntity {

  public static final String TABLE_NAME = "candidate";
  public static final String COLUMN_EMAIL_ADDRESS = "email_address";
  public static final String COLUMN_FIRST_NAME = "first_name";
  public static final String COLUMN_LAST_NAME = "last_name";
  public static final String COLUMN_PHONE_NUMBER = "phone_number";

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
  private CandidateDetail candidateDetail;

  @Column(name = Candidate.COLUMN_EMAIL_ADDRESS)
  private String emailAddress;

  @Column(name = Candidate.COLUMN_FIRST_NAME)
  private String firstName;

<<<<<<< HEAD
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
  private CandidateDetail candidatedetail;
=======
  @Column(name = Candidate.COLUMN_LAST_NAME)
  private String lastName;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

  @Column(name = Candidate.COLUMN_PHONE_NUMBER)
  private String phoneNumber;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
  private Set<CandidatePosition> candidatePositions = new HashSet<CandidatePosition>();

  public Candidate() {
    //nothing to do here
//    setId(UUID.randomUUID().toString());
  }

  public CandidateDetail getCandidateDetail() {
    return candidateDetail;
  }

<<<<<<< HEAD
  // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidate")
  // private Set<CandidatePosition> candidatePositions;

  public Candidate(String STORE_ID) {
    super();
    this.setStoreId(STORE_ID);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Candidate other = (Candidate) obj;
    if (candidatedetail == null) {
      if (other.candidatedetail != null)
        return false;
    } else if (!candidatedetail.equals(other.candidatedetail))
      return false;
    if (emailaddress == null) {
      if (other.emailaddress != null)
        return false;
    } else if (!emailaddress.equals(other.emailaddress))
      return false;
    if (firstname == null) {
      if (other.firstname != null)
        return false;
    } else if (!firstname.equals(other.firstname))
      return false;
    if (lastname == null) {
      if (other.lastname != null)
        return false;
    } else if (!lastname.equals(other.lastname))
      return false;
    if (phonenumber == null) {
      if (other.phonenumber != null)
        return false;
    } else if (!phonenumber.equals(other.phonenumber))
      return false;
    return true;
  }

  // public Set<CandidatePosition> getCandidatePositions() {
  // return candidatePositions;
  // }

  public CandidateDetail getCandidatedetail() {
    return this.candidatedetail;
=======
  public Set<CandidatePosition> getCandidatePositions() {
    return candidatePositions;
  }

  public String getEmailAddress() {
    return emailAddress;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
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

  public void setCandidateDetail(CandidateDetail candidateDetail) {
    this.candidateDetail = candidateDetail;
  }

<<<<<<< HEAD
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((candidatedetail == null) ? 0 : candidatedetail.hashCode());
    result = prime * result + ((emailaddress == null) ? 0 : emailaddress.hashCode());
    result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
    result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
    result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
    return result;
  }

  public void setCandidatedetail(CandidateDetail candidatedetail) {
    this.candidatedetail = candidatedetail;
  }

  // public void setCandidatePositions(Set<CandidatePosition> candidatePositions) {
  // this.candidatePositions = candidatePositions;
  // }

  public void setEmailaddress(String emailaddress) {
    this.emailaddress = emailaddress;
=======
  public void setCandidatePositions(Set<CandidatePosition> candidatePositions) {
    this.candidatePositions = candidatePositions;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
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

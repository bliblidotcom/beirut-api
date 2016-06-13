package com.gdn.x.beirut.entities;

<<<<<<< HEAD
import java.util.Arrays;
=======
import com.gdn.common.base.entity.GdnBaseEntity;

import java.io.Serializable;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

<<<<<<< HEAD
import com.gdn.common.base.entity.GdnBaseEntity;

=======
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
@Entity
@Table(name = CandidateDetail.TABLE_NAME)
public class CandidateDetail implements Serializable {

  public static final String TABLE_NAME = "candidate_detail";
  public static final String COLUMN_CONTENT = "content";

  @Id
  private String id;

  @Column(name = CandidateDetail.COLUMN_CONTENT)
  private byte[] content;

  public CandidateDetail() {
    //nothing to do here
  }

  public CandidateDetail(Candidate candidate) {
    this.candidate = candidate;
  }

<<<<<<< HEAD
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    final CandidateDetail other = (CandidateDetail) obj;
    if (candidate == null) {
      if (other.candidate != null)
        return false;
    } else if (!candidate.equals(other.candidate))
      return false;
    if (!Arrays.equals(content, other.content))
      return false;
    return true;
  }

  public Candidate getCandidate() {
    return candidate;
  }


  public byte[] getContent() {
    return this.content;
=======
  @MapsId
  @OneToOne
  @JoinColumn(name = GdnBaseEntity.ID)
  private Candidate candidate;

  public Candidate getCandidate() {
    return candidate;
  }

  public byte[] getContent() {
    return content;
  }

  public String getId() {
    return id;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

<<<<<<< HEAD

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((candidate == null) ? 0 : candidate.hashCode());
    result = prime * result + Arrays.hashCode(content);
    return result;
  }


  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }


=======
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  public void setContent(byte[] content) {
    this.content = content;
  }

  public void setId(String id) {
    this.id = id;
  }
}

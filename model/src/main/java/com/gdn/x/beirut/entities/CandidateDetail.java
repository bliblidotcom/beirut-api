package com.gdn.x.beirut.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.gdn.common.base.entity.GdnBaseEntity;

@Entity
@Table(name = CandidateDetail.TABLE_NAME)
public class CandidateDetail implements Serializable {

  public static final String TABLE_NAME = "candidate_detail";
  public static final String COLUMN_CONTENT = "content";

  @Id
  private String id;

  @Column(name = CandidateDetail.COLUMN_CONTENT)
  private byte[] content;

  @MapsId
  @OneToOne
  @JoinColumn(name = GdnBaseEntity.ID)
  private Candidate candidate;

  public CandidateDetail() {
    // nothing to do here
  }



  public CandidateDetail(Candidate candidate) {
    this.candidate = candidate;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public byte[] getContent() {
    return content;
  }

  public String getId() {
    return id;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }


  public void setContent(byte[] content) {
    this.content = content;
  }

  public void setId(String id) {
    this.id = id;
  }
}

package com.gdn.x.beirut.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.gdn.common.base.entity.GdnBaseEntity;

public class CandidateDetail extends GdnBaseEntity {

  public static final String CANDIDATE_ID = "CANDIDATE_ID";

  public static final String CONTENT = "CONTENT";

  @Column(name = CandidateDetail.CONTENT)
  private byte[] content;

  @OneToOne
  @JoinColumn(name = CandidateDetail.CANDIDATE_ID)
  private Candidate idCandidate;

  public byte[] getContent() {
    return content;
  }


  public Candidate getIdCandidate() {
    return idCandidate;
  }


  public void setContent(byte[] content) {
    this.content = content;
  }


  public void setIdCandidate(Candidate idCandidate) {
    this.idCandidate = idCandidate;
  }

}

package com.gdn.x.beirut.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.gdn.common.base.entity.GdnBaseEntity;

public class CandidateDetail extends GdnBaseEntity {

  public static final String CANDIDATE_ID = "candidate";

  public static final String CONTENT = "content";

  @OneToOne
  @JoinColumn(name = CandidateDetail.CANDIDATE_ID)
  private Candidate candidate;

  @Column(name = CandidateDetail.CONTENT)
  private byte[] content;

  public byte[] getContent() {
    return content;
  }


  public Candidate getIdCandidate() {
    return candidate;
  }


  public void setContent(byte[] content) {
    this.content = content;
  }


  public void setIdCandidate(Candidate idCandidate) {
    candidate = idCandidate;
  }

}

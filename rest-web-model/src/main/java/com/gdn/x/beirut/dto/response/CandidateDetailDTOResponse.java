package com.gdn.x.beirut.dto.response;

import com.gdn.x.beirut.dto.request.CandidateDTORequest;

public class CandidateDetailDTOResponse {
  private CandidateDTORequest candidate;

  private byte[] content;

  public CandidateDTORequest getCandidate() {
    return candidate;
  }

  public byte[] getContent() {
    return content;
  }

  public void setCandidate(CandidateDTORequest candidate) {
    this.candidate = candidate;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

}

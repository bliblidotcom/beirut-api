package com.gdn.x.beirut.dto.request;

import com.gdn.common.web.base.BaseRequest;

public class CandidateDetailDTORequest extends BaseRequest {
<<<<<<< HEAD
  private CandidateDTORequest candidate;

  private byte[] content;

  public CandidateDTORequest getCandidate() {
    return candidate;
  }

=======

  private byte[] content;

>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  public byte[] getContent() {
    return content;
  }

<<<<<<< HEAD
  public void setCandidate(CandidateDTORequest candidate) {
    this.candidate = candidate;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }


=======
  public void setContent(byte[] content) {
    this.content = content;
  }
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
}

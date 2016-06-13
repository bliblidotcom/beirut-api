package com.gdn.x.beirut.dto.response;

<<<<<<< HEAD
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
=======
import com.gdn.common.web.base.BaseResponse;

public class CandidateDetailDTOResponse extends BaseResponse {
  private byte[] content;

  public CandidateDetailDTOResponse() {
    super();
  }

  public CandidateDetailDTOResponse(String STORE_ID) {
    super();
    this.setStoreId(STORE_ID);
  }

  public byte[] getContent() {
    return content;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

}

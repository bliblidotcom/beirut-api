package com.gdn.x.beirut.dto.response;

<<<<<<< HEAD
import java.util.Set;

import com.gdn.common.web.base.BaseResponse;

public class PositionDTOResponse extends BaseResponse {
  private String id;
  private String title;
  private boolean markForDelete;

  private Set<CandidatePositionDTORequest> candreqs;

  public Set<CandidatePositionDTORequest> getCandreqs() {
    return candreqs;
  }

  @Override
  public String getId() {
    return id;
  }
=======
import com.gdn.common.web.base.BaseResponse;

public class PositionDTOResponse extends BaseResponse {
  private String title;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

  public String getTitle() {
    return title;
  }

<<<<<<< HEAD
  public boolean isMarkForDelete() {
    return markForDelete;
  }

  public void setCandreqs(Set<CandidatePositionDTORequest> candreqs) {
    this.candreqs = candreqs;
  }

  @Override
  public void setId(String id) {
    this.id = id;
  }

  public void setMarkForDelete(boolean markForDelete) {
    this.markForDelete = markForDelete;
  }

=======
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  public void setTitle(String title) {
    this.title = title;
  }
}

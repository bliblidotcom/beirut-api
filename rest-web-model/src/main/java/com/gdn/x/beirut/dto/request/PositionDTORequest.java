package com.gdn.x.beirut.dto.request;

<<<<<<< HEAD
import java.util.Set;

import com.gdn.common.web.base.BaseRequest;

public class PositionDTORequest extends BaseRequest {
  private String title;

  private Set<CandidatePositionDTORequest> candpos;

  public Set<CandidatePositionDTORequest> getCandpos() {
    return candpos;
=======
import com.gdn.common.web.base.BaseRequest;

public class PositionDTORequest extends BaseRequest {

  private String title;
  private String id;

  public String getId() {
    return id;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  public String getTitle() {
    return title;
  }

<<<<<<< HEAD
  public void setCandpos(Set<CandidatePositionDTORequest> candpos) {
    this.candpos = candpos;
=======
  public void setId(String id) {
    this.id = id;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  public void setTitle(String title) {
    this.title = title;
  }
}

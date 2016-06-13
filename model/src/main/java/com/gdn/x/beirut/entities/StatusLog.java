package com.gdn.x.beirut.entities;

import com.gdn.common.base.entity.GdnBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
<<<<<<<HEAD @Table(name="StatusLog")public class StatusLog extends GdnBaseEntity {


  @ManyToOne
  @JoinColumn(name = "candidatePosition")
  =======@Table(name = StatusLog.TABLE_NAME)
  public class StatusLog extends GdnBaseEntity {

    public static final String TABLE_NAME = "status_log";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_CANDIDATE_POSITION_ID = "candidate_position_id";

    @Column(name = COLUMN_STATUS)
    @Enumerated(EnumType.STRING)
    private Status status;

  @ManyToOne
  @JoinColumn(name = COLUMN_CANDIDATE_POSITION_ID)
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  private CandidatePosition candidatePosition;

    public StatusLog() {
      // nothing to do here
    }

    <<<<<<<HEAD @Column(name="newStatus")@Enumerated(EnumType.STRING)

    private Status getNewStatus() {
      return newStatus;
    }

  @Column(name = "oldStatus")
  @Enumerated(EnumType.STRING)
  private Status getOldStatus() {
    return oldStatus;
=======

    public StatusLog(CandidatePosition candidatePosition, Status status) {
      this.candidatePosition = candidatePosition;
      this.status = status;
    }

  public CandidatePosition getCandidatePosition() {
    return candidatePosition;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = super.hashCode();
      result = prime * result + ((candidatePosition == null) ? 0 : candidatePosition.hashCode());
      result = prime * result + ((status == null) ? 0 : status.hashCode());
      return result;
    }

    <<<<<<<HEAD

    public void setNewStatus(Status newStatus) {
      this.newStatus = newStatus;
    }

  public void setOldStatus(Status oldStatus) {
    this.oldStatus = oldStatus;
=======

    public void setCandidatePosition(CandidatePosition candidatePostition) {
      this.candidatePosition = candidatePostition;
    }

  public void setStatus(Status newStatus) {
    this.status = newStatus;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }
}

@Column(name = "oldStatus")
private Status oldStatus;

@Column(name = "newStatus")
  private Status newStatus;

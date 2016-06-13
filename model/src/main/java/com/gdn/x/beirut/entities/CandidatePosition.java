package com.gdn.x.beirut.entities;

<<<<<<< HEAD
=======
import com.gdn.common.base.entity.GdnBaseEntity;

import java.util.HashSet;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< HEAD
=======
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

<<<<<<< HEAD
import com.gdn.common.base.entity.GdnBaseEntity;

@Entity
@Table(name = "CandidatePosition")
public class CandidatePosition extends GdnBaseEntity {

	@Column(name = "status")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "candidatePosition")
	private Set<StatusLog> statusLogs;
	
	public Set<StatusLog> getStatusLogs() {
		return statusLogs;
	}

	public void setStatusLogs(Set<StatusLog> statusLogs) {
		this.statusLogs = statusLogs;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
=======
@Entity
@Table(name = CandidatePosition.TABLE_NAME)
public class CandidatePosition extends GdnBaseEntity {

  public static final String TABLE_NAME = "candidate_position";
  public static final String COLUMN_STATUS = "status";
  public static final String COLUMN_POSITION_ID = "position_id";
  public static final String COLUMN_CANDIDATE_ID = "candidate_id";

  @Column(name = COLUMN_STATUS)
  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToOne
  @JoinColumn(name = COLUMN_POSITION_ID)
  private Position position;

  @ManyToOne
  @JoinColumn(name = COLUMN_CANDIDATE_ID)
  private Candidate candidate;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "candidatePosition")
  private Set<StatusLog> statusLogs = new HashSet<StatusLog>();

  public CandidatePosition() {
    this.status = Status.APPLY;
  }

  public CandidatePosition(Candidate candidate, Position position) {
    this.candidate = candidate;
    this.position = position;
    this.status = Status.APPLY;
  }

  public Candidate getCandidate() {
    return candidate;
  }

  public Position getPosition() {
    return position;
  }

  public Status getStatus() {
    return status;
  }

  public Set<StatusLog> getStatusLogs() {
    return statusLogs;
  }

  public void setCandidate(Candidate candidate) {
    this.candidate = candidate;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setStatusLogs(Set<StatusLog> statusLogs) {
    this.statusLogs = statusLogs;
  }

>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
}

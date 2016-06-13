package com.gdn.x.beirut.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gdn.common.base.entity.GdnBaseEntity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name= Position.TABLE_NAME)
public class Position extends GdnBaseEntity {

  public static final String TABLE_NAME = "position";
  public static final String COLUMN_TITLE = "title";

  @Column(name= Position.COLUMN_TITLE)
  private String title;

<<<<<<< HEAD
  @Column(name="candidatePosition")
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="position")
  private Set<CandidatePosition> candidatePosition= new HashSet<CandidatePosition>();

  public Position(String STORE_ID){
    super();
=======
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="position")
  private Set<CandidatePosition> candidatePositions = new HashSet<CandidatePosition>();

  public Position(){
    //nothing to do here
  }

  public void addCandidatePosition(CandidatePosition candpos){
    this.candidatePositions.add(candpos);
  }

  public Set<CandidatePosition> getCandidatePositions() {
    return candidatePositions;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  public void addCandidatePosition(CandidatePosition candpos){
    this.candidatePosition.add(candpos);
  }

  public Set<CandidatePosition> getCandidatePosition() {
    return candidatePosition;
  }

  public String getTitle() {
    return title;
  }

<<<<<<< HEAD
  public void setCandidatePosition(Set<CandidatePosition> candpos){
    this.candidatePosition=candpos;
=======
  public void setCandidatePositions(Set<CandidatePosition> candidatePositions){
    this.candidatePositions =candidatePositions;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  public void setTitle(String title) {
    this.title = title;
  }
}

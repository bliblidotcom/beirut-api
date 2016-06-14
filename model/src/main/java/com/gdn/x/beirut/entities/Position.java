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
@Table(name = Position.TABLE_NAME)
public class Position extends GdnBaseEntity {

  public static final String TABLE_NAME = "position";
  public static final String COLUMN_TITLE = "title";

  @Column(name = Position.COLUMN_TITLE)
  private String title;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "position")
  private Set<CandidatePosition> candidatePositions = new HashSet<CandidatePosition>();

  public Position() {
    // nothing to do here
  }

  public void addCandidatePosition(CandidatePosition candpos) {
    this.candidatePositions.add(candpos);
  }

  public void addCandidatePosition(CandidatePosition candpos) {
    this.candidatePosition.add(candpos);
  }

  public Set<CandidatePosition> getCandidatePosition() {
    return candidatePosition;
  }

  public Set<CandidatePosition> getCandidatePositions() {
    return candidatePositions;
  }

  public String getTitle() {
    return title;
  }

  public void setCandidatePositions(Set<CandidatePosition> candidatePositions) {
    this.candidatePositions = candidatePositions;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}

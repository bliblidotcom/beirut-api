package com.gdn.x.beirut.services;

<<<<<<< HEAD
import java.util.List;

import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.CandidateDetail;

public interface CandidateService {
  List<Candidate> findCandidateByEmailAddress(String emailAddress);

  Candidate findCandidateById(String id);

  List<Candidate> findCandidateByPhoneNumber(String phoneNumber);

  List<Candidate> getAllCandidates();

=======

import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.CandidateDetail;
import com.gdn.x.beirut.entities.Position;
import com.gdn.x.beirut.entities.Status;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface CandidateService {
  void applyNewPosition(Candidate candidate, Position position) throws Exception;

  Candidate createNew(Candidate candidate, Position position) throws Exception;

  List<Candidate> getAllCandidateDetailStatus();

  List<Candidate> getAllCandidates();

  Page<Candidate> getAllCandidatesWithPageable(Pageable pageable);

>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  Candidate getCandidate(String id) throws Exception;

  CandidateDetail getCandidateDetail(String id) throws Exception;

<<<<<<< HEAD
  List<Candidate> markForDelete(List<String> id);

  Candidate save(Candidate candidate);

  List<Candidate> searchByFirstname(String firstname);

  List<Candidate> searchByLastname(String lastname);

  void setCandidateDetail(String id, CandidateDetail candidateDetail) throws Exception;

=======
  void markForDelete(String id) throws Exception;

  List<Candidate> searchByCreatedDateBetween(Date start, Date end);

  List<Candidate> searchByFirstName(String firstname);

  List<Candidate> searchByLastName(String lastname);

  List<Candidate> searchCandidateByEmailAddress(String emailAddress);

  List<Candidate> searchCandidateByPhoneNumber(String phoneNumber);

  List<Candidate> searchCandidateByPhoneNumberLike(String phoneNumber);

  void updateCandidateDetail(Candidate candidate) throws Exception;

  void updateCandidateStatus(Candidate candidate, Position position, Status status) throws Exception;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
}

package com.gdn.x.beirut.services;

import java.util.List;

import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.CandidateDetail;

public interface CandidateService {
  List<Candidate> findCandidateByEmailAddress(String emailAddress);

  Candidate findCandidateById(String id);

  List<Candidate> findCandidateByPhoneNumber(String phoneNumber);

  List<Candidate> getAllCandidates();

  Candidate getCandidate(String id) throws Exception;

  CandidateDetail getCandidateDetail(String id) throws Exception;

  List<Candidate> markForDelete(List<String> id);

  Candidate save(Candidate candidate);

  List<Candidate> searchByFirstname(String firstname);

  List<Candidate> searchByLastname(String lastname);

  void setCandidateDetail(String id, CandidateDetail candidateDetail) throws Exception;

}

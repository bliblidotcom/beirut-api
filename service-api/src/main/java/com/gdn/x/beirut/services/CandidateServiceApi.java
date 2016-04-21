package com.gdn.x.beirut.services;

import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.Status;

public interface CandidateServiceApi {
	
	Candidate save(Candidate candidate);
	
	void update(String id,Candidate candidate);
	
	void markForDeleteCandidate(String id);
	
	void markForDeleteCandidatePosition(String id);
	
	void updateCandidatePositionStatus(String id,Status newStatus);
	
}

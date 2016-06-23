package com.gdn.x.beirut.services.listener;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import com.gdn.common.base.domainevent.subscriber.DomainEventListener;
import com.gdn.common.base.domainevent.subscriber.SubscribeDomainEvent;
import com.gdn.common.base.mapper.GdnMapper;
import com.gdn.x.beirut.domain.event.model.CandidateNewInsert;
import com.gdn.x.beirut.domain.event.model.DomainEventName;
import com.gdn.x.beirut.solr.dao.CandidatePositionSolrRepository;
import com.gdn.x.beirut.solr.entities.CandidatePositionSolr;

@Service
@SubscribeDomainEvent(DomainEventName.CANDIDATE_NEW_INSERT)
public class CandidateInsertNewEventListener implements DomainEventListener<CandidateNewInsert> {

  @Autowired
  private CandidatePositionSolrRepository candidatePositionSolrRepository;

  @Resource(name = "xcandidatePositionTemplate")
  private SolrTemplate candidatePositionTemplate;

  @Autowired
  private GdnMapper gdnMapper;

  @Override
  public void onDomainEventConsumed(CandidateNewInsert message) throws Exception {
    CandidatePositionSolr newCandidateSolr =
        gdnMapper.deepCopy(message, CandidatePositionSolr.class);
    candidatePositionTemplate.saveBean(newCandidateSolr);
    System.out.println(newCandidateSolr);
  }

  public CandidatePositionSolrRepository getCandidatePositionSolrRepository() {
    return candidatePositionSolrRepository;
  }

  public void setCandidatePositionSolrRepository(CandidatePositionSolrRepository candidatePositionSolrRepository) {
    this.candidatePositionSolrRepository = candidatePositionSolrRepository;
  }
}
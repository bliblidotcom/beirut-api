package com.gdn.x.beirut.services.listener;

import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

import com.gdn.common.base.domainevent.subscriber.DomainEventListener;
import com.gdn.common.base.domainevent.subscriber.SubscribeDomainEvent;
import com.gdn.common.base.mapper.GdnMapper;
import com.gdn.x.beirut.domain.event.model.CandidateNewInsert;
import com.gdn.x.beirut.domain.event.model.DomainEventName;
import com.gdn.x.beirut.solr.entities.CandidatePositionSolr;

@Service
@SubscribeDomainEvent(DomainEventName.CANDIDATE_NEW_INSERT)
public class CandidateInsertNewEventListener implements DomainEventListener<CandidateNewInsert> {

  private static final Logger LOG = LoggerFactory.getLogger(CandidateInsertNewEventListener.class);

  @Resource(name = "xcandidatePositionTemplate")
  private SolrTemplate candidatePositionTemplate;

  @Autowired
  private GdnMapper gdnMapper;

  @Override
  public void onDomainEventConsumed(CandidateNewInsert message) throws Exception {
    LOG.info("consuming message from kafka : {}", new Object[] {message});
    CandidatePositionSolr newCandidateSolr =
        gdnMapper.deepCopy(message, CandidatePositionSolr.class);
    newCandidateSolr.setId(UUID.randomUUID().toString());
    candidatePositionTemplate.saveBean(newCandidateSolr);
    candidatePositionTemplate.commit();
  }
}

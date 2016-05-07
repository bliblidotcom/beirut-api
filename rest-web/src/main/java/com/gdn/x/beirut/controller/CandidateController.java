package com.gdn.x.beirut.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.x.beirut.dto.request.CandidateDTORequest;
import com.gdn.x.beirut.dto.response.CandidateDTOResponse;
import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.CandidateDetail;
import com.gdn.x.beirut.services.CandidateService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api/candidate/")
@Api(value = "CandidateController", description = "Controller untuk Candidate")
public class CandidateController {

  @Autowired
  private CandidateService candidateService;

  @Autowired
  private Mapper dozerMapper;

  @RequestMapping(value = "/deleteCandidate", method = RequestMethod.POST)
  @ApiOperation(value = "delete candidate dengan id value")
  @ResponseBody
  public GdnRestSingleResponse<CandidateDTOResponse> deleteCandidateById(
      @RequestParam String storeId, @RequestParam String channelId, @RequestParam String clientId,
      @RequestParam String requestId, @RequestParam String username,
      @RequestParam List<String> id) {
    final Candidate deleted = new Candidate(storeId);
    List<Candidate> candidates = new ArrayList<Candidate>();
    candidates = candidateService.markForDelete(id);
    final CandidateDTOResponse deletedCandidateDTO = new CandidateDTOResponse();
    dozerMapper.map(deleted, deletedCandidateDTO);
    final GdnRestSingleResponse<CandidateDTOResponse> gdnDeletedCandidate =
        new GdnRestSingleResponse<>(deletedCandidateDTO, requestId);
    return gdnDeletedCandidate;
  }

  public Mapper getDozerMapper() {
    return dozerMapper;
  }

  @RequestMapping(value = "/insertCandidate", method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "simpan 1 Candidate", notes = "")
  @ResponseBody
  public GdnRestSingleResponse<CandidateDTOResponse> saveCandidate(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam String username, @RequestBody CandidateDTORequest newCandidate) {
    Candidate dest = new Candidate(storeId);
    dozerMapper.map(newCandidate, dest);
    if (newCandidate.getCandidateDetail() != null) {
      CandidateDetail cd = new CandidateDetail(storeId);
      dozerMapper.map(newCandidate.getCandidateDetail(), cd);
      dest.setCandidatedetail(cd);
    }
    this.candidateService.save(dest);

    CandidateDTOResponse resDTO = new CandidateDTOResponse();
    dozerMapper.map(dest, resDTO);
    return new GdnRestSingleResponse<>(resDTO, requestId);
  }

  public void setDozerMapper(Mapper dozerMapper) {
    this.dozerMapper = dozerMapper;
  }

  @RequestMapping(value = "/updateCandidate", method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "update Candidate dengan id value")
  @ResponseBody
  public GdnRestSingleResponse<CandidateDTOResponse> updateCandidate(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam String username, @RequestParam String id,
      @RequestBody CandidateDTORequest candidate) {
    final Candidate dest = this.candidateService.findCandidateById(id);
    dozerMapper.map(candidate, dest);
    final CandidateDTOResponse updatedCandidateDTO = new CandidateDTOResponse();
    dozerMapper.map(dest, updatedCandidateDTO);
    final GdnRestSingleResponse<CandidateDTOResponse> gdnUpdatedCandidate =
        new GdnRestSingleResponse<>(updatedCandidateDTO, requestId);
    return gdnUpdatedCandidate;
  }
}

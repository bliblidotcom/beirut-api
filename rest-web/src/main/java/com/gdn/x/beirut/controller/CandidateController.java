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

<<<<<<< HEAD
import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.x.beirut.dto.request.CandidateDTORequest;
import com.gdn.x.beirut.dto.response.CandidateDTOResponse;
import com.gdn.x.beirut.entities.Candidate;
import com.gdn.x.beirut.entities.CandidateDetail;
=======
import com.gdn.common.web.wrapper.response.GdnBaseRestResponse;
import com.gdn.common.web.wrapper.response.GdnRestListResponse;
import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.common.web.wrapper.response.PageMetaData;
import com.gdn.x.beirut.dto.request.CandidateDTORequest;
import com.gdn.x.beirut.dto.response.CandidateDTOResponse;
import com.gdn.x.beirut.entities.Candidate;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
import com.gdn.x.beirut.services.CandidateService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
<<<<<<< HEAD
@RequestMapping(value = "/api/candidate/")
=======
@RequestMapping(value = "/api/candidate")
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
@Api(value = "CandidateController", description = "Controller untuk Candidate")
public class CandidateController {

  @Autowired
  private CandidateService candidateService;
<<<<<<< HEAD

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
=======
  @Autowired
  private Mapper dozerMapper;

  @RequestMapping(value = "/api/candidate/findCandidateById", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "mencari kandidat berdasarkan ID",
      notes = "mengeluarkan kandidat dengan ID tersebut.")
  @ResponseBody
  public GdnRestSingleResponse<CandidateDTOResponse> findCandidateById(
      @RequestParam String clientId, @RequestParam String storeId, @RequestParam String requestId,
      @RequestParam String channelId, @RequestParam String username, @RequestParam String id)
          throws Exception {
    Candidate candidate = this.candidateService.getCandidate(id);
    CandidateDTOResponse candres = new CandidateDTOResponse();
    CandidateMapper.map(candidate, candres, dozerMapper);
    return new GdnRestSingleResponse<CandidateDTOResponse>(candres, requestId);
  }

  @RequestMapping(value = "/api/candidate/findCandidateByPhoneNumber", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "mencari kandidat berdasarkan nomor telepon",
      notes = "mengeluarkan kandidat dengan nomor telepon tersebut.")
  @ResponseBody
  public GdnRestListResponse<CandidateDTOResponse> findCandidateByPhoneNumber(
      @RequestParam String clientId, @RequestParam String storeId, @RequestParam String requestId,
      @RequestParam String channelId, @RequestParam String username,
      @RequestParam String phoneNumber) throws Exception {
    List<Candidate> candidates = this.candidateService.searchCandidateByPhoneNumber(phoneNumber);
    List<CandidateDTOResponse> candidateResponse = new ArrayList<>();
    for (Candidate candidate : candidates) {
      CandidateDTOResponse newCandidateDTORes = new CandidateDTOResponse();
      CandidateMapper.map(candidate, newCandidateDTORes, dozerMapper);
      candidateResponse.add(newCandidateDTORes);
    }
    return new GdnRestListResponse<>(candidateResponse,
        new PageMetaData(50, 0, candidateResponse.size()), requestId);
  }

  @RequestMapping(value = "/api/candidate/getAllCandidate", method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "Get all Candidates", notes = "Mengambil semua kandidat")
  @ResponseBody
  public GdnRestListResponse<CandidateDTOResponse> getAllCandidate(@RequestParam String clientId,
      @RequestParam String storeId, @RequestParam String requestId, @RequestParam String channelId,
      @RequestParam String username) {
    List<Candidate> candidates = this.candidateService.getAllCandidates();
    List<CandidateDTOResponse> candidateResponse = new ArrayList<>();
    for (Candidate candidate : candidates) {
      CandidateDTOResponse newCandidateDTORes = new CandidateDTOResponse();
      CandidateMapper.map(candidate, newCandidateDTORes, dozerMapper);
      candidateResponse.add(newCandidateDTORes);
    }
    return new GdnRestListResponse<>(candidateResponse,
        new PageMetaData(50, 0, candidateResponse.size()), requestId);
  }

  @RequestMapping(value = "/api/position/insertNewCandidate", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "Insert new Candidate", notes = "memasukan kandidat baru.")
  @ResponseBody
  public GdnBaseRestResponse insertNewCandidate(@RequestParam String clientId,
      @RequestParam String storeId, @RequestParam String requestId, @RequestParam String channelId,
      @RequestParam String username, @RequestBody CandidateDTORequest candreq) {
    Candidate temp = new Candidate(storeId);
    CandidateMapper.map(candreq, temp, dozerMapper);
    this.candidateService.createNew(temp);
    return new GdnBaseRestResponse(true);
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }
}

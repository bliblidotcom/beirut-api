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
import com.gdn.common.web.wrapper.response.GdnRestListResponse;
import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.common.web.wrapper.response.PageMetaData;
import com.gdn.x.beirut.dto.request.CandidatePositionDTORequest;
import com.gdn.x.beirut.dto.request.PositionDTORequest;
import com.gdn.x.beirut.dto.response.PositionDTOResponse;
import com.gdn.x.beirut.entities.CandidatePosition;
=======
import com.gdn.common.web.wrapper.response.GdnBaseRestResponse;
import com.gdn.common.web.wrapper.response.GdnRestListResponse;
import com.gdn.common.web.wrapper.response.PageMetaData;
import com.gdn.x.beirut.dto.request.PositionDTORequest;
import com.gdn.x.beirut.dto.response.PositionDTOResponse;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
import com.gdn.x.beirut.entities.Position;
import com.gdn.x.beirut.services.PositionService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api/position/")
@Api(value = "PositionController")
public class PositionController {

  @Autowired
  private PositionService positionService;

  @Autowired
  private Mapper dozerMapper;

<<<<<<< HEAD
  @RequestMapping(value = "/api/position/deletePosition", method= RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "delete position",notes="menghapus posisi.")
  @ResponseBody
  public GdnRestListResponse<PositionDTOResponse> deletePosition(@RequestParam String clientId, @RequestParam String storeId,
      @RequestParam String requestId, @RequestParam String channelId, @RequestParam String username, @RequestBody List<String> ids){
     List<Position> pos = this.positionService.markForDeletePosition(ids);
     List<PositionDTOResponse> posis = new ArrayList<PositionDTOResponse>();
     for(int i=0; i< ids.size(); i++){
       PositionDTOResponse pr = new PositionDTOResponse();
       dozerMapper.map(pos.get(i), pr);
       posis.add(pr);
     }
     return new GdnRestListResponse<PositionDTOResponse>(posis, new PageMetaData(50, 0, pos.size()), requestId);
  }

  @RequestMapping(value = "/api/position/insertNewPosition", method= RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "insert new position",notes="memasukan posisi baru.")
  @ResponseBody
  public GdnRestSingleResponse<PositionDTOResponse> insertNewPosition(@RequestParam String clientId, @RequestParam String storeId,
      @RequestParam String requestId, @RequestParam String channelId, @RequestParam String username, @RequestBody PositionDTORequest posreq){
    Position temp = new Position(storeId);
    dozerMapper.map(posreq, temp);
    if(posreq.getCandpos() !=null){
      for (CandidatePositionDTORequest iterable_element : posreq.getCandpos()){
        CandidatePosition candidatepos = new CandidatePosition();
        dozerMapper.map(iterable_element, candidatepos);
        temp.addCandidatePosition(candidatepos);
      }
    }
    this.positionService.insertNewPosition(temp);
    PositionDTOResponse result = new PositionDTOResponse();
    dozerMapper.map(temp, result);

    return new GdnRestSingleResponse(result, requestId);
  }

  @RequestMapping(value = "/api/position/updatePosition", method= RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "update position",notes="mengganti posisi.")
  @ResponseBody
  public GdnRestSingleResponse<PositionDTOResponse> updatePosition(@RequestParam String clientId, @RequestParam String storeId,
      @RequestParam String requestId, @RequestParam String channelId, @RequestParam String username, @RequestParam String id, @RequestBody PositionDTORequest posreq){
    Position pos = new Position(storeId);
    dozerMapper.map(posreq, pos);
    this.positionService.updatePositionTitle(id, pos.getTitle());
    PositionDTOResponse posres = new PositionDTOResponse();

    return new GdnRestSingleResponse(posres, requestId);
  }

}
=======
  @RequestMapping(value = "/api/position/deletePosition", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "delete position", notes = "menghapus posisi.")
  @ResponseBody
  public GdnBaseRestResponse deletePosition(@RequestParam String clientId,
      @RequestParam String storeId, @RequestParam String requestId, @RequestParam String channelId,
      @RequestParam String username, @RequestBody List<PositionDTORequest> positionDTORequests) {

    List<String> ids = new ArrayList<String>();
    for (PositionDTORequest positionDTO : positionDTORequests) {
      ids.add(positionDTO.getId());
    }
    this.positionService.markForDeletePosition(ids);

    return new GdnBaseRestResponse(true);
  }

  @RequestMapping(value = "/api/position/getAllPosition", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "get all position", notes = "mengambil semua posisi.")
  @ResponseBody
  public GdnRestListResponse<PositionDTOResponse> getAllPosition(@RequestParam String clientId,
      @RequestParam String storeId, @RequestParam String requestId, @RequestParam String channelId,
      @RequestParam String username) {
    List<Position> positions = this.positionService.getAllPosition();
    List<PositionDTOResponse> positionDTOResponses = new ArrayList<PositionDTOResponse>();
    for (Position positiones : positions) {
      PositionDTOResponse positionDTOResponse = new PositionDTOResponse();
      dozerMapper.map(positiones, positionDTOResponse);
      positionDTOResponses.add(positionDTOResponse);
    }

    return new GdnRestListResponse<PositionDTOResponse>(positionDTOResponses,
        new PageMetaData(5, 5, positions.size()), requestId);
  }

  @RequestMapping(value = "/api/position/getPositionByTitle", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "get position by title", notes = "mengambil semua posisi dengan nama.")
  @ResponseBody
  public GdnRestListResponse<PositionDTOResponse> getPositionByTitle(@RequestParam String clientId,
      @RequestParam String storeId, @RequestParam String requestId, @RequestParam String channelId,
      @RequestParam String username, @RequestBody PositionDTORequest positionDTORequest) {
    List<Position> positions =
        this.positionService.getPositionByTitle(positionDTORequest.getTitle());
    List<PositionDTOResponse> positionDTOResponses = new ArrayList<PositionDTOResponse>();

    for (Position positiones : positions) {
      PositionDTOResponse positionDTOResponse = new PositionDTOResponse();
      dozerMapper.map(positiones, positionDTOResponse);
      positionDTOResponses.add(positionDTOResponse);
    }

    return new GdnRestListResponse<PositionDTOResponse>(positionDTOResponses,
        new PageMetaData(5, 5, positions.size()), requestId);
  }

  @RequestMapping(value = "/api/position/insertNewPosition", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "insert new position", notes = "memasukan posisi baru.")
  @ResponseBody
  public GdnBaseRestResponse insertNewPosition(@RequestParam String clientId,
      @RequestParam String storeId, @RequestParam String requestId, @RequestParam String channelId,
      @RequestParam String username, @RequestBody PositionDTORequest positionDTORequest) {
    Position temp = new Position();
    dozerMapper.map(positionDTORequest, temp);
    temp.setStoreId(storeId);
    return new GdnBaseRestResponse(this.positionService.insertNewPosition(temp));
  }

  public void setDozerMapper(Mapper dm) {
    this.dozerMapper = dm;
  }

  @RequestMapping(value = "/api/position/updatePosition", method = RequestMethod.POST,
      consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "update position", notes = "mengganti posisi.")
  @ResponseBody
  public GdnBaseRestResponse updatePosition(@RequestParam String clientId,
      @RequestParam String storeId, @RequestParam String requestId, @RequestParam String channelId,
      @RequestParam String username, @RequestBody PositionDTORequest positionDTORequest) {
    Position pos = new Position();
    dozerMapper.map(positionDTORequest, pos);
    pos.setStoreId(storeId);

    return new GdnBaseRestResponse(this.positionService
        .updatePositionTitle(positionDTORequest.getId(), positionDTORequest.getTitle()));
  }
}

>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

package com.ega.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ega.dto.response.MatakuliahDTOResponse;
import com.ega.entities.MataKuliah;
import com.ega.helper.MyObjectMapper;
import com.ega.services.SimpleCRUD;
import com.gdn.common.web.wrapper.response.GdnRestListResponse;
import com.gdn.common.web.wrapper.response.PageMetaData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "api/matakuliah/") /*
                                            * kita ngasih tau sama framework spring url-nya (bisa
                                            * dilvel kelas bisa dilevel method)
                                            *
                                            */
@Api(value = "MatakuliahController", description = "this is a controller for api to matakuliah")
public class MatakuliahController {

  @Autowired
  private Mapper dozerMapper;

  @Autowired
  private SimpleCRUD simpleCRUD;

  @RequestMapping(value = "getAllMatakuliah", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "activate get all matakuliah value",
      notes = "api ini akan mengembalikan seluruh matakuliah yang telah terdaftar")
  @ResponseBody
  public GdnRestListResponse<MatakuliahDTOResponse> getAllMatakuliah(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId,
      @RequestParam String requestId) {
    List<MataKuliah> matakuliahs = this.simpleCRUD.getAllMataKuliah();
    if (matakuliahs == null || matakuliahs.isEmpty()) {
      return null;
    }
    List<MatakuliahDTOResponse> matakuliahOut = new ArrayList<MatakuliahDTOResponse>();
    for (MataKuliah matakuliah : matakuliahs) {
      MatakuliahDTOResponse out = new MatakuliahDTOResponse();
      MyObjectMapper.mapMatakuliahEntityToDTOResponse(dozerMapper, matakuliah, out);
      matakuliahOut.add(out);
    }
    GdnRestListResponse<MatakuliahDTOResponse> gdnResult =
        new GdnRestListResponse<MatakuliahDTOResponse>(matakuliahOut,
            new PageMetaData(10, 0, matakuliahs.size()), requestId);
    return gdnResult;
  }

}

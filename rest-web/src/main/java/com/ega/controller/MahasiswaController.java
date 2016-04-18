package com.ega.controller;

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

import com.ega.dto.request.MahasiswaDTORequest;
import com.ega.dto.request.MahasiswaDetailDTORequest;
import com.ega.dto.response.MahasiswaDTOResponse;
import com.ega.dto.response.MahasiswaDetailDTOResponse;
import com.ega.entities.Mahasiswa;
import com.ega.helper.MyObjectMapper;
import com.ega.services.SimpleCRUD;
import com.gdn.common.web.wrapper.response.GdnRestListResponse;
import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.common.web.wrapper.response.PageMetaData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/*
 * kita ngasih tau sama framework spring url-nya (bisa dilvel kelas bisa dilevel method)
 *
 */
@Controller
@RequestMapping(value = "/api/mahasiswa")
@Api(value = "MahasiswaController", description = "this is a controller for api to mahasiswa")
public class MahasiswaController {
  /*
   * @RequestMapping(value = API, method=RequestMethod.method=... , produces = {}, consumes = {})
   */
  // content type --> consumes
  // accept --> produces

  @Autowired
  private Mapper dozerMapper;

  @Autowired
  private SimpleCRUD simpleCRUD;

  @RequestMapping(value = "/createNewMahasiswa", method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "activate create new mahasiswa value",
      notes = "api ini akan melakukan create mahasiswa baru dengan parameter yang harus dimasukkan adalah : nama,npm")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDetailDTOResponse> createNewMahasiswa(
      @RequestParam String storeId, @RequestParam String channelId, @RequestParam String clientId,
      @RequestParam String requestId, @RequestParam("username") String username,
      @RequestBody MahasiswaDetailDTORequest mahasiswaIn) {
    Mahasiswa newMahasiswa = new Mahasiswa();
    MyObjectMapper.mapMahasiswaDetailDTORequestToEntity(getDozerMapper(), mahasiswaIn,
        newMahasiswa);
    // if (!newMahasiswa.getMataKuliahs().isEmpty() || newMahasiswa.getMataKuliahs() != null) {
    // for (MataKuliah matkul : newMahasiswa.getMataKuliahs()) {
    // matkul.setMahasiswa(newMahasiswa);
    // }
    // }
    this.simpleCRUD.addNewMahasiswa(newMahasiswa);
    MahasiswaDetailDTOResponse mahasiswaOut = new MahasiswaDetailDTOResponse();
    MyObjectMapper.mapMahasiswaEntityToDetailDTOResponse(getDozerMapper(), newMahasiswa,
        mahasiswaOut);
    GdnRestSingleResponse<MahasiswaDetailDTOResponse> gdnResult =
        new GdnRestSingleResponse<MahasiswaDetailDTOResponse>(mahasiswaOut, requestId);
    return gdnResult;
  }

  @RequestMapping(value = "/deleteMahasiswa", method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "activate delete mahasiswa value",
      notes = "api ini akan melakukan delete terhadap mahsiswa berdasarkan id")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDTOResponse> deleteMahasiswa(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam String username, @RequestParam String id) throws Exception {
    Mahasiswa c = this.simpleCRUD.findMahasiswaById(id);
    MahasiswaDTOResponse md = new MahasiswaDTOResponse();
    this.simpleCRUD.deleteMahasiswaById(id);
    MyObjectMapper.mapMahasiswaEntityToDTOResponse(getDozerMapper(), c, md);
    GdnRestSingleResponse<MahasiswaDTOResponse> deleted =
        new GdnRestSingleResponse<MahasiswaDTOResponse>(md, requestId);
    return deleted;
  }

  @RequestMapping(value = "/getAllMahasiswa", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "activate get all mahasiswa value",
      notes = "api ini akan mengembalikan seluruh mahasiswa yang telah terdaftar")
  @ResponseBody
  public GdnRestListResponse<MahasiswaDTOResponse> getAllMahasiswa(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam("username") String username) {
    List<Mahasiswa> mahasiswas = this.simpleCRUD.getAllMahasiswa();
    // System.out.println("Mahasiswas Length: " + mahasiswas.size());
    List<MahasiswaDTOResponse> mahasiswaOut = new ArrayList<MahasiswaDTOResponse>();

    if (mahasiswas.isEmpty() || mahasiswas == null) {
      System.out.println("INI NULL");
      return null;
    }
    for (Mahasiswa mahasiswa : mahasiswas) {
      MahasiswaDTOResponse out = new MahasiswaDTOResponse();
      MyObjectMapper.mapMahasiswaEntityToDTOResponse(getDozerMapper(), mahasiswa, out);
      // System.out.println("Out..: ");
      mahasiswaOut.add(out);
      // System.out.println("length updt out : " + mahasiswaOut.size());
    }
    GdnRestListResponse<MahasiswaDTOResponse> gdnMahasiswas =
        new GdnRestListResponse<MahasiswaDTOResponse>(mahasiswaOut,
            new PageMetaData(10, 0, mahasiswas.size()), requestId);

    return gdnMahasiswas;
  }

  public Mapper getDozerMapper() {
    return dozerMapper;
  }

  @RequestMapping(value = "/getMahasiswa", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "activate get mahasiswa value",
      notes = "api ini akan mengembalikan satu buah mahasiswa dengan id yang diberikan")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDTOResponse> getMahasiswa(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam("username") String username, @RequestParam String id) {
    Mahasiswa target = this.simpleCRUD.findMahasiswaById(id);
    if (target == null) {
      return null;
    }
    MahasiswaDTOResponse md = new MahasiswaDTOResponse();
    MyObjectMapper.mapMahasiswaEntityToDTOResponse(getDozerMapper(), target, md);
    return new GdnRestSingleResponse<MahasiswaDTOResponse>(md, requestId);
  }

  @RequestMapping(value = "/getMahasiswaDetail", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "activate get mahasiswa detail with its matakuliah signed",
      notes = "api ini akan mengembalikan satu mahasiswa dengan detail matakuliahnya")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDetailDTOResponse> getMahasiswaDetail(
      @RequestParam String storeId, @RequestParam String channelId, @RequestParam String clientId,
      @RequestParam String requestId, @RequestParam("username") String username,
      @RequestParam String id) {
    Mahasiswa target = this.simpleCRUD.findMahasiswaDetail(id);
    if (target == null) {
      return null;
    }
    // System.out.println(target.getNama() + " " + target.getNpm());
    MahasiswaDetailDTOResponse result = new MahasiswaDetailDTOResponse();
    MyObjectMapper.mapMahasiswaEntityToDetailDTOResponse(getDozerMapper(), target, result);

    // result.setPrimaryKey(target.getId());
    // result.setNama(target.getNama());
    // result.setNpm(target.getNpm());
    // Iterator<MataKuliah> myItr = target.getMataKuliah().iterator();
    // while (myItr.hasNext()) {
    // MataKuliah now = myItr.next();
    // System.out.println(now.toString());
    // MatakuliahDTOResponse tmp = new MatakuliahDTOResponse();
    // tmp.setPrimaryKey(now.getId());
    // tmp.setKode(now.getKode());
    // tmp.setNama(now.getNama());
    // tmp.setNamaDosen(now.getNamaDosen());
    // tmp.setPrimaryKey(now.getId());
    // result.addMatakuliah(tmp);
    // }
    GdnRestSingleResponse<MahasiswaDetailDTOResponse> gdnRes =
        new GdnRestSingleResponse<MahasiswaDetailDTOResponse>(result, requestId);
    return gdnRes;
  }

  public void setDozerMapper(Mapper dozerMapper) {
    this.dozerMapper = dozerMapper;
  }

  @RequestMapping(value = "/updateMahasiswa", method = RequestMethod.PATCH,
      produces = {MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "activate update mahasiswa by Id value",
      notes = "api ini akan mengupdate value mahasiswa berdasarkan id yang diberikan")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDTOResponse> updateMahasiswa(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam("username") String username, @RequestParam String id,
      @RequestBody MahasiswaDTORequest mahasiswaIn) {
    Mahasiswa mahasiswa = this.simpleCRUD.findMahasiswaById(id);
    if (mahasiswa == null) {
      return null;
    }
    MyObjectMapper.mapMahasiswaDTORequestToEntity(getDozerMapper(), mahasiswaIn, mahasiswa);
    this.simpleCRUD.saveMahasiswa(mahasiswa);
    MahasiswaDTOResponse updatedMahasiswaDTO = new MahasiswaDTOResponse();
    MyObjectMapper.mapMahasiswaEntityToDTOResponse(getDozerMapper(), mahasiswa,
        updatedMahasiswaDTO);
    GdnRestSingleResponse<MahasiswaDTOResponse> gdnUpdatedMahasiswa =
        new GdnRestSingleResponse<>(updatedMahasiswaDTO, requestId);
    return gdnUpdatedMahasiswa;
  }

}

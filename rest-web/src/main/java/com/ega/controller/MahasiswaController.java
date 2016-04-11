package com.ega.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ega.dto.MahasiswaDTO;
import com.ega.dto.MahasiswaDetailDTO;
import com.ega.dto.MatakuliahDTO;
import com.ega.entities.Mahasiswa;
import com.ega.entities.MataKuliah;
import com.ega.services.SimpleCRUD;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdn.common.web.wrapper.response.GdnRestListResponse;
import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.common.web.wrapper.response.PageMetaData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "api/mahasiswa/") /*
                                           * kita ngasih tau sama framework spring url-nya (bisa
                                           * dilvel kelas bisa dilevel method)
                                           *
                                           */
@Api(value = "MahasiswaController", description = "this is a controller for api to mahasiswa")
public class MahasiswaController {
  /*
   * @RequestMapping(value = API, method=RequestMethod.method=... , produces = {}, consumes = {})
   */
  // content type --> consumes
  // accept --> produces

  private ObjectMapper om;

  @Autowired
  private SimpleCRUD simpleCRUD;

  @RequestMapping(value = "createNewMahasiswa", method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "activate create new mahasiswa value",
      notes = "api ini akan melakukan create mahasiswa baru dengan parameter yang harus dimasukkan adalah : nama,npm")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDTO> createNewMahasiswa(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestBody Mahasiswa mahasiswaIn) {
    Mahasiswa saved = this.simpleCRUD.addNewMahasiswa(mahasiswaIn);
    MahasiswaDTO result = new MahasiswaDTO();
    result.setNama(saved.getNama());
    result.setNpm(saved.getNpm());
    result.setPrimaryKey(saved.getId());
    GdnRestSingleResponse<MahasiswaDTO> gdnResult =
        new GdnRestSingleResponse<MahasiswaDTO>(result, requestId);
    return gdnResult;
  }

  @RequestMapping(value = "deleteMahasiswa", method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "activate delete mahasiswa value",
      notes = "api ini akan melakukan delete terhadap mahsiswa berdasarkan id")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDTO> deleteMahasiswa(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam Integer id) {
    Mahasiswa target = this.simpleCRUD.deleteMahasiswaById(id);
    MahasiswaDTO md = new MahasiswaDTO();
    md.setPrimaryKey(target.getId());
    md.setNama(target.getNama());
    md.setNpm(target.getNpm());
    GdnRestSingleResponse<MahasiswaDTO> deleted =
        new GdnRestSingleResponse<MahasiswaDTO>(md, requestId);
    return deleted;
  }

  @RequestMapping(value = "getAllMahasiswa", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "activate get all mahasiswa value",
      notes = "api ini akan mengembalikan seluruh mahasiswa yang telah terdaftar")
  @ResponseBody
  public GdnRestListResponse<MahasiswaDTO> getAllMahasiswa(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId,
      @RequestParam String requestId) {
    List<Mahasiswa> mahasiswas = this.simpleCRUD.getAllMahasiswa();
    List<MahasiswaDTO> listMahasiswaDTO = new ArrayList<MahasiswaDTO>();
    for (int i = 0; i < mahasiswas.size(); i++) {
      MahasiswaDTO md = new MahasiswaDTO();
      md.setNama(mahasiswas.get(i).getNama());
      md.setNpm(mahasiswas.get(i).getNpm());
      md.setPrimaryKey(mahasiswas.get(i).getId());
      listMahasiswaDTO.add(md);
    }
    GdnRestListResponse<MahasiswaDTO> gdnMahasiswas = new GdnRestListResponse<MahasiswaDTO>(
        listMahasiswaDTO, new PageMetaData(10, 0, mahasiswas.size()), requestId);

    return gdnMahasiswas;
  }

  @RequestMapping(value = "getMahasiswa", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "activate get mahasiswa value",
      notes = "api ini akan mengembalikan satu buah mahasiswa dengan id yang diberikan")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDTO> getMahasiswa(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam Integer id) {
    Mahasiswa target = this.simpleCRUD.findMahasiswaById(id);
    MahasiswaDTO md = new MahasiswaDTO();
    md.setPrimaryKey(target.getId());
    md.setNama(target.getNama());
    md.setNpm(target.getNpm());
    return new GdnRestSingleResponse<MahasiswaDTO>(md, requestId);
  }

  @RequestMapping(value = "getMahasiswaDetail", method = RequestMethod.GET,
      produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
  @ApiOperation(value = "activate get mahasiswa detail with its matakuliah signed",
      notes = "api ini akan mengembalikan satu mahasiswa dengan detail matakuliahnya")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDetailDTO> getMahasiswaDetail(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam Integer id) {
    Mahasiswa target = this.simpleCRUD.findMahasiswaDetail(id);
    System.out.println(target.getNama() + " " + target.getNpm());
    MahasiswaDetailDTO result = new MahasiswaDetailDTO();
    result.setPrimaryKey(target.getId());
    result.setNama(target.getNama());
    result.setNpm(target.getNpm());
    Iterator<MataKuliah> myItr = target.getMataKuliah().iterator();
    while (myItr.hasNext()) {
      MataKuliah now = myItr.next();
      System.out.println(now.toString());
      MatakuliahDTO tmp = new MatakuliahDTO();
      tmp.setPrimaryKey(now.getId());
      tmp.setKode(now.getKode());
      tmp.setNama(now.getNama());
      tmp.setNamaDosen(now.getNamaDosen());
      tmp.setPrimaryKey(now.getId());
      result.addMatakuliah(tmp);
    }
    GdnRestSingleResponse<MahasiswaDetailDTO> gdnRes =
        new GdnRestSingleResponse<MahasiswaDetailDTO>(result, requestId);
    return gdnRes;
  }

  @RequestMapping(value = "updateMahasiswa", method = RequestMethod.PATCH,
      produces = {MediaType.APPLICATION_XML_VALUE},
      consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "activate update mahasiswa by Id value",
      notes = "api ini akan mengupdate value mahasiswa berdasarkan id yang diberikan")
  @ResponseBody
  public GdnRestSingleResponse<MahasiswaDTO> updateMahasiswa(@RequestParam String storeId,
      @RequestParam String channelId, @RequestParam String clientId, @RequestParam String requestId,
      @RequestParam Integer id, @RequestBody Mahasiswa mahasiswaIn) {
    Mahasiswa mahasiswa = this.simpleCRUD.findMahasiswaById(id);
    mahasiswa.setNama(mahasiswaIn.getNama());
    mahasiswa.setNpm(mahasiswaIn.getNpm());
    this.simpleCRUD.saveMahasiswa(mahasiswa);
    MahasiswaDTO updatedMahasiswaDTO = new MahasiswaDTO();
    updatedMahasiswaDTO.setNama(mahasiswa.getNama());
    updatedMahasiswaDTO.setNpm(mahasiswa.getNpm());
    GdnRestSingleResponse<MahasiswaDTO> gdnUpdatedMahasiswa =
        new GdnRestSingleResponse<>(updatedMahasiswaDTO, requestId);
    return gdnUpdatedMahasiswa;
  }

}

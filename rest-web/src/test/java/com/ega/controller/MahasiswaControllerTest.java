package com.ega.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ega.entities.Mahasiswa;
import com.ega.services.SimpleCRUD;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MahasiswaControllerTest {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  private static final DozerBeanMapper MAPPER = new DozerBeanMapper();
  private static final String ID = "id";
  private static final String USERNAME = "username";
  
  private Mahasiswa mahasiswa1;

  @Mock
  private SimpleCRUD simpleCRUD;

  @InjectMocks
  private MahasiswaController mahasiswaController;

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    initMocks(this);
    this.mahasiswaController.setDozerMapper(MAPPER);
    this.mockMvc = standaloneSetup(this.mahasiswaController).build();
    this.mahasiswa1 = new Mahasiswa(); 
    this.mahasiswa1.setNpm("2013");
    when(this.simpleCRUD.findMahasiswaById(ID)).thenReturn(this.mahasiswa1);
    doNothing().when(this.simpleCRUD).deleteMahasiswaById(ID);
  }

  @Test
  public void testMahasiswaControllerDeleteMahasiswa() throws Exception {
    this.mockMvc
        .perform(post("/api/mahasiswa/deleteMahasiswa").contentType(MediaType.APPLICATION_XML_VALUE)
            .accept(MediaType.APPLICATION_XML_VALUE).param("storeId", "1").param("channelId", "1")
            .param("clientId", "1").param("requestId", "1").param("id", ID).param("username",USERNAME))
        .andExpect(status().isOk());
    verify(this.simpleCRUD, times(1)).findMahasiswaById(ID);
    verify(this.simpleCRUD, times(1)).deleteMahasiswaById(ID);
    verifyNoMoreInteractions(this.simpleCRUD);
  }



}

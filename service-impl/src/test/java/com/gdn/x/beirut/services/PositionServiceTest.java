package com.gdn.x.beirut.services;

import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.gdn.x.beirut.dao.PositionDAO;
import com.gdn.x.beirut.entities.Position;

public class PositionServiceTest {

  @Mock
  private PositionDAO repository;

  @InjectMocks
  private PositionServiceImpl service;

  private Position position;
  private final List<Position> pos = new ArrayList<Position>();

  @Test
  @Ignore
  public void checkMarkForDelete(){
    List<String> ids = new ArrayList<String>();
    for(int i=0; i<pos.size(); i++){
      ids.add(pos.get(i).getId());
    }
<<<<<<< HEAD
    System.out.println("IDs :" + ids.toString());
=======
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
    this.service.markForDeletePosition(ids);
    Mockito.verify(this.repository).findByIdAndMarkForDelete(this.position.getId(), false);
  }


  @Test
  public void checkUpdatePositionTitle(){
    this.service.updatePositionTitle(this.position.getId(), "Emporio Ivankov");
    Mockito.verify(this.repository).findByIdAndMarkForDelete(this.position.getId(), false);
  }

  @Test
<<<<<<< HEAD
  public void checkUpdatePositionTitle(){
    List<Position> positions = new ArrayList<Position>();
    Position posi1 = new Position("12");
    posi1.setTitle("Kamabaka");
    posi1.setId("1");
    positions.add(posi1);
    this.service.updatePositionTitle(posi1.getId(), "Emporio Ivankov");
    Mockito.verify(this.repository).findByIdAndMarkForDelete(this.position.getId(), false);
=======
  public void getAllPosition(){
    this.service.getAllPosition();
    Mockito.verify(this.repository, Mockito.times(1)).findByMarkForDelete(false);
  }

  @Test
  public void getPositionByTitle(){
    this.service.getPositionByTitle("Cho");
    Mockito.verify(this.repository).findByTitleContainingAndMarkForDelete("Cho", false);
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
  }

  @Before
  public void initialize() throws Exception {
    initMocks(this);

    this.position=new Position("12");
    this.position.setTitle("Choa");
<<<<<<< HEAD
    this.position.setId("1");
=======
    this.position.setId("122");
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
    pos.add(this.position);
    this.repository.save(this.position);
    Mockito.when(this.repository.findByTitleContainingAndMarkForDelete(this.position.getTitle(), false)).thenReturn(pos);
    Mockito.when(this.repository.save(this.position)).thenReturn(this.position);
    List<String> aa = new ArrayList<String>();
    aa.add("1");
  }

}

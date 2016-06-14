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
  public void checkMarkForDelete() {
    List<String> ids = new ArrayList<String>();
    for (int i = 0; i < pos.size(); i++) {
      ids.add(pos.get(i).getId());
    }
    this.service.markForDeletePosition(ids);
    Mockito.verify(this.repository).findByIdAndMarkForDelete(this.position.getId(), false);
  }


  @Test
  public void checkUpdatePositionTitle() {
    this.service.updatePositionTitle(this.position.getId(), "Emporio Ivankov");
    Mockito.verify(this.repository).findByIdAndMarkForDelete(this.position.getId(), false);
  }

  @Test

  public void getAllPosition() {
    this.service.getAllPosition();
    Mockito.verify(this.repository, Mockito.times(1)).findByMarkForDelete(false);
  }

  @Test
  public void getPositionByTitle() {
    this.service.getPositionByTitle("Cho");
    Mockito.verify(this.repository).findByTitleContainingAndMarkForDelete("Cho", false);
  }

  @Before
  public void initialize() throws Exception {
    initMocks(this);

    this.position = new Position("12");
    this.position.setTitle("Choa");
    this.position.setId("122");
    pos.add(this.position);
    this.repository.save(this.position);
    Mockito
        .when(
            this.repository.findByTitleContainingAndMarkForDelete(this.position.getTitle(), false))
        .thenReturn(pos);
    Mockito.when(this.repository.save(this.position)).thenReturn(this.position);
    List<String> aa = new ArrayList<String>();
    aa.add("1");
  }

}

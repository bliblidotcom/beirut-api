package com.gdn.x.beirut.dao;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
=======
import com.gdn.x.beirut.entities.Position;
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
@Transactional(readOnly = false)
public class PositionDAOTest {
  private static final Logger LOG = LoggerFactory.getLogger(PositionDAO.class);
  private static final String AUTHOR = "unit-test";
  private static final String STORE_ID_1 = "store1";
  private static final String STORE_ID_2 = "store2";
  public static final String POSITION_TITLE_PREFIX = "position-";
  private List<Position> positions;

  @Autowired
  private PositionDAO positionDao;

  @Test
  public void findById(){
    this.position1.setMarkForDelete(true);
    assertEquals(this.positionDAO.findByIdAndMarkForDelete(this.position1.getId(), false), null);
  }

  @Before
<<<<<<< HEAD
  public void initialize(){
    this.position1= new Position("12");
    this.position2= new Position("12");
    this.position1.setTitle("Nanami");
    this.position2.setTitle("Budi");
    this.position1.setCreatedBy("Aderai");
    this.positionDAO.save(this.position1);
  }
=======
  public void initialize() {
    positions = new ArrayList<Position>();
    for (int i = 1; i <= 15; i++) {
      Position positionForStore1 = new Position();
      positionForStore1.setTitle(POSITION_TITLE_PREFIX + i);
      positionForStore1.setCreatedBy(AUTHOR);
      positionForStore1.setStoreId(STORE_ID_1);
      positions.add(positionForStore1);
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test

      Position positionForStore2 = new Position();
      positionForStore2.setTitle(POSITION_TITLE_PREFIX + i);
      positionForStore2.setCreatedBy(AUTHOR);
      positionForStore2.setStoreId(STORE_ID_2);
      positions.add(positionForStore2);
    }
    this.positionDao.save(this.positions);
  }

  @Test
  public void testFindByStoreIdMarkForDelete() {
    assertTrue(this.positionDao.findByStoreIdAndMarkForDelete(STORE_ID_1, true).isEmpty());
    assertTrue(this.positionDao.findByStoreIdAndMarkForDelete(STORE_ID_1, false).size() == 15);
    assertTrue(this.positionDao.findByStoreIdAndMarkForDelete(STORE_ID_2, true).isEmpty());
    assertTrue(this.positionDao.findByStoreIdAndMarkForDelete(STORE_ID_2, false).size() == 15);
  }

  @Test
  public void testFindByTitleContainingAndStoreIdAndMarkForDelete() {
    assertTrue(this.positionDao.findByTitleContainingAndStoreIdAndMarkForDelete("1", STORE_ID_1, false).size() == 7);
    assertTrue(this.positionDao.findByTitleContainingAndStoreIdAndMarkForDelete("2", STORE_ID_2, false).size() == 2);
  }

}

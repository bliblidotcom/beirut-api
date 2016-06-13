package com.gdn.x.beirut.services;

import java.util.List;

import com.gdn.x.beirut.entities.Position;

public interface PositionService {

<<<<<<< HEAD
    List<Position> getAllPosition();
    void insertNewPosition(Position position);
    List<Position> markForDeletePosition(List<String> id);
    void updatePositionTitle(String id, String title);
=======
  List<Position> getAllPosition();

  List<Position> getPositionByTitle(String title);

  boolean insertNewPosition(Position position);

  void markForDeletePosition(List<String> id);

  boolean updatePositionTitle(String id, String title);
>>>>>>> refs/remotes/bliblidotcom/revisi-1-entity-with-jpa-with-dao-test
}

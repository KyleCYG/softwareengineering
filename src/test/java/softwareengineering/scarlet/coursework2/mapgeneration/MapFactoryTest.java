package softwareengineering.scarlet.coursework2.mapgeneration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Corridor;
import softwareengineering.scarlet.coursework2.models.Map;
import softwareengineering.scarlet.coursework2.models.Room;

public class MapFactoryTest {
  @Test
  public void testMakeRoom() {
    int x = 0;
    int y = 0;
    int width = 10;
    int height = 10;

    Room room = MapFactory.makeRoom(x, y, width, height);

    assertTrue("Width too big: " + room.getWidth(), room.getWidth() < width);
    assertTrue("Height too big: " + room.getHeight(), room.getHeight() < height);
    assertTrue("X too small: " + room.getX(), room.getX() > x);
    assertTrue("Y too small: " + room.getY(), room.getY() > y);
    assertTrue("X too big: " + room.getX(), room.getX() < x + width);
    assertTrue("Y too big: " + room.getY(), room.getY() < y + height);
  }

  @Test
  public void testFinalMakeNode() {
    int x = 0;
    int y = 0;
    int width = 8;
    int height = 8;

    Direction direction = Direction.HORIZONTAL;
    Leaf leaf = MapFactory.makeNode(x, y, width, height, direction);

    assertEquals(leaf.getRooms().size(), 1);

    Room room = leaf.getRooms().get(0);

    // Is the generated room within the leaf?
    assertTrue("Room X " + room.getX() + " <= 0", room.getX() > leaf.getX());
    assertTrue(room.getY() > leaf.getY());
    assertTrue(room.getX() < leaf.getX() + leaf.getWidth());
    assertTrue(room.getY() < leaf.getY() + leaf.getHeight());
  }

  @Test
  public void testMakeCorridor() {
    int width = 100;
    int height = 100;

    Map map = TwoRoomMapFactory.generateMap(width, height);
    Corridor corridor = map.getCorridors().get(0);

    assertEquals(2, map.getRooms().size());
    // These values are slightly odd because of the off-by-1 error of using "width" as a coordinate
    // in a zero-based system
    assertEquals((width / 2) - 2, corridor.getX1());
    assertEquals((width / 2) + 1, corridor.getX2());
  }

  @Test
  public void testTreeMakeNode() {
    int x = 0;
    int y = 0;
    int width = 50;
    int height = 50;

    Direction direction = Direction.HORIZONTAL;
    Leaf leaf = MapFactory.makeNode(x, y, width, height, direction);

    assertTrue(leaf.getRooms().size() > 1);
    assertEquals("Not the right number of corridors", leaf.getRooms().size() - 1,
        leaf.getCorridors().size());
  }

  @Test
  public void testFindMatchTwoRooms() throws Exception {
    Room roomA = new Room(0, 0, 10, 1);
    Room roomB = new Room(5, 2, 10, 1);

    List<Room> sideA = new ArrayList<Room>();
    List<Room> sideB = new ArrayList<Room>();

    sideA.add(roomA);
    sideB.add(roomB);

    List<Integer> matches = MapFactory.findMatch(sideA, sideB, Direction.HORIZONTAL);

    assertEquals(5, matches.size());
  }

  @Test
  public void testFindMatchThreeRooms() throws Exception {
    Room roomA = new Room(4, 0, 10, 1);
    Room roomB = new Room(0, 2, 8, 1);
    Room roomC = new Room(11, 2, 8, 1);

    List<Room> sideA = new ArrayList<Room>();
    List<Room> sideB = new ArrayList<Room>();

    sideA.add(roomA);
    sideB.add(roomB);
    sideB.add(roomC);

    List<Integer> matches = MapFactory.findMatch(sideA, sideB, Direction.HORIZONTAL);

    assertEquals(7, matches.size());
  }

  @Test
  public void testGenerateMap() {
    int width = 100;
    int height = 100;
    Map map = MapFactory.generateMap(width, height, null);
    assertTrue(map.getRooms().size() > 0);
    assertTrue(map.getCorridors().size() > 0);
  }

  @Test
  public void testNoOverlap() {
    int width = 100;
    int height = 100;

    Map map = MapFactory.generateMap(width, height, null);

    CellType[][] grid = new CellType[width][height];

    for (Room room : map.getRooms()) {
      for (int x = room.getX(); x <= room.getX2(); x++) {
        for (int y = room.getY(); y <= room.getY2(); y++) {
          grid[x][y] = CellType.ROOM;
        }
      }
    }

    for (Corridor corridor : map.getCorridors()) {
      for (int x = corridor.getX1(); x <= corridor.getX2(); x++) {
        for (int y = corridor.getY1(); y <= corridor.getY2(); y++) {
          assertFalse(grid[x][y] == CellType.ROOM);
        }
      }
    }
  }
}

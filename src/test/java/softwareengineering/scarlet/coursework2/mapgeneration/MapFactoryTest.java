package softwareengineering.scarlet.coursework2.mapgeneration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Test;
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
  public void testTreeMakeNode() {
    int x = 0;
    int y = 0;
    int width = 50;
    int height = 50;

    Direction direction = Direction.HORIZONTAL;
    Leaf leaf = MapFactory.makeNode(x, y, width, height, direction);

    assertTrue(leaf.getRooms().size() > 1);
  }

  @Test
  public void testFindMatchNoRooms() {
    List<Room> sideA = new ArrayList<Room>();
    List<Room> sideB = new ArrayList<Room>();

    try {
      MapFactory.findMatch(sideA, sideB, Direction.HORIZONTAL);
      fail();
    } catch (Exception e) {
      assertEquals(e.getMessage(), "No matching sides");
    }
  }

  @Test
  public void testFindMatchTwoRooms() throws Exception {
    Room roomA = new Room(0, 0, 10, 1);
    Room roomB = new Room(5, 2, 10, 1);

    List<Room> sideA = new ArrayList<Room>();
    List<Room> sideB = new ArrayList<Room>();

    sideA.add(roomA);
    sideB.add(roomB);

    Set<Integer> matches = MapFactory.findMatch(sideA, sideB, Direction.HORIZONTAL);

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

    Set<Integer> matches = MapFactory.findMatch(sideA, sideB, Direction.HORIZONTAL);

    assertEquals(7, matches.size());
  }
}

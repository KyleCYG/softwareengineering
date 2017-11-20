package softwareengineering.scarlet.coursework2.mapgeneration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
}

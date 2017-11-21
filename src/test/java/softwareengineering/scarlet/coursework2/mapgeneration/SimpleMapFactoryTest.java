package softwareengineering.scarlet.coursework2.mapgeneration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import softwareengineering.scarlet.coursework2.models.Map;
import softwareengineering.scarlet.coursework2.models.Room;

public class SimpleMapFactoryTest {
  @Test
  public void testGenerateMap() {
    Map map = SimpleMapFactory.generateMap(50, 50);

    assertEquals(map.getRooms().size(), 1);

    Room room = map.getRooms().get(0);

    assertTrue(room.getWidth() < map.getWidth());
    assertTrue(room.getHeight() < map.getHeight());
    assertTrue(room.getX() > 0);
    assertTrue(room.getY() > 0);
  }
}

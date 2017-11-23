package softwareengineering.scarlet.coursework2.mapgeneration;

import softwareengineering.scarlet.coursework2.models.Map;
import softwareengineering.scarlet.coursework2.models.Room;

/**
 * Used to generate a simple map containing a single room.
 *
 * The room almost fills the entire map.
 *
 * Used for testing.
 *
 * @author Dan Cosser
 */
public class SimpleMapFactory extends MapFactory {
  /**
   * Make a Map of a defined size containing a single room.
   *
   * @param width Width of the map in cells
   * @param height Height of the map in cells
   * @return A Map with a single room
   */
  public static Map generateMap(int width, int height) {
    Room room = new Room(2, 2, width - 4, height - 4);
    Map map = new Map(width, height);
    map.getRooms().add(room);
    return map;
  }
}

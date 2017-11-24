package softwareengineering.scarlet.coursework2.levelgeneration;

import java.util.List;
import softwareengineering.scarlet.coursework2.models.Entity;
import softwareengineering.scarlet.coursework2.models.Level;
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
public class SimpleLevelFactory extends LevelFactory {
  /**
   * Make a Map of a defined size containing a single room.
   *
   * @param width Width of the map in cells
   * @param height Height of the map in cells
   * @return A Map with a single room
   */
  public static Level generateLevel(int width, int height, List<Entity> entities) {
    Room room = new Room(2, 2, width - 4, height - 4);
    Level map = new Level(width, height);
    map.getRooms().add(room);
    placeObjects(map, entities);
    return map;
  }
}

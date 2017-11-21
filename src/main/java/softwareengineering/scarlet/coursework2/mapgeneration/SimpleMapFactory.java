package softwareengineering.scarlet.coursework2.mapgeneration;

import softwareengineering.scarlet.coursework2.models.Map;
import softwareengineering.scarlet.coursework2.models.Room;

public class SimpleMapFactory extends MapFactory {
  public static Map generateMap(int width, int height) {
    Room room = makeRoom(2, 2, width - 4, height - 4);
    Map map = new Map(width, height);
    map.getRooms().add(room);
    return map;
  }
}

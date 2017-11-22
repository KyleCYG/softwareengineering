package softwareengineering.scarlet.coursework2.mapgeneration;

import softwareengineering.scarlet.coursework2.models.Corridor;
import softwareengineering.scarlet.coursework2.models.Map;
import softwareengineering.scarlet.coursework2.models.Room;

public class TwoRoomMapFactory extends MapFactory {
  public static Map generateMap(int width, int height) {
    Room roomA = new Room(2, 2, (width / 2) - 4, height - 4);
    Room roomB = new Room((width / 2) + 2, 2, (width / 2) - 4, height - 4);

    Leaf leafA = new Leaf(0, 0, width / 2, height);
    Leaf leafB = new Leaf(width /2, 0, width / 2, height);

    leafA.getRooms().add(roomA);
    leafB.getRooms().add(roomB);

    Map map = new Map(width, height);
    map.getRooms().add(roomA);
    map.getRooms().add(roomB);

    Corridor corridor = MapFactory.makeCorridor(leafA, leafB, Direction.VERTICAL);

    map.getCorridors().add(corridor);

    return map;
  }
}

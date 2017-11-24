package softwareengineering.scarlet.coursework2.levelgeneration;

import java.util.List;
import softwareengineering.scarlet.coursework2.models.Corridor;
import softwareengineering.scarlet.coursework2.models.Entity;
import softwareengineering.scarlet.coursework2.models.Level;
import softwareengineering.scarlet.coursework2.models.Room;

public class TwoRoomLevelFactory extends LevelFactory {
  public static Level generateLevel(int width, int height, List<Entity> entities) {
    Room roomA = new Room(2, 2, (width / 2) - 4, height - 4);
    Room roomB = new Room((width / 2) + 2, 2, (width / 2) - 4, height - 4);

    Leaf leafA = new Leaf(0, 0, width / 2, height);
    Leaf leafB = new Leaf(width /2, 0, width / 2, height);

    leafA.getRooms().add(roomA);
    leafB.getRooms().add(roomB);

    Level level = new Level(width, height);
    level.getRooms().add(roomA);
    level.getRooms().add(roomB);

    Corridor corridor = LevelFactory.makeCorridor(leafA, leafB, Direction.VERTICAL);

    level.getCorridors().add(corridor);

    placeObjects(level, entities);

    return level;
  }
}

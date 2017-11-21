package softwareengineering.scarlet.coursework2.mapgeneration;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import softwareengineering.scarlet.coursework2.models.Room;

public class MapFactory {
  private static int minRoomSize = 5;

  private static Set<Integer> roomSideRange(Room room, Direction direction) {
    /*
     * Utility method to return the width or height of a room as a set of integers
     */
    int start = direction == Direction.HORIZONTAL ? room.getX() : room.getY();
    int stop = direction == Direction.HORIZONTAL ? room.getWidth() : room.getHeight();

    Set<Integer> side = new HashSet<Integer>();
    for (int i = start; i < stop + start; i++) {
      side.add(i);
    }

    return side;
  }

  public static Set<Integer> findMatch(List<Room> sideA, List<Room> sideB, Direction direction)
      throws Exception {
    /*
     * Given two sets of rooms and a direction, find points that are found in both sets
     *
     * Slightly more clearly: imagine two rooms next to each other, overlapping but offset. This
     * method will return the points where you could draw a straight line, perpendicular to the
     * rooms, that pass through both rooms at 90 degrees.
     */
    Set<Integer> setA = new HashSet<Integer>();
    Set<Integer> setB = new HashSet<Integer>();

    for (Room room : sideA) {
      setA.addAll(roomSideRange(room, direction));
    }

    for (Room room : sideB) {
      setB.addAll(roomSideRange(room, direction));
    }

    setA.retainAll(setB);

    if (setA.size() == 0) {
      throw new Exception("No matching sides");
    }

    return setA;
  }

  public static Room makeRoom(int x, int y, int width, int height) {
    // Will replace this later, hate having randomness when testing
    Random random = new Random();

    // We'll add a boundary of 1 space around the edge (for a wall)
    int maxWidth = width - 2;
    int maxHeight = height - 2;

    // Due to the wall, the minimum width/height will be equal to half - this way two rooms
    // next to each other will guarantee an overlap
    int minWidth = width / 2;
    int minHeight = height / 2;

    // Choose a width and height!
    int roomWidth = random.nextInt(maxWidth - minWidth) + minWidth;
    int roomHeight = random.nextInt(maxHeight - minHeight) + minHeight;

    // Determine range for room placement within the leaf
    int maxX = width - roomWidth;
    int maxY = height - roomHeight;

    // Choose an x and a y! +1 for the wall
    int roomX = random.nextInt(maxX) + x + 1;
    int roomY = random.nextInt(maxY) + y + 1;

    return new Room(roomX, roomY, roomWidth, roomHeight);
  }

  public static Leaf makeNode(int x, int y, int width, int height, Direction direction) {
    if ((width <= minRoomSize * 2) || (height <= minRoomSize * 2)) {
      Leaf leaf = new Leaf(x, y, width, height);
      Room room = makeRoom(x, y, width, height);
      leaf.getRooms().add(room);
      return leaf;
    }

    // Will replace this later, hate having randomness when testing
    Random random = new Random();

    // Slightly different depending on direction!
    int toSplit = (direction == Direction.HORIZONTAL) ? height : width;

    // Only choose somewhere between the two quartiles, setting a hard lower/upper limit on min
    // height
    int min = toSplit / 4;
    min = min >= minRoomSize ? min : minRoomSize;
    int max = toSplit - min;

    int split = random.nextInt(max - min) + min;

    Direction newDirection = direction == Direction.HORIZONTAL ? Direction.VERTICAL : Direction.HORIZONTAL;

    // Make the two leaves - this will recurse until it reaches the end
    Leaf leafA = makeNode(
        x, y, direction == Direction.HORIZONTAL ? width : split,
        direction == Direction.HORIZONTAL ? split : height,
        newDirection
    );

    Leaf leafB = makeNode(direction == Direction.HORIZONTAL ? x : x + split,
        direction == Direction.HORIZONTAL ? y + split : y,
        direction == Direction.HORIZONTAL ? width : width - split,
        direction == Direction.HORIZONTAL ? height - split : height, newDirection);

    // TODO: Add a corridor between the two leaves

    // Merge the two leaves together
    leafA.getRooms().addAll(leafB.getRooms());
    leafA.getCorridors().addAll(leafB.getCorridors());

    return leafA;
  }
}

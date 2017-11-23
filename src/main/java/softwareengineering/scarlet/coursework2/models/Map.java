package softwareengineering.scarlet.coursework2.models;

import java.util.ArrayList;

/**
 * Stores information about the position of objects within the dungeon.
 *
 * Only stores direct references to rooms and corridors - objects are then stored within these.
 *
 * Use {@code getGrid} to get a 2-dimensional array giving every cell in the entire map.
 *
 * You can use {@code printGrid} to dump the map to the console.
 *
 * @author Dan Cosser
 */
public class Map {
  private ArrayList<Room> rooms;
  private ArrayList<Corridor> corridors;
  private int width;
  private int height;

  public Map(int width, int height) {
    this.rooms = new ArrayList<Room>();
    this.corridors = new ArrayList<Corridor>();
    this.width = width;
    this.height = height;
  }

  public ArrayList<Room> getRooms() {
    /**
     * A list of rooms within the dungeon.
     *
     * The ordering of this list is not consistent and may change.
     */
    return rooms;
  }

  public ArrayList<Corridor> getCorridors() {
    /**
     * A list of corridors within the dungeon.
     *
     * The ordering of this list is not consistent and may change.
     */
    return corridors;
  }

  public CellType[][] getGrid() {
    /**
     * Return a 2-dimensional grid representing the dungeon.
     */
    CellType[][] grid = new CellType[width][height];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        grid[x][y] = CellType.VOID;
      }
    }

    for (Room room : getRooms()) {
      for (int x = room.getX(); x < room.getX2(); x++) {
        for (int y = room.getY(); y < room.getY2(); y++) {
          grid[x][y] = CellType.ROOM;
        }
      }
    }

    for (Corridor corridor : getCorridors()) {
      for (int x = corridor.getX1(); x < corridor.getX2(); x++) {
        for (int y = corridor.getY1(); y < corridor.getY2(); y++) {
          grid[x][y] = CellType.ROOM;
        }
      }
    }

    return grid;
  }

  public int getWidth() {
    /**
     * The width of the dungeon in cells, zero based
     */
    return width;
  }

  public int getHeight() {
    /**
     * The height of the dungeon in cells, zero based
     */
    return height;
  }

  public void printGrid() {
    /**
     * Dump a textual representation of the map to the console.
     *
     * Be careful with large maps!
     *
     * Note that the default font is not square, and one character is used per cell, so it will
     * appear stretched.
     */
    CellType[][] grid = this.getGrid();

    for (int x = 0; x < this.getWidth(); x++) {
      for (int y = 0; y < this.getHeight(); y++) {
        switch (grid[x][y]) {
          case VOID:
            System.out.print(" ");
            break;
          case ROOM:
            System.out.print(".");
            break;
          case CORRIDOR:
            System.out.println(".");
            break;
          case WALL:
            System.out.println("#");
            break;
          default:
            break;
        }
      }
      System.out.println("\n");
    }
  }
}

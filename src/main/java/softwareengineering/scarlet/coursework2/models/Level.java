package softwareengineering.scarlet.coursework2.models;

import java.util.ArrayList;
import java.util.List;

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
public class Level {
  private ArrayList<Room> rooms;
  private ArrayList<Corridor> corridors;
  private List<Entity> entities;
  private int width;
  private int height;

  public Level(int width, int height) {
    this.rooms = new ArrayList<Room>();
    this.corridors = new ArrayList<Corridor>();
    this.entities = new ArrayList<Entity>();
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

  public List<Entity> getEntities() {
    return entities;
  }

  public CellType[][] getGrid() {
    /**
     * Return a 2-dimensional grid representing the dungeon.
     */
    CellType[][] grid = new CellType[width][height];

    // Fill the map in with void
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        grid[x][y] = CellType.VOID;
      }
    }

    // Draw rooms
    for (Room room : getRooms()) {
      // The actual room
      for (int x = room.getX(); x <= room.getX2(); x++) {
        for (int y = room.getY(); y <= room.getY2(); y++) {
          grid[x][y] = CellType.ROOM;
        }
      }
    }

    // Draw entities
    for (Entity entity : getEntities()) {
      grid[entity.getX()][entity.getY()] = entity.type;
    }

    // Draw corridors
    for (Corridor corridor : getCorridors()) {
      for (int x = corridor.getX1(); x <= corridor.getX2(); x++) {
        for (int y = corridor.getY1(); y <= corridor.getY2(); y++) {
          grid[x][y] = CellType.CORRIDOR;
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

  /**
   * What kind of thing is at grid position x, y?
   *
   * @param x Position of where we're looking
   * @param y Position of where we're looking
   * @return The type of cell at that point
   */
  public CellType getTypeAtPos(int x, int y) {
    return getGrid()[x][y];
  }

  /**
   * Find the entity at grid position x, y
   *
   * @param x Position of where we're looking
   * @param y Position of where we're looking
   * @return The entity at that position, or null if not found
   */
  public Entity getEntityAtPos(int x, int y) {
    for (Entity entity : getEntities()) {
      if (entity.getX() == x && entity.getY() == y) {
        return entity;
      }
    }

    return null;
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
            System.out.print("*");
            break;
          case WALL:
            System.out.print("#");
            break;
          case EXIT:
            System.out.print("X");
            break;
          case GOLD:
            System.out.print("G");
            break;
          case HEALTH:
            System.out.print("H");
            break;
          case STAIRSDOWN:
            System.out.print("<");
            break;
          case STAIRSUP:
            System.out.print(">");
            break;
          case STRENGTH:
            System.out.print("S");
            break;
          case STRENGTH1:
            System.out.print("S1");
            break;
          case STRENGTH2:
            System.out.print("S2");
            break;
          case STRENGTH3:
            System.out.print("S3");
            break;
        }
      }
      System.out.print("\n");
    }
  }

  private Entity getFirstEntityByType(CellType type) {
    for (Entity entity : this.getEntities()) {
      if (entity.type == CellType.STAIRSUP) {
        return entity;
      }
    }

    return null;
  }

  public Entity getStairsUp() {
    return getFirstEntityByType(CellType.STAIRSUP);
  }

  public Entity getStairsDown() {
    return getFirstEntityByType(CellType.STAIRSDOWN);
  }
}

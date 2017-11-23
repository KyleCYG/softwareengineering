package softwareengineering.scarlet.coursework2.models;

import java.util.ArrayList;

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
    return rooms;
  }

  public ArrayList<Corridor> getCorridors() {
    return corridors;
  }

  public CellType[][] getGrid() {
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
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void printGrid() {
    CellType[][] grid = this.getGrid();

    for (int x = 0; x < 50; x++) {
      for (int y = 0; y < 50; y++) {
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

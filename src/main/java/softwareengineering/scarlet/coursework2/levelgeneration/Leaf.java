package softwareengineering.scarlet.coursework2.levelgeneration;

import java.util.ArrayList;
import java.util.Comparator;
import softwareengineering.scarlet.coursework2.models.Corridor;
import softwareengineering.scarlet.coursework2.models.Room;

public class Leaf {
  private ArrayList<Room> rooms;
  private ArrayList<Corridor> corridors;
  private int x;
  private int y;
  private int width;
  private int height;

  public Leaf(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.rooms = new ArrayList<Room>();
    this.corridors = new ArrayList<Corridor>();
  }

  public ArrayList<Room> getRooms() {
    return rooms;
  }

  public ArrayList<Corridor> getCorridors() {
    return corridors;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getX2() {
    return x + width;
  }

  public int getY2() {
    return y + height;
  }

  // The functions below demonstrate how much I dislike Java.

  public int findMaxXAtY(int targetY) {
    // Sort rooms by their far right edge
    getRooms().sort(new Comparator<Room>() {
      public int compare(Room r1, Room r2) {
        return r2.getX2() - r1.getX2();
      }
    });

    // Find the furthest room that sits on the y line
    int result = -1;
    for (Room room : getRooms()) {
      if (room.getY() <= targetY && room.getY2() >= targetY) {
        result = room.getX2();
        break;
      }
    }
    return result;
  }

  public int findMinXAtY(int targetY) {
    // Sort rooms by their far left edge
    getRooms().sort(new Comparator<Room>() {
      public int compare(Room r1, Room r2) {
        return r1.getX2() - r2.getX2();
      }
    });

    // Find the furthest room that sits on the y line
    int result = -1;
    for (Room room : getRooms()) {
      if (room.getY() <= targetY && room.getY2() >= targetY) {
        result = room.getX();
        break;
      }
    }
    return result;
  }

  public int findMaxYAtX(int targetX) {
    // Sort rooms by bottom edge
    getRooms().sort(new Comparator<Room>() {
      public int compare(Room r1, Room r2) {
        return r2.getY2() - r1.getY2();
      }
    });

    // Find the furthest room that sits on the x line
    int result = -1;
    for (Room room : getRooms()) {
      if (room.getX() <= targetX && room.getX2() >= targetX) {
        result = room.getY2();
        break;
      }
    }
    return result;
  }

  public int findMinYAtX(int targetX) {
    // Sort rooms by top edge
    getRooms().sort(new Comparator<Room>() {
      public int compare(Room r1, Room r2) {
        return r1.getY() - r2.getY();
      }
    });

    // Find the furthest room that sits on the x line
    int result = -1;
    for (Room room : getRooms()) {
      if (room.getX() <= targetX && room.getX2() >= targetX) {
        result = room.getY();
        break;
      }
    }
    return result;
  }
}

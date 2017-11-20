package softwareengineering.scarlet.coursework2.mapgeneration;

import java.util.ArrayList;
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
}

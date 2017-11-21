package softwareengineering.scarlet.coursework2.models;

import java.util.ArrayList;

public class Map {
  private ArrayList<Room> rooms;
  private ArrayList<Corridor> corridors;
  private int[][] cache;
  private int width;
  private int height;

  public Map(int width, int height) {
    this.rooms = new ArrayList<Room>();
    this.corridors = new ArrayList<Corridor>();
    this.width = width;
    this.height = height;
    this.cache = new int[width][height];
  }

  public ArrayList<Room> getRooms() {
    return rooms;
  }

  public ArrayList<Corridor> getCorridors() {
    return corridors;
  }

  public int[][] getCache() {
    return cache;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}

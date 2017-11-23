package softwareengineering.scarlet.coursework2.models;

public class Room {
  private int x;
  private int y;
  private int width;
  private int height;
  
  public Room(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
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
    return x + width - 1;
  }

  public int getY2() {
    return y + height - 1;
  }
}

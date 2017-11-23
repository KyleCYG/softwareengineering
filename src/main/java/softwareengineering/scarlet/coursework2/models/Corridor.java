package softwareengineering.scarlet.coursework2.models;

public class Corridor {
  private int x1;
  private int y1;
  private int x2;
  private int y2;
  
  public Corridor(int x1, int y1, int x2, int y2) {
    assert x1 >= 0;
    assert x2 >= 0;
    assert y1 >= 0;
    assert y2 >= 0;
    assert (y1 == y2) || (x1 == x2);
    assert y1 <= y2;
    assert x1 <= x2;

    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public int getX1() {
    return x1;
  }

  public int getY1() {
    return y1;
  }

  public int getX2() {
    return x2;
  }

  public int getY2() {
    return y2;
  }
}

package softwareengineering.scarlet.coursework2.views;

public class ShowPlayer {
  
  private int x = 0;
  private int y = 0;
  private player p;
public ShowPlayer() {
  initPlayer();
}

private void initPlayer() {
  p = new player();
  p.setLocation(x, y);
}

public void setLocation(int x, int y) {
  this.x = x;
  this.y = y;
}

public int getX() {
  return x;
}

public int getY() {
  return y;
}

}

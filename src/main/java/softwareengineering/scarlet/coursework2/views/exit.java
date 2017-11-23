package softwareengineering.scarlet.coursework2.views;

import java.awt.Image;
import javax.swing.ImageIcon;

public class exit {
  private Image image;
  private int x;
  private int y;
  public void exit() {
    initExit();
  }

  private void initExit() {
    // TODO Auto-generated method stub
      ImageIcon ii = new ImageIcon("exit.png");
      image = ii.getImage();
  }
  
  public int getX() {
    return x;
}

  public int getY() {
    return y;
}

  public Image getImage() {
    return image;
}
}

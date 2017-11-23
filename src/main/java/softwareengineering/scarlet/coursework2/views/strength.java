package softwareengineering.scarlet.coursework2.views;

import java.awt.Image;
import javax.swing.ImageIcon;

public class strength {
  private Image image;
  private int x;
  private int y;
  public void strength() {
    initStrength();
  }

  private void initStrength() {
    // TODO Auto-generated method stub
      ImageIcon ii = new ImageIcon("strength.png");
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

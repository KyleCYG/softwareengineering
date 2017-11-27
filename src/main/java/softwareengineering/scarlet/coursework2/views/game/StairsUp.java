package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StairsUp implements Items{
  private Image image;
  private int x;
  private int y;
 
  public StairsUp() {
    ImageIcon ii = new ImageIcon("StU.png");
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

  @Override
  public void draw(int x, int y, Graphics2D g2d, JPanel p) {
    // To be done
  }
}

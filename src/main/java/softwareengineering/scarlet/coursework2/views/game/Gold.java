package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Gold implements Items{
  private Image image;
  private int x;
  private int y;

  public Gold(){
    ImageIcon ii = new ImageIcon("gold.png");
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
    // need to be done   
  }
}
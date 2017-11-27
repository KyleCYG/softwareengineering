package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StairsUp extends ItemImage implements Items{
  private Image image;
 
  public StairsUp() {
    ImageIcon ii = new ImageIcon("StU.png");
    image = ii.getImage();
  }

  public Image getImage() {
    return image;
  }

  @Override
  public void draw(int x, int y, Graphics2D g2d, JPanel p) {
    super.draw(image, x, y, g2d, p);
  }
}

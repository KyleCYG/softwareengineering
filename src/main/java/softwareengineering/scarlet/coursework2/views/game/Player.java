package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends ItemImage implements Items{
  private Image image;
  
  public Player() {
    ImageIcon ii = new ImageIcon("player.png");
    image = ii.getImage();
  }

  @Override
  public Image getImage() {
    return null;
  }
  
  public void draw(int x, int y, Graphics2D g2d, JPanel p) {
    super.draw(image, x, y, g2d, p);
  }
}

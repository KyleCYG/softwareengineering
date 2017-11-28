package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

public class ItemImage {
  protected Image image;

  public void draw(int x, int y, Graphics2D g2d, JPanel p) {
    if (image != null) {
      g2d.drawImage(image, GameView.getXForGridX(x), GameView.getYForGridY(y), p);
    }
  }
}

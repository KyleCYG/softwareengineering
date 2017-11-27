package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

public interface Items {
  public Image getImage();
  public void draw(int x, int y, Graphics2D g2d, JPanel p);
}

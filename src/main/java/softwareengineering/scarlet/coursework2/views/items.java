package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JPanel;

public interface items {
  public int getX();
  public int getY();
  public Image getImage();
  void draw(int x, int y, Graphics2D g2d, JPanel p);
}

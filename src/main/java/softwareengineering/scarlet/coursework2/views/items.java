package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public interface items {
  public int getX();
  public int getY();
  public Image getImage();
  public void draw(Graphics g, JPanel p);
}

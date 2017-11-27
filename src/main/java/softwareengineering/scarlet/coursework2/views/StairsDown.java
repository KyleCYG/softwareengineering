package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StairsDown implements Items{
  private Image image;
  private int x;
  private int y;
 

  public StairsDown() {
    // TODO Auto-generated method stub
      ImageIcon ii = new ImageIcon("StD.png");
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
    // TODO Auto-generated method stub
    
  }
}

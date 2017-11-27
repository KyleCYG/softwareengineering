package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Room implements Items{
  private Image image;
  private int x;
  private int y;
  
  public Room(){
    ImageIcon ii = new ImageIcon("room.png");
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
    this.x = x;
    this.y = y;
    
    g2d.setColor(new Color(125, 167, 116));
    g2d.drawRect(GameView.getXForGridX(x), GameView.getYForGridY(y), GameView.CELL_WIDTH, GameView.CELL_HEIGHT);
  }

}

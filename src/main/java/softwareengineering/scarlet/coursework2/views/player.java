package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class player implements items{
  private int dx;
  private int dy;
  private int x;
  private int y;
  private Image image;
  

  public player() {
    // TODO Auto-generated method stub
    ImageIcon ii = new ImageIcon("player.png");
    image = ii.getImage();
    
  }

  @Override
  public int getX() {
    // TODO Auto-generated method stub
    return x;
  }

  @Override
  public int getY() {
    // TODO Auto-generated method stub
    return y;
  }

 
  public Image getImage() {
    // TODO Auto-generated method stub
    return image;
  }

  public void setLocation(int x,int y) {
    this.x = x;
    this.y = y;
  }
  public void move() {
    x += dx;
    y += dy;
  }

  public void keyReleased(KeyEvent e) {
    
    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {
        x += -10;
    }

    if (key == KeyEvent.VK_RIGHT) {
        x += 10;
    }

    if (key == KeyEvent.VK_UP) {
        y += -10;
    }

    if (key == KeyEvent.VK_DOWN) {
        y += 10;
    }
  }


  @Override
  public void draw(Graphics g, JPanel p) {
    // TODO Auto-generated method stub
    Graphics2D g2d = (Graphics2D) g;
    
    g2d.drawImage(image, x, y, p);
  }

}

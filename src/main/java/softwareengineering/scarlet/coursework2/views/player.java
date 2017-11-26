package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import softwareengineering.scarlet.coursework2.MenuFrame;

public class player implements items, ActionListener {
  private int dx;
  private int dy;
  private int x;
  private int y;
  private Image image;
  private JPanel p;
  private Timer timer;
  private Graphics2D g2d;
  public player() {
    // TODO Auto-generated method stub
    ImageIcon ii = new ImageIcon("player.png");
    image = ii.getImage();
    timer = new Timer(100,this);
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
       int n;
    if (e.getKeyCode() == KeyEvent.VK_Q) {
       n = JOptionPane.showConfirmDialog(
          p,
          "Are you sure you want to quit?",
          "Quit",
          JOptionPane.YES_NO_OPTION);
      
    
    if(n == JOptionPane.OK_OPTION) {
      p.setVisible(false);
      
      MenuFrame menu = new MenuFrame();
      menu.setVisible(true);
      
    }
    }
   
  }


  @Override
  public void draw(Graphics2D g2d, JPanel p) {
    // TODO Auto-generated method stub
    this.p = p;
    this.g2d = g2d;
    g2d.drawImage(image, x, y, p);

  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
    p.repaint(); 
    timer.start();
  }

  public void redraw() {
    // TODO Auto-generated method stub
    g2d.drawImage(image, x, y, p);
    p.repaint();
  }
  
  

}

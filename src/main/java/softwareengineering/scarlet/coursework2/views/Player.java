package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import softwareengineering.scarlet.coursework2.MenuFrame;

public class Player implements Items, ActionListener {
  private int dx;
  private int dy;
  private int x;
  private int y;
  private Image image;
  private JPanel p;
  private Graphics2D g2d;

  public Player() {
    ImageIcon ii = new ImageIcon("player.png");
    image = ii.getImage();
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  public Image getImage() {
    return image;
  }

  public void setLocation(int x, int y) {
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
      x += -30;
    }

    if (key == KeyEvent.VK_RIGHT) {
      x += 30;
    }

    if (key == KeyEvent.VK_UP) {
      y += -30;
    }

    if (key == KeyEvent.VK_DOWN) {
      y += 30;
    }

    int n;

    if (e.getKeyCode() == KeyEvent.VK_Q) {
      n = JOptionPane.showConfirmDialog(p, "Are you sure you want to quit?", "Quit",
          JOptionPane.YES_NO_OPTION);

      if (n == JOptionPane.OK_OPTION) {
        p.setVisible(false);

        MenuFrame menu = new MenuFrame();
        menu.setVisible(true);
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
  }

  public void redraw() {
    g2d.drawImage(image, x, y, p);
    p.repaint();
  }

  public void draw(Graphics2D g2d, JPanel p) {
    this.p = p;
    this.g2d = g2d;
    g2d.drawImage(image, x, y, p);
  }

  @Override
  public void draw(int x, int y, Graphics2D g2d, JPanel p) {
    // To be done
  }
}

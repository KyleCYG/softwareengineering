package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PlayerRenderer implements ActionListener {
  private int dx;
  private int dy;
  private int x;
  private int y;
  private JPanel p;
  private Graphics2D g2d;
  private Player player;

  public PlayerRenderer() {
    player = new Player();
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

        //MenuFrame menu = new MenuFrame();
        //menu.setVisible(true);
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {}

  public void redraw() {
    this.player.draw(x, y, g2d, p);
    p.repaint();
  }

  public void draw(Graphics2D g2d, JPanel p) {
    this.p = p;
    this.g2d = g2d;
    this.player.draw(x, y, g2d, p);
  }
}

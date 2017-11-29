package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.Player;

public class PlayerRenderer {
  private PlayerAvatar avatar;
  private Player player;

  public PlayerRenderer(Player player) {
    avatar = new PlayerAvatar();
    this.player = player;
  }

  /*
  public void keyReleased(KeyEvent e) {
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
  */

  public void render(Graphics2D g2d, ImageObserver observer) {
    this.avatar.draw(this.player.getX(), this.player.getY(), g2d, observer);
  }
}

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

  public void render(Graphics2D g2d, ImageObserver observer) {
    this.avatar.draw(this.player.getX(), this.player.getY(), g2d, observer);
  }
}

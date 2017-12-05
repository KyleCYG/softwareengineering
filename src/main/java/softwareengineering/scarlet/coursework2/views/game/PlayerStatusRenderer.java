package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Player;

/**
 * Use for Display Player combat status at bottom of the screen.
 *
 * @author Tehniat Fatima
 */
public class PlayerStatusRenderer {

  private Player player;

  public PlayerStatusRenderer(Player player) {
    this.player = player;
  }

  @SuppressWarnings("incomplete-switch")
  public void render(Graphics2D g2d, ImageObserver observer) {
    // Set these x and y later
    int x = 80;
    int y = 4;

    PlayerItemsFactory.init("g").drawStatus(x, y, g2d, observer);
    int currentGold = player.getGold();
    g2d.drawString("x", x + 25, y + 20);
    g2d.drawString(Integer.toString(currentGold), x + 45, y + 20);

    PlayerItemsFactory.init("h").drawStatus(x + 65, y, g2d, observer);
    int hp = player.getHealthPoints();
    g2d.drawString("x", x + 90, y + 20);
    g2d.drawString(Integer.toString(hp), x + 110, y + 20);
    int strength = player.getStrength();

    CellType cellType = this.player.getStrengthItem().getType();
    switch (cellType) {
      case STRENGTH1:
        PlayerItemsFactory.init("s1").drawStatus(x + 130, y, g2d, observer);
        break;
      case STRENGTH2:
        PlayerItemsFactory.init("s2").drawStatus(x + 130, y, g2d, observer);
        break;
      case STRENGTH3:
        PlayerItemsFactory.init("s3").drawStatus(x + 130, y, g2d, observer);
        break;
    }

    g2d.drawString("x", x + 155, y + 20);
    g2d.drawString(Integer.toString(strength), x + 175, y + 20);
  }
}

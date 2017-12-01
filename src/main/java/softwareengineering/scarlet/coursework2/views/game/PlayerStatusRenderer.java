package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Player;
/**
 * Use for Display Player combat status at bottom of the screen.
 *
 *  @author Tehniat Fatima
 */
public class PlayerStatusRenderer {

  private Player player;

  public PlayerStatusRenderer(Player player) {
    this.player = player;
  }
  public void render(Graphics2D g2d, ImageObserver observer) {
    
    // set these x and y later
    int x=0;int y=0;
    PlayerItemsFactory.init("g").draw(x, y, g2d, observer);
    int currentGold=player.getGold();
    PlayerItemsFactory.init("h").draw(x, y, g2d, observer);
    int hp=player.getHealthPoints();
    CellType cellType=this.player.getStrengthItem().getType();
    int strength=player.getStrength();
    switch(cellType)
    {
      case STRENGTH1:
        PlayerItemsFactory.init("s1").draw(x, y, g2d, observer);
        break;
      case STRENGTH2:
        PlayerItemsFactory.init("s2").draw(x, y, g2d, observer);
        break;
      case STRENGTH3:
        PlayerItemsFactory.init("s3").draw(x, y, g2d, observer);
        break;
    }
  }
}

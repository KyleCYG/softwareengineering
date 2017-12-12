package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.MessageList;
import softwareengineering.scarlet.coursework2.models.Monster;
import softwareengineering.scarlet.coursework2.models.Player;
import softwareengineering.scarlet.coursework2.views.BackgroundFactory;
import softwareengineering.scarlet.coursework2.views.FontFactory;
import softwareengineering.scarlet.coursework2.views.View;

/**
 * View for the main game
 *
 * @author Clark Yang
 * @author Dan Cosser
 */
public class GameView implements View {
  public static final int CELL_HEIGHT = 32;
  public static final int CELL_WIDTH = 32;
  public static final int TOP_OFFSET = 40;
  private MonsterRenderer monsterRenderer;
  private PlayerRenderer playerRenderer;
  private LevelRenderer levelRenderer;
  private PlayerStatusRenderer playerStatusRenderer;

  protected static int getXForGridX(int gridX) {
    return gridX * CELL_WIDTH;
  }

  protected static int getYForGridY(int gridY) {
    return (gridY * CELL_HEIGHT) + TOP_OFFSET;
  }

  public void setModels(Dungeon dungeon, Player player) {
    levelRenderer = new LevelRenderer(dungeon);
    playerRenderer = new PlayerRenderer(player);
    monsterRenderer = new MonsterRenderer(dungeon);
    playerStatusRenderer = new PlayerStatusRenderer(player);
  }

  protected void renderBackground(Graphics2D g2d, ImageObserver observer) {
    g2d.drawImage(BackgroundFactory.getGameBackground(), 0, 0, observer);
  }

  protected void renderMessages(Graphics2D g2d, ImageObserver observer) {
    if (!MessageList.hasMessages()) {
      return;
    }

    for (int i = 0; i < MessageList.getMessages().size(); i++) {
      g2d.drawString(MessageList.getMessages().get(i), 80, 54 + (i * 20));
    }
  }

  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    g2d.setFont(FontFactory.getSizedFont());
    g2d.setColor(Color.white);

    renderBackground(g2d, observer);
    renderMessages(g2d, observer);
    levelRenderer.render(g2d, observer);
    playerRenderer.render(g2d, observer);

    for (Monster monster : monsterRenderer.getDungeon().getCurrentLevel().getMonsters()) {
      monsterRenderer.setMonster(monster);
      monsterRenderer.render(g2d, observer);
    }

    playerStatusRenderer.render(g2d, observer);
  }
}

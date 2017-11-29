package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Player;
import softwareengineering.scarlet.coursework2.views.View;

/**
 * View for the main game
 *
 * @author Clark Yang
 * @author Dan Cosser
 */
public class GameView implements View {
  public static final int CELL_HEIGHT = 30;
  public static final int CELL_WIDTH = 30;
  public static final int TOP_OFFSET = 40;
  private static final Font TITLE_FONT = new Font("Chalkduster", Font.PLAIN, 20);

  private PlayerRenderer playerRenderer;
  private LevelRenderer levelRenderer;
  private Image background;

  public GameView() {
    ImageIcon backgroundIco = new ImageIcon("background.png");
    background = backgroundIco.getImage();
  }

  protected static int getXForGridX(int gridX) {
    return gridX * CELL_WIDTH;
  }

  protected static int getYForGridY(int gridY) {
    return (gridY * CELL_HEIGHT) + TOP_OFFSET;
  }

  public void setModels(Dungeon dungeon, Player player) {
    levelRenderer = new LevelRenderer(dungeon);
    playerRenderer = new PlayerRenderer(player);
  }

  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    g2d.drawImage(this.background, 0, 0, observer);
    g2d.setFont(TITLE_FONT);
    g2d.drawString("Shalllll.. weeee.. begin?", 300, 25);
    levelRenderer.render(g2d, observer);
    playerRenderer.render(g2d, observer);
  }
}

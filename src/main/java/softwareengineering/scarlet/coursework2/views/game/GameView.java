package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.MessageList;
import softwareengineering.scarlet.coursework2.models.Player;
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
  private static final Font TITLE_FONT = new Font("Chalkduster", Font.PLAIN, 20);

  private PlayerRenderer playerRenderer;
  private LevelRenderer levelRenderer;
  private PlayerStatusRenderer playerStatusRenderer;
  private Image background;
  private MessageList messages;

  public GameView() {
    InputStream stream = getClass().getResourceAsStream("/background2.png");
    try {
      ImageIcon icon = new ImageIcon(ImageIO.read(stream));
      background = icon.getImage();
    } catch (IOException e) {
      throw new RuntimeException("Image %s not found! Assuming problem with resources and quitting");
    }
  }

  protected static int getXForGridX(int gridX) {
    return gridX * CELL_WIDTH;
  }

  protected static int getYForGridY(int gridY) {
    return (gridY * CELL_HEIGHT) + TOP_OFFSET;
  }

  public void setModels(Dungeon dungeon, Player player, MessageList messages) {
    levelRenderer = new LevelRenderer(dungeon);
    playerRenderer = new PlayerRenderer(player);
    playerStatusRenderer = new PlayerStatusRenderer(player);
    this.messages = messages;
  }

  protected void renderBackground(Graphics2D g2d, ImageObserver observer) {
    g2d.drawImage(this.background, 0, 0, observer);
  }

  protected void renderMessages(Graphics2D g2d, ImageObserver observer) {
    if (!messages.hasMessages()) {
      return;
    }

    g2d.drawString(messages.getMessage(), 80, 54);
  }

  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    g2d.setFont(TITLE_FONT);
    g2d.setColor(Color.white);

    renderBackground(g2d, observer);
    renderMessages(g2d, observer);
    levelRenderer.render(g2d, observer);
    playerRenderer.render(g2d, observer);
    playerStatusRenderer.render(g2d, observer);
  }
}

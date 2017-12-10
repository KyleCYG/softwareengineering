package softwareengineering.scarlet.coursework2.views;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import softwareengineering.scarlet.coursework2.models.Menu;

/**
 * Renders the title and menu to the screen.
 *
 * @author Gordon Rennie
 * @author Dan Cosser
 */
public class MenuView implements View {
  private static final Font TITLE_FONT = new Font("Chalkduster", Font.BOLD, 6);
  private static final Font MENU_FONT = new Font("Chalkduster", Font.PLAIN, 18);
  private static final int ySpacing = 30; // height between menu option
  private Menu model;
  private Image background;

  /**
   * Render to the screen.
   *
   * @param g2d The graphics object to render to.
   */
  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    this.drawBackground(g2d,observer);
    //this.drawTitle(g2d);
    this.drawOptions(g2d);
    this.drawMenuArrow(g2d);
  }

  private void drawBackground(Graphics2D g2d, ImageObserver observer) {
    InputStream stream = getClass().getResourceAsStream("/background1.png");
    try {
      ImageIcon icon = new ImageIcon(ImageIO.read(stream));
      background = icon.getImage();
    } catch (IOException e) {
      throw new RuntimeException(
          "Image %s not found! Assuming problem with resources and quitting");
    }
    g2d.drawImage(this.background, 0, 0, observer);
  }

  /**
   * Renders the menu options.
   *
   * @param g2d The graphics object the options are rendered to.
   */
  private void drawOptions(Graphics2D g2d) {
    g2d.setFont(MenuView.MENU_FONT);
    g2d.drawString("  New Game", 270, 350);
    g2d.drawString("  View Leaderboard", 270, 380);
    g2d.drawString("  Quit", 270, 410);
  }

  /**
   * Shows the arrow on the appropriate option.
   *
   * @param g2d The graphics object the arrow is rendered to.
   */
  private void drawMenuArrow(Graphics2D g2d) {
    g2d.setFont(MenuView.MENU_FONT);
    g2d.drawString("→", 270, 350 + model.getOption() * ySpacing);
  }

  /**
   * Set the model object that will be used as the source of state for rendering.
   *
   * @param menu The Menu object to be used
   */
  public void setModel(Menu menu) {
    this.model = menu;
  }
}

package softwareengineering.scarlet.coursework2.views;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import softwareengineering.scarlet.coursework2.models.GameScore;

public class AbandonGameView implements View {
  private GameScore score;
  private final Font namefont = new Font("Chalkduster", Font.PLAIN, 18);
  private Image background;

  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    g2d.setFont(this.namefont);
    this.drawBackground(g2d, observer);
    this.drawBackstory(g2d);
  }

  private void drawBackground(Graphics2D g2d, ImageObserver observer) {
    InputStream stream = getClass().getResourceAsStream("/background.png");
    try {
      ImageIcon icon = new ImageIcon(ImageIO.read(stream));
      background = icon.getImage();
    } catch (IOException e) {
      throw new RuntimeException(
          "Image %s not found! Assuming problem with resources and quitting");
    }
    g2d.drawImage(this.background, 0, 0, observer);
  }

  private void drawBackstory(Graphics2D g2d) {
    String bsTitle = "You Quit!";
    g2d.drawString(bsTitle, 200, 170);
    String backstoryText = String.format(
        "You Abandon the Game %s!\n" + "You got %s thesis papers,\n"
            + "\n\n\n      Press Enter To Go Back to Main Menu...",
        score.getPlayerName(), score.getScore());

    int x = 40;
    int y = 200;

    // Print line by line; N.B. Graphics.drawString method does not break
    // across lines, so we must do it for it.
    for (String line : backstoryText.split("\n"))
      g2d.drawString(line, x, y += g2d.getFontMetrics().getHeight());
  }

  public void setScore(GameScore score) {
    this.score = score;
  }
}

package softwareengineering.scarlet.coursework2.views;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import softwareengineering.scarlet.coursework2.models.GameScore;

public class AbandonGameView implements View {
  private GameScore score;
  private Image background;
  private Font sizedFont;
  private Image paperpageIcon;

  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    InputStream is = MenuView.class.getResourceAsStream("/Chalkduster.ttf");
    try {
      Font font = Font.createFont(Font.TRUETYPE_FONT, is);
      sizedFont = font.deriveFont(Font.BOLD, 18f);
    } catch (FontFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    g2d.setFont(sizedFont);
    this.drawBackground(g2d, observer);
    this.drawBackstory(g2d, observer);
  }

  private void drawBackground(Graphics2D g2d, ImageObserver observer) {
    InputStream stream = getClass().getResourceAsStream("/abandonbackground.png");
    try {
      ImageIcon icon = new ImageIcon(ImageIO.read(stream));
      background = icon.getImage();
    } catch (IOException e) {
      throw new RuntimeException(
          "Image %s not found! Assuming problem with resources and quitting");
    }
    g2d.drawImage(this.background, 0, 0, observer);
  }

  private void drawBackstory(Graphics2D g2d, ImageObserver observer) {
    this.paperpageIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/paperpage.gif"));
    g2d.drawImage(this.paperpageIcon, 327, 397, observer);
    g2d.drawString("x", 360, 417);
    g2d.drawString(Integer.toString(score.getScore()), 377, 417);
  }

  public void setScore(GameScore score) {
    this.score = score;
  }
}

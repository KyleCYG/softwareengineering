package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import javax.swing.JTextArea;
import softwareengineering.scarlet.coursework2.models.GameScore;

public class GameoverView implements View {
  private GameScore score;
  protected Image paperpageIcon;

  public void render(Graphics2D g2d, ImageObserver observer) {
    g2d.setFont(FontFactory.getSizedFont());
    this.drawBackground(g2d, observer);
    this.drawBackstory(g2d, observer);
  }

  private void drawBackground(Graphics2D g2d, ImageObserver observer) {
    g2d.drawImage(BackgroundFactory.getGameoverBackground(), 0, 0, observer);
  }

  private void drawBackstory(Graphics2D g2d, ImageObserver observer) {
    if (this.paperpageIcon == null) {
      this.paperpageIcon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/paperpage.gif"));
    }

    g2d.drawImage(this.paperpageIcon, 327, 397, observer);
    g2d.drawString("x", 360, 417);
    g2d.drawString(Integer.toString(score.getScore()), 377, 417);
  }

  public void setScore(GameScore score) {
    this.score = score;
  }

  @Override
  public void renderMessages(JTextArea textArea) {
    // Unnecessary override
  }
}

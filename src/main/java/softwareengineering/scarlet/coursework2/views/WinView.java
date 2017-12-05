package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.GameScore;

public class WinView implements View {
  private GameScore score;

  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    this.drawBackstory(g2d);
  }

  private void drawBackstory(Graphics2D g2d) {
    String bsTitle = "You got there!";
    g2d.drawString(bsTitle, 200, 170);
    String backstoryText =
        String.format("Congratulations %s! You got %s gold, enough to print your thesis, and made it\n"
            + " to the print shop. Handing it in is easy now - hopefully you will get a good \n"
            + "grade! Go enjoy a well earned rest... until the next time!"
            + "\n\n\n                              Press Enter To Continue...", score.getPlayerName(), score.getScore());

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

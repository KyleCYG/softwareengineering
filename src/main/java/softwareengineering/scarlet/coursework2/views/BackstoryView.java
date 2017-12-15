package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class BackstoryView implements View {
  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    this.drawBackstory(g2d, observer);
  }

  private void drawBackstory(Graphics2D g2d, ImageObserver observer) {
    String bsTitle = "Back Story";
    g2d.drawString(bsTitle, 200, 170);

    g2d.drawImage(BackgroundFactory.getBackstoryBackground(), 0, 0, observer);
  }
<<<<<<< HEAD
=======

  @Override
  public void renderMessages(JTextArea textArea) {
    // Unnecessary override
  }
>>>>>>> 2d66e1ddde464953ba19edba6de55988626b347b
}


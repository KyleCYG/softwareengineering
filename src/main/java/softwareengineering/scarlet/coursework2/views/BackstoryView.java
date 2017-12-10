package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BackstoryView implements View {
  private Image background;
  
  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    // TODO Auto-generated method stub
    this.drawBackstory(g2d,observer);
  }

  // draw back story text
  private void drawBackstory(Graphics2D g2d, ImageObserver observer) {

    String bsTitle = "Back Story";
    g2d.drawString(bsTitle, 200, 170);
    InputStream stream = getClass().getResourceAsStream("/background3.png");
    try {
      ImageIcon icon = new ImageIcon(ImageIO.read(stream));
      background = icon.getImage();
    } catch (IOException e) {
      throw new RuntimeException(
          "Image %s not found! Assuming problem with resources and quitting");
    }
    g2d.drawImage(this.background, 0, 0, observer);
    /*String backstoryText =
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. \n"
            + " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown \n"
            + "printer took a galley of type and scrambled it to make a type specimen book. It has survived not \n"
            + "only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. \n"
            + "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, \n"
            + "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            + "\n\n\n                              Press Enter To Continue..";

    int x = 40;
    int y = 200;

    // Print line by line; N.B. Graphics.drawString method does not break
    // across lines, so we must do it for it.
    for (String line : backstoryText.split("\n"))
      g2d.drawString(line, x, y += g2d.getFontMetrics().getHeight());*/
  }
}


package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ItemImage {
  protected Image image;
  protected String filename;

  private InputStream getImageStream() {
    InputStream stream = getClass().getResourceAsStream("/" + this.filename);

    if (stream == null) {
      stream = getClass().getResourceAsStream("/placeholder.png");
    }

    return stream;
  }

  private Image getImage() {
    if (this.image == null) {
      try {
        InputStream stream = getImageStream();
        if (this.filename.endsWith(".gif")) {
          this.image = Toolkit.getDefaultToolkit().createImage(this.filename);
        } else {
          ImageIcon icon = new ImageIcon(ImageIO.read(stream));
          this.image = icon.getImage();
        }
      } catch (IOException io) {
        throw new RuntimeException(String.format(
            "Image %s not found! Assuming problem with resources and quitting", this.filename));
      }
    }

    return this.image;
  }

  public void draw(int x, int y, Graphics2D g2d, ImageObserver observer) {
    g2d.drawImage(this.getImage(), GameView.getXForGridX(x), GameView.getYForGridY(y), observer);
  }

  public void drawStatus(int x, int y, Graphics2D g2d, ImageObserver observer) {
    g2d.drawImage(this.getImage(), x, y, observer);
  }
}

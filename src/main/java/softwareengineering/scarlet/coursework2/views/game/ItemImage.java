package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ItemImage {
  protected Image image;
  protected String filename;

  private Image getImage() {
    if (this.image == null) {
      try {
        InputStream stream = getClass().getResourceAsStream("/" + this.filename);
        ImageIcon icon = new ImageIcon(ImageIO.read(stream));
        this.image = icon.getImage();
      } catch (IOException io) {
        System.out.println("Blargh");
      }
    }
    return this.image;
  }

  public void draw(int x, int y, Graphics2D g2d, JPanel panel) {
    g2d.drawImage(this.getImage(), GameView.getXForGridX(x), GameView.getYForGridY(y), panel);
  }
}

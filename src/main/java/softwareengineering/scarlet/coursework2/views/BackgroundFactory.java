package softwareengineering.scarlet.coursework2.views;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BackgroundFactory {
  private static Image background;
  private static Image abandonBackground;
  private static Image backstoryBackground;
  private static Image gameoverBackground;
  private static Image menuBackground;
  private static Image winBackground;

  private static Image getImageFromDisk(String filename) {
    InputStream stream = BackgroundFactory.class.getClassLoader().getResourceAsStream(filename);
    try {
      ImageIcon icon = new ImageIcon(ImageIO.read(stream));
      return icon.getImage();
    } catch (IOException e) {
      throw new RuntimeException(
          "Image %s not found! Assuming problem with resources and quitting");
    }
  }

  public static Image getMainBackground() {
    if (background == null) {
      background = getImageFromDisk("background.png");
    }

    return background;
  }

  public static Image getAbandonBackground() {
    if (abandonBackground == null) {
      abandonBackground = getImageFromDisk("abandonbackground.png");
    }

    return abandonBackground;
  }

  public static Image getBackstoryBackground() {
    if (backstoryBackground == null) {
      backstoryBackground = getImageFromDisk("background3.png");
    }

    return backstoryBackground;
  }

  public static Image getGameoverBackground() {
    if (gameoverBackground == null) {
      gameoverBackground = getImageFromDisk("gameoverbackground.png");
    }

    return gameoverBackground;
  }

  public static Image getMenuBackground() {
    if (menuBackground == null) {
      menuBackground = getImageFromDisk("background1.png");
    }

    return menuBackground;
  }

  public static Image getWinBackground() {
    if (winBackground == null) {
      winBackground = getImageFromDisk("winbackground.png");
    }

    return winBackground;
  }
}

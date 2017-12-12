package softwareengineering.scarlet.coursework2.views;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class FontFactory {
  private static Font sizedFont;

  public static Font getSizedFont() {
    if (sizedFont == null) {
      InputStream is = MenuView.class.getResourceAsStream("/Chalkduster.ttf");
      try {
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        sizedFont = font.deriveFont(Font.BOLD, 18f);
      } catch (FontFormatException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return sizedFont;
  }
}

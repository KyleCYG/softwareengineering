package softwareengineering.scarlet.coursework2.views.game;

import javax.swing.ImageIcon;

public class Wall extends ItemImage {
  public Wall() {
    ImageIcon ii = new ImageIcon("wall.png");
    image = ii.getImage();
  }
}

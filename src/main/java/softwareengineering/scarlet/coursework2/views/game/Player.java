package softwareengineering.scarlet.coursework2.views.game;

import javax.swing.ImageIcon;

public class Player extends ItemImage {
  public Player() {
    ImageIcon ii = new ImageIcon("player.png");
    image = ii.getImage();
  }
}

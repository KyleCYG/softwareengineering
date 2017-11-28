package softwareengineering.scarlet.coursework2.views.game;

import javax.swing.ImageIcon;

public class Room extends ItemImage {
  public Room() {
    ImageIcon ii = new ImageIcon("room.png");
    this.image = ii.getImage();
  }
}

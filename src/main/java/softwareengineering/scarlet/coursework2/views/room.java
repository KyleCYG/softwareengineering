package softwareengineering.scarlet.coursework2.views;
import java.awt.Image;
import javax.swing.ImageIcon;
public class room {
  private Image image;
  private int x;
  private int y;
  public void room() {
        initRoom();
  }

  private void initRoom() {
    // TODO Auto-generated method stub
      ImageIcon ii = new ImageIcon("room.png");
      image = ii.getImage();
  }
  
  public int getX() {
    return x;
}

  public int getY() {
    return y;
}

  public Image getImage() {
    return image;
}

}

package softwareengineering.scarlet.coursework2.views;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
public class room implements items{
  private Image image;
  private int x;
  private int y;
  

  public room(){
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


  @Override
  public void draw(Graphics g, JPanel p) {
    // TODO Auto-generated method stub
    
  }

}

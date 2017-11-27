package softwareengineering.scarlet.coursework2.views;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
  public void draw(int x, int y, Graphics2D g2d, JPanel p) {
    // TODO Auto-generated method stub
    this.x = x;
    this.y = y;
    
  //  g2d.drawImage(image, x, y, p);
    
    g2d.setColor(new Color(125, 167, 116));
    g2d.drawRect(x*30, 40+y*30, 30, 30);
  }

}

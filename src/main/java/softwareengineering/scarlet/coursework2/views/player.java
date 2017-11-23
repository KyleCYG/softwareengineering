package softwareengineering.scarlet.coursework2.views;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
public class player {
	 private int dx;
	    private int dy;
	    private int x;
	    private int y;
	    private Image image;

	    public player() {
	        
	      initPlayer();
	    }
	    
	    private void initPlayer() {
	        
	        ImageIcon ii = new ImageIcon("player.png");
	        image = ii.getImage();
	        
	    }
	    public void setLocation(int x,int y) {
	      this.x = x;
	      this.y = y;
	    }


	    public void move() {
	        x += dx;
	        y += dy;
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

	 /*   public void keyPressed(KeyEvent e) {

	        int key = e.getKeyCode();
	    }*/ // keypressed 

	    public void keyReleased(KeyEvent e) {
	        
	        int key = e.getKeyCode();

	        if (key == KeyEvent.VK_LEFT) {
	            x += -10;
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	            x += 10;
	        }

	        if (key == KeyEvent.VK_UP) {
	            y += -10;
	        }

	        if (key == KeyEvent.VK_DOWN) {
	            y += 10;
	        }
	    }
}

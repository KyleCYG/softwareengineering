package softwareengineering.scarlet.coursework2.playerappear;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
public class Player {
	 private int dx;
	    private int dy;
	    private int x;
	    private int y;
	    private Image image;

	    public Player() {
	        
	        initCraft();
	    }
	    
	    private void initCraft() {
	        
	        ImageIcon ii = new ImageIcon("man.png");
	        image = ii.getImage();
	        x = 450;
	        y = 350;        
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

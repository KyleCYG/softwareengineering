package softwareengineering.scarlet.coursework2.views;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
      private ShowMap sm;
	 public GameFrame(ShowMap sm) {
	        this.sm = sm;
	        initUI();
	    }
	    
	    private void initUI() {

	        add(new GamePanel(sm));
	        
	        setResizable(false);
	        
	        setTitle("It's a Dungen Game!");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setExtendedState(JFrame.MAXIMIZED_BOTH);
	        

	    }

	    public static void main(String[] args) {
	       ShowMap sm;
          sm = new ShowMap();
          sm.setupEntity(1, 1, 1, 1, 1);
          sm.setupSize(50, 25);
          
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	              GameFrame ex = new GameFrame(sm);
	                ex.setVisible(true);
	            }
	        });
	    }
}

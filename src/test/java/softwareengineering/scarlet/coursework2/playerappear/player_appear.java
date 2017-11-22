package softwareengineering.scarlet.coursework2.playerappear;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class player_appear extends JFrame{
	 public player_appear() {
	        
	        initUI();
	    }
	    
	    private void initUI() {
	        
	        add(new Board());
	        
	        setSize(900, 700);
	        setResizable(false);
	        
	        setTitle("It's a Dungen Game!");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public static void main(String[] args) {
	        
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                
	              player_appear ex = new player_appear();
	                ex.setVisible(true);
	            }
	        });
	    }
}

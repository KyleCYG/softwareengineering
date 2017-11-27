package softwareengineering.scarlet.coursework2.views;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameFrame extends JFrame{  
  public GameFrame() {
    // TODO Auto-generated constructor stub
    initUI();
  }

  private void initUI() {
    add(new GamePanel());
    setResizable(false);
    setTitle("It's a Dungen Game!");
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        GameFrame ex = new GameFrame();
        ex.setVisible(true);
      }
    });
  }
}

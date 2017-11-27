package softwareengineering.scarlet.coursework2.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import softwareengineering.scarlet.coursework2.views.game.ShowMap;

public class InputNameFrame extends JFrame {

  private ShowMap sm;
  
  public InputNameFrame() {
    initUI();
  }

  private void initUI() {
    add(new InputNamePanel());
    setSize(500, 500);
    setResizable(false);
    setTitle("Player Name");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   // setExtendedState(JFrame.MAXIMIZED_BOTH);
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        InputNameFrame ex = new InputNameFrame();
        ex.setVisible(true);
      }
    });
  }  
}

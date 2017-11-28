package softwareengineering.scarlet.coursework2.views.game;

import javax.swing.JFrame;
import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.models.Dungeon;

public class GameFrame extends JFrame {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private GamePanel panel;

  public GameFrame(GameController controller, Dungeon dungeon) {
    initUI(controller, dungeon);
  }

  private void initUI(GameController controller, Dungeon dungeon) {
    panel = new GamePanel(controller, dungeon);
    add(panel);
    setResizable(false);
    setTitle("It's a Dungen Game!");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
  }

  public GamePanel getPanel() {
    return panel;
  }
}

package softwareengineering.scarlet.coursework2.views.game;

import javax.swing.JFrame;
import softwareengineering.scarlet.coursework2.models.Dungeon;

public class GameFrame extends JFrame {
  public GameFrame(Dungeon dungeon) {
    initUI(dungeon);
  }

  private void initUI(Dungeon dungeon) {
    add(new GamePanel(dungeon));
    setResizable(false);
    setTitle("It's a Dungen Game!");
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setExtendedState(JFrame.MAXIMIZED_BOTH);
  }
}

package softwareengineering.scarlet.coursework2.views.game;

import java.awt.EventQueue;
import softwareengineering.scarlet.coursework2.models.Dungeon;

/**
 * View for the main game
 *
 * @author Clark Yang
 * @author Dan Cosser
 */
public class GameView {
  /**
   * A reference to the current dungeon to render
   */
  private Dungeon dungeon;

  public GameView(Dungeon dungeon) {
    this.dungeon = dungeon;
 
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        GameFrame frame = new GameFrame(dungeon);
        frame.setVisible(true);
      }
    });
  }

  public Dungeon getDungeon() {
    return dungeon;
  }

  public void setDungeon(Dungeon dungeon) {
    this.dungeon = dungeon;
    render();
  }

  /**
   * Render the currently loaded Dungeon to the screen
   */
  public void render() {
    
  }
}

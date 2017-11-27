package softwareengineering.scarlet.coursework2.views.game;

import java.awt.EventQueue;
import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.models.Dungeon;

/**
 * View for the main game
 *
 * @author Clark Yang
 * @author Dan Cosser
 */
public class GameView {
  public static final int CELL_HEIGHT = 30;
  public static final int CELL_WIDTH = 30;
  public static final int TOP_OFFSET = 40;

  private Dungeon dungeon;
  private GameController controller;
  private GameFrame frame;

  public GameView(GameController controller, Dungeon dungeon) {
    this.dungeon = dungeon;
    this.controller = controller;
 
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        frame = new GameFrame(controller, dungeon);
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

  public static int getXForGridX(int gridX) {
    return gridX * CELL_WIDTH;
  }

  public static int getYForGridY(int gridY) {
    return (gridY * CELL_HEIGHT) + TOP_OFFSET;
  }

  /**
   * Render the currently loaded Dungeon to the screen
   */
  public void render() {
    
  }
}

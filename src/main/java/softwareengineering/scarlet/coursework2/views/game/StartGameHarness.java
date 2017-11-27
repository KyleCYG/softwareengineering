package softwareengineering.scarlet.coursework2.views.game;

import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.models.Dungeon;

public class StartGameHarness {
  public static void main(String[] args) {
    GameController controller = new GameController("Scarlet Pimpernel");
    Dungeon dungeon = new Dungeon(48, 25, 1);
    GameView start = new GameView(controller, dungeon);
  }
}
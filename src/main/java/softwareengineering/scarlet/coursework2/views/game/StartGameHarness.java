package softwareengineering.scarlet.coursework2.views.game;

import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.models.Dungeon;

public class StartGameHarness {
  public static void main(String[] args) {
    GameController controller = new GameController("Scarlet Pimpernel");
    Dungeon dungeon = new Dungeon(44, 25, 1);
    new GameView(controller, dungeon);
  }
}

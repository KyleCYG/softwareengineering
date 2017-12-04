package softwareengineering.scarlet.coursework2.controllers;

import java.util.HashMap;
import java.util.Map;
import softwareengineering.scarlet.coursework2.App;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Player;
import softwareengineering.scarlet.coursework2.models.Room;
import softwareengineering.scarlet.coursework2.views.View;
import softwareengineering.scarlet.coursework2.views.game.GameView;

public class GameController implements Controller {
  private GameView view;
  private Dungeon dungeon;
  private Player player;
  private App app;

  // TODO: split these constants into some kind of gameConfig class?
  private static final int LEVEL_HEIGHT = 20;
  private static final int LEVEL_WIDTH = 20;
  private static final int NUM_LEVELS = 4;

  // Map of movement directions to their x, y movements
  private static final Map<MoveDirection, Pair> moveMap;
  static {
    moveMap = new HashMap<MoveDirection, Pair>();
    moveMap.put(MoveDirection.RIGHT, new Pair(1, 0));
    moveMap.put(MoveDirection.LEFT, new Pair(-1, 0));
    moveMap.put(MoveDirection.UP, new Pair(0, -1));
    moveMap.put(MoveDirection.DOWN, new Pair(0, 1));
    moveMap.put(MoveDirection.UPLEFT, new Pair(-1, -1));
    moveMap.put(MoveDirection.UPRIGHT, new Pair(1, -1));
    moveMap.put(MoveDirection.DOWNLEFT, new Pair(-1, 1));
    moveMap.put(MoveDirection.DOWNRIGHT, new Pair(1, 1));
  }

  public GameController(App app) {
    this.app = app;
  }

  /**
   * Assumed to be instantiated once per game, therefore it also creates a dungeon and player for
   * the game.
   *
   * @param playerName The player's name for this playthrough
   */
  public void setUpModels(String playerName) {
    // create new dungeon
    this.dungeon = new Dungeon(GameController.LEVEL_WIDTH, GameController.LEVEL_HEIGHT,
        GameController.NUM_LEVELS);

    // get the location of the first room (arbitrarily...) in the dungeon
    // TODO: make the start location selection more intelligent
    Room startRoom = dungeon.getCurrentLevel().getRooms().get(0);
    int startX = startRoom.getX();
    int startY = startRoom.getY();

    // create player
    this.player = new Player(playerName, startX, startY);

    // create player status

  }

  /**
   * Moves the player to adjacent tile in the specified direction.
   *
   * @param direction A valid direction as defined in the MoveDirection enum
   */
  public void movePlayer(MoveDirection direction) {
    Pair movePair = moveMap.get(direction);

    int targetX = player.getX() + movePair.getX();
    int targetY = player.getY() + movePair.getY();

    if (this.dungeon.getCurrentLevel().getTypeAtPos(targetX, targetY) != CellType.VOID) {
      player.movePlayer(movePair.getX(), movePair.getY());

      // checks if the player's position is the same as the gold's position and increase the amount
      // of gold
      if (this.dungeon.getCurrentLevel().getTypeAtPos(targetX, targetY) == CellType.GOLD) {
        player.setGold(player.getGold() + 1);

        // checks if the player's position is the same as the gold's position and increase the
        // amount of health points
      } else if (this.dungeon.getCurrentLevel().getTypeAtPos(targetX, targetY) == CellType.HEALTH) {

        player.increaseHealthPoint(1);
      }
    }
  }

  @Override
  public View getView() {
    return view;
  }

  @SuppressWarnings("incomplete-switch")
  @Override
  public void handleInput(Input input) {
    switch (input) {
      case UP:
        movePlayer(MoveDirection.UP);
        break;
      case DOWN:
        movePlayer(MoveDirection.DOWN);
        break;
      case LEFT:
        movePlayer(MoveDirection.LEFT);
        break;
      case RIGHT:
        movePlayer(MoveDirection.RIGHT);
        break;
      case QUIT:
        app.quit();
        break;
    }
  }

  @Override
  public void init(View view) {
    this.view = (GameView) view;
    setUpModels("Scarlet Pimpernel");
    this.view.setModels(this.dungeon, this.player);
  }
}

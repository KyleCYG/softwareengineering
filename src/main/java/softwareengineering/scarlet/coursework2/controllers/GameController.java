package softwareengineering.scarlet.coursework2.controllers;

import java.util.HashMap;
import java.util.Map;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Player;
import softwareengineering.scarlet.coursework2.models.Room;

public class GameController {
  private Dungeon dungeon;
  private Player player;
  
  // TODO: split these constants into some kind of gameConfig class?
  private static final int LEVEL_HEIGHT = 64;
  private static final int LEVEL_WIDTH = 64;
  private static final int NUM_LEVELS = 4;
  
  // Map of movement directions to their x, y movements
  private static final Map<MoveDirection, Pair> moveMap;
  static {
    moveMap = new HashMap<MoveDirection, Pair>();
    moveMap.put(MoveDirection.UP, new Pair(1, 0));
    moveMap.put(MoveDirection.DOWN, new Pair(-1, 0));
    moveMap.put(MoveDirection.LEFT, new Pair(0, -1));
    moveMap.put(MoveDirection.RIGHT, new Pair(0, 1));
    moveMap.put(MoveDirection.UPLEFT, new Pair(1, -1));
    moveMap.put(MoveDirection.UPRIGHT, new Pair(1, 1));
    moveMap.put(MoveDirection.DOWNLEFT, new Pair(-1, -1));
    moveMap.put(MoveDirection.DOWNRIGHT, new Pair(-1, 1));
  }

  /**
   * Constructor. Assumed to be instantiated once per game, therefore it also creates a dungeon and
   * player for the game.
   * 
   * @param playerName The player's name for this playthrough
   */
  public GameController(String playerName) {
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
  }

  public void movePlayer() {
    // TODO Auto-generated method stub
    
  }
  
  /**
   * Moves the player to adjacent tile in the specified direction.
   * 
   * @param direction A valid direction as defined in the MoveDirection enum
   */
  public void movePlayer(MoveDirection direction) {
    Pair movePair = moveMap.get(direction);
    // TODO: implement check to see whether the player CAN legally move
    player.movePlayer(movePair.getX(), movePair.getY());
  }
}

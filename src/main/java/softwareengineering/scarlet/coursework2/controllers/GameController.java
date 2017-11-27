package softwareengineering.scarlet.coursework2.controllers;

import java.awt.Point;
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
  
}

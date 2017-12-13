package softwareengineering.scarlet.coursework2.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import softwareengineering.scarlet.coursework2.App;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.DemoMonster;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Entity;
import softwareengineering.scarlet.coursework2.models.GameScore;
import softwareengineering.scarlet.coursework2.models.MessageList;
import softwareengineering.scarlet.coursework2.models.Monster;
import softwareengineering.scarlet.coursework2.models.Player;
import softwareengineering.scarlet.coursework2.models.Room;
import softwareengineering.scarlet.coursework2.models.StrengthItem;
import softwareengineering.scarlet.coursework2.views.View;
import softwareengineering.scarlet.coursework2.views.game.GameView;

public class GameController implements Controller {
  private GameView view;
  protected Dungeon dungeon;
  protected Player player;
  private String playerName;
  private App app;

  // TODO: split these constants into some kind of gameConfig class?
  private static final int LEVEL_HEIGHT = 20;
  private static final int LEVEL_WIDTH = 20;
  private static final int NUM_LEVELS = 4;

  private boolean yn = false;
  private boolean moveOn = true;

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
   * Set the player's name for this play through.
   *
   * Used by the SetPreGameController to pass the name to the GameController so it can be recorded
   * in the Player object
   *
   * @param playerName The player's chosen name
   */
  public void setPlayerName(String playerName) {
    this.playerName = playerName;
  }

  @Override
  public View getView() {
    return view;
  }

  /**
   * Assumed to be instantiated once per game, therefore it also creates a dungeon and player for
   * the game.
   *
   * @param playerName The player's name for this playthrough
   */
  public void setUpModels() {
    // Create new dungeon
    this.dungeon = new Dungeon(GameController.LEVEL_WIDTH, GameController.LEVEL_HEIGHT,
        GameController.NUM_LEVELS);

    // Get the location of the first room (arbitrarily...) in the dungeon
    // TODO: make the start location selection more intelligent
    Room startRoom = dungeon.getCurrentLevel().getRooms().get(0);
    int startX = startRoom.getX();
    int startY = startRoom.getY();

    // Create player
    this.player = new Player(playerName, startX, startY);
  }

  /**
   * Implementation of player actions, based on movement.
   *
   * The actual action performed depends on the type of the cell the player is moving on to.
   *
   * @param movePair The movement action of the player
   */
  @SuppressWarnings("incomplete-switch")
  protected void performAction(Pair movePair) {
    int targetX = player.getX() + movePair.getX();
    int targetY = player.getY() + movePair.getY();

    CellType targetCellType = this.dungeon.getCurrentLevel().getTypeAtPos(targetX, targetY);
    CharacterinSameRoom(player);
    scanForMonsters(targetX, targetY);
    if (moveOn) {
      switch (targetCellType) {
        case ROOM:
        case CORRIDOR:
          player.move(movePair.getX(), movePair.getY());
          break;

        case GOLD:
          player.setGold(player.getGold() + 1);
          player.move(movePair.getX(), movePair.getY());
          Entity gold = this.dungeon.getCurrentLevel().getEntityAtPos(targetX, targetY);
          // Remove gold
          this.dungeon.getCurrentLevel().getEntities().remove(gold);
          break;

        case HEALTH:
          player.increaseHealthPoint(1);
          player.move(movePair.getX(), movePair.getY());
          Entity health = this.dungeon.getCurrentLevel().getEntityAtPos(targetX, targetY);
          // Remove health item
          this.dungeon.getCurrentLevel().getEntities().remove(health);
          break;

        case STRENGTH1:
          player.setStrengthItem(new StrengthItem(10, CellType.STRENGTH1));
          player.move(movePair.getX(), movePair.getY());
          Entity strength1 = this.dungeon.getCurrentLevel().getEntityAtPos(targetX, targetY);
          // Remove strength1
          this.dungeon.getCurrentLevel().getEntities().remove(strength1);
          break;

        case STRENGTH2:
          player.setStrengthItem(new StrengthItem(20, CellType.STRENGTH2));
          player.move(movePair.getX(), movePair.getY());
          Entity strength2 = this.dungeon.getCurrentLevel().getEntityAtPos(targetX, targetY);
          // Remove strength2
          this.dungeon.getCurrentLevel().getEntities().remove(strength2);
          break;

        case STRENGTH3:
          player.setStrengthItem(new StrengthItem(30, CellType.STRENGTH3));
          player.move(movePair.getX(), movePair.getY());
          Entity strength3 = this.dungeon.getCurrentLevel().getEntityAtPos(targetX, targetY);
          // Remove strength3
          this.dungeon.getCurrentLevel().getEntities().remove(strength3);
          break;

        case STAIRSUP:
          dungeon.goUp();
          player.setX(dungeon.getCurrentLevel().getStairsDown().getX());
          player.setY(dungeon.getCurrentLevel().getStairsDown().getY());
          break;

        case STAIRSDOWN:
          dungeon.goDown();
          player.setX(dungeon.getCurrentLevel().getStairsUp().getX());
          player.setY(dungeon.getCurrentLevel().getStairsUp().getY());
          break;
        case EXIT:
          if (player.getGold() >= Dungeon.REQUIRED_SCORE) {
            GameScore score = new GameScore(player.getName(), player.getGold());
            app.getWinController().setScore(score);
            app.switchToWin();
          } else {
            MessageList.addMessage(String.format("You still need %d more gold!",
                Dungeon.REQUIRED_SCORE - player.getGold()));
            player.move(movePair.getX(), movePair.getY());
          }
          break;
      }
    }
  }



  /**
   * Checks if there is a monster 1 tile away from the player in x and/or y axis
   * 
   * @param targetY The position that the user intends to move the player in y axis
   * @param targetX The position that the user intends to move the player in x axis
   * 
   */
  private boolean scanForMonsters(int targetX, int targetY) {
    // TODO Auto-generated method stub

    List<Monster> monsterList = this.dungeon.getCurrentLevel().getMonsters();
    for (Iterator<Monster> it = monsterList.iterator(); it.hasNext();) {
      Monster monster = it.next();

      if (((player.getX() == monster.getX() + 1) && (player.getY() == monster.getY()))
          || ((player.getX() == monster.getX() - 1) && (player.getY() == monster.getY()))
          || (player.getX() == monster.getX()) && (player.getY() == monster.getY() + 1)
          || (player.getX() == monster.getX()) && (player.getY() == monster.getY() - 1)) {

        if (monster.getX() == targetX && monster.getY() == targetY && this.dungeon.getCurrentLevel()
            .getTypeAtPos(player.getX(), player.getY()) == CellType.ROOM) {
          monster.decreaseHealthPoint(player.getStrength());
          MessageList.addMessage("You hit the monster! Damage: " + -player.getStrength()
              + " Monster's current health:" + monster.getHealthPoints());
          moveOn = false;
        } else
          moveOn = true;

        if (monster.getHealthPoints() <= 0) {
          it.remove();
          MessageList.addMessage("Monster is dead!");
          moveOn = true;
        }

      }

    }
    if (player.getHealthPoints() <= 0) {
      MessageList.addMessage("You got killed by Monster.Game Over!");
      GameScore score = new GameScore(player.getName(), player.getGold());
      app.getGameOverController().setScore(score);
      MessageList.clear();
      moveOn = true;
      app.switchToGameOver();

    }
    return moveOn;

  }

  /**
   * Checks if the player and a monster are in the same room
   * 
   * @param player The player object
   */
  public void CharacterinSameRoom(Player player) {
    boolean m = false;
    boolean p = false;
    ArrayList<Room> rooms = dungeon.getCurrentLevel().getRooms();
    List<Monster> monsters = dungeon.getCurrentLevel().getMonsters();
    DemoMonster tempMonster = null;
    Player tempPlayer;
    Room roomwithPlayer = null;;
    for (Room room : rooms) {// player is in room 0
      if ((player.getX() <= room.getX2() && player.getX() >= room.getX())
          && (player.getY() <= room.getY2() && player.getY() >= room.getY())) {

        p = true;
        tempPlayer = player;
        roomwithPlayer = room;
        break;
      }
    }

    if (monsters.size() != 0 && roomwithPlayer != null) {
      for (Monster monster : monsters) {
        if ((monster.getX() <= roomwithPlayer.getX2() && monster.getX() >= roomwithPlayer.getX())
            && (monster.getY() <= roomwithPlayer.getY2()
                && monster.getY() >= roomwithPlayer.getY())) {
          m = true;
          monster.setHunt(true);

        } else {
          m = false;
          monster.setHunt(false);
        }
      }
    }

  }


  /**
   * Moves the player to adjacent tile in the specified direction.
   *
   * @param direction A valid direction as defined in the MoveDirection enum
   */
  public void movePlayer(MoveDirection direction) {
    Pair movePair = moveMap.get(direction);
    performAction(movePair);
  }

  /**
   * Give the monster's a turn each.
   *
   * Iterates through each monster on the level, asking each to perform an action based on the state
   * of the dungeon and the player.
   */
  protected void handleMonsters() {
    for (Monster monster : dungeon.getCurrentLevel().getMonsters()) {
      monster.performAction(dungeon, player);
    }
  }

  /**
   * Perform an action based on the player's input when the game is in the "game" mode (i.e. normal
   * game actions)
   *
   * Once complete, control is handed to the monsters for them to have a turn
   *
   * @param input The input from the view
   */
  @SuppressWarnings("incomplete-switch")
  private void handleGameInput(Input input) {
    switch (input) {
      case UP:
        MessageList.clear();
        movePlayer(MoveDirection.UP);
        break;
      case DOWN:
        MessageList.clear();
        movePlayer(MoveDirection.DOWN);
        break;
      case LEFT:
        MessageList.clear();
        movePlayer(MoveDirection.LEFT);
        break;
      case RIGHT:
        MessageList.clear();
        movePlayer(MoveDirection.RIGHT);
        break;
      case QUIT:
      case Q:
        MessageList.addMessage("Are you sure you want to quit? (Y/N)");
        yn = true;
        break;
    }

    handleMonsters();

  }

  /**
   * Perform an action based on the player's input when the game is in the "abandon" mode (i.e. the
   * user has an expressed a desire to quit and the game is asking for confirmation)
   *
   * @param input The input from the view
   */
  @SuppressWarnings("incomplete-switch")
  private void handleAbandonInput(Input input) {
    switch (input) {
      case Y:
        GameScore score = new GameScore(player.getName(), player.getGold());
        MessageList.clear();
        yn = false;
        app.getAbandonGameController().setScore(score);
        app.switchToAbandonGame();
        break;
      case N:
        MessageList.clear();
        yn = false;
        break;
    }
  }

  /**
   * Perform an action based on the player's input
   *
   * The action depends on what "mode" the game is in - normal play, or the abandon question
   *
   * @param input The input from the view
   */
  @Override
  public void handleInput(Input input) {
    if (yn) {
      handleAbandonInput(input);
    } else {
      handleGameInput(input);
    }
  }

  @Override
  public void init(View view) {
    this.view = (GameView) view;
    setUpModels();
    this.view.setModels(this.dungeon, this.player);
  }
}

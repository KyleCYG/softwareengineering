package softwareengineering.scarlet.coursework2.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import softwareengineering.scarlet.coursework2.controllers.MoveDirection;
import softwareengineering.scarlet.coursework2.controllers.Pair;

/**
 * Implementation of monster's actions depending on the player's position
 *
 * Only works with DemoMonster
 */
public class MonsterBehaviourType1 implements MonsterBehaviour {

  private MoveDirection moveDirection;

  @Override
  /**
   * Implementation of monster's actions depending on the player's position
   *
   * @param monster, dungeon, player
   */
  public void performAction(Monster monster, Dungeon dungeon, Player player) {
    DemoMonster myMonster = (DemoMonster) monster;

    CharacterInSameRoom(myMonster, player, dungeon);
    if (myMonster.isHunt()) {
      MessageList.removeDuplicateMessages();
      MessageList.addMessage("A monster is hunting you!");
      huntPlayer(myMonster, player);
    } else {
      getDirection();
    }

    Pair movePair = moveMap.get(moveDirection);
    int targetX = myMonster.getX() + movePair.getX();
    int targetY = myMonster.getY() + movePair.getY();

    CellType targetCellType = dungeon.getCurrentLevel().getTypeAtPos(targetX, targetY);

    switch (targetCellType) {
      case ROOM:
      case GOLD:
      case HEALTH:
      case STRENGTH1:
      case STRENGTH2:
      case STRENGTH3:
        if (dungeon.getCurrentLevel().getTypeAtPos(player.getX(),
            player.getY()) == CellType.CORRIDOR)
          myMonster.setHunt(false);

        if (targetX == player.getX() && targetY == player.getY()) {
          // if player and monster are on same tile don't move
          fightPlayer(player, myMonster);
        } else {
          myMonster.move(movePair.getX(), movePair.getY());
        }
        break;

      case CORRIDOR:
        break;
      case MONSTER:
        break;
      case MONSTERSPAWNER:
        break;

      case VOID:
        break;

      default:
        break;
    }
  }

  /**
   * Monster fights player if the player is one tile away
   *
   * @param player The player object
   * @param monster The monster object
   */
  public void fightPlayer(Player player, Monster monster) {
    if (((player.getX() == monster.getX() + 1) && (player.getY() == monster.getY()))
        || ((player.getX() == monster.getX() - 1) && (player.getY() == monster.getY()))
        || (player.getX() == monster.getX()) && (player.getY() == monster.getY() + 1)
        || (player.getX() == monster.getX()) && (player.getY() == monster.getY() - 1)) {

      player.decreaseHealthPoint(monster.getStrength());
      MessageList.addMessage("You got hit by the monster! Damage:" + -monster.getStrength());
      if (player.healthPoints <= 0)
        MessageList.addMessage("You got killed by Monster.Game Over!");
    }
  }

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

  /**
   * Implementation of the monster's idle state. The monster moves randomly in the room when it is
   * not in hunt state
   */
  private void getDirection() {
    Random rand = new Random();
    int randomNumber = rand.nextInt(4);
    switch (randomNumber) {
      case 0:
        moveDirection = MoveDirection.UP;
        break;
      case 1:
        moveDirection = MoveDirection.DOWN;
        break;
      case 2:
        moveDirection = MoveDirection.LEFT;
        break;
      case 3:
        moveDirection = MoveDirection.RIGHT;
        break;
    }
  }

  /**
   * Checks if the player and the monster are in the same room, and if so set the monster's hunt
   * status
   */
  private static void CharacterInSameRoom(DemoMonster monster, Player player, Dungeon dungeon) {
    Level level = dungeon.getCurrentLevel();

    if (level.getRoomAtPos(player.getX(), player.getY()) == level.getRoomAtPos(monster.getX(), monster.getY())) {
      // Player is in the same room
      monster.setHunt(true);
    } else {
      // Player isn't in the same room
      monster.setHunt(false);
    }
  }

  /**
   * Implementation of the player hunting algorithm
   *
   * @param monster The monster object
   * @param player The player object
   */
  public void huntPlayer(Monster monster, Player player) {
    int dx = monster.getX() - player.getX(), dy = monster.getY() - player.getY();
    int nx = Math.abs(dx), ny = Math.abs(dy);
    int sign_x = dx > 0 ? 1 : -1, sign_y = dy > 0 ? 1 : -1;
    int ix = 0, iy = 0;

    if ((0.5 + ix) / nx < (0.5 + iy) / ny) {
      // next step is horizontal
      if (sign_x == 1) {
        moveDirection = MoveDirection.LEFT;
      } else {
        moveDirection = MoveDirection.RIGHT;
      }
    } else {
      // next step is vertical
      if (sign_y == 1) {
        moveDirection = MoveDirection.UP;
      } else {
        moveDirection = MoveDirection.DOWN;
      }
    }
  }
}

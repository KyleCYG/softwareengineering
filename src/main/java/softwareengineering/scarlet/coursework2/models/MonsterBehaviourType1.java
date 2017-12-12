package softwareengineering.scarlet.coursework2.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import softwareengineering.scarlet.coursework2.controllers.MoveDirection;
import softwareengineering.scarlet.coursework2.controllers.Pair;

public class MonsterBehaviourType1 implements MonsterBehaviour {

  private MoveDirection moveDirection;

  @Override
  public void performAction(Monster monster, Dungeon dungeon, Player player) {
    // TODO Auto-generated method stub
    if (monster.isHunt()) {
      huntPlayer(monster, player);
    } else {
      getDirection();
    }
    Pair movePair = moveMap.get(moveDirection);
    int targetX = monster.getX() + movePair.getX();
    int targetY = monster.getY() + movePair.getY();

    CellType targetCellType = dungeon.getCurrentLevel().getTypeAtPos(targetX, targetY);

    switch (targetCellType) {
      case ROOM:
        if (targetX == player.getX() && targetY == player.getY()) {
          // player and monster are on same tile dont move

        } else {
          monster.move(movePair.getX(), movePair.getY());
          fightPlayer(player, monster);
        }

        break;
      case CORRIDOR:
        break;
      case GOLD:
        break;
      case HEALTH:
        break;
      case STRENGTH1:
        break;
      case STRENGTH2:
        break;
      case STRENGTH3:
        break;
      case VOID:
        break;
      default:
        break;

    }
  }

  public void fightPlayer(Player player, Monster monster) {
    if (((player.getX() == monster.getX() + 1) && (player.getY() == monster.getY()))
        || ((player.getX() == monster.getX() - 1) && (player.getY() == monster.getY()))
        || (player.getX() == monster.getX()) && (player.getY() == monster.getY() + 1)
        || (player.getX() == monster.getX()) && (player.getY() == monster.getY() - 1)) {

      player.decreaseHealthPoint(monster.getStrength());
      if (player.getHealthPoints() <= 0)
      {
        MessageList.addMessage("You got killed by Monster.Game Over!");
      }
     else {
      MessageList.addMessage("You got hit by the monster! Damage:" + -monster.getStrength());
    }
    }
    // System.out.println("I WILL KILL YOU " + "monster coords: " + monster.getX() + ", "
    // + monster.getY() + " player coords: " + player.getX() + ", " + player.getY());


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

  public void huntPlayer(Monster monster, Player player) {
    int dx = monster.getX() - player.getX(), dy = monster.getY() - player.getY();
    int nx = Math.abs(dx), ny = Math.abs(dy);
    int sign_x = dx > 0 ? -1 : 1, sign_y = dy > 0 ? -1 : 1;
    int ix = 0, iy = 0;

    if ((0.5 + ix) / nx < (0.5 + iy) / ny) {
      // next step is horizontal
      if (sign_x == 1)
        moveDirection = MoveDirection.RIGHT;
      else
        moveDirection = MoveDirection.LEFT;
    } else {
      // next step is vertical
      if (sign_y == 1)
        moveDirection = MoveDirection.DOWN;
      else
        moveDirection = MoveDirection.UP;

    }

  }

}

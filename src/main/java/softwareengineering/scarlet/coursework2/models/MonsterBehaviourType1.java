package softwareengineering.scarlet.coursework2.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import softwareengineering.scarlet.coursework2.controllers.Input;
import softwareengineering.scarlet.coursework2.controllers.MoveDirection;
import softwareengineering.scarlet.coursework2.controllers.Pair;

public class MonsterBehaviourType1 implements MonsterBehaviour {

  private MoveDirection moveDirection;

  @Override
  public void performAction(Monster monster, Dungeon dungeon, Player player) {
    // TODO Auto-generated method stub
    getDirection();
    Pair movePair = moveMap.get(moveDirection);
    int targetX = player.getX() + movePair.getX();
    int targetY = player.getY() + movePair.getY();

    CellType targetCellType = dungeon.getCurrentLevel().getTypeAtPos(targetX, targetY);

    switch (targetCellType) {
      case ROOM:
      case CORRIDOR:
      case GOLD:
      case HEALTH:
      case STRENGTH1:
      case STRENGTH2:
      case STRENGTH3:
        monster.move(movePair.getX(), movePair.getY());
        break;
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



}

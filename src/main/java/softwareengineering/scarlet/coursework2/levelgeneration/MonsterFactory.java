package softwareengineering.scarlet.coursework2.levelgeneration;

import softwareengineering.scarlet.coursework2.models.DemoMonster;
import softwareengineering.scarlet.coursework2.models.Monster;

public class MonsterFactory {
  public static Monster generateMonster(int startX, int startY) {
    // TODO: replace with some logic to pick monsters
    return new DemoMonster(startX, startY);
  }
}

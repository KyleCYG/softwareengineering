package softwareengineering.scarlet.coursework2.levelgeneration;

import java.util.ArrayList;
import java.util.List;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.DemoMonster;
import softwareengineering.scarlet.coursework2.models.Entity;
import softwareengineering.scarlet.coursework2.models.Monster;

public class MonsterFactory {
  public static Monster generateMonster(int startX, int startY) {
    // TODO: replace with some logic to pick monsters
    return new DemoMonster(startX, startY);
  }

  public static List<Monster> generateMonsters(List<Entity> entities, int levelNumber, int totalLevels) {
    List<Monster> monsters = new ArrayList<Monster>();
    List<Entity> entitiesToRemove = new ArrayList<Entity>();

    for (Entity entity : entities) {
      if (entity.type != CellType.MONSTERSPAWNER) {
        continue;
      }

      monsters.add(generateMonster(entity.getX(), entity.getY()));

      entitiesToRemove.add(entity);
    }

    entities.removeAll(entitiesToRemove);

    return monsters;
  }
}

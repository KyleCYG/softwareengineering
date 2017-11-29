package softwareengineering.scarlet.coursework2.models;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import softwareengineering.scarlet.coursework2.levelgeneration.SimpleLevelFactory;

public class LevelTest {
  @Test
  public void testVoidTypeAtPos() {
    int entityPositionX = 0;
    int entityPositionY = 0;
    Level level = SimpleLevelFactory.generateLevel(50, 50, new ArrayList<Entity>());

    assertEquals(CellType.VOID, level.getTypeAtPos(entityPositionX, entityPositionY));
  }

  @Test
  public void testRoomTypeAtPos() {
    int entityPositionX = 10;
    int entityPositionY = 10;
    Level level = SimpleLevelFactory.generateLevel(50, 50, new ArrayList<Entity>());

    assertEquals(CellType.ROOM, level.getTypeAtPos(entityPositionX, entityPositionY));
  }

  @Test
  public void testEntityTypeAtPos() {
    int entityPositionX = 10;
    int entityPositionY = 10;
    Level level = SimpleLevelFactory.generateLevel(50, 50, new ArrayList<Entity>());
    Entity entity = new HealthItem(1);
    entity.setPosition(entityPositionX, entityPositionY);
    level.getEntities().add(entity);

    assertEquals(entity.type, level.getTypeAtPos(entityPositionX, entityPositionY));
  }

  @Test
  public void testGetEntityAtPos() {
    int entityPositionX = 10;
    int entityPositionY = 10;
    Level level = SimpleLevelFactory.generateLevel(50, 50, new ArrayList<Entity>());
    Entity entity = new HealthItem(1);
    entity.setPosition(entityPositionX, entityPositionY);
    level.getEntities().add(entity);

    assertEquals(entity, level.getEntityAtPos(entityPositionX, entityPositionY));
  }

  @Test
  public void testGetNoEntityAtPos() {
    int entityPositionX = 10;
    int entityPositionY = 10;
    Level level = SimpleLevelFactory.generateLevel(50, 50, new ArrayList<Entity>());

    assertEquals(null, level.getEntityAtPos(entityPositionX, entityPositionY));
  }
}

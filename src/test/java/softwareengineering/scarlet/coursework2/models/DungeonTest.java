package softwareengineering.scarlet.coursework2.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.List;
import org.junit.Test;

public class DungeonTest {
  @Test
  public void testGenerateLevels() {
    int numLevels = 6;
    List<Level> levels = Dungeon.generateLevels(50, 50, numLevels);

    assertEquals(numLevels, levels.size());
  }

  @Test
  public void testCurrentLevelFromBlank() {
    int numLevels = 6;
    Dungeon dungeon = new Dungeon(50, 50, numLevels);

    assertEquals(null, dungeon.levels);

    Level level = dungeon.getCurrentLevel();

    assertNotEquals(null, level);
    assertEquals(numLevels, dungeon.levels.size());
    assertSame(level, dungeon.levels.get(0));
  }
}

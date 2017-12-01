package softwareengineering.scarlet.coursework2.levelgeneration;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EntityFactoryTest {

  @Test
  public void testGenerateGold_checkSum() {
    int totalLevels = 6;
    int targetGold = 100;
    int totalGold = 0;

    for (int level = 0; level < totalLevels; level++) {
      totalGold += EntityFactory.generateGold(level, totalLevels, targetGold).size();
    }

    // Test that the resulting gold is greater or equal to the amount we asked for
    assertTrue(totalGold >= targetGold);

    // Test that the resulting gold is less than the total possible rounding error - equal to the
    // number of levels, as each can be "wrong" by a max of 1
    assertTrue(totalGold <= targetGold + totalLevels);
  }

  @Test
  public void testGenerateGold_distribution() {
    int totalLevels = 6;
    int targetGold = 100;

    int amountPreviousLevel = EntityFactory.generateGold(0, totalLevels, targetGold).size();

    for (int level = 1; level < totalLevels; level++) {
      int amountThisLevel = EntityFactory.generateGold(level, totalLevels, targetGold).size();

      assertEquals(amountThisLevel / amountPreviousLevel, (level + 1) / level);

      amountPreviousLevel = amountThisLevel;
    }
  }
}

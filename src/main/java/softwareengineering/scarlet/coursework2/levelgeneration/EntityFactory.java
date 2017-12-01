package softwareengineering.scarlet.coursework2.levelgeneration;

import java.util.ArrayList;
import java.util.List;
import softwareengineering.scarlet.coursework2.models.GoldItem;

/**
 * Used to generate entity items over appropriate distributions for the difficulty of a level.
 *
 * @author Gordon Rennie
 * @author Dan Cosser
 */
public class EntityFactory {
  /**
   * Generate gold for the level.
   * 
   * Gold is generated on a level in proportion to its level number (+1 for zero base). E.g. level 1
   * gets half as much gold as level 2 and a third as much as level 3.
   *
   * @param levelNumber The index of the level (0-based)
   * @param totalLevels Total count of levels
   * @param totalGold Total gold to appear in entire dungeon
   * @return A list of GoldItems to populate the level with.
   */
  public static List<GoldItem> generateGold(int levelNumber, int totalLevels, int totalGold) {
    int n = levelNumber + 1;
    double nTotal = totalLevels * (totalLevels + 1) / 2; // the nth triangle number, equal to summing all level numbers
    int goldInLevel = (int) Math.ceil((n / nTotal) * totalGold);

    List<GoldItem> result = new ArrayList<GoldItem>();

    for (int i = 0; i < goldInLevel; i++) {
      result.add(new GoldItem(1));
    }

    return result;
  }
}

package softwareengineering.scarlet.coursework2.levelgeneration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Entity;
import softwareengineering.scarlet.coursework2.models.ExitItem;
import softwareengineering.scarlet.coursework2.models.GoldItem;
import softwareengineering.scarlet.coursework2.models.HealthItem;
import softwareengineering.scarlet.coursework2.models.StairsDownItem;
import softwareengineering.scarlet.coursework2.models.StairsUpItem;
import softwareengineering.scarlet.coursework2.models.StrengthItem;

/**
 * Used to generate entity items over appropriate distributions for the difficulty of a level.
 *
 * @author Gordon Rennie
 * @author Dan Cosser
 */
public class EntityFactory {
  protected static final int NUM_ENTITIES_PER_LEVEL = 10;

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
  protected static List<GoldItem> generateGold(int levelNumber, int totalLevels, int totalGold) {
    int n = levelNumber + 1;
    double nTotal = totalLevels * (totalLevels + 1) / 2; // the nth triangle number, equal to
                                                         // summing all level numbers
    int goldInLevel = (int) Math.ceil((n / nTotal) * totalGold);

    List<GoldItem> result = new ArrayList<GoldItem>();

    for (int i = 0; i < goldInLevel; i++) {
      result.add(new GoldItem(1));
    }

    return result;
  }

  /**
   * Determine the percentage chance of an entity appearing, between bounds
   *
   * @param levelNumber The current level to determine a chance for
   * @param totalLevels The maximum number of levels to consider
   * @param min The minimum chance of appearing between 0.0 and 1.0
   * @param max The maximum chance of appearing between 0.0 and 1.0
   * @param positive True if the chance rises as you go deeper into the dungeon
   * @return The chance of appearing, between 0.0 and 1.0
   */
  protected static double generateChance(int levelNumber, int totalLevels, double min, double max,
      boolean positive) {
    max = max > 1 ? 1 : max;
    min = min > 1 ? 1 : min;
    double gradient = (max - min) / totalLevels;
    int direction = positive ? 1 : -1;
    double constant = positive ? min : max;
    return constant + (gradient * levelNumber) * direction;
  }

  /**
   * Ranges from a 74% chance to a 1% chance of getting a health item
   *
   * @param levelNumber Current level
   * @param totalLevels Total number of levels to consider
   * @return Chance of return a health item for this level, between 0.0 and 1.0
   */
  protected static double generateHealthChance(int levelNumber, int totalLevels) {
    return generateChance(levelNumber, totalLevels, 0.01, 0.74, false);
  }

  /**
   * Ranges from a 1% chance to a 74% chance of getting a monster spawn
   *
   * @param levelNumber Current level
   * @param totalLevels Total number of levels to consider
   * @return Chance of return a health item for this level, between 0.0 and 1.0
   */
  protected static double generateMonsterChance(int levelNumber, int totalLevels) {
    return generateChance(levelNumber, totalLevels, 0.01, 0.74, true);
  }

  /**
   * Ranges from a 0% chance to a 25% chance of getting a strength one item, but only considers the
   * first half of the levels.
   *
   * @param levelNumber Current level
   * @param totalLevels Total number of levels to consider
   * @return Chance of return a health item for this level, between 0.0 and 1.0
   */
  protected static double generateStrengthOneChance(int levelNumber, int totalLevels) {
    // Ranges between 25% and 0%, but only for the first half of the levels
    if (levelNumber > totalLevels / 2) {
      return 0;
    }
    return generateChance(levelNumber, totalLevels / 2, 0.01, 0.25, false);
  }

  /**
   * Ranges from a 0% chance to a 25% chance of getting a strength two item, rising and then
   * falling.
   *
   * @param levelNumber Current level
   * @param totalLevels Total number of levels to consider
   * @return Chance of return a health item for this level, between 0.0 and 1.0
   */
  protected static double generateStrengthTwoChance(int levelNumber, int totalLevels) {
    if (levelNumber < totalLevels / 2) {
      return generateChance(levelNumber, totalLevels / 2, 0, 0.25, true);
    } else {
      return generateChance(levelNumber - (totalLevels / 2), totalLevels / 2, 0, 0.25, false);
    }
  }

  /**
   * Ranges from a 25% chance to a 0% chance of getting a strength three item, but only considers the
   * second half of the levels.
   *
   * @param levelNumber Current level
   * @param totalLevels Total number of levels to consider
   * @return Chance of return a health item for this level, between 0.0 and 1.0
   */
  protected static double generateStrengthThreeChance(int levelNumber, int totalLevels) {
    if (levelNumber < totalLevels / 2) {
      return 0;
    }
    return generateChance(levelNumber - (totalLevels / 2), totalLevels / 2, 0, 0.25, false);
  }

  /**
   * Generate health and strength items.
   *
   * @param levelNumber Current level
   * @param totalLevels Total number of levels to consider
   * @return A list of HealthItems and Strength*Items appropriate for the level
   */
  protected static List<Entity> generateHealthAndStrength(int levelNumber, int totalLevels) {
    List<Entity> entities = new ArrayList<Entity>();

    // Make cumulative chance boundaries
    double healthLevel = generateHealthChance(levelNumber, totalLevels);
    double strengthOneLevel = healthLevel + generateStrengthOneChance(levelNumber, totalLevels);
    double strengthTwoLevel =
        strengthOneLevel + generateStrengthTwoChance(levelNumber, totalLevels);
    double strengthThreeLevel =
        strengthTwoLevel + generateStrengthThreeChance(levelNumber, totalLevels);
    double choice;
    Random random = new Random();

    // For each "slot" in a level, randomly pick an entity
    for (int i = 0; i < NUM_ENTITIES_PER_LEVEL; i++) {
      choice = random.nextDouble();
      if (choice < healthLevel) {
        entities.add(new HealthItem(1));
      } else if (choice < strengthOneLevel) {
        entities.add(new StrengthItem(1,CellType.STRENGTH1));
      } else if (choice < strengthTwoLevel) {
        entities.add(new StrengthItem(2,CellType.STRENGTH1));
      } else if (choice < strengthThreeLevel) {
        entities.add(new StrengthItem(3,CellType.STRENGTH1));
      }
    }

    return entities;
  }

  /**
   * Make the stairs up, stairs down and exit entities
   *
   * @param levelNumber Current level
   * @param totalLevels Total levels in the dungeon
   * @return A combination of StairsUpItem, StairsDownItem and ExitItem
   */
  protected static List<Entity> generateStairs(int levelNumber, int totalLevels) {
    List<Entity> entities = new ArrayList<Entity>();

    if (levelNumber != 0) {
      entities.add(new StairsUpItem(levelNumber - 1));
    }
    if (levelNumber == totalLevels - 1) {
      entities.add(new ExitItem());
    } else {
      entities.add(new StairsDownItem(levelNumber + 1));
    }

    return entities;
  }

  /**
   * Generate all non-character entities for the dungeon
   *
   * @param levelNumber The depth of the level
   * @param totalLevels The total number of levels in the dungeon
   * @return A list of items with which to populate the map
   */
  public static List<Entity> generateItems(int levelNumber, int totalLevels, int totalGold) {
    List<Entity> entities = new ArrayList<Entity>();

    // First, add the gold items, which vary based on the total amount of gold in the dungeon
    entities.addAll(generateGold(levelNumber, totalLevels, totalGold));

    // Next, randomly choose health and strength items
    entities.addAll(generateHealthAndStrength(levelNumber, totalLevels));

    // Finally add "stairs up" and "stairs down"
    entities.addAll(generateStairs(levelNumber, totalLevels));

    return entities;
  }
}

package softwareengineering.scarlet.coursework2.models;

import java.util.ArrayList;
import java.util.List;
import softwareengineering.scarlet.coursework2.levelgeneration.EntityFactory;
import softwareengineering.scarlet.coursework2.levelgeneration.LevelFactory;

public class Dungeon {
  public static final int REQUIRED_SCORE = 100;
  protected List<Level> levels;
  private Level currentLevel;
  private int numLevels;
  private int width;
  private int height;

  public Dungeon(int width, int height, int numLevels) {
    this.numLevels = numLevels;
    this.width = width;
    this.height = height;
  }

  /**
   * Generate all the levels for the dungeon.
   *
   * @param width Size of the dungeon in cells
   * @param height Size of the dungeon in cells
   * @param numLevels How many levels are in the dungeon
   * @return
   */
  protected static List<Level> generateLevels(int width, int height, int numLevels) {
    List<Level> levels = new ArrayList<Level>();

    for (int i = 0; i < numLevels; i++) {
      List<Entity> entities = Dungeon.generateEntities(i, numLevels); // difficulty is proportional
                                                                      // to level
      levels.add(LevelFactory.generateLevel(width, height, entities));
    }

    return levels;
  }

  /**
   * Generates a list of entities to populate a level
   *
   * @param level The depth of the level to be populated - the higher the number, the harder the level
   * @return A list of entities
   */
  protected static List<Entity> generateEntities(int level, int numLevels) {
    return EntityFactory.generateItems(level, numLevels, REQUIRED_SCORE);
  }

  /**
   * @return The current level being played
   */
  public Level getCurrentLevel() {
    if (this.levels == null) {
      this.levels = Dungeon.generateLevels(this.width, this.height, this.numLevels);
      this.currentLevel = this.levels.get(0);
    }
    return this.currentLevel;
  }
}

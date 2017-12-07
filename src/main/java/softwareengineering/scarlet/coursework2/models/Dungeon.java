package softwareengineering.scarlet.coursework2.models;

import java.util.ArrayList;
import java.util.List;
import softwareengineering.scarlet.coursework2.levelgeneration.EntityFactory;
import softwareengineering.scarlet.coursework2.levelgeneration.LevelFactory;

public class Dungeon {
  public static final int REQUIRED_SCORE = 20;
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

  public Dungeon(int width, int height, List<Level> levels) {
    this.levels = levels;
    this.numLevels = levels.size();
    this.width = width;
    this.height = height;
    this.currentLevel = this.levels.get(0);
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
    if (this.levels == null || this.levels.size() == 0) {
      this.levels = Dungeon.generateLevels(this.width, this.height, this.numLevels);
      this.currentLevel = this.levels.get(0);
    }
    return this.currentLevel;
  }

  /**
   * Drop the player to the next lowest level
   *
   * @return The new level
   */
  public Level goDown() {
    int currentIndex = this.levels.indexOf(this.getCurrentLevel());
    this.currentLevel = levels.get(currentIndex + 1);
    return this.getCurrentLevel();
  }

  /**
   * Raise the player to the next highest level
   *
   * @return The new level
   */
  public Level goUp() {
    int currentIndex = this.levels.indexOf(this.getCurrentLevel());
    this.currentLevel = levels.get(currentIndex - 1);
    return this.getCurrentLevel();
  }
}

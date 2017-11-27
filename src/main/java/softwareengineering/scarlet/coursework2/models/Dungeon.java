package softwareengineering.scarlet.coursework2.models;

import java.util.ArrayList;
import java.util.List;
import softwareengineering.scarlet.coursework2.levelgeneration.LevelFactory;

public class Dungeon {
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

  protected static List<Level> generateLevels(int width, int height, int numLevels) {
    List<Level> levels = new ArrayList<Level>();

    for (int i = 0; i < numLevels; i++) {
      List<Entity> entities = Dungeon.generateEntities(i); // difficulty is proportional to level
      levels.add(LevelFactory.generateLevel(width, height, entities));
    }

    return levels;
  }

  /**
   * Generates a list of entities to populate a level with
   * 
   * @param difficulty An arbitrary number representing difficulty, higher is harder
   * @return A list of entities
   */
  protected static List<Entity> generateEntities(int difficulty) {
    List<Entity> entities = new ArrayList<Entity>();
    
    int numGoldItems = 4;
    
    // Generate gold (with value proportional to difficulty) and add
    for (int i = 0; i < numGoldItems; i++){
      entities.add(new GoldItem((difficulty+1) * 10));
    }
    
    return entities;
  }
  
  public Level getCurrentLevel() {
    if (this.levels == null) {
      this.levels = Dungeon.generateLevels(this.width, this.height, this.numLevels);
      this.currentLevel = this.levels.get(0);
    }
    return this.currentLevel;
  }
}

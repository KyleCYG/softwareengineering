package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Level;

public class LevelRenderer {
  private Dungeon dungeon;

  public LevelRenderer(Dungeon dungeon) {
    init(dungeon);
  }

  public void init(Dungeon dungeon) {
    this.dungeon = dungeon;
  }

  public void render(Graphics2D g2d, ImageObserver observer) {
    Level level = dungeon.getCurrentLevel();

    CellType[][] grid = level.getGrid();

    for (int x = 0; x < level.getWidth(); x++) {
      for (int y = 0; y < level.getHeight(); y++) {
        switch (grid[x][y]) {
          case VOID:
            break;
          case ROOM:
            LevelItemsFactory.init("r").draw(x, y, g2d, observer);
            break;
          case CORRIDOR:
            LevelItemsFactory.init("c").draw(x, y, g2d, observer);
            break;
          case WALL:
            LevelItemsFactory.init("w").draw(x, y, g2d, observer);
            break;
          case EXIT:
            LevelItemsFactory.init("e").draw(x, y, g2d, observer);
            break;
          case GOLD:
            LevelItemsFactory.init("g").draw(x, y, g2d, observer);
            break;
          case HEALTH:
            LevelItemsFactory.init("h").draw(x, y, g2d, observer);
            break;
          case STAIRSDOWN:
            LevelItemsFactory.init("SD").draw(x, y, g2d, observer);
            break;
          case STAIRSUP:
            LevelItemsFactory.init("SU").draw(x, y, g2d, observer);
            break;
          case STRENGTH:
            LevelItemsFactory.init("s").draw(x, y, g2d, observer);
            break;
          case STRENGTH1:
            LevelItemsFactory.init("s1").draw(x, y, g2d, observer);
            break;
          case STRENGTH2:
            LevelItemsFactory.init("s2").draw(x, y, g2d, observer);
            break;
          case STRENGTH3:
            LevelItemsFactory.init("s3").draw(x, y, g2d, observer);
            break;
          default:
            break;
        }
      }
    }
  }
}

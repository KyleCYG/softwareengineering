package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.Arrays;
import java.util.List;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Level;

public class LevelRenderer {
  private static List<CellType> needsFloor = Arrays.asList(CellType.EXIT, CellType.GOLD,
      CellType.HEALTH, CellType.STAIRSDOWN, CellType.STAIRSUP, CellType.STRENGTH,
      CellType.STRENGTH1, CellType.STRENGTH2, CellType.STRENGTH3, CellType.MONSTER);

  private Dungeon dungeon;

  public LevelRenderer(Dungeon dungeon) {
    init(dungeon);
  }

  public void init(Dungeon dungeon) {
    this.dungeon = dungeon;
  }

  private void renderGrid(Level level, Graphics2D g2d, ImageObserver observer) {
    CellType[][] grid = level.getGrid();

    for (int x = 0; x < level.getWidth(); x++) {
      for (int y = 0; y < level.getHeight(); y++) {
        // If void, don't draw anything
        if (grid[x][y] == CellType.VOID) {
          continue;
        }

        // Some entities require floor to be drawn beneath them, so draw that first
        if (needsFloor.contains(grid[x][y])) {
          LevelItemsFactory.init(CellType.ROOM).draw(x, y, g2d, observer);
        }

        // Finally load the entity image from the cache and draw it
        LevelItemsFactory.init(grid[x][y]).draw(x, y, g2d, observer);
      }
    }
  }

  public void render(Graphics2D g2d, ImageObserver observer) {
    Level level = dungeon.getCurrentLevel();

    renderGrid(level, g2d, observer);
  }
}

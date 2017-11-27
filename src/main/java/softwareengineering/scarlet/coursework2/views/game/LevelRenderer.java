package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Color;
import java.awt.Graphics2D;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Level;

public class LevelRenderer {
  private Level level;

  public LevelRenderer(Dungeon dungeon) {
    init(dungeon);
  }

  public void init(Dungeon dungeon) {
    level = dungeon.getCurrentLevel();
  }

  public void render(Graphics2D g2d) {
    CellType[][] grid = level.getGrid();
    LevelItemsFactory mif = new LevelItemsFactory();

    for (int x = 0; x < level.getWidth(); x++) {
      for (int y = 0; y < level.getHeight(); y++) {
        switch (grid[x][y]) {
          case VOID:
            break;
          case ROOM:
            mif.init("r").draw(x, y, g2d, null);
            break;
          case CORRIDOR:
            g2d.setColor(new Color(42, 179, 231));
            g2d.drawRect(x * 30, 40 + y * 30, 30, 30);
            break;
          case WALL:
            g2d.setColor(new Color(130, 100, 84));
            g2d.drawRect(x * 30, 40 + y * 30, 30, 30);
            break;
          case EXIT:
            break;
          case GOLD:
            g2d.setColor(new Color(130, 100, 84));
            g2d.drawOval(x * 30, 40 + y * 30, 30, 30);
            break;
          case HEALTH:
            break;
          case STAIRSDOWN:
            break;
          case STAIRSUP:
            break;
          case STRENGTH:
            break;
          default:
            break;
        }
      }
    }
  }
}
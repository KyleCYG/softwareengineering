package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import javax.swing.JPanel;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Level;

public class LevelRenderer {
  private Level level;
  private JPanel p;

  public LevelRenderer(Dungeon dungeon, JPanel p) {
    this.p = p;
    init(dungeon);
  }

  public void init(Dungeon dungeon) {
    level = dungeon.getCurrentLevel();
  }

  public void render(Graphics2D g2d) {
    CellType[][] grid = level.getGrid();
    LevelItemsFactory lif = new LevelItemsFactory();

    for (int x = 0; x < level.getWidth(); x++) {
      for (int y = 0; y < level.getHeight(); y++) {
        switch (grid[x][y]) {
          case VOID:
            break;
          case ROOM:
            lif.init("r").draw(x, y, g2d, p);
            break;
          case CORRIDOR:
            lif.init("c").draw(x, y, g2d, p);
            break;
          case WALL:
            lif.init("w").draw(x, y, g2d, p);
            break;
          case EXIT:
            lif.init("e").draw(x, y, g2d, p);
            break;
          case GOLD:
            lif.init("g").draw(x, y, g2d, p);
            break;
          case HEALTH:
            lif.init("h").draw(x, y, g2d, p);
            break;
          case STAIRSDOWN:
            lif.init("SD").draw(x, y, g2d, p);
            break;
          case STAIRSUP:
            lif.init("SU").draw(x, y, g2d, p);
            break;
          case STRENGTH:
            lif.init("s").draw(x, y, g2d, p);
            break;
          default:
            break;
        }
      }
    }
  }
}

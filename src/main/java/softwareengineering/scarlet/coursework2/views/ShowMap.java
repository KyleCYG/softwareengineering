package softwareengineering.scarlet.coursework2.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import softwareengineering.scarlet.coursework2.levelgeneration.LevelFactory;
import softwareengineering.scarlet.coursework2.models.CellType;
import softwareengineering.scarlet.coursework2.models.Entity;
import softwareengineering.scarlet.coursework2.models.ExitItem;
import softwareengineering.scarlet.coursework2.models.GoldItem;
import softwareengineering.scarlet.coursework2.models.HealthItem;
import softwareengineering.scarlet.coursework2.models.Level;
import softwareengineering.scarlet.coursework2.models.StairsDownItem;
import softwareengineering.scarlet.coursework2.models.StairsUpItem;
import softwareengineering.scarlet.coursework2.models.StrengthItem;

public class ShowMap {
  private Level level;
  private List<Entity> entities = new ArrayList<Entity>();
  private int width;
  private int heigh;
  private LevelItemsFactory mif;
  private int[] roomArrays;
  public ShowMap(int amount_gold, int amount_heal, int amount_stre, int amount_StU, int amount_StD,int width, int heigh) {
    entities.add(new GoldItem(amount_gold));
    entities.add(new HealthItem(amount_heal));
    entities.add(new StrengthItem(amount_stre));
    entities.add(new StairsUpItem(amount_StU));
    entities.add(new StairsDownItem(amount_StD));
    entities.add(new ExitItem());
    this.width = width;
    this.heigh = heigh;
    init();
  }
  
  public void init() {
    level = LevelFactory.generateLevel(this.width, this.heigh, this.entities);
  }
  public void Show(Graphics2D g2d) {
    CellType[][] grid = level.getGrid();
    roomArrays = null;
    mif = new LevelItemsFactory();
    
    for(int x=0;x<level.getWidth();x++) {
      for(int y=0;y<level.getHeight();y++) {
        switch(grid[x][y]) {
          case VOID:

            break;
          case ROOM:
            mif.init("r").draw(x, y, g2d, null);
            //roomArrays[x][y] = 1;
            break;
          case CORRIDOR:
            g2d.setColor(new Color(42, 179, 231));
            g2d.drawRect(x*30, 40+y*30, 30, 30);
            break;
          case WALL:
            g2d.setColor(new Color(130, 100, 84));
            g2d.drawRect(x*30, 40+y*30, 30, 30);
            break;
          case EXIT:
            
            break;
          case GOLD:
            g2d.setColor(new Color(130, 100, 84));
            g2d.drawOval(x*30, 40+y*30, 30, 30);
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

  
  public List<Entity> getEntities() {
    return entities;
  }
  
  public Level getMap() {
    return level;
  }

}

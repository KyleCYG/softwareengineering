package softwareengineering.scarlet.coursework2.views;

import java.util.ArrayList;
import java.util.List;
import softwareengineering.scarlet.coursework2.mapgeneration.MapFactory;
import softwareengineering.scarlet.coursework2.models.Entity;
import softwareengineering.scarlet.coursework2.models.ExitItem;
import softwareengineering.scarlet.coursework2.models.GoldItem;
import softwareengineering.scarlet.coursework2.models.HealthItem;
import softwareengineering.scarlet.coursework2.models.Map;
import softwareengineering.scarlet.coursework2.models.StairsDownItem;
import softwareengineering.scarlet.coursework2.models.StairsUpItem;
import softwareengineering.scarlet.coursework2.models.StrengthItem;

public class ShowMap {
  private Map map;
  private List<Entity> entities = new ArrayList<Entity>();
  
  public ShowMap() {
    initMap();
  }
  
  public void initMap() {


    map = MapFactory.generateMap(50, 50, entities);
  }
  
  public void initEntity() {
    entities.add(new GoldItem(1));
    entities.add(new HealthItem(1));
    entities.add(new StrengthItem(1));
    entities.add(new StairsUpItem(1));
    entities.add(new StairsDownItem(1));
    entities.add(new ExitItem());
  }
  
  public List<Entity> getEntities() {
    return entities;
  }
  
  public Map getMap() {
    return map;
  }

}

package softwareengineering.scarlet.coursework2.models;

/**
 * Defines behaviour of monsters within the level
 */
public interface MonsterBehaviour {
  public void performAction(Monster monster, Dungeon dungeon, Player player);
}

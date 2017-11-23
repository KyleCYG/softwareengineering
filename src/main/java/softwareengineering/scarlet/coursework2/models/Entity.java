package softwareengineering.scarlet.coursework2.models;

/**
 * Superclass for all static objects in the dungeon
 *
 * eg Gold, Health, Stairs etc
 *
 * @author Dan Cosser
 */
public abstract class Entity {
  private int x;
  private int y;

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

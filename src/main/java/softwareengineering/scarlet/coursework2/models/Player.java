package softwareengineering.scarlet.coursework2.models;

import java.awt.Point;

/**
 * A model class to represent information about the player.
 */
public class Player {
  private String name;
  private Point location;
  private int gold;
  
  /**
   * Constructor.
   * 
   * @param playerName The player's name
   * @param startLocation The starting position of the player
   */
  public Player(String playerName, Point startLocation){
    this.name = playerName;
    this.location = startLocation;
    this.gold = 0;
  }

  public Point getLocation() {
    return location;
  }

  public void setLocation(Point location) {
    this.location = location;
  }

  /**
   * Moves the player location by the input amounts to (x+dx, y+dy)
   * 
   * @param dx X-axis movement
   * @param dy Y-axis movement
   */
  public void movePlayer(int dx, int dy) {
    this.location.translate(dx, dy);
  }
  
  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }

  public String getName() {
    return name;
  }
  
}

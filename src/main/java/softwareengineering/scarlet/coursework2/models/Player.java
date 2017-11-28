package softwareengineering.scarlet.coursework2.models;

/**
 * A model class to represent information about the player.
 */
public class Player {
  private String name;
  private int x;
  private int y;
  private int gold;
  
  /**
   * Constructor.
   * 
   * @param playerName The player's name
   * @param startLocation The starting position of the player
   */
  public Player(String playerName, int startX, int startY) {
    this.name = playerName;
    this.x = startX;
    this.y = startY;
    this.gold = 0;
  }


  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  /**
   * Moves the player location by the input amounts to (x+dx, y+dy)
   * 
   * @param dx X-axis movement
   * @param dy Y-axis movement
   */
  public void movePlayer(int dx, int dy) {
    this.x += dx;
    this.y += dy;
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

package softwareengineering.scarlet.coursework2.models;

/**
 * A model class to represent information about the player.
 */
public class Player {
  private String name;
  private int x;
  private int y;
  private int gold;
  private int strength;
  private int healthPoints;
  private StrengthItem strengthItem;

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
    this.healthPoints = 5;
    this.strength = 10;
    this.strengthItem = new StrengthItem(10, CellType.STRENGTH1);
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

  public int getStrength() {
    return strength;
  }


  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void increaseStrength(int strength) {
    this.strength += strength;
  }

  public void decreaseStrength(int strength) {
    this.strength -= strength;
  }

  /* Health points increase when player collects p */
  public int getHealthPoints() {
    return healthPoints;
  }

  public void setHealthPoints(int healthPoints) {
    this.healthPoints = healthPoints;
  }

  public void increaseHealthPoint(int healthPoints) {
    this.healthPoints += healthPoints;
  }

  public void decreaseHealthPoint(int healthPoints) {
    this.healthPoints -= healthPoints;
  }

  public StrengthItem getStrengthItem() {
    return strengthItem;
  }

  /* Player can hold one Strength Item at a time */
  /* Player strength will be set to that strength value */
  public void setStrengthItem(StrengthItem strengthItem) {
    this.strengthItem = strengthItem;
    this.setStrength(this.strengthItem.getValue());
  }
}

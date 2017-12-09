package softwareengineering.scarlet.coursework2.models;

public abstract class Character {
  private int x;
  private int y;
  protected String name;
  protected int strength;
  protected int healthPoints;
  protected StrengthItem strengthItem;

  public Character(String name, int x, int y, int health, int strength) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.healthPoints = health;
    this.strength = strength;
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
   * Moves the character's location by the input amounts to (x+dx, y+dy)
   *
   * @param dx X-axis movement
   * @param dy Y-axis movement
   */
  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
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
}

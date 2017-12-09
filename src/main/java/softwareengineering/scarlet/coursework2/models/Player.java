package softwareengineering.scarlet.coursework2.models;

/**
 * A model class to represent information about the player.
 */
public class Player extends Character {
  private int gold;

  /**
   * Constructor.
   *
   * @param name The player's name
   * @param startLocation The starting position of the player
   */
  public Player(String name, int startX, int startY) {
    super(name, startX, startY, 5, 10);
    this.gold = 0;
    this.strengthItem = new StrengthItem(10, CellType.STRENGTH1);
  }

  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
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

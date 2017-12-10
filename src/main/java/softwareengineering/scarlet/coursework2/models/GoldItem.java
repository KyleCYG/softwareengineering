package softwareengineering.scarlet.coursework2.models;

/**
 * A "Gold" entity, represented in the game as a page, is collected by the player to exit the
 * dungeon.
 */
public class GoldItem extends Entity {
  private int value;

  public GoldItem(int value) {
    this.value = value;
    this.type = CellType.GOLD;
  }

  public int getValue() {
    return value;
  }
}

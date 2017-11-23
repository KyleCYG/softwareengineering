package softwareengineering.scarlet.coursework2.models;

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

package softwareengineering.scarlet.coursework2.models;

public class StrengthItem extends Entity {
  private int value;

  public StrengthItem(int value) {
    this.value = value;
    this.type = CellType.STRENGTH;
  }

  public int getValue() {
    return value;
  }
  public CellType getType() {
    return type;
  }
}

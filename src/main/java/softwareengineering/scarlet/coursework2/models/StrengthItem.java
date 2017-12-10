package softwareengineering.scarlet.coursework2.models;

public class StrengthItem extends Entity {
  private int value;

  public StrengthItem(int value, CellType type) {
    this.value = value;
    this.type = type;
  }

  public int getValue() {
    return value;
  }

  public CellType getType() {
    return type;
  }
}

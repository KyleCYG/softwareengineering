package softwareengineering.scarlet.coursework2.models;

public class StairsUpItem extends Entity {
  private int toLevel;

  public StairsUpItem(int toLevel) {
    this.toLevel = toLevel;
    this.type = CellType.STAIRSUP;
  }

  public int getToLevel() {
    return toLevel;
  }
}

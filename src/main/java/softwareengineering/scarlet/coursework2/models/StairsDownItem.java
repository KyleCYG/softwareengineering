package softwareengineering.scarlet.coursework2.models;

public class StairsDownItem extends Entity {
  private int toLevel;

  public StairsDownItem(int toLevel) {
    this.toLevel = toLevel;
  }

  public int getToLevel() {
    return toLevel;
  }
}

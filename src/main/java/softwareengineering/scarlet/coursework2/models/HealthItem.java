package softwareengineering.scarlet.coursework2.models;

public class HealthItem extends Entity {
  private int value;

  public HealthItem(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}

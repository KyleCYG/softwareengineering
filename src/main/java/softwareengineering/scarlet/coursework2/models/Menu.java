package softwareengineering.scarlet.coursework2.models;

public class Menu {
  private int selectedOption;

  public Menu() {
    this.selectedOption = 0;
  }

  public void incrementOption() {
    this.selectedOption++;
    this.selectedOption = this.selectedOption % 3;
  }

  public void decrementOption() {
    this.selectedOption--;
    if (this.selectedOption == -1) {
      this.selectedOption = 2; // loop back to bottom option
    }
  }

  public int getOption() {
    return this.selectedOption;
  }
}

package softwareengineering.scarlet.coursework2.models;

/**
 * Simple model to store the state of the menu.
 *
 * @author Gordon Rennie
 * @author Dan Cosser
 */
public class Menu {
  private int selectedOption;

  public Menu() {
    this.selectedOption = 0;
  }

  /**
   * Move to the next menu option
   */
  public void incrementOption() {
    this.selectedOption++;
    this.selectedOption = this.selectedOption % 3;
  }

  /**
   * Move to the previous menu option
   */
  public void decrementOption() {
    this.selectedOption--;
    if (this.selectedOption == -1) {
      // Loop back to bottom option
      this.selectedOption = 2; 
    }
  }

  /**
   * Get the currently selected menu option
   *
   * @return The selected option
   */
  public int getOption() {
    return this.selectedOption;
  }
}

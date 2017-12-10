package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.SetPreGame;

public class SetPreGameView implements View {
  private SetPreGame model;

  @Override
  public void render(Graphics2D g2d, ImageObserver observer) {
    // TODO Auto-generated method stub
    this.drawNameString(g2d);
    this.drawNameTextField(g2d);
    this.drawEnterString(g2d);
    if (this.model.isWarning()) {
      this.drawWarning(g2d);
      this.model.setWarning(false);
    }
  }

  /**
   * Renders the input name string.
   *
   * @param g2d The graphics object the options are rendered to.
   */
  private void drawNameString(Graphics2D g2d) {
    g2d.drawString(" Enter Name", 180, 250);
  }

  /**
   * Renders the text field to enter name.
   *
   * @param g2d The graphics object the options are rendered to.
   */
  private void drawNameTextField(Graphics2D g2d) {
    if (model.getName() != null)
      g2d.drawString(model.getName(), 300, 250);
    else
      g2d.drawString("----", 300, 250);
  }

  /**
   * Renders the Enter option.
   *
   * @param g2d The graphics object the options are rendered to.
   */
  private void drawEnterString(Graphics2D g2d) {
    g2d.drawString("Press Enter ", 250, 300);
  }

  private void drawWarning(Graphics2D g2d) {
    g2d.drawString("Please Input 4 Characters ", 250, 350);
  }

  public void setModel(SetPreGame preGameModel) {
    this.model = preGameModel;
  }
}

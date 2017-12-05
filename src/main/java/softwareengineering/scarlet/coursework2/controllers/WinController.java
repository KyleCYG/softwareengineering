package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.App;
import softwareengineering.scarlet.coursework2.views.View;
import softwareengineering.scarlet.coursework2.views.WinView;

public class WinController implements Controller {
  private App app;
  private WinView view;

  public WinController(App app) {
    this.app = app;
  }

  /**
   * Switch to the "winning" game end screen.
   *
   * @param view The view to render the back story
   */
  @Override
  public void init(View view) {
    this.view = (WinView) view;
  }

  @Override
  public View getView() {
    return this.view;
  }

  @Override
  /**
   * User should press enter to continue to go back to the menu
   *
   * @param input
   */
  public void handleInput(Input input) {
    if (input == Input.CHOOSE) {
      app.switchToMenu();;
    }
  }
}

package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.App;
import softwareengineering.scarlet.coursework2.models.GameScore;
import softwareengineering.scarlet.coursework2.views.GameoverView;
import softwareengineering.scarlet.coursework2.views.View;
import softwareengineering.scarlet.coursework2.views.game.GameView;

public class GameoverController implements Controller {
  private App app;
  private GameoverView view;
  private GameScore score;

  public GameoverController(App app) {
    this.app = app;
  }

  public void setScore(GameScore score) {
    this.score = score;
  }

  protected void setModels() {
    this.view.setScore(score);
  }

  /**
   * Switch to the "winning" game end screen.
   *
   * @param view The view to render the back story
   */
  @Override
  public void init(View view) {
    this.view = (GameoverView) view;
    setModels();
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

  @Override
  public GameView getGameView() {
    // TODO Auto-generated method stub
    return null;
  }
}

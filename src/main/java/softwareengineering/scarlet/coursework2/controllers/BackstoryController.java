package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.App;
import softwareengineering.scarlet.coursework2.views.BackstoryView;
import softwareengineering.scarlet.coursework2.views.View;

public class BackstoryController implements Controller{
  private App app;
  private BackstoryView view;
  
  public BackstoryController(App app) {
    
    this.app = app;
    
  }
  
  /**
   * Switch to the back story screen.
   *
   * @param view The view to render the back story
   */
  @Override
  public void init(View view) {
    this.view = (BackstoryView) view;
    
  }

  @Override
  public View getView() {
    // TODO Auto-generated method stub
    return this.view;
  }

  @Override
  /**
   * user should press enter to continue to the game
   * @param input
   */
  public void handleInput(Input input) {
    // TODO Auto-generated method stub
    switch(input) {
      case CHOOSE:
        app.switchToGame();
        break;
      
    }
    
  }
  
}

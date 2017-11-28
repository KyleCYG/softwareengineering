package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.models.Menu;
import softwareengineering.scarlet.coursework2.views.MenuView;
import softwareengineering.scarlet.coursework2.views.View;

public class MenuController implements Controller {
  private MenuView view;
  private Menu model;

  @Override
  public View getView() {
    return this.view;
  }

  @SuppressWarnings("incomplete-switch")
  @Override
  public void keyPress(Keyboard key) {
    switch (key) {
      case UP:
        this.model.decrementOption();
        break;
      case DOWN:
        this.model.incrementOption();
        break;
      case ENTER:
        performAction();
        break;
    }
  }

  private void performAction() {
    switch (this.model.getOption()) {
      case 2:
        System.exit(0);
        break;
    }
  }

  @Override
  public void init(View view) {
    this.view = (MenuView) view;
    this.model = new Menu();
    this.view.setModel(model);
  }
}

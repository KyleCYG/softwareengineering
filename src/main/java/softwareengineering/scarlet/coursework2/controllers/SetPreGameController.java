package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.App;
import softwareengineering.scarlet.coursework2.models.SetPreGame;
import softwareengineering.scarlet.coursework2.views.SetPreGameView;
import softwareengineering.scarlet.coursework2.views.View;;


public class SetPreGameController implements Controller {
  private App app;
  private SetPreGameView view;
  protected SetPreGame model;

  public SetPreGameController(App app) {
    this.app = app;
  }

  @Override
  public View getView() {
    return this.view;
  }

  @Override
  public void init(View view) {
    this.view = (SetPreGameView) view;
    this.setUpData();
    this.view.setModel(model);
  }

  @SuppressWarnings("incomplete-switch")
  @Override
  public void handleInput(Input input) {
    switch (input) {
      case A:
        this.model.appendLetter("A");
        break;
      case B:
        this.model.appendLetter("B");
        break;
      case C:
        this.model.appendLetter("C");
        break;
      case D:
        this.model.appendLetter("D");
        break;
      case E:
        this.model.appendLetter("E");
        break;
      case F:
        this.model.appendLetter("F");
        break;
      case G:
        this.model.appendLetter("G");
        break;
      case H:
        this.model.appendLetter("H");
        break;
      case I:
        this.model.appendLetter("I");
        break;
      case J:
        this.model.appendLetter("J");
        break;
      case K:
        this.model.appendLetter("K");
        break;
      case L:
        this.model.appendLetter("L");
        break;
      case M:
        this.model.appendLetter("M");
        break;
      case N:
        this.model.appendLetter("N");
        break;
      case O:
        this.model.appendLetter("O");
        break;
      case P:
        this.model.appendLetter("P");
        break;
      case Q:
        this.model.appendLetter("Q");
        break;
      case R:
        this.model.appendLetter("R");
        break;
      case S:
        this.model.appendLetter("S");
        break;
      case T:
        this.model.appendLetter("T");
        break;
      case U:
        this.model.appendLetter("U");
        break;
      case V:
        this.model.appendLetter("V");
        break;
      case W:
        this.model.appendLetter("W");
        break;
      case X:
        this.model.appendLetter("X");
        break;
      case Y:
        this.model.appendLetter("Y");
        break;
      case Z:
        this.model.appendLetter("Z");
        break;
      case CHOOSE:
        performAction();
        break;
      case DELETE:
        this.model.deleteLetter();
    }
  }

  private void performAction() {
    // TODO Auto-generated method stub
    String playerName = this.model.getName();
  }

  protected void setUpData() {
    this.model = new SetPreGame();
  }
}

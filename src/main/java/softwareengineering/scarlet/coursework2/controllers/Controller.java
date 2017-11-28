package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.views.View;

public interface Controller {
  public View getView();
  public void keyPress(Keyboard key);
  public void init(View view);
}

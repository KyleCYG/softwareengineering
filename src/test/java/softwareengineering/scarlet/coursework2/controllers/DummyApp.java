package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.App;

public class DummyApp implements App {
  public boolean didIQuit = false;

  @Override
  public void quit() {
    this.didIQuit = true;
  }

  @Override
  public void switchToMenu() {
    // TODO Auto-generated method stub
  }

  @Override
  public void switchToPreGame() {
    // TODO Auto-generated method stub
  }
  
  @Override
  public void switchToBackstory() {
    // TODO Auto-generated method stub
  }

  @Override
  public void switchToGame() {
    // TODO Auto-generated method stub
  }
}

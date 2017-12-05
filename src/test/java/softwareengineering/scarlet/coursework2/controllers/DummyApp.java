package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.App;

public class DummyApp implements App {
  public boolean didIQuit = false;
  public boolean didISwitchToBackStory = false;

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
    this.didISwitchToBackStory=true;
    // TODO Auto-generated method stub
  }

  @Override
  public void switchToGame() {
    // TODO Auto-generated method stub
  }

  @Override
  public void switchToWin() {
    // TODO Auto-generated method stub
  }

  @Override
  public MenuController getMenuController() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public SetPreGameController getSetPreGameController() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BackstoryController getBackstoryController() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public GameController getGameController() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public WinController getWinController() {
    // TODO Auto-generated method stub
    return null;
  }
}

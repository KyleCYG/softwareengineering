package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.GameApp;

public class DummyApp implements GameApp {
  public boolean didIQuit = false;

  @Override
  public void quit() {
    this.didIQuit = true;
  }

}

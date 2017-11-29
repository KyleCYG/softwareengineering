package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.AppInterface;

public class DummyApp implements AppInterface {
  public boolean didIQuit = false;

  @Override
  public void quit() {
    this.didIQuit = true;
  }

}

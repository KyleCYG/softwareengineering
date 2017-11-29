package softwareengineering.scarlet.coursework2.controllers;

import softwareengineering.scarlet.coursework2.App;

public class DummyApp implements App {
  public boolean didIQuit = false;

  @Override
  public void quit() {
    this.didIQuit = true;
  }

}

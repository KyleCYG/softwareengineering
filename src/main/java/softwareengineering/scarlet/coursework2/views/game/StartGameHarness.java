package softwareengineering.scarlet.coursework2.views.game;

import java.awt.EventQueue;
import softwareengineering.scarlet.coursework2.GameApp;

public class StartGameHarness {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        // Create the app
        GameApp app = new GameApp();

        // Hand over control to the Game
        app.switchToGame();

        // Once everything is instantiated, actually display the screen
        app.start();
      }
    });
  }
}

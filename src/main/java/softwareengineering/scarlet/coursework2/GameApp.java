package softwareengineering.scarlet.coursework2;

import java.awt.EventQueue;
import softwareengineering.scarlet.coursework2.controllers.BackstoryController;
import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.controllers.MenuController;
import softwareengineering.scarlet.coursework2.controllers.SetPreGameController;
import softwareengineering.scarlet.coursework2.views.BackstoryView;
import softwareengineering.scarlet.coursework2.views.Frame;
import softwareengineering.scarlet.coursework2.views.MenuView;
import softwareengineering.scarlet.coursework2.views.Panel;
import softwareengineering.scarlet.coursework2.views.SetPreGameView;
import softwareengineering.scarlet.coursework2.views.View;
import softwareengineering.scarlet.coursework2.views.game.GameView;

/**
 * Main entry point into the application.
 *
 * Contains the main method, kicking off AWT etc. Also acts as a central point of reference for all
 * controllers, allowing them to switch without having to store references to each other.
 *
 * Each controller will have a reference to the App, and should use it to pass control to other
 * controllers/views via the switchTo* methods.
 *
 * There should be a switchTo* method for each controller, which should act as a factory method for
 * the controller. This should also include the creation of the relevant View, so that the view
 * implementation is separated from the controller. Other objects should be instantiated by the
 * controller itself.
 *
 * @author Gordon Rennie
 * @author Dan Cosser
 */
public class GameApp implements App {
  private Frame frame;
  private Panel panel;
  private MenuController menuController;
  private GameController gameController;
  private SetPreGameController setpregameController;
  private BackstoryController backstoryController;

  public GameApp() {
    this.panel = new Panel();
    this.frame = new Frame(this.panel);
  }

  /**
   * Switch control to the Menu
   */
  public void switchToMenu() {
    if (this.menuController == null) {
      this.menuController = new MenuController(this);
    }

    this.panel.setController(this.menuController);

    View view = new MenuView();
    this.menuController.init(view);
  }

  /**
   * Switch control to the Pre Game Settings
   */
  public void switchToPreGame() {
    if (this.setpregameController == null) {
      this.setpregameController = new SetPreGameController(this);
    }

    this.panel.setController(this.setpregameController);

    SetPreGameView view = new SetPreGameView();
    this.setpregameController.init(view);
  }
  
  public void switchToBackstory() {
    if (this.backstoryController == null) {
      this.backstoryController = new BackstoryController(this);
    }

    this.panel.setController(this.backstoryController);

    BackstoryView view = new BackstoryView();
    this.backstoryController.init(view);
    
  }

  /**
   * Switch control to the Game
   */
  public void switchToGame() {
    if (this.gameController == null) {
      this.gameController = new GameController(this);
    }

    this.panel.setController(this.gameController);

    View view = new GameView();
    this.gameController.init(view);
  }

  /**
   * Quit the application
   */
  public void quit() {
    System.exit(0);
  }

  /**
   * Start the application after initialization
   */
  public void start() {
    this.frame.setVisible(true);
  }

  /**
   * Main method.
   *
   * Creates the App (including basic AWT resources), and then surrenders control to the
   * MenuController.
   *
   * @param args Command line args - none respected by this application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        // Create the app
        GameApp app = new GameApp();

        // Hand over control to the Menu
        app.switchToMenu();

        // Once everything is instantiated, actually display the screen
        app.start();
      }
    });
  }
}

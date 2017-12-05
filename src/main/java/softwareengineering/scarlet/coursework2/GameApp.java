package softwareengineering.scarlet.coursework2;

import java.awt.EventQueue;
import softwareengineering.scarlet.coursework2.controllers.BackstoryController;
import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.controllers.MenuController;
import softwareengineering.scarlet.coursework2.controllers.SetPreGameController;
import softwareengineering.scarlet.coursework2.controllers.WinController;
import softwareengineering.scarlet.coursework2.views.BackstoryView;
import softwareengineering.scarlet.coursework2.views.Frame;
import softwareengineering.scarlet.coursework2.views.MenuView;
import softwareengineering.scarlet.coursework2.views.Panel;
import softwareengineering.scarlet.coursework2.views.SetPreGameView;
import softwareengineering.scarlet.coursework2.views.View;
import softwareengineering.scarlet.coursework2.views.WinView;
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
  private SetPreGameController setPreGameController;
  private BackstoryController backstoryController;
  private WinController winController;
  private String playerName;

  public GameApp() {
    this.panel = new Panel();
    this.frame = new Frame(this.panel);
  }

  public MenuController getMenuController() {
    if (menuController == null) {
      menuController = new MenuController(this);
    }
    return menuController;
  }

  public GameController getGameController() {
    if (gameController == null) {
      gameController = new GameController(this);
    }
    return gameController;
  }

  public SetPreGameController getSetPreGameController() {
    if (setPreGameController == null) {
      setPreGameController = new SetPreGameController(this);
    }
    return setPreGameController;
  }

  public BackstoryController getBackstoryController() {
    if (backstoryController == null) {
      backstoryController = new BackstoryController(this);
    }
    return backstoryController;
  }

  public WinController getWinController() {
    if (winController == null) {
      winController = new WinController(this);
    }
    return winController;
  }

  /**
   * Switch control to the Menu
   */
  public void switchToMenu() {
    this.panel.setController(getMenuController());

    View view = new MenuView();
    this.menuController.init(view);
  }

  /**
   * Switch control to the Pre Game Settings
   */
  public void switchToPreGame() {
    this.panel.setController(getSetPreGameController());

    SetPreGameView view = new SetPreGameView();
    this.setPreGameController.init(view);
  }

  /**
   * Switch control to the backstory screen
   */
  public void switchToBackstory() {
    this.panel.setController(getBackstoryController());

    BackstoryView view = new BackstoryView();
    this.backstoryController.init(view);
  }

  /**
   * Switch control to the Game
   */
  public void switchToGame() {
    this.panel.setController(getGameController());

    View view = new GameView();
    this.gameController.init(view);
  }

  /**
   * Switch control to the Winning End screen
   */
  public void switchToWin() {
    this.panel.setController(getWinController());

    View view = new WinView();
    this.winController.init(view);
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
   * Set Player Name At APP level to pass it to Pre Game Controller to Game Controller
   */
  public void setPlayerName(String name) {
    this.playerName = name;
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

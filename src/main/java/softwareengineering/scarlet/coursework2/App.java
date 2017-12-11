package softwareengineering.scarlet.coursework2;

import softwareengineering.scarlet.coursework2.controllers.BackstoryController;
import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.controllers.GameoverController;
import softwareengineering.scarlet.coursework2.controllers.MenuController;
import softwareengineering.scarlet.coursework2.controllers.SetPreGameController;
import softwareengineering.scarlet.coursework2.controllers.WinController;

/**
 * Represents the behaviour of the application.
 *
 * This interface used so we can easily mock out the live GameApp, which is inseparable from AWT.
 *
 * @author Gordon Rennie
 * @author Dan Cosser
 */
public interface App {
  /**
   * Quit the application.
   */
  public void quit();

  public MenuController getMenuController();

  public SetPreGameController getSetPreGameController();

  public BackstoryController getBackstoryController();

  public GameController getGameController();

  public WinController getWinController();

  public GameoverController getGameOverController();

  public void switchToMenu();

  public void switchToPreGame();

  public void switchToBackstory();

  public void switchToGame();

  public void switchToWin();

  public void switchToGameOver();
}

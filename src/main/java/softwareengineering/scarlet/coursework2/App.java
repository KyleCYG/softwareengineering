package softwareengineering.scarlet.coursework2;

import java.awt.EventQueue;
import softwareengineering.scarlet.coursework2.controllers.Controller;
import softwareengineering.scarlet.coursework2.controllers.MenuController;
import softwareengineering.scarlet.coursework2.views.Frame;
import softwareengineering.scarlet.coursework2.views.MenuView;
import softwareengineering.scarlet.coursework2.views.Panel;

public class App implements GameApp {
  private Frame frame;
  private Panel panel;
  private MenuController menuController;

  public App() {
    this.panel = new Panel();
    this.frame = new Frame(this.panel);
  }
  public void switchToMenu() {
    if (this.menuController == null) {
      this.menuController = new MenuController(this);
    }

    this.panel.setController(this.menuController);
    
    MenuView view = new MenuView();
    this.menuController.init(view);
  }

  public void quit() {
    System.exit(0);
  }

  public static void main(String[] args) { 
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        
        // Create the app
        App app = new App();

        // Hand over control to the Menu
        app.switchToMenu();

        // Once everything is instantiated, actually display the screen
        app.frame.setVisible(true);
      }
    });
  }
}

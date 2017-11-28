package softwareengineering.scarlet.coursework2;

import java.awt.EventQueue;
import softwareengineering.scarlet.coursework2.controllers.Controller;
import softwareengineering.scarlet.coursework2.controllers.MenuController;
import softwareengineering.scarlet.coursework2.views.Frame;
import softwareengineering.scarlet.coursework2.views.MenuView;
import softwareengineering.scarlet.coursework2.views.Panel;

public class App {
  private Frame frame;
  private Panel panel;
  private Controller currentController;
  private MenuController menuController;

  public Controller getCurrentController() {
    return this.currentController;
  }
  
  public void switchToMenu() {
    if (this.menuController == null) {
      this.menuController = new MenuController();
    }

    this.panel.setController(this.menuController);
    
    MenuView view = new MenuView();
    this.menuController.init(view);

    this.currentController = this.menuController;
  }

  public static void main(String[] args) { 
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        
        App app = new App();
        app.panel = new Panel();
        app.frame = new Frame(app.panel);

        app.switchToMenu();

        app.frame.setVisible(true);
      }
    });
  }
}

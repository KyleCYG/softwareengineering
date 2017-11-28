package softwareengineering.scarlet.coursework2;

import java.awt.EventQueue;
import softwareengineering.scarlet.coursework2.views.MenuFrame;

/**
 * Hello world!
 *
 */
public class App  
{
    public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
        public void run() {
          MenuFrame menu = new MenuFrame();
          menu.setVisible(true);
        }
      }); 
    }
}

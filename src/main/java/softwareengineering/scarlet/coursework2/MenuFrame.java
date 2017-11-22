package softwareengineering.scarlet.coursework2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MenuFrame extends JFrame {

 /**
  * Calls unutUI()
  */  
  public MenuFrame() {
    initUI();
  }
  
  /**
  * Initialises and configures a MenuPanel. 
  */  
  public void initUI() {
    this.add(new MenuPanel());

    setSize(500, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}



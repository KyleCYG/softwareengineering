package softwareengineering.scarlet.coursework2.views;

import javax.swing.JFrame;

public class Frame extends JFrame {
  private static final long serialVersionUID = 1L;

  public Frame(Panel panel) {
    this.build(panel);
  }
  
  public void build(Panel panel) {
    this.add(panel);
    
    setSize(500, 500);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setFocusTraversalKeysEnabled(false); // stops treating arrow keys/tabs as changing focus
  }
}

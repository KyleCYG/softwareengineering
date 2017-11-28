package softwareengineering.scarlet.coursework2.views;

import javax.swing.JFrame;

public class MenuFrame extends JFrame {
  private static final long serialVersionUID = 1L;

  /**
   * Calls initUI()
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



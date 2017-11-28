package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import softwareengineering.scarlet.coursework2.controllers.Controller;
import softwareengineering.scarlet.coursework2.controllers.Keyboard;

public class Panel extends JPanel implements KeyListener {
  private static final long serialVersionUID = 1L;
  private Controller controller;

  public Panel() {
    addKeyListener(this);
    setFocusable(true);
    // does not get arrow keys as input
    setFocusTraversalKeysEnabled(false);
  }

  public void setController(Controller controller) {
    this.controller = controller;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    // Call the view's render method
    this.controller.getView().render(g2d);
  }

  @Override
  public void keyPressed(KeyEvent event) {
    // Unnecessary override
  }

  @Override
  public void keyReleased(KeyEvent event) {
    Keyboard key = Keyboard.NONE;
    switch (event.getKeyCode()) {
      case KeyEvent.VK_UP:
        key = Keyboard.UP;
        break;
      case KeyEvent.VK_LEFT:
        key = Keyboard.LEFT;
        break;
      case KeyEvent.VK_DOWN:
        key = Keyboard.DOWN;
        break;
      case KeyEvent.VK_RIGHT:
        key = Keyboard.RIGHT;
        break;
      case KeyEvent.VK_ENTER:
        key = Keyboard.ENTER;
        break;
    }
    this.controller.keyPress(key);
    repaint();
  }

  @Override
  public void keyTyped(KeyEvent event) {
    // Unnecessary override
  }
}

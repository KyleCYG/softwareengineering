package softwareengineering.scarlet.coursework2.views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import softwareengineering.scarlet.coursework2.controllers.Controller;
import softwareengineering.scarlet.coursework2.controllers.Keyboard;

/**
 * Wrapper around JPanel.
 *
 * Handles rendering and key presses from the user, using the appropriate view and controller.
 *
 * @author Gordon Rennie
 * @author Dan Cosser
 */
public class Panel extends JPanel implements KeyListener {
  private static final long serialVersionUID = 1L;
  private Controller controller;

  /**
   * Creates the JPanel, and applies the necessary application-level settings.
   */
  public Panel() {
    addKeyListener(this);
    setFocusable(true);
    // does not get arrow keys as input
    setFocusTraversalKeysEnabled(false);
  }

  /**
   * Change the currently 'live' controller.
   *
   * Changing this will affect which view is used to render to the screen, and which controller
   * receives input.
   *
   * @param controller The controller to switch to.
   */
  public void setController(Controller controller) {
    this.controller = controller;
  }

  /**
   * The paint method, called by JPanel.
   *
   * Hands over to the controller's view for rendering.
   *
   * @param g The graphics object to draw on.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    // Call the view's render method
    this.controller.getView().render(g2d);
  }

  /**
   * Receive a key entry from the user.
   *
   * Translates into a non-AWT representation, and hands over to the controller, before calling
   * repaint.
   */
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

    // TODO: Have the controller return a "dirty" flag and only repaint if set
    repaint();
  }

  @Override
  public void keyTyped(KeyEvent event) {
    // Override not required
  }

  @Override
  public void keyPressed(KeyEvent event) {
    // Override not required
  }
}

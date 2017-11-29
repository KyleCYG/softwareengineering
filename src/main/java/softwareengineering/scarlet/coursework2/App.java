package softwareengineering.scarlet.coursework2;

/**
 * Represents the behaviour of the application.
 *
 * This interface used so we can easily mock out the live GameApp, which
 * is inseparable from AWT.
 *
 * @author Gordon Rennie
 * @author Dan Cosser
 */
public interface App {
  /**
   * Quit the application.
   */
  public void quit();
}

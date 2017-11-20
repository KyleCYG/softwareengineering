/**
 * 
 */
package softwareengineering.scarlet.coursework2;

import javax.swing.JPanel;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * @author grr28
 *
 */
public class MenuFrameTest extends TestCase {
  
  @Test
  public void testCheckPanelInitialised() {
    
    MenuFrame testMenu = new MenuFrame();
    assertTrue(testMenu.getContentPane() instanceof JPanel);
  }
  
}

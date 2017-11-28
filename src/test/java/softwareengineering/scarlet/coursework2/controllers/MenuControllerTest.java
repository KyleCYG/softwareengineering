package softwareengineering.scarlet.coursework2.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MenuControllerTest {
  private DummyApp app = new DummyApp();

  @Test
  public void testInitial() {
    MenuController controller = new MenuController(app);
    controller.setUpData();

    assertEquals(0, controller.model.getOption());
  }

  @Test
  public void testGoUp() {
    MenuController controller = new MenuController(app);
    controller.setUpData();
    controller.keyPress(Keyboard.UP);

    assertEquals(2, controller.model.getOption());
  }

  @Test
  public void testGoDown() {
    MenuController controller = new MenuController(app);
    controller.setUpData();
    controller.keyPress(Keyboard.DOWN);

    assertEquals(1, controller.model.getOption());
  }

  @Test
  public void testQuit() {
    app = new DummyApp();
    MenuController controller = new MenuController(app);
    controller.setUpData();
    controller.keyPress(Keyboard.UP);
    controller.keyPress(Keyboard.ENTER);

    assertTrue(app.didIQuit);
  }
}

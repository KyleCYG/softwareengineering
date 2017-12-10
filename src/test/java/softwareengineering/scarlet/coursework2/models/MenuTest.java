package softwareengineering.scarlet.coursework2.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class MenuTest {

  @Test
  public void testCreation() {
    Menu menu = new Menu();

    // menu should start at top option
    assertEquals(0, menu.getOption());
  }

  @Test
  public void testIncrement() {
    Menu menu = new Menu();
    menu.incrementOption();

    assertEquals(1, menu.getOption());
  }

  @Test
  public void testIncrementOverBound() {
    Menu menu = new Menu();
    menu.incrementOption();
    menu.incrementOption();
    menu.incrementOption();

    // menu wraps back to first option
    assertEquals(0, menu.getOption());
  }

  @Test
  public void testDecrement() {
    Menu menu = new Menu();
    menu.incrementOption();
    menu.incrementOption();
    menu.decrementOption();

    assertEquals(1, menu.getOption());
  }

  @Test
  public void testDecrementOverBound() {
    Menu menu = new Menu();
    menu.decrementOption();

    // menu wraps to bottom option
    assertEquals(2, menu.getOption());
  }

}

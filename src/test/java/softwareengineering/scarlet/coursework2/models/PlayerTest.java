package softwareengineering.scarlet.coursework2.models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest {

  @Test
  public void testGetters() {
    Player player = new Player("test", 2, 3);

    assertEquals("test", player.getName());
    assertEquals(2, player.getX());
    assertEquals(3, player.getY());
  }

  @Test
  public void testMovePlayer() {
    Player player = new Player("test", 5, 3);

    int dx = 3;
    int dy = -2;

    player.movePlayer(dx, dy);

    int newX = player.getX();
    int newY = player.getY();

    // Note: the Point class getters return double for some stupid reason, therefore we
    // access its attributes directly.
    assertEquals(8, newX);
    assertEquals(1, newY);

  }

}

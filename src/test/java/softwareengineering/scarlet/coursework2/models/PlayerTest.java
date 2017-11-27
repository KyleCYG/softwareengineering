package softwareengineering.scarlet.coursework2.models;

import static org.junit.Assert.*;
import java.awt.Point;
import org.junit.Test;

public class PlayerTest {
  private static final String NAME = "test";
  private static final int LOCATION_X = 2;
  private static final int LOCATION_Y = 5;
  private static final Point LOCATION = new Point(PlayerTest.LOCATION_X, PlayerTest.LOCATION_Y);
  
  @Test
  public void testGetters() {
    Player player = new Player(PlayerTest.NAME, PlayerTest.LOCATION);
    
    assertEquals(PlayerTest.NAME, player.getName());
    assertEquals(PlayerTest.LOCATION, player.getLocation());
  }
  
  @Test
  public void testMovePlayer() {
    Player player = new Player(PlayerTest.NAME, PlayerTest.LOCATION);

    int dx = 3;
    int dy = -2;
    
    player.movePlayer(dx, dy);
    
    Point newLocation = player.getLocation();
    
    // Note: the Point class getters return double for some stupid reason, therefore we
    //  access its attributes directly.
    assertEquals(newLocation.x, PlayerTest.LOCATION_X+dx);
    assertEquals(newLocation.y, PlayerTest.LOCATION_Y+dy);
    
  }

}

package softwareengineering.scarlet.coursework2.controllers;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
import softwareengineering.scarlet.coursework2.levelgeneration.SimpleLevelFactory;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Level;
import softwareengineering.scarlet.coursework2.models.Player;

public class GameControllerTest {

  @Test
  public void testHandleInput_left() {
    GameController controller = new GameController(new DummyApp());
    Level level = SimpleLevelFactory.generateLevel(10, 10);
    controller.dungeon = new Dungeon(10, 10, Arrays.asList(level));
    controller.player = new Player("", 4, 4);

    controller.handleInput(Input.LEFT);

    assertEquals(3, controller.player.getX());
    assertEquals(4, controller.player.getY());
  }

  @Test
  public void testHandleInput_right() {
    GameController controller = new GameController(new DummyApp());
    Level level = SimpleLevelFactory.generateLevel(10, 10);
    controller.dungeon = new Dungeon(10, 10, Arrays.asList(level));
    controller.player = new Player("", 4, 4);

    controller.handleInput(Input.RIGHT);

    assertEquals(5, controller.player.getX());
    assertEquals(4, controller.player.getY());
  }

  @Test
  public void testHandleInput_up() {
    GameController controller = new GameController(new DummyApp());
    Level level = SimpleLevelFactory.generateLevel(10, 10);
    controller.dungeon = new Dungeon(10, 10, Arrays.asList(level));
    controller.player = new Player("", 4, 4);

    controller.handleInput(Input.UP);

    assertEquals(4, controller.player.getX());
    assertEquals(3, controller.player.getY());
  }

  @Test
  public void testHandleInput_down() {
    GameController controller = new GameController(new DummyApp());
    Level level = SimpleLevelFactory.generateLevel(10, 10);
    controller.dungeon = new Dungeon(10, 10, Arrays.asList(level));
    controller.player = new Player("", 4, 4);

    controller.handleInput(Input.DOWN);

    assertEquals(4, controller.player.getX());
    assertEquals(5, controller.player.getY());
  }
}

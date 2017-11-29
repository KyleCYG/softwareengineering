package softwareengineering.scarlet.coursework2.views.game;

public class LevelItemsFactory {
  private static Room room;
  private static Corridor corridor;
  private static Wall wall;
  private static Gold gold;
  private static Health health;
  private static Exit exit;
  private static Strength strength;
  private static StairsDown stairsdown;
  private static StairsUp stairsup;

  public static ItemImage init(String item) {
    switch (item) {
      case "r":
        if (room == null) {
          room = new Room();
        }
        return room;
      case "c":
        if (corridor == null) {
          corridor = new Corridor();
        }
        return corridor;
      case "w":
        if (wall == null) {
          wall = new Wall();
        }
        return wall;
      case "g":
        if (gold == null) {
          gold = new Gold();
        }
        return gold;
      case "h":
        if (health == null) {
          health = new Health();
        }
        return health;
      case "e":
        if (exit == null) {
          exit = new Exit();
        }
        return exit;
      case "s":
        if (strength == null) {
          strength = new Strength();
        }
        return strength;
      case "SD":
        if (stairsdown == null) {
          stairsdown = new StairsDown();
        }
        return stairsdown;
      case "SU":
        if (stairsup == null) {
          stairsup = new StairsUp();
        }
        return stairsup;
      default:
        return null;
    }
  }
}

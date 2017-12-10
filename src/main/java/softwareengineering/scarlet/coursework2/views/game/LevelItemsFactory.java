package softwareengineering.scarlet.coursework2.views.game;

public class LevelItemsFactory {
  private static Room room;
  private static Corridor corridor;
  private static Wall wall;
  private static Gold gold;
  private static Health health;
  private static Exit exit;
  private static Strength strength;
  private static StrengthType1 strength1;
  private static StrengthType2 strength2;
  private static StrengthType3 strength3;
  private static StairsDown stairsdown;
  private static StairsUp stairsup;
  // static MonsterAvatar monster;

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
      case "s1":
        if (strength1 == null) {
          strength1 = new StrengthType1();
        }
        return strength1;
      case "s2":
        if (strength2 == null) {
          strength2 = new StrengthType2();
        }
        return strength2;
      case "s3":
        if (strength3 == null) {
          strength3 = new StrengthType3();
        }
        return strength3;
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
      // case "x":
      // if (monster == null) {
      // monster = new MonsterAvatar();
      // }
      // return monster;
      default:
        return null;
    }
  }
}

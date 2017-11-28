package softwareengineering.scarlet.coursework2.views.game;

public class LevelItemsFactory {
  public ItemImage init(String item) {
    switch (item) {
      case "r":
        return new Room();
      case "c":
        return new Corridor();
      case "w":
        return new Wall();
      case "g":
        return new Gold();
      case "h":
        return new Health();
      case "e":
        return new Exit();
      case "s":
        return new Strength();
      case "SD":
        return new StairsDown();
      case "SU":
        return new StairsUp();
      default:
        return null;
    }
  }
}

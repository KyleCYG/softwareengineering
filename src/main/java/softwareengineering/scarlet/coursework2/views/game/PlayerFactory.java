package softwareengineering.scarlet.coursework2.views.game;

public class PlayerFactory {
  public ItemImage init(String item) {
    switch (item) {
      case "m":
        return new Player();
      case "r":
        return new Player();
      default:
        return null;
    }
  }
}

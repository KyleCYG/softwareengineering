package softwareengineering.scarlet.coursework2.views.game;

public class MonsterFactory {
  public ItemImage init(String item) {
    switch (item) {
      case "x":
        return new MonsterAvatar();
      default:
        return null;
    }
  }
}

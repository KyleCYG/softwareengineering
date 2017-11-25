package softwareengineering.scarlet.coursework2.views;

public class playerFactory implements Factory{




  public items init(String item) {
    // TODO Auto-generated method stub
    switch(item) {
      case "m":
        return new player();
      case "r":
        return new player();
      default:
       return null;
    }
  }

  @Override
  public items init(String item, int amount) {
    // TODO Auto-generated method stub
    return null;
  }
}

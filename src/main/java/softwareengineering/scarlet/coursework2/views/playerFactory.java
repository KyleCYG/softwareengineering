package softwareengineering.scarlet.coursework2.views;

public class playerFactory implements Factory{



@Override
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
}
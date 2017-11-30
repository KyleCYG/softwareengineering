package softwareengineering.scarlet.coursework2.models;

public class SetPreGame {

  private String name;
  
  
  public SetPreGame() {
    this.name = "----";
  }
  
  public void setName(String name)
  {
    this.name=name;
    
  }
  public String getName()
  {
    return this.name;
  }
  public void appendLetter(String letter)
  {
    if(name.contains("-"))
       name=name.replaceFirst("-", letter);
  }
  public void deleteLetter()
  {
    if(name.contains("-"))
    {
      int index=name.indexOf("-");
      char[] chars = name.toCharArray();
      chars[index-1] = '-';
      name=String.valueOf(chars);
    }
    else
    {
      name= name.substring(0, name.length()-1);
      name=name.concat("-");
    }
    
  }
  
  
}

package softwareengineering.scarlet.coursework2.models;

public class DemoMonster extends Monster {
  public boolean hasHadTurn = false;
  public DemoMonster(int startX, int startY) {
    super("Demo Monster", startX, startY, 50, 5);
    behaviour = new MonsterBehaviourType1();
  }
  @Override
  public void performAction(Dungeon dungeon, Player player) {
    super.performAction(dungeon, player);
    hasHadTurn = true;
  }
}

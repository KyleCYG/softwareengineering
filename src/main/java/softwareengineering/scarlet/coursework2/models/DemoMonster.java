package softwareengineering.scarlet.coursework2.models;

public class DemoMonster extends Monster {
  private static int monsterStrength = 5;
  private static int monsterHealth = 50;

  public boolean hasHadTurn = false;

  public DemoMonster(int startX, int startY) {
    super("Demo Monster", startX, startY, monsterHealth, monsterStrength);
    behaviour = new MonsterBehaviourType1();
  }

  @Override
  public void performAction(Dungeon dungeon, Player player) {
    super.performAction(dungeon, player);
    hasHadTurn = true;
  }
}

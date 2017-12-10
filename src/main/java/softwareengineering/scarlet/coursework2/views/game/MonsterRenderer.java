package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Monster;

public class MonsterRenderer {
  private MonsterAvatar avatar;
  private Monster monster;
  private Dungeon dungeon;

  public MonsterRenderer(Dungeon dungeon) {
    avatar = new MonsterAvatar();
    this.monster = null;
    this.setDungeon(dungeon);
  }

  public void setMonster(Monster monster) {
    this.monster = monster;
  }

  public void render(Graphics2D g2d, ImageObserver observer) {
    if (monster != null)
      this.avatar.draw(monster.getX(), monster.getY(), g2d, observer);
  }

  public Dungeon getDungeon() {
    return dungeon;
  }

  public void setDungeon(Dungeon dungeon) {
    this.dungeon = dungeon;
  }
}

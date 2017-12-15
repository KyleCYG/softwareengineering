package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import softwareengineering.scarlet.coursework2.models.Dungeon;
import softwareengineering.scarlet.coursework2.models.Monster;

/**
 * Render monsters to the screen
 */
public class MonsterRenderer {
  private MonsterAvatar avatar;
  private Monster monster;
  private Dungeon dungeon;

  public MonsterRenderer(Dungeon dungeon) {
    avatar = new MonsterAvatar();
    this.monster = null;
    this.setDungeon(dungeon);
  }

  /**
   * Set which monster to render
   */
  public void setMonster(Monster monster) {
    this.monster = monster;
  }

  /**
   * Render current monster to the screen
   */
  public void render(Graphics2D g2d, ImageObserver observer) {
    if (monster != null) {
      int screenX = GameView.getXForGridX(monster.getX());
      int screenY = GameView.getYForGridY(monster.getY());
      this.avatar.draw(screenX, screenY, g2d, observer);
    }
  }

  public Dungeon getDungeon() {
    return dungeon;
  }

  public void setDungeon(Dungeon dungeon) {
    this.dungeon = dungeon;
  }
}

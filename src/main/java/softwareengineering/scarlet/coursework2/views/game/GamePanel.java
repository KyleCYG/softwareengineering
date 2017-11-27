package softwareengineering.scarlet.coursework2.views.game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import softwareengineering.scarlet.coursework2.controllers.GameController;
import softwareengineering.scarlet.coursework2.models.Dungeon;

public class GamePanel extends JPanel implements KeyListener{
  private PlayerFactory pF;
  private PlayerRenderer main_player;
  private LevelRenderer sm;
  private GameController controller;
  
  public GamePanel(GameController controller, Dungeon dungeon) {
    this.controller = controller;  
    initGamePanel(dungeon);
  }
  
  private void initGamePanel(Dungeon dungeon) {
    addKeyListener(new TAdapter());
    setFocusable(true);
    sm = new LevelRenderer(dungeon);
    pF = new PlayerFactory();
    main_player = (PlayerRenderer) pF.init("m");
  }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setFont(new Font("Chalkduster", Font.PLAIN, 20));
      g2d.drawString("Shalllll.. weeee.. begin?", 300, 25);
      sm.render(g2d);
      main_player.draw(g2d, this);
      Toolkit.getDefaultToolkit().sync();
    }

    private class TAdapter extends KeyAdapter {
      @Override
      public void keyReleased(KeyEvent e) {
        main_player.keyReleased(e);
        main_player.redraw();
      }
    }

    @Override
    public void keyTyped(KeyEvent e) {
      // TODO Auto-generated method stub 
    }

    @Override
    public void keyPressed(KeyEvent e) {
      // TODO Auto-generated method stub 
    }

    @Override
    public void keyReleased(KeyEvent e) {
      // TODO Auto-generated method stub
    }
}

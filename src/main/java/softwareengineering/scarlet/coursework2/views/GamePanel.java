package softwareengineering.scarlet.coursework2.views;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener{
  private PlayerFactory pF;
  private Player main_player;
  private ShowMap sm;
  private final int DELAY = 10;

  public GamePanel() {
      initGamePanel();
  }
  
  private void initGamePanel() {
    addKeyListener(new TAdapter());
    setFocusable(true);
    sm = new ShowMap(1, 1, 1, 1, 1, 48, 25);
    pF = new PlayerFactory();
    main_player = (Player) pF.init("m");
  }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setFont(new Font("Chalkduster", Font.PLAIN, 20));
      g2d.drawString("Shalllll.. weeee.. begin?", 300, 25);
      sm.Show(g2d);
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

package softwareengineering.scarlet.coursework2.views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;
import softwareengineering.scarlet.coursework2.levelgeneration.LevelFactory;
import softwareengineering.scarlet.coursework2.models.Entity;
import softwareengineering.scarlet.coursework2.models.ExitItem;
import softwareengineering.scarlet.coursework2.models.GoldItem;
import softwareengineering.scarlet.coursework2.models.HealthItem;
import softwareengineering.scarlet.coursework2.models.Level;
import softwareengineering.scarlet.coursework2.models.StairsDownItem;
import softwareengineering.scarlet.coursework2.models.StairsUpItem;
import softwareengineering.scarlet.coursework2.models.StrengthItem;
import java.awt.RenderingHints;
public class GamePanel extends JPanel{


    private playerFactory pF;
    private player main_player;
    private ShowMap sm;
    private final int DELAY = 10;

    
    public GamePanel(ShowMap sm) {
        this.sm = sm;
        initGamePanel();
    }
    
    private void initGamePanel() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
       

        pF = new playerFactory();
        main_player = (player) pF.init("m");
        
   
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        
        
        

        g2d.setFont(new Font("Chalkduster", Font.PLAIN, 20));
        g2d.drawString("Shalllll.. weeee.. begin?", 300, 25);


        sm.Show(g2d);

        
       
       
        main_player.draw(g2d, this);
        BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs1);
        g2d.drawLine(150, 40, 750, 40);
        g2d.drawLine(750, 40, 750, 640);
        g2d.drawLine(150, 40, 150, 640);
        g2d.drawLine(750, 640, 150, 640);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
          main_player.keyReleased(e);
          main_player.redraw();

        }


    }
}

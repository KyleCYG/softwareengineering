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
public class GamePanel extends JPanel implements ActionListener {

    private Timer timer;
    private playerFactory pF;
    private player main_player;
    private final int DELAY = 10;

    public GamePanel() {

        initGamePanel();
    }
    
    private void initGamePanel() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);

        pF = new playerFactory();
        main_player = (player) pF.init("m");

      //  timer = new Timer(DELAY, this);
       // timer.start();        
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        List<Entity> entities = new ArrayList<Entity>();

        entities.add(new GoldItem(1));
        entities.add(new HealthItem(1));
        entities.add(new StrengthItem(1));
        entities.add(new StairsUpItem(1));
        entities.add(new StairsDownItem(1));
        entities.add(new ExitItem());

        Level map = LevelFactory.generateLevel(50, 50, entities);
          

        g2d.setFont(new Font("Chalkduster", Font.PLAIN, 20));
        g2d.drawString("Shalllll.. weeee.. begin?", 300, 25);
             
       
        
        
        BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs1);
        g2d.drawLine(150, 40, 750, 40);
        g2d.drawLine(750, 40, 750, 640);
        g2d.drawLine(150, 40, 150, 640);
        g2d.drawLine(750, 640, 150, 640);

    }

    public void actionPerformed(ActionEvent e) {
        

        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
          main_player.keyReleased(e);
        }


    }
}

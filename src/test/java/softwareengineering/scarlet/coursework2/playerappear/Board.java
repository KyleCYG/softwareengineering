package softwareengineering.scarlet.coursework2.playerappear;

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
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.RenderingHints;
public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Player player;
    private final int DELAY = 10;

    public Board() {

        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);

        player = new Player();

        timer = new Timer(DELAY, this);
        timer.start();        
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);     

        g2d.setFont(new Font("Chalkduster", Font.PLAIN, 20));
        g2d.drawString("Shalllll.. weeee.. begin?", 300, 25);
             
        for(int i = 1;i < 60;i++) {
        		for(int j = 1;j < 60;j++) {
        			g2d.drawLine(150+i*10, 40+j*10, 150+i*10, 40+j*10);
        		}
        }
        
        BasicStroke bs1 = new BasicStroke(8, BasicStroke.CAP_SQUARE,
    			BasicStroke.JOIN_ROUND);
        
        
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
          player.keyReleased(e);
        }


    }
}

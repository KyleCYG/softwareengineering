package softwareengineering.scarlet.coursework2;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Test2D_Main extends JFrame{

	public Test2D_Main() {

		initUI();
	}

	private void initUI() {

		this.add(new Surface());

		setTitle("We are totally printing a dungeon");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				Test2D_Main ex = new Test2D_Main();
				ex.setVisible(true);
			}
		});
	}
}
class Surface extends JPanel {

	private void doDrawing(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		/*        String[] newArray = new String[3];
        newArray[0] = "000";
        newArray[1] = "010";
        newArray[2] = "000";*/

		int[][] mapArray = generateRandom(50,50);/*{{0,0,0,0,0}, {0,1,0,1,1}, {0,0,0,1,1}};*/

		String[] newArray = convertToStringArray(mapArray);

		
		Font newFont=new Font("Monospaced", Font.PLAIN, 12); 
		g2d.setFont(newFont);
		
		for(int i = 0; i < newArray.length; i++) 
		{
			g2d.drawString(newArray[i], 50, 50 + 10*i);
		}

	}

	private String[] convertToStringArray(int[][] map) {
		int rows = map.length;
		int cols = map[0].length;
		int i, j;
		String[] charMap = new String[rows];
		for(i = 0; i < rows; i++)
		{
			charMap[i]="";
		}
		String wall = "|";
		String floor = ".";

		for(i = 0; i < rows; i++)
		{
			for(j = 0; j < cols; j++)
			{
				if(map[i][j] == 0) 
				{
					charMap[i] += wall;
				}
				else 
				{
					charMap[i] += floor;
				}
			}
		}
		return charMap;
	}

	private int[][] generateRandom(int rows,int cols)
	{
		Random rand=new Random();
		int[][] temp= new int[rows][cols];
		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{
				temp[i][j]=rand.nextInt(2);
			}
		}
		return temp;

	}
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		doDrawing(g);
	}
}
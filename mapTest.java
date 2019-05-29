import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.Timer;

// Purely for the settlements (ie. the intersections)
public class mapTest implements ActionListener
{
	JFrame frame = new JFrame();
	AnimationPanel panel = new AnimationPanel();
	Timer timer = new Timer (1000/60, this);
	String[][] strMap = new String [5][9];
	
	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource() == timer)
		{
			panel.repaint();
		}
	}
	
	public static String[][] loadMap() throws IOException
	{
		BufferedReader map = null;
		String[] strMapLine = new String[5];
		String[][] strMap = new String [5][9];
		int intCount;
		
		try
		{
			map = new BufferedReader(new FileReader("catan-tiles.csv"));
		}
		catch (IOException e)
		{
			
		}
		
		for (intCount = 0; intCount < 5; intCount++)
		{
			try
			{
				strMapLine[intCount] = map.readLine();
			}
			catch (IOException e)
			{
			}
			strMap[intCount] = strMapLine[intCount].split(",");
		}
		
		return strMap;
	}
	
	public mapTest ()
	{
		panel = new AnimationPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1280, 720));
		
		// timer.addActionListener(this);
		// timer.start();
		
		frame = new JFrame("New Animations :)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		
		try
		{
			strMap = mapTest.loadMap();
		}
		catch (IOException e)
		{
			System.out.println("IOException");
		}
		
		int intColumn;
		int intRow;
		int intOreX = 50;
		int intOreY = 50;
		
		for (intRow = 0; intRow < 5; intRow++)
		{
			if (intRow == 0 || intRow == 4)
			{
				intOreX = 150;
			}
			else if (intRow == 1 || intRow == 3)
			{
				intOreX = 100;
			}
			else if (intRow == 2)
			{
				intOreX = 50;
			}
			
			for (intColumn = 0; intColumn < 9; intColumn++)
			{
				if (strMap[intRow][intColumn].equals("x"))
				{
					System.out.println("X");
					
				}
				else if (strMap[intRow][intColumn].equals("_"))
				{
					panel.intOreX = intOreX;
					panel.intOreY = intOreY;
					intOreX = intOreX + 100;
					panel.intTileNum++;
					panel.repaint();
					
					System.out.println("_");
				}
			}
			intOreY = intOreY + 116;
		}
	}
	
	public static void main (String[] args) throws IOException
	{
		new mapTest();
	}
}

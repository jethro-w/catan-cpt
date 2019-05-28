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
	// Timer timer = new Timer (1000/60, this);
	String[][] strMap = new String [5][9];
	
	public void actionPerformed (ActionEvent evt)
	{
		/*
		if (evt.getSource() == timer)
		{
			panel.repaint();
		}
		*/
	}
	
	public static String[][] loadMap()
	{
		BufferedReader map = null;
		
		try
		{
			map = new BufferedReader(new FileReader("catan-tiles.csv"));
		}
		catch (IOException e)
		{
			
		}
		
		String[] strMapLine = new String[5];
		String[][] strMap = new String [5][9];
		int intCount;
		
		
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
		
		strMap = mapTest.loadMap();
		
		int intColumn;
		int intRow;
		int intOreX = 50;
		int intOreY = 50;
		boolean wasTile = false;
		
		panel.printTile = false;
		panel.repaint();
		
		for (intRow = 0; intRow < 5; intRow++)
		{
			if (intRow == 0 || intRow == 4)
			{
				intOreX = 250;
			}
			else if (intRow == 1 || intRow == 3)
			{
				intOreX = 150;
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
					panel.printTile = true;
					intOreX = intOreX + 100;
					System.out.println("_");
					panel.paintChildren(null);
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

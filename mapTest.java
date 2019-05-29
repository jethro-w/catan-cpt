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
	Timer timer = new Timer (1000/200, this);
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
		
		timer.addActionListener(this);
		timer.start();
		
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
		int intRand;
		
		// Copy array to AnimationPanel
		for (intRow = 0; intRow < 5; intRow++)
		{
			for (intColumn = 0; intColumn < 9; intColumn++)
			{
				if (strMap[intRow][intColumn].equals("_"))
				{
					intRand = (int) (Math.random() * 5);
					if (intRand == 0)
					{
						panel.strMap[intRow][intColumn] = "0";
					}
					else if (intRand == 1)
					{
						panel.strMap[intRow][intColumn] = "1";
					}
					else if (intRand == 2)
					{
						panel.strMap[intRow][intColumn] = "2";
					}
					else if (intRand == 3)
					{
						panel.strMap[intRow][intColumn] = "3";
					}
					else if (intRand == 4)
					{
						panel.strMap[intRow][intColumn] = "4";
					}
				}
				else if (strMap[intRow][intColumn].equals("x"))
				{
					panel.strMap[intRow][intColumn] = "x";
				}
			}
		}
	}
	
	public static void main (String[] args) throws IOException
	{
		new mapTest();
	}
}

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
	String[][] strMap = new String [12][11];
	
	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource() == timer)
		{
			panel.repaint();
		}
	}
	
	public static String[][] loadMap()
	{
		BufferedReader map = null;
		
		try
		{
			map = new BufferedReader(new FileReader("catan-settlements-map.csv"));
		}
		catch (IOException e)
		{
			
		}
		
		String[] strMapLine = new String[12];
		String[][] strMap = new String [12][11];
		int intCount;
		
		
		for (intCount = 0; intCount < 12; intCount++)
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
		
		strMap = mapTest.loadMap();
		
		int intColumn;
		int intRow;
		int intOreX = 0;
		int intOreY = 0;
		
		for (intRow = 0; intRow < 12; intRow++)
		{
			intOreX = 0;
			for (intColumn = 0; intColumn < 11; intColumn++)
			{
				if (strMap[intRow][intColumn].equals("x"))
				{
					System.out.println("X");
				}
				else if (strMap[intRow][intColumn].equals("_"))
				{
					panel.intOreX = intOreX;
					panel.intOreY = intOreY;
					panel.printOre = true;
					panel.repaint();
					System.out.println("_");
				}
				
				intOreX = intOreX + 100;
			}
			
			intOreY = intOreY + 116;
		}
	}
	
	public static void main (String[] args) throws IOException
	{
		new mapTest();
	}
}

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.Timer;

// Game phase code
public class GameCode implements ActionListener, MouseListener
{
	// Properties
	public JFrame frame = new JFrame();
	public AnimationPanel panel = new AnimationPanel();
	public Timer timer = new Timer(1000 / 10, this);
	public String[][] strMap = new String[5][9];
	public String[][] strSettlements = new String[12][11];
	public int[] intTileNums = new int[18];
	public int intStartTile;
	
	private int intCount;
	
	// Methods
	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource() == timer)
		{
			panel.repaint();
		}
	}
	
	public void mouseClicked (MouseEvent evt)
	{
		panel.intMouseX = evt.getX();
		panel.intMouseY = evt.getY();
	}

	public void mousePressed (MouseEvent evt)
	{
		
	}

	public void mouseReleased (MouseEvent evt)
	{
		
	}

	public void mouseEntered (MouseEvent evt)
	{
		
	}

	public void mouseExited (MouseEvent evt)
	{
		
	}

	public static String[][] loadMap () throws IOException
	{
		BufferedReader map = null;
		String[] strMapLine = new String[5];
		String[][] strMap = new String[5][9];
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
	
	public static String[][] loadSettlements () throws IOException
	{
		BufferedReader map = null;
		String[] strMapLine = new String[12];
		String[][] strMap = new String[12][11];
		int intCount;

		try
		{
			map = new BufferedReader(new FileReader("catan-settlements-map.csv"));
		}
		catch (IOException e)
		{

		}

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
	
	private static int[] loadTileNumbers ()
	{
		int[] intTileNums = new int[18];
		
		// TileNumber,Rarity
		
		intTileNums[0] = 5;
		intTileNums[1] = 2;
		intTileNums[2] = 6;
		intTileNums[3] = 3;
		intTileNums[4] = 8;
		intTileNums[5] = 10;
		intTileNums[6] = 9;
		intTileNums[7] = 12;
		intTileNums[8] = 11;
		intTileNums[9] = 4;
		intTileNums[10] = 8;
		intTileNums[11] = 10;
		intTileNums[12] = 9;
		intTileNums[13] = 4;
		intTileNums[14] = 5;
		intTileNums[15] = 6;
		intTileNums[16] = 3;
		intTileNums[17] = 11;
		
		return intTileNums;
	}
	
	// Constructor
	public GameCode()
	{
		panel = new AnimationPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1280, 720));
		panel.addMouseListener(this);

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
			strMap = GameCode.loadMap();
			strSettlements = GameCode.loadSettlements();
		}
		catch (IOException e)
		{
			System.out.println("Could not load map(s)");
		}

		int intColumn;
		int intRow;
		int intRand = 0;
		int intOre = 0;
		int intBrick = 0;
		int intWheat = 0;
		int intWood = 0;
		int intWool = 0;
		int intDesert = 0;
		int intTemp = (int) (Math.random() * 2);
		boolean hasMaxOre = false;
		boolean hasMaxBrick = false;
		boolean hasMaxWheat = false;
		boolean hasMaxWood = false;
		boolean hasMaxWool = false;
		boolean hasDesert = false;
		
		// Copy array to AnimationPanel
		for (intRow = 0; intRow < 5; intRow++)
		{
			for (intColumn = 0; intColumn < 9; intColumn++)
			{
				if (strMap[intRow][intColumn].equals("_"))
				{
					// Generate random tile
					if (intTemp == 1)
					{
						intRand = (int)(Math.random() * 6);
					}
					else
					{
						intRand = (int)(Math.random() * 5);
					}
					
					while ((intRand == 0 && hasMaxOre == true) || (intRand == 1 && hasMaxBrick == true)
							|| (intRand == 2 && hasMaxWheat == true) || (intRand == 3 && hasMaxWood == true)
							|| (intRand == 4 && hasMaxWool == true) || (intRand == 5 && hasDesert == true))
					{
						intRand = (int) (Math.random() * 6);
						System.out.println(intRand);
					}

					if (intRand == 0)
					{
						panel.strMap[intRow][intColumn] = "0";
						intOre++;
						if (intOre == 3)
						{
							hasMaxOre = true;
						}
					}
					if (intRand == 1)
					{
						panel.strMap[intRow][intColumn] = "1";
						intBrick++;
						if (intBrick == 3)
						{
							hasMaxBrick = true;
						}
					}
					if (intRand == 2)
					{
						panel.strMap[intRow][intColumn] = "2";
						intWheat++;
						if (intWheat == 4)
						{
							hasMaxWheat = true;
						}
					}
					if (intRand == 3)
					{
						panel.strMap[intRow][intColumn] = "3";
						intWood++;
						if (intWood == 4)
						{
							hasMaxWood = true;
						}
					}
					if (intRand == 4)
					{
						panel.strMap[intRow][intColumn] = "4";
						intWool++;
						if (intWool == 4)
						{
							hasMaxWool = true;
						}
					}
					if (intRand == 5)
					{
						panel.strMap[intRow][intColumn] = "5";
						intDesert++;
						if (intDesert == 1)
						{
							hasDesert = true;
						}
					}
				}
				else if (strMap[intRow][intColumn].equals("x"))
				{
					panel.strMap[intRow][intColumn] = "x";
				}
			}
		}
		
		// Decide where which tile starts
		intTileNums = loadTileNumbers();
		
		intRand = (int) (Math.random() * 12);
		
		if ((intRand == 0) || (intRand == 1) || (intRand == 2) || (intRand == 3)) 
		{
			intStartTile = intRand + 1;
		}
		else if ((intRand == 4) || (intRand == 5))
		{
			intStartTile = intRand + 3;
		}
		else if ((intRand == 6) || (intRand == 7))
		{
			intStartTile = intRand + 6;
		}
		else if ((intRand == 8) || (intRand == 9) || (intRand == 10) || (intRand == 11))
		{
			intStartTile = intRand + 8;
		}
	}

	// Main method
	public static void main (String[] args) throws IOException
	{
		new GameCode();
	}
}

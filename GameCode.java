import java.awt.Color;
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
	public int intMouseX;
	public int intMouseY;
	int intDrawX;
	int intDrawY = 90;
	int intDeltaY = 56;
	
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
		int intXCell; // Column
		int intYCell; // Row
		int intRow;
		
		intMouseX = evt.getX();
		intMouseY = evt.getY();
		
		
		for (intRow = 1; intRow <= 12; intRow++)
		{
			if (intRow == 1 || intRow == 12)
			{
				intDrawX = 240;
			}
			else if (intRow == 2 || intRow == 3 || intRow == 10
					|| intRow == 11)
			{
				intDrawX = 190;
			}
			else if (intRow == 4 || intRow == 5 || intRow == 8
					|| intRow == 9)
			{
				intDrawX = 140;
			}
			else if (intRow == 6 || intRow == 7)
			{
				intDrawX = 90;
			}

			for (intCount = 0; intDrawX <= 580; intDrawX = intDrawX + 100)
			{
				if (((intMouseX >= intDrawX) && (intMouseX <= intDrawX + 20))
						&& ((intMouseY >= intDrawY) && (intMouseY <= intDrawY + 20)))
				{
					intXCell = (int) Math.round((intMouseX - 100) / 50.0);
					intYCell = Math.round((intMouseY / 58) - 1);
					
					panel.strSettlements[intYCell][intXCell] = "r";
					strSettlements[intYCell][intXCell] = "r";
					
					System.out.println("intersection [" + intYCell + "][" + intXCell + "]");
					System.out.println(intMouseX + ", " + intMouseY);
				}
			}
			if (intDeltaY == 30)
			{
				intDeltaY = 56;
			}
			else if (intDeltaY == 56)
			{
				intDeltaY = 30;
			}

			intDrawY = intDrawY + intDeltaY;
		}
		intDrawY = 90;
		
		/*
		for (intRow = 0; intRow < 12; intRow++)
		{
			if (intRow == 0 || intRow == 11)
			{
				intDrawX = 230;
			}
			else if (intRow == 1 || intRow == 2 || intRow == 9
					|| intRow == 10)
			{
				intDrawX = 180;
			}
			else if (intRow == 3 || intRow == 4 || intRow == 7
					|| intRow == 8)
			{
				intDrawX = 130;
			}
			else if (intRow == 5 || intRow == 6)
			{
				intDrawX = 80;
			}

			for (intColumn = 0; intColumn < 11 && intDrawX <= 580; intColumn++)
			{
				if (((intMouseX >= intDrawX) && (intMouseX <= intDrawX + 40))
						&& ((intMouseY >= intDrawY) && (intMouseY <= intDrawY + 40)))
				{
					intXCell = Math.round((intMouseX - 100) / 50);
					intYCell = Math.round((intMouseY / 58) - 1);
					
					panel.strSettlements[intXCell][intYCell] = "r";
					strSettlements[intXCell][intYCell] = "r";
					
					intDrawX = intDrawX + 100;
					
					System.out.println("intersection");
				}
			}

			if (intDeltaY == 30)
			{
				intDeltaY = 56;
			}
			else if (intDeltaY == 56)
			{
				intDeltaY = 30;
			}

			intDrawY = intDrawY + intDeltaY;
		}
		intDrawY = 80;
		*/
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
					intRand = (int)(Math.random() * 11);
					
					while (((intRand == 0 || intRand == 1) && hasMaxOre == true) || ((intRand == 2 || intRand == 3) && hasMaxBrick == true)
							|| ((intRand == 4 || intRand == 5) && hasMaxWheat == true) || ((intRand == 6 || intRand == 7) && hasMaxWood == true)
							|| ((intRand == 8 || intRand == 9) && hasMaxWool == true) || (intRand == 10 && hasDesert == true))
					{
						intRand = (int) (Math.random() * 11);
						System.out.println(intRand);
					}

					if (intRand == 0 || intRand == 1)
					{
						panel.strMap[intRow][intColumn] = "0";
						intOre++;
						if (intOre == 3)
						{
							hasMaxOre = true;
						}
					}
					if (intRand == 2 || intRand == 3)
					{
						panel.strMap[intRow][intColumn] = "1";
						intBrick++;
						if (intBrick == 4)
						{
							hasMaxBrick = true;
						}
					}
					if (intRand == 4 || intRand == 5)
					{
						panel.strMap[intRow][intColumn] = "2";
						intWheat++;
						if (intWheat == 4)
						{
							hasMaxWheat = true;
						}
					}
					if (intRand == 6 || intRand == 7)
					{
						panel.strMap[intRow][intColumn] = "3";
						intWood++;
						if (intWood == 4)
						{
							hasMaxWood = true;
						}
					}
					if (intRand == 8 || intRand == 9)
					{
						panel.strMap[intRow][intColumn] = "4";
						intWool++;
						if (intWool == 4)
						{
							hasMaxWool = true;
						}
					}
					if (intRand == 10)
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
		
		for (intRow = 0; intRow < 12; intRow ++)
		{
			for (intColumn = 0; intColumn < 11; intColumn ++)
			{
				if (strSettlements[intRow][intColumn].equals("_"))
				{
					panel.strSettlements[intRow][intColumn] = "_";
				}
				else if (strSettlements[intRow][intColumn].equals("x"))
				{
					panel.strSettlements[intRow][intColumn] = "x";
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

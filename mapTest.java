import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

// Purely for the settlements (ie. the intersections)
public class mapTest implements ActionListener
{
	public JFrame frame = new JFrame();
	public AnimationPanel panel = new AnimationPanel();
	public Timer timer = new Timer(1000 / 200, this);
	public String[][] strMap = new String[5][9];
	private int intCount;

	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource() == timer)
		{
			panel.repaint();
		}
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

	public mapTest()
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
		boolean printedTile = false;

		// Copy array to AnimationPanel
		for (intRow = 0; intRow < 5; intRow++)
		{
			for (intColumn = 0; intColumn < 9; intColumn++)
			{
				if (strMap[intRow][intColumn].equals("_"))
				{
					while (printedTile == false)
					{
						intRand = (int) (Math.random() * 6);
						System.out.println(intRand);

						if (intRand == 0)
						{
							if (hasMaxOre == true)
							{
								intRand = (int) (Math.random() * 6);
							}
							else
							{
								panel.strMap[intRow][intColumn] = "0";
								intOre++;
								printedTile = true;

								// Capping ore tiles at 3 (same for other resource tiles)
								if (intOre == 3)
								{
									hasMaxOre = true;
								}
							}
						}
						if (intRand == 1)
						{
							if (hasMaxBrick == true)
							{
								intRand = (int) (Math.random() * 6);
							}
							else
							{
								panel.strMap[intRow][intColumn] = "1";
								intBrick++;
								printedTile = true;

								if (intBrick == 3)
								{
									hasMaxBrick = true;
								}
							}
						}
						if (intRand == 2)
						{
							if (hasMaxWheat == true)
							{
								intRand = (int) (Math.random() * 6);
							}
							else
							{
								panel.strMap[intRow][intColumn] = "2";
								intWheat++;
								printedTile = true;

								if (intWheat == 4)
								{
									hasMaxWheat = true;
								}
							}
						}
						if (intRand == 3)
						{
							if (hasMaxWood == true)
							{
								intRand = (int) (Math.random() * 6);
							}
							else
							{
								panel.strMap[intRow][intColumn] = "3";
								intWood++;
								printedTile = true;

								if (intWood == 4)
								{
									hasMaxWood = true;
								}
							}
						}
						if (intRand == 4)
						{
							if (hasMaxWool == true)
							{
								intRand = (int) (Math.random() * 6);
							}
							else
							{
								panel.strMap[intRow][intColumn] = "4";
								intWool++;
								printedTile = true;

								if (intWool == 4)
								{
									hasMaxWool = true;
								}
							}
						}
						if (intRand == 5)
						{
							if (hasDesert == true)
							{
								intRand = (int) (Math.random() * 6);
							}
							else
							{
								panel.strMap[intRow][intColumn] = "5";
								intDesert++;
								printedTile = true;

								if (intDesert == 1)
								{
									hasDesert = true;
								}
							}
						}
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

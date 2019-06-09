import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.JPanel;

public class AnimationPanel extends JPanel
{
	// Properties
	int intTileX;
	int intTileY = 100;
	String strTiles[][] = new String[5][9];
	String strSettlements[][] = new String[12][11];
	String strRoads[][] = new String[11][11];
	BufferedImage[] tileImage = new BufferedImage[6];
	BufferedImage menu = null;
	BufferedImage settlement = null;
	BufferedImage vertRoad = null;
	BufferedImage upRoad = null;
	BufferedImage downRoad = null;
	boolean printTile;
	int intCount;
	int intRow;
	int intColumn;
	int intMouseX;
	int intMouseY;
	int intDrawX;
	int intDrawY = 80;
	int intDeltaY = 56;

	// Methods
	// Override how this component paints itself
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		// Draw resource tiles
		for (intRow = 0; intRow < 5; intRow++)
		{
			if (intRow == 0 || intRow == 4)
			{
				intTileX = 200;
			}
			else if (intRow == 1 || intRow == 3)
			{
				intTileX = 150;
			}
			else if (intRow == 2)
			{
				intTileX = 100;
			}

			for (intColumn = 0; intColumn < 9; intColumn++)
			{
				if (strTiles[intRow][intColumn].equals("0"))
				{
					g.drawImage(tileImage[0], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strTiles[intRow][intColumn].equals("1"))
				{
					g.drawImage(tileImage[1], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strTiles[intRow][intColumn].equals("2"))
				{
					g.drawImage(tileImage[2], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strTiles[intRow][intColumn].equals("3"))
				{
					g.drawImage(tileImage[3], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strTiles[intRow][intColumn].equals("4"))
				{
					g.drawImage(tileImage[4], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strTiles[intRow][intColumn].equals("5"))
				{
					g.drawImage(tileImage[5], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strTiles[intRow][intColumn].equals("x"))
				{
				}
			}
			intTileY = intTileY + 86;
		}
		
		intTileY = 100;
		
		// Draw settlements
		for (intRow = 0; intRow < 12; intRow++)
		{
			intDrawX = 80;

			for (intColumn = 0; intColumn < 11 && intDrawX <= 600; intColumn++)
			{
				if (strSettlements[intRow][intColumn].equals("r"))
				{
					g.setColor(Color.white);
					g.drawRect(intDrawX + 10, intDrawY + 10, 20, 20);
					g.drawImage(settlement, intDrawX + 10, intDrawY + 10, null);
					intDrawX = intDrawX + 50;
				}
				else if (strSettlements[intRow][intColumn].equals("_"))
				{
					g.setColor(Color.white);
					g.drawRect(intDrawX + 10, intDrawY + 10, 20, 20);
					intDrawX = intDrawX + 50;
				}
				else if (strSettlements[intRow][intColumn].equals("x"))
				{
					intDrawX = intDrawX + 50;
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
		
		// Draw roads
		for (intRow = 0; intRow < 11; intRow++)
		{
			if (intRow == 0 || intRow == 10)
			{
				intTileX = 200;
			}
			else if (intRow == 1 || intRow == 9)
			{
				intTileX = 195;
			}
			else if (intRow == 2 || intRow == 8)
			{
				intTileX = 150;
			}
			else if (intRow == 3 || intRow == 7)
			{
				intTileX = 145;
			}
			else if (intRow == 4 || intRow == 6)
			{
				intTileX = 100;
			}
			else if (intRow == 5)
			{
				intTileX = 95;
			}

			for (intColumn = 0; intColumn < 11 && intDrawX <= 600; intColumn++)
			{
				if (strRoads[intColumn][intRow].equals("r"))
				{
					g.drawImage(vertRoad, intDrawX + 10, intDrawY + 10, null);
					intDrawX = intDrawX + 50;
				}
				else if (strRoads[intColumn][intRow].equals("_") || strRoads[intColumn][intRow].equals("x"))
				{
					if (intRow == 0 || intRow == 2 || intRow == 4 || intRow == 6 || intRow == 8 || intRow == 10)
					{
						intDrawX = intDrawX + 50;
					}
					else
					{
						intDrawX = intDrawX + 100;
					}
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
	}

	// Constructor
	public AnimationPanel()
	{
		super();

		setBackground(Color.black);

		try
		{
			for (intCount = 0; intCount < 6; intCount++)
			{
				// Ore Tile = 0
				if (intCount == 0)
				{
					tileImage[intCount] = ImageIO.read(new File("OreTile.png"));
				}
				// Brick Tile = 1
				else if (intCount == 1)
				{
					tileImage[intCount] = ImageIO.read(new File("BrickTile.png"));
				}
				// Wheat Tile = 2
				else if (intCount == 2)
				{
					tileImage[intCount] = ImageIO.read(new File("WheatTile.png"));
				}
				// Wood Tile = 3
				else if (intCount == 3)
				{
					tileImage[intCount] = ImageIO.read(new File("WoodTile.png"));
				}
				// Wool Tile = 4
				else if (intCount == 4)
				{
					tileImage[intCount] = ImageIO.read(new File("WoolTile.png"));
				}
				// Desert Tile = 5
				else if (intCount == 5)
				{
					tileImage[intCount] = ImageIO.read(new File("DesertTile.png"));
				}
			}

			settlement = ImageIO.read(new File("settlement.png"));
			vertRoad = ImageIO.read(new File("vertRoad.png"));
			// upRoad = ImageIO.read(new File("upRoad.png"));
			// downRoad = ImageIO.read(new File("downRoad.png"));
		}
		catch (IOException e)
		{
			System.out.println("Cannot load image");
		}
	}
}

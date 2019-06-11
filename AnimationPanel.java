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
	BufferedImage[] settlement = new BufferedImage[4];
	BufferedImage[] vertRoad = new BufferedImage[4];
	BufferedImage[] upRoad = new BufferedImage[4];
	BufferedImage[] downRoad = new BufferedImage[4];
	boolean printTile;
	boolean isSlantedUp;
	int intCount;
	int intRow;
	int intColumn;
	int intMouseX;
	int intMouseY;
	int intDrawX;
	int intSettleY = 80;
	int intSettleDeltaY = 56;
	int intRoadDeltaY = 56;
	int intRoadY = 100;

	// Methods
	// Override how this component paints itself
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);

		// Draw resource tiles
		for (intRow = 0; intRow < 5; intRow ++)
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

			for (intColumn = 0; intColumn < 9; intColumn ++)
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
		
		intRoadY = 100;
		
		// Draw roads
		for (intRow = 0; intRow < 11; intRow ++)
		{
			if (intRow == 0 || intRow == 2 || intRow == 4 || intRow == 6 || intRow == 8 || intRow == 10)
			{
				intDrawX = 100;
			}
			else if (intRow == 1 || intRow == 3 || intRow == 5 || intRow == 7 || intRow == 9)
			{
				intDrawX = 95;
			}

			if (intRow == 0 || intRow == 2 || intRow == 4)
			{
				isSlantedUp = true;
			}
			else if (intRow == 6 || intRow == 8 || intRow == 10)
			{
				isSlantedUp = false;
			}

			for (intColumn = 0; intColumn < 11; intColumn ++)
			{
				if (strRoads[intRow][intColumn].equals("r") || strRoads[intRow][intColumn].equals("b") ||
						strRoads[intRow][intColumn].equals("w") || strRoads[intRow][intColumn].equals("o"))
				{
					if (intRow == 0 || intRow == 2 || intRow == 4 || intRow == 6 || intRow == 8 || intRow == 10)
					{
						if (isSlantedUp == true)
						{
							if (strRoads[intRow][intColumn].equals("r"))
							{
								g.drawImage(upRoad[0], intDrawX, intRoadY, null);
							}
							else if (strRoads[intRow][intColumn].equals("b"))
							{
								g.drawImage(upRoad[1], intDrawX, intRoadY, null);
							}
							else if (strRoads[intRow][intColumn].equals("w"))
							{
								g.drawImage(upRoad[2], intDrawX, intRoadY, null);
							}
							else if (strRoads[intRow][intColumn].equals("o"))
							{
								g.drawImage(upRoad[3], intDrawX, intRoadY, null);
							}
							isSlantedUp = false;
						}
						else if (isSlantedUp == false)
						{
							if (strRoads[intRow][intColumn].equals("r"))
							{
								g.drawImage(downRoad[0], intDrawX, intRoadY, null);
							}
							else if (strRoads[intRow][intColumn].equals("b"))
							{
								g.drawImage(downRoad[1], intDrawX, intRoadY, null);
							}
							else if (strRoads[intRow][intColumn].equals("w"))
							{
								g.drawImage(downRoad[2], intDrawX, intRoadY, null);
							}
							else if (strRoads[intRow][intColumn].equals("o"))
							{
								g.drawImage(downRoad[3], intDrawX, intRoadY, null);
							}
							isSlantedUp = true;
						}
						intDrawX = intDrawX + 50;
					}
					else
					{
						if (strRoads[intRow][intColumn].equals("r"))
						{
							g.drawImage(vertRoad[0], intDrawX, intRoadY, null);
						}
						else if (strRoads[intRow][intColumn].equals("b"))
						{
							g.drawImage(vertRoad[1], intDrawX, intRoadY, null);
						}
						intDrawX = intDrawX + 50;
					}
				}
				else
				{
					if ((intRow == 0 || intRow == 0 || intRow == 2 || intRow == 4 || intRow == 6 || intRow == 8
							|| intRow == 10) && strRoads[intRow][intColumn].equals("_"))
					{
						if (isSlantedUp == true)
						{
							isSlantedUp = false;
						}
						else if (isSlantedUp == false)
						{
							isSlantedUp = true;
						}
					}
					intDrawX = intDrawX + 50;
				}
			}

			if (intRoadDeltaY == 30)
			{
				intRoadDeltaY = 56;
			}
			else if (intRoadDeltaY == 56)
			{
				intRoadDeltaY = 30;
			}

			intRoadY = intRoadY + intRoadDeltaY;
		}

		// Draw settlements
		for (intRow = 0; intRow < 12; intRow ++)
		{
			intDrawX = 80;

			for (intColumn = 0; intColumn < 11 && intDrawX <= 600; intColumn ++)
			{
				if (strSettlements[intRow][intColumn].equals("r") || strSettlements[intRow][intColumn].equals("b")
						|| strSettlements[intRow][intColumn].equals("w") || strSettlements[intRow][intColumn].equals("o"))
				{
					g.setColor(Color.white);
					g.drawRect(intDrawX + 10, intSettleY + 10, 20, 20);

					if (strSettlements[intRow][intColumn].equals("r"))
					{
						g.drawImage(settlement[0], intDrawX + 10, intSettleY + 10, null);
					}
					else if (strSettlements[intRow][intColumn].equals("b"))
					{
						g.drawImage(settlement[1], intDrawX + 10, intSettleY + 10, null);
					}
					else if (strSettlements[intRow][intColumn].equals("w"))
					{
						g.drawImage(settlement[2], intDrawX + 10, intSettleY + 10, null);
					}
					else if (strSettlements[intRow][intColumn].equals("o"))
					{
						g.drawImage(settlement[3], intDrawX + 10, intSettleY + 10, null);
					}
					intDrawX = intDrawX + 50;
				}
				else if (strSettlements[intRow][intColumn].equals("_"))
				{
					g.setColor(Color.white);
					g.drawRect(intDrawX + 10, intSettleY + 10, 20, 20);
					intDrawX = intDrawX + 50;
				}
				else if (strSettlements[intRow][intColumn].equals("x"))
				{
					intDrawX = intDrawX + 50;
				}
			}

			if (intSettleDeltaY == 30)
			{
				intSettleDeltaY = 56;
			}
			else if (intSettleDeltaY == 56)
			{
				intSettleDeltaY = 30;
			}

			intSettleY = intSettleY + intSettleDeltaY;
		}

		intSettleY = 80;
	}

	// Constructor
	public AnimationPanel ()
	{
		super();

		setBackground(Color.black);

		try
		{
			tileImage[0] = ImageIO.read(new File("OreTile.png"));
			tileImage[1] = ImageIO.read(new File("BrickTile.png"));
			tileImage[2] = ImageIO.read(new File("WheatTile.png"));
			tileImage[3] = ImageIO.read(new File("WoodTile.png"));
			tileImage[4] = ImageIO.read(new File("WoolTile.png"));
			tileImage[5] = ImageIO.read(new File("DesertTile.png"));

			settlement[0] = ImageIO.read(new File("settlementRed.png"));
			settlement[1] = ImageIO.read(new File("settlementBlue.png"));
			settlement[2] = ImageIO.read(new File("settlementWhite.png"));
			settlement[3] = ImageIO.read(new File("settlementOrange.png"));

			vertRoad[0] = ImageIO.read(new File("vertRoadRed.png"));
			vertRoad[1] = ImageIO.read(new File("vertRoadBlue.png"));
			vertRoad[2] = ImageIO.read(new File("vertRoadWhite.png"));
			vertRoad[3] = ImageIO.read(new File("vertRoadOrange.png"));

			upRoad[0] = ImageIO.read(new File("upRoadRed.png"));
			upRoad[1] = ImageIO.read(new File("upRoadBlue.png"));
			upRoad[2] = ImageIO.read(new File("upRoadWhite.png"));
			upRoad[3] = ImageIO.read(new File("upRoadOrange.png"));

			downRoad[0] = ImageIO.read(new File("downRoadRed.png"));
			downRoad[1] = ImageIO.read(new File("downRoadBlue.png"));
			downRoad[2] = ImageIO.read(new File("downRoadWhite.png"));
			downRoad[3] = ImageIO.read(new File("downRoadOrange.png"));
		}
		catch (IOException e)
		{
			System.out.println("Cannot load image");
		}
	}
}

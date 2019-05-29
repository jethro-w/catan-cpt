import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.JPanel;

public class AnimationPanel extends JPanel
{
	// Properties
	int intTileX;
	int intTileY = 100;
	String strMap[][] = new String [5][9];
	BufferedImage[] tileImage = new BufferedImage [5];
	BufferedImage menu = null;
	boolean printTile;
	int intCount;
	int intRow;
	int intColumn;
	
	// Methods
	// Override how this component paints itself
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		// Print map
		for (intRow = 0; intRow < 5; intRow++)
		{
			if (intRow == 0 || intRow == 4)
			{
				intTileX = 250;
			}
			else if (intRow == 1 || intRow == 3)
			{
				intTileX = 200;
			}
			else if (intRow == 2)
			{
				intTileX = 150;
			}
			
			for (intColumn = 0; intColumn < 9; intColumn++)
			{
				if (strMap[intRow][intColumn].equals("0"))
				{
					g.drawImage(tileImage[0], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strMap[intRow][intColumn].equals("1"))
				{
					g.drawImage(tileImage[1], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strMap[intRow][intColumn].equals("2"))
				{
					g.drawImage(tileImage[2], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strMap[intRow][intColumn].equals("3"))
				{
					g.drawImage(tileImage[3], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
				else if (strMap[intRow][intColumn].equals("4"))
				{
					g.drawImage(tileImage[4], intTileX, intTileY, null);
					intTileX = intTileX + 100;
				}
			}
			intTileY = intTileY + 87;
		}
		intTileY = 100;
	}

	// Constructor
	public AnimationPanel()
	{
		super();
		
		setBackground(Color.black);
		
		try
		{
			for (intCount = 0; intCount < 5; intCount++)
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
			}
		}
		catch (IOException e)
		{
			System.out.println("Cannot load image");
		}
	}
}

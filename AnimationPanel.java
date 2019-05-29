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
	int intOreX;
	int intOreY;
	BufferedImage[] image = null;
	BufferedImage menu = null;
	boolean printTile;
	int intCount;
	int intTileNum = 0;
	
	// Methods
	// Override how this component paints itself
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		// g.drawImage(image[intTileNum], intOreX, intOreY, null);
		g.drawImage(menu, 0, 0, null);
		g.setColor(Color.white);
		g.fillRect(500, 500, 25, 25);
	}
	
	public void paintChildren (Graphics g)
	{
		
	}

	// Constructor
	public AnimationPanel()
	{
		super();
		
		setBackground(Color.black);
		
		try
		{
			for (intCount = 0; intCount < 19; intCount++)
			{
				image[intCount] = ImageIO.read(new File("OreTile.png"));
				menu = ImageIO.read(new File("catanmenu.jpg"));
			}
		}
		catch (IOException e)
		{	
		}
	}
}

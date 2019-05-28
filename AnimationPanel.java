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
	boolean printTile;
	int intCount;
	int intTileNum = 0;
	
	// Methods
	// Override how this component paints itself
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		g.drawImage(image[intTileNum], intOreX, intOreY, null);
		g.setColor(Color.white);
		g.fillRect(500, 500, 25, 25);
		
		System.out.println("sigh");
		
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
			}
		}
		catch (IOException e)
		{	
		}
	}
}

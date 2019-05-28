import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.JPanel;

public class AnimationPanel extends JPanel
{
	// Properties
	int intOreX;
	int intOreY;
	BufferedImage image = null;
	boolean printTile;

	// Methods
	// Override how this component paints itself
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		
		if (printTile == true)
		{
			g.drawImage(image, intOreX, intOreY, null);
			System.out.println("print");
		}
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
			image = ImageIO.read(new File("OreTile.png"));
		}
		catch (IOException e)
		{	
		}
	}
}
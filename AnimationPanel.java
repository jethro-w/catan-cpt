import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class AnimationPanel extends JPanel
{
	// Properties
	int intOreX;
	int intOreY;
	boolean printOre = false;
	BufferedImage image = null;

	// Methods
	// Override how this component paints itself
	public void paintComponent(Graphics g)
	{
		// g.setColor(Color.black);
		// g.fillRect(0, 0, 1280, 720);
		
		if (printOre == true)
		{
			g.drawImage(image, intOreX, intOreY, null);
			printOre = false;
			System.out.println("print");
		}
	}

	// Constructor
	public AnimationPanel()
	{
		super();
		
		try
		{
			image = ImageIO.read(new File("OreTile.png"));
		}
		catch (IOException e)
		{
			
		}
	}
}

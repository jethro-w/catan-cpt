
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class AnimationPanel extends JPanel
{
	// Properties

	// Methods
	// Override how this component paints itself
	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,1280,720);
	
	}

	// Constructor
	public AnimationPanel()
	{
		super();
	}
}

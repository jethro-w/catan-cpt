import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;


public class ReplacementPanel extends JPanel
{

	BufferedImage background = null;
	File file = null;
	Font f = null;
	public void paintComponent(Graphics g)
	{
		g.drawImage(background,0,0,null);
		
		g.setFont(f);
		
		g.setD
		g.drawString("Play",1000,300);
		
		g.drawString("Settings",1000,400");
		
		g.drawString("Help",1000,500");
		
		


	}
	public ReplacementPanel()
	{
		
		
		super();
		try
		{
			background = ImageIO.read(new File("catanmenu.jpg"));
			f = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("ipixelu.ttf"))).deriveFont(Font.PLAIN,48);
		}catch(IOException e)
		{
		}catch(FontFormatException e)
		{
		}
	
	
	
	}


}

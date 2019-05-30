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
	boolean blnPlay = false;
	boolean blnSettings = false;
	boolean blnHelp = false;
	boolean blnQuit = false;
	public void paintComponent(Graphics g)
	{
		g.drawImage(background,0,0,null);
		
		g.setFont(f);
		
		if (blnPlay){
			g.setColor(Color.RED);
			g.drawString("Play",900,350);
			g.setColor(Color.BLACK);
			g.drawString("Settings",900,430);
			g.drawString("Help",900,510);
			g.drawString("Quit",900,590);
		}else if (blnSettings)
		{
			g.setColor(Color.BLACK);
			g.drawString("Play",900,350);
		
			g.setColor(Color.RED);
			g.drawString("Settings",900,430);
			g.setColor(Color.BLACK);
			g.drawString("Help",900,510);
			g.drawString("Quit",900,590);

		g.drawString("Play",1000,300);
		
		g.drawString("Settings",1000,400);
		
		g.drawString("Help",1000,500);
	
		}else if (blnHelp)
		{	
			g.setColor(Color.BLACK);
			g.drawString("Play",900,350);
			g.drawString("Settings",900,430);
			g.setColor(Color.RED);
			g.drawString("Help",900,510);
			g.setColor(Color.BLACK);			
			g.drawString("Quit",900,590);
			
		}else if (blnQuit)
		{
			g.setColor(Color.BLACK);
			g.drawString("Play",900,350);
			g.drawString("Settings",900,430);
			g.drawString("Help",900,510);
			g.setColor(Color.RED);
			g.drawString("Quit",900,590);
			
		}else{
			g.setColor(Color.BLACK);
			g.drawRect(900,475,100,50);
			g.drawString("Play",900,350);
			g.drawString("Settings",900,430);
			g.drawString("Help",900,510);
			g.drawString("Quit",900,590);
		
		}


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

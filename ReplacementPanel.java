import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;


public class ReplacementPanel extends JPanel
{

	BufferedImage background = null;
	File file = null;
	Font f48 = null;
	Font f24 = null;
	int intRedText = 0;
	boolean blnMainMenu = true;
	boolean blnPlay = false;
	boolean blnSettings = false;
	boolean blnHelp = false;
	boolean blnQuit = false;
	boolean blnClickable = true;
	public void paintComponent(Graphics g)
	{
		g.drawImage(background,0,0,null);
		
		g.setFont(f48);
		
		if (blnMainMenu){
			if (intRedText == 1){
				g.setColor(Color.RED);
				g.drawString("Play",900,350);
				g.setColor(Color.BLACK);
				g.drawString("Settings",900,430);
				g.drawString("Help",900,510);
				g.drawString("Quit",900,590);
			}else if (intRedText == 2)
			{
				g.setColor(Color.BLACK);
				g.drawString("Play",900,350);
			
				g.setColor(Color.RED);
				g.drawString("Settings",900,430);
				g.setColor(Color.BLACK);
				g.drawString("Help",900,510);
				g.drawString("Quit",900,590);

			}else if (intRedText == 3)
			{	
				g.setColor(Color.BLACK);
				g.drawString("Play",900,350);
				g.drawString("Settings",900,430);
				g.setColor(Color.RED);
				g.drawString("Help",900,510);
				g.setColor(Color.BLACK);			
				g.drawString("Quit",900,590);
				
			}else if (intRedText == 4)
			{
				g.setColor(Color.BLACK);
				g.drawString("Play",900,350);
				g.drawString("Settings",900,430);
				g.drawString("Help",900,510);
				g.setColor(Color.RED);
				g.drawString("Quit",900,590);
				
			}else{
				g.setColor(Color.BLACK);
				g.drawString("Play",900,350);
				g.drawString("Settings",900,430);
				g.drawString("Help",900,510);
				g.drawString("Quit",900,590);
			
			}
		}else if (blnHelp)
		{
			
		}else if (blnSettings)
		{
			g.drawString("Port Number:",525,345);
			g.setFont(f24);
			g.drawString("Port must be 4 digits.",540,500);
		}

	}
	public ReplacementPanel()
	{
		super();
		
		try
		{
			background = ImageIO.read(new File("catanmenu.jpg"));
			f48 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("ipixelu.ttf"))).deriveFont(Font.PLAIN,48);
			f24 = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("ipixelu.ttf"))).deriveFont(Font.PLAIN,24);
		}catch(IOException e)
		{
		}catch(FontFormatException e)
		{
		}
	
	}


}

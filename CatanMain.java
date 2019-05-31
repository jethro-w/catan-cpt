import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

// Main Program
public class CatanMain implements ActionListener, MouseMotionListener, KeyListener, MouseListener
{
	// Properties
	JFrame theframe;
	ReplacementPanel thepanel;
	Timer thetimer;
	//JLabel playLabel;
	
	JTextField textIP;
	JTextField textPort;
	
	//for noobchat
	JTextField thefield;
	JTextArea thearea;
	JButton thebutton;

	//usernames
	String strPlayer1;
	String strPlayer2;
	String strPlayer3;
	String strPlayer4;
	
	String strText;
	String strIP;
	String strPort = "3000";
	int intPort = 3000;
	 
	boolean isClient = false;
	JButton buttonIP;
	JButton buttonPort;
	JButton buttonClient;
	JButton buttonServer;
	
	logic logic; //from logic class
	
	JScrollPane thescroll;
	JMenuBar thebar;
	
	SuperSocketMaster ssm;
	
	int intMouseX;
	int intMouseY;
	//~ JTextField textIP;
	JLabel LabelUser;
	JLabel labelIP;
	// Methods
	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource() == thetimer)
		{
			thepanel.repaint();
		}
		/*
		if (evt.getSource() == playLabel)
		{
			playLabel.setVisible(false);
			buttonHelp.setVisible(false);
			buttonSettings.setVisible(false);
			buttonQuit.setVisible(false);
			buttonUser.setVisible(true);
			textUser.setVisible(true);
		}
		
		 if (evt.getSource() == buttonQuit)
		{
			System.exit(0);
		}

		* */
		
		if (evt.getSource() == buttonIP)
		{
			//System.out.println("ENTER USERNAME");
			//strPlayer1 = textIP.getText();

			strIP = textIP.getText();
			buttonIP.setVisible(false);
			textIP.setVisible(false);
			labelIP.setVisible(false);
			
			if (isClient){//check if user is a host or a client
				
				ssm = new SuperSocketMaster(strIP, intPort, this);
				ssm.connect();
				
			}
			thepanel.blnMainMenu = true;
		
		}else if (evt.getSource() == buttonPort)
		{
			try{
				System.out.println("Grabbing and saving port.");
				textPort.getText();
				strPort = textPort.getText();
				intPort = Integer.parseInt(strPort);
				
				if (strPort.length() == 4)
				{
					System.out.println("Saved Port");					
					thepanel.blnMainMenu = true;
					thepanel.blnSettings = false;
					buttonPort.setVisible(false);
					textPort.setVisible(false);
				}else{
					System.out.println("Port must have 4 digits");
				}
				
			}catch(NumberFormatException e){
				System.out.println("Port invalid.");
			}
			
		}else if(evt.getSource() == buttonServer)
		{
			buttonServer.setVisible(false);
			buttonClient.setVisible(false);
			
			ssm = new SuperSocketMaster(3000, this);
			System.out.println(ssm.getMyAddress());
			strIP = ssm.getMyAddress();
			ssm.connect();
			//from here i guess the game would start since the server is up.
			
		}else if (evt.getSource() == buttonClient)
		{	
			isClient = true;
			buttonServer.setVisible(false);
			buttonClient.setVisible(false);
			labelIP.setVisible(true);
			buttonIP.setVisible(true);
			textIP.setVisible(true);
		}
	}

	public void mouseMoved (MouseEvent evt)
	{

		if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 300 && evt.getY() <= 350)
		{
			thepanel.intRedText = 1;
			
		}else if (evt.getX() >= 900 && evt.getX() <= 1075 && evt.getY() >= 400 && evt.getY() <= 450)
		{
			thepanel.intRedText = 2;
			
		}else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 475 && evt.getY() <= 525)
		{
			thepanel.intRedText = 3;
			
		}else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 550 && evt.getY() <= 600)
		{
			thepanel.intRedText = 4;
			
			
		}else
		{
			thepanel.intRedText = 0;
		}

		intMouseX = evt.getX();
		intMouseY = evt.getY();
	}

	public void mouseDragged (MouseEvent evt)
	{

	}
	public void mouseClicked(MouseEvent evt){
		System.out.println("Clicked");
		if(evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 300 && evt.getY() <=350)
		{
			System.out.println("Play Option");
			thepanel.blnMainMenu = false;
			//opens server or client option. port will be in settings
			buttonServer.setVisible(true);
			buttonClient.setVisible(true);
			
			
		}else if (evt.getX() >= 900 && evt.getX() <= 1075 && evt.getY() >= 400 && evt.getY() <= 450)
		{
			//place settings
			System.out.println("Settings Option");
			textPort.setVisible(true);
			buttonPort.setVisible(true);
			thepanel.blnMainMenu = false;
			thepanel.blnSettings = true;
			
		}else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 475 && evt.getY() <= 525)
		{
			//place help menu screens here.
			System.out.println("Help Option");
			
		}else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 550 && evt.getY() <= 600)
		{
			System.out.println("Exit Option");
			System.exit(0);
		}
		
	
	}
	public void mousePressed (MouseEvent evt)
	{
	}
	public void mouseReleased (MouseEvent evt)
	{
	}
	public void mouseEntered (MouseEvent evt)
	{
	}
	public void mouseExited (MouseEvent evt)
	{
	}
	public void keyReleased (KeyEvent evt)
	{
	}
	public void keyPressed (KeyEvent evt)
	{
	}
	public void keyTyped (KeyEvent evt)
	{
	}
	// Constructor
	public CatanMain()
	{
		thepanel = new ReplacementPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280, 720));
		thepanel.addMouseMotionListener(this);
		
		buttonIP = new JButton("Enter");
		buttonIP.setFont(thepanel.f24);
		buttonIP.setSize(200, 100);
		buttonIP.setLocation(1000, 600);
		buttonIP.addActionListener(this);
		thepanel.add(buttonIP);
		buttonIP.setVisible(false);
		
		
		buttonPort = new JButton("Enter");
		buttonPort.setFont(thepanel.f24);
		
		//this is for making the jbutton invisible but functioning
		//buttonPort.setContentAreaFilled(false);
		//buttonPort.setBorderPainted(false);
		
		buttonPort.setSize(200,100);
		buttonPort.setLocation(1000,600);
		buttonPort.addActionListener(this);
		buttonPort.setVisible(false);
		thepanel.add(buttonPort);

		textIP = new JTextField("");
		textIP.setSize(250, 40);
		textIP.setLocation(540, 400);
		textIP.setVisible(false);
		thepanel.add(textIP);
		
		textPort = new JTextField("");
		textPort.setSize(250,40);
		textPort.setLocation(540,360);
		textPort.setVisible(false);
		thepanel.add(textPort);

		buttonServer = new JButton("Server");
		buttonServer.setSize(200, 100);
		buttonServer.setLocation(300, 250);
		buttonServer.addActionListener(this);
		buttonServer.setVisible(false);
		thepanel.add(buttonServer);
		
		buttonClient = new JButton("Client");
		buttonClient.setSize(200, 100);
		buttonClient.setLocation(800, 250);
		buttonClient.addActionListener(this);
		buttonClient.setVisible(false);
		thepanel.add(buttonClient);

		
		//~ LabelUser = new JLabel("Enter you Username: ");
		//~ LabelUser.setSize(200, 120);
		//~ LabelUser.setLocation(600,500);
		//~ thepanel.add(LabelUser);
		
		labelIP = new JLabel("Enter the Server's IP:");
		labelIP.setFont(thepanel.f24);
		labelIP.setSize(300, 120);
		labelIP.setLocation(540,310);
		labelIP.setVisible(false);
		thepanel.add(labelIP);
		//~ textIP = new JTextField("");
		//~ textIP.setSize(400,50);
		//~ textIP.setLocation(0,310);

		theframe = new JFrame("Settlers of Catan");
		theframe.addKeyListener(this);
		thepanel.addMouseListener(this);
		thepanel.addMouseMotionListener(this);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setVisible(true);
		thetimer = new Timer(1000 / 60, this);
		thetimer.start();
		theframe.setResizable(false);
		

	/*	
	 * 
	 * this is all part of noob chat. not needed yet
		thearea = new JTextArea();

		
		thescroll = new JScrollPane(thearea);
		thescroll.setBounds(0,50,400,250);
		
		thefield = new JTextField("");
		thefield.setSize(400,50);
		thefield.setLocation(0,310);
		
		thebutton = new JButton("Send");
		thebutton.setSize(400, 50);
		thebutton.setLocation(0, 370);
		thebutton.addActionListener(this);
			
		thepanel.add(thescroll);
		thepanel.add(thefield);
		thepanel.add(thebutton);
	*/
	
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setResizable(false);	
		
		/*
		ssm = new SuperSocketMaster(3000, this);
		

		ssm = new SuperSocketMaster(657, this);
		ssm.connect();
		System.out.println(ssm.getMyAddress());
	
		*/

	}
	
	// Main method
	public static void main (String[] args)
	{
		new CatanMain();
		//experimenting with painting main menu options
		//no jlabel use, just editing color in JPanel
	}
}

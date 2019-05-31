import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

// Main Program
public class CatanMain2 implements ActionListener, MouseMotionListener, KeyListener, MouseListener{
	// Properties
	JFrame theframe;
	ReplacementPanel thepanel;
	Timer thetimer;
	//JLabel playLabel;
	JTextField textIP;
	JTextField textPort;
	
	
	//For Menu
	int intMenu = 0;
	// 0 = home
	// 2 = server | host
	// for noobchat
	JTextField thefield;
	JTextArea thearea;
	JButton thebutton;

	// usernames
	String strUsername;
	String strPlayer1;
	String strPlayer2;
	String strPlayer3;
	String strPlayer4;
	
	JButton buttonUser;
	JTextField textUser;
	
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
	JLabel LabelIP;
	// Methods
	public void actionPerformed (ActionEvent evt)
	{
		if(intMenu == 1){
			thepanel.blnPlay = true;
			//~ System.out.println("Main Menu");
		}else if(intMenu == 2){
			
			buttonServer.setVisible(true);
			buttonClient.setVisible(true);
			thepanel.blnMainMenu = false;
		}else if(intMenu == 3){
			
		textPort.setVisible(true);
		thepanel.blnMainMenu = false;
		}else if(intMenu == 99){
			thepanel.blnMainMenu = false;
			buttonUser.setVisible(true);
			textUser.setVisible(true);
			if (evt.getSource() == buttonUser){
				strUsername = textUser.getText();
				System.out.println("Username: " + strUsername);
				
				}
			
		}
		
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
			System.out.println("ENTER USERNAME");
			strPlayer1 = textIP.getText();

			strIP = textIP.getText();
			buttonIP.setVisible(false);
			textIP.setVisible(false);
			
			if (isClient){//check if user is a host or a client
				
				ssm = new SuperSocketMaster(strIP, intPort, this);
				ssm.connect();
				
			}
			thepanel.blnMainMenu = true;
		
		}else if (evt.getSource() == buttonPort)
		{
		
			try{
				textPort.getText();
				strPort = textPort.getText();
				intPort = Integer.parseInt(strPort);
				
			}catch(NumberFormatException e){
				System.out.println("Invalid port");
			}
		
		}else if(evt.getSource() == buttonServer)
		{
			buttonServer.setVisible(false);
			buttonClient.setVisible(false);
			
			ssm = new SuperSocketMaster(3000, this);
			System.out.println(ssm.getMyAddress());
			strIP = ssm.getMyAddress();
			ssm.connect();
			
			buttonIP.setVisible(true);
			textIP.setVisible(true);
			
		}else if (evt.getSource() == buttonClient)
		{	
			isClient = true;
			buttonServer.setVisible(false);
			buttonClient.setVisible(false);
			LabelIP.setVisible(true);
			buttonIP.setVisible(true);
			textIP.setVisible(true);
		}
	}

	public void mouseMoved (MouseEvent evt)
	{
		if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 300 && evt.getY() <= 350)
		{
			thepanel.blnPlay = true;
		}else if (evt.getX() >= 900 && evt.getX() <= 1075 && evt.getY() >= 400 && evt.getY() <= 450)
		{
			thepanel.blnSettings = true;
		}else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 475 && evt.getY() <= 525)
		{
			thepanel.blnHelp = true;
		}else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 550 && evt.getY() <= 600)
		{
			thepanel.blnQuit = true;
		}else
		{
			thepanel.blnPlay = false;
			thepanel.blnSettings = false;
			thepanel.blnHelp = false;
			thepanel.blnQuit = false;
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
			System.out.println("Play");
			//opens server or client option. port will be in settings
			intMenu = 99;
			//~ buttonServer.setVisible(true);
			//~ buttonClient.setVisible(true);
			//~ thepanel.blnMainMenu = false;

		}else if (evt.getX() >= 900 && evt.getX() <= 1075 && evt.getY() >= 400 && evt.getY() <= 450)
		{
			//place settings
			//~ textPort.setVisible(true);
			intMenu = 3;
			
			
		}else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 475 && evt.getY() <= 525)
		{
			//place help menu screens here.
			
		}else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 550 && evt.getY() <= 600)
		{
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
	public CatanMain2()
	{
		thepanel = new ReplacementPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280, 720));
		thepanel.addMouseMotionListener(this);
		
		buttonIP = new JButton("Enter");
		buttonIP.setSize(200, 100);
		buttonIP.setLocation(1000, 600);
		buttonIP.addActionListener(this);
		thepanel.add(buttonIP);
		buttonIP.setVisible(false);
		
		buttonUser = new JButton("User");
		buttonUser.setSize(200, 100);
		buttonUser.setLocation(1000, 600);
		buttonUser.addActionListener(this);
		thepanel.add(buttonUser);
		buttonUser.setVisible(false);
		
		textUser = new JTextField("");
		textUser.setSize(250, 40);
		textUser.setLocation(540, 310);
		textUser.setVisible(false);
		thepanel.add(textUser);
		
		buttonPort = new JButton("Enter");
		buttonPort.setSize(200,100);
		buttonPort.setLocation(1000,600);
		buttonPort.addActionListener(this);
		buttonPort.setVisible(false);
		thepanel.add(buttonPort);

		textIP = new JTextField("");
		textIP.setSize(250, 40);
		textIP.setLocation(540, 310);
		textIP.setVisible(false);
		thepanel.add(textIP);
		
		textPort = new JTextField("");
		textPort.setSize(250,40);
		textPort.setLocation(540,310);
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
		
		LabelIP = new JLabel("Enter the Server's IP: ");
		LabelIP.setSize(200, 120);
		LabelIP.setLocation(600,500);
		LabelIP.setVisible(false);
		thepanel.add(LabelIP);
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
		new CatanMain2();
		//experimenting with painting main menu options
		//no jlabel use, just editing color in JPanel
	}
}

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
	JButton buttonIP;
	JTextField textIP;
	String strPlayer1;
	String strPlayer2;
	String strPlayer3;
	String strPlayer4;
	JButton buttonClient;
	JButton buttonServer;
	JButton buttonHelp;
	JButton buttonSettings;
	JButton buttonQuit;
	logic logic;
	JTextArea thearea;
	JScrollPane thescroll;
	JMenuBar thebar;
	JTextField thefield;
	JButton thebutton;
	SuperSocketMaster ssm;
	String strText;
	String strIP;
	int intMouseX;
	int intMouseY;
	//~ JTextField textIP;
	JLabel LabelUser;
	JLabel LabelIP;
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
			strPlayer1 = textIP.getText();
			buttonIP.setVisible(false);
			textIP.setVisible(false);
			System.out.println("USERNAME");
			ssm = new SuperSocketMaster(strIP, 3000, this);
			ssm.connect();
		}
		if(evt.getSource() == thebutton)
		{
		}else if(evt.getSource() == buttonServer){
			buttonServer.setVisible(false);
			buttonClient.setVisible(false);
			ssm = new SuperSocketMaster(3000, this);
			System.out.println(ssm.getMyAddress());
			strIP = ssm.getMyAddress();
			ssm.connect();
			buttonIP.setVisible(true);
			textIP.setVisible(true);
			
		}else if (evt.getSource() == buttonClient){	
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
		}else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 600 && evt.getY() <= 650)
		{//incomplete
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
		if(evt.getX() >= 1000 && evt.getX() <= 1200 && evt.getY() >= 250 && evt.getY() <=350){
			System.out.println("Play");
			buttonHelp.setVisible(false);
			buttonSettings.setVisible(false);
			buttonQuit.setVisible(false);
			
			buttonServer.setVisible(true);
			buttonClient.setVisible(true);
			//~ buttonUser.setVisible(true);
			//~ textUser.setVisible(true);
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
		buttonIP.setSize(200, 100);
		buttonIP.setLocation(1000, 600);
		buttonIP.addActionListener(this);
		thepanel.add(buttonIP);
		buttonIP.setVisible(false);

		textIP = new JTextField("");
		textIP.setSize(250, 40);
		textIP.setLocation(540, 310);
		thepanel.add(textIP);
		textIP.setVisible(false);

		buttonClient = new JButton("Client");
		buttonClient.setSize(200, 100);
		buttonClient.setLocation(1000, 250);
		buttonClient.addActionListener(this);
		thepanel.add(buttonClient);
		buttonClient.setVisible(false);
		
		buttonServer = new JButton("Server");
		buttonServer.setSize(200, 100);
		buttonServer.setLocation(500, 250);
		buttonServer.addActionListener(this);
		thepanel.add(buttonServer);
		buttonServer.setVisible(false);

		buttonSettings = new JButton("Settings");
		buttonSettings.setSize(200, 100);
		buttonSettings.setLocation(1000, 450);
		buttonSettings.addActionListener(this);
		thepanel.add(buttonSettings);

		buttonQuit = new JButton("Quit");
		buttonQuit.setSize(200, 100);
		buttonQuit.setLocation(1000, 600);
		buttonQuit.addActionListener(this);
		thepanel.add(buttonQuit);
		
		//~ LabelUser = new JLabel("Enter you Username: ");
		//~ LabelUser.setSize(200, 120);
		//~ LabelUser.setLocation(600,500);
		//~ thepanel.add(LabelUser);
		
		LabelIP = new JLabel("Enter the Server's IP: ");
		LabelIP.setSize(200, 120);
		LabelIP.setLocation(600,500);
		thepanel.add(LabelIP);
		LabelIP.setVisible(false);
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
		thearea = new JTextArea();
		
		//~ thearea = new JTextArea();

		
		//~ thescroll = new JScrollPane(thearea);
		//~ thescroll.setBounds(0,50,400,250);
		
		//~ thefield = new JTextField("");
		//~ thefield.setSize(400,50);
		//~ thefield.setLocation(0,310);
		
		//~ thebutton = new JButton("Send");
		//~ thebutton.setSize(400, 50);
		//~ thebutton.setLocation(0, 370);
		//~ thebutton.addActionListener(this);
			
		thepanel.add(thescroll);
		thepanel.add(thefield);
		thepanel.add(thebutton);
	*/
	
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setResizable(false);

		//~ thepanel.add(thescroll);
		//~ thepanel.add(thefield);
		//~ thepanel.add(thebutton);
		
		
		/*
		//ssm = new SuperSocketMaster(3000, this);
		

		ssm = new SuperSocketMaster(657, this);
		ssm.connect();
		System.out.println(ssm.getMyAddress());
		*/

		//~ ssm = new SuperSocketMaster(657, this);
		//~ ssm.connect();
		//~ System.out.println(ssm.getMyAddress());
	}
	
	// Main method
	public static void main (String[] args)
	{
		new CatanMain();
		//experimenting with painting main menu options
		//no jlabel use, just editing color in JPanel
	}
}

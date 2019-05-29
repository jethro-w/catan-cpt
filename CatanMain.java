import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;

// Main Program
public class CatanMain implements ActionListener, MouseMotionListener, KeyListener
{
	// Properties
	JFrame theframe;
	ReplacementPanel thepanel;
	Timer thetimer;
	//JLabel playLabel;
	JButton buttonUser;
	JTextField textUser;
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
	//~ SuperSocketMaster ssm;
	String strText;
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
		* */
		else if (evt.getSource() == buttonQuit)
		{
			System.exit(0);
		}
		if (evt.getSource() == buttonUser)
		{
			strPlayer1 = textUser.getText();
			buttonUser.setVisible(false);
			textUser.setVisible(false);
			System.out.println("userdd");
		}
		if(evt.getSource() == thebutton)
		{
		}

	}

	public void mouseMoved (MouseEvent evt)
	{
		// ~ thepanel.intRectX = evt.getX();
		// ~ thepanel.intRectY = evt.getY();
	}

	public void mouseDragged (MouseEvent evt)
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
		

		buttonUser = new JButton("Enter");
		buttonUser.setSize(200, 100);
		buttonUser.setLocation(1000, 600);
		buttonUser.addActionListener(this);
		thepanel.add(buttonUser);
		buttonUser.setVisible(false);

		textUser = new JTextField("");
		textUser.setSize(100, 50);
		textUser.setLocation(540, 310);
		thepanel.add(textUser);
		textUser.setVisible(false);

		buttonClient = new JButton("Client");
		buttonClient.setSize(200, 100);
		buttonClient.setLocation(1000, 250);
		buttonClient.addActionListener(this);
		thepanel.add(buttonClient);
		buttonClient.setVisible(false);
		
		buttonServer = new JButton("Server");
		buttonServer.setSize(200, 100);
		buttonServer.setLocation(1000, 250);
		buttonServer.addActionListener(this);
		thepanel.add(buttonServer);
		buttonServer.setVisible(false);

		buttonHelp = new JButton("Help");
		buttonHelp.setSize(200, 100);
		buttonHelp.setLocation(1000, 350);
		buttonHelp.addActionListener(this);
		thepanel.add(buttonHelp);

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

		theframe = new JFrame("Settlers of Catan");
		theframe.addKeyListener(this);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setVisible(true);
		thetimer = new Timer(1000 / 60, this);
		thetimer.start();
		theframe.setResizable(false);
		
		
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
		
		//~ thepanel.add(thescroll);
		//~ thepanel.add(thefield);
		//~ thepanel.add(thebutton);
		
		
		//ssm = new SuperSocketMaster(3000, this);
		
		//~ ssm = new SuperSocketMaster(657, this);
		//~ ssm.connect();
		//~ System.out.println(ssm.getMyAddress());
	}
	
	// Main method
	public static void main (String[] args)
	{
		new CatanMain();
	}
}

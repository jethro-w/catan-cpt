import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <h1>Settlers of Catan<h1>
 * This game is Settlers of Catan by Justin, Jethro, and Jason
 * written for the ICS4U1 course. Users play online in a strategy game
 * against friends
 * @authors Justin, Jethro, and Jason
 * @version 0.1
 * @since 2019-06-01
 */

// Happy birthday Sir!
    //~ &&%##############################################################(((//////////////((((((((#####
    //~ #%%%%%&((((((###################################################(((///////////(((((((((((####
    //~ #&%%%%&,,,*&(((((##################################################((((((((((((((((((((((((####
    //~ &%%%%%&,,,,,,,%#(#####################################################(((((((((((((((((((((####
    //~ ((((%%&,,,,,,,,,,,###############################################%%%###################&&,,%%
    //~ (((((&%,,,,,,,,,,,,,,############################################%%%%%%%%%%%%%%%%%&,,,,,,,,%%
    //~ ((((((&&,,,,,,,,,,,,,,,,%###########################################%%%%%%%%%%%&,,,,,,,,,,,,,%%
    //~ (((((((&,,,,,,,,,,,,,,,,,,,#######################################%%%%%%&%,,,,,,,,,,,,,,,,&%%
    //~ (((((((#&,,,,,,,,,,,,,,,,,,,,,%#####################################%%&,,,,,,,,,,,,,,,,,,,,,%%%
    //~ (((((#####,,,,,,,,,,,,,,,,,,,,,,################################&,,,,,,,,,,,,,,,,,,,,,,,,&&%%
    //~ (((((####%%#,,,,,,,,,,,,,,,,,,,,,,#######%&&&&&%(*,,,,,,*%&&&,,,,,,,,,,,,,,,,,,,,,,,,,,,&&%%%
    //~ ((((#####%%%&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&%%%%%
    //~ (((#####%%%%%%,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,###%%
    //~ #######%%%%%%%%&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,#########
    //~ ##%%%%%%%%%%%%%%%&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*((((((####
    //~ %%%%%%%%%%%%%%%%%%%&,,&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&((((((((####
    //~ %%%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,/,,,/%((((((((((####
    //~ %%%%%%%%%%%%%%%%%%%%,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,###((((((((#####
    //~ %%%%%%%%%%%%%%%%%%%*,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,%################
    //~ &&&&%%%%%%%%%%%%%%&,,,,,,,,,,&,,%%&,,,,,,,,,,,,,,,,,,,,,,,,,,,,%%,,,,,,,,,,,,,,#############%
    //~ &&&&%%%%%%%%%%%##&,,,,,,,,,,&(  #%%#,,,,,,,,,,,,,,,,,,,,,,,%, ,%%&,,,,,,,,,,,,,,###########%%
    //~ &&&&&%%%%%%%%%###,,,,,,,,,,,(%%%%%%,,,,,,,,,,,,,,,,,,,,,,,,&%%%%%&,,,,,,,,,,,,,,,##########%%%%
    //~ &&&&&%%%%%%%%###&,,,,,,,,,,,,,&%%&,,,,,,,,,,,,,,,,,,,,,,,,,,&%%%&,,,,,,,,,,,,,,,,&%%%%%%%%%%%%%
    //~ &&&&&&%%%%%%%###,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,%%%%%%%%%%%%%
    //~ &&&&&%%%%%%%###&,,,,,,,,,,,,,,,,,,,,,,,,,,%%%%&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&%%%%%%%%%%%%
    //~ &&&%%%%%%%%####,,,(((((((,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*(((((((,,,,,,,,%%%%%%%%%%%%
    //~ %%%%%%%%%#####&,(((((((((((,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(((((((((((,,,,,,#########%%%
    //~ %%%%%#########&,(((((((((((,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,((((((((((((,,,,,,,%#########%
    //~ ###############,,(((((((((,,,,,,,,,,,,,,,%(********%,,,,,,,,,,,,,,(((((((((((,,,,,,,%##########
    //~ #####(((((((((&,,,,,*/,,,,,,,,,,,,,,,,,,(***********%,,,,,,,,,,,,,,,(((((((,,,,,,,,,,%(((######
    //~ (((((((((((((((,,,,,,,,,,,,,,,,,,,,,,,,,,%**********%,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&(((((####
    //~ (((((((((((((((&,,,,,,,,,,,,,,,,,,,,,,,,,,%*********%,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,(((((####
    //~ ((((((((((((((((&,,,,,,,,,,,,,,,,,,,,,,,,,,,,%%%%%%,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,&((((####
    //~ (((((((((((((((((&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,((((####
    //~ ((((((((((((((((##&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,#((#####
    //~ ((((((((((((((#####&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,######
    //~ ####################,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,#######%
    //~ ###################&,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,#####%%





/* TO DO LIST:
 * 1. When Server.java sees everyone is ready (2 people) then it will send ssm message
 * to Client.java.
 * 2. Then they synchronize and print a blank screen.
 * 3. Merge ServerGameCode and CatanMain.
 * 4. Get CatanMain to copy its arrays to Server (starting with strTiles)
 * 5. Get Server to send the arrays through ssm
 * 6. Get Client to read and split into its own CatanMain
*/

// Main Program
public class CatanMain implements ActionListener, MouseMotionListener, KeyListener, MouseListener
{
	// Properties
	public JFrame theframe;
	public AnimationPanel thepanel;
	public Timer thetimer;
	public JTextField textIP;
	public JTextField textPort;
	public JTextField textUser;
	public JTextField textField;
	public JTextField thefield;
	public JTextArea thearea;
	public JButton thebutton;
	public String strText;
	public static String strIP;
	public String strPort = "3000";
	public static int intPort = 3000;
	public String strSSM[];
	public boolean isClient = false;
	public boolean blnClickable = true;
	public JButton buttonUser;
	public JButton buttonIP;
	public JButton buttonPort;
	public JButton buttonClient;
	public JButton buttonReady;
	public JButton buttonServer;
	public JButton buttonNext; // help menu next button
	public JButton buttonBack;
	public JScrollPane thescroll;
	public JMenuBar thebar;
	public SuperSocketMaster ssm;
	// int intReady = 0;
	// int intPlayers = 0;
	public int intRNG;
	public JLabel labelUser;
	public JLabel labelIP;
	public JLabel labelServerIP;
	public boolean isReady = false;
	public JFrame frame = new JFrame();
	public int[] intTileNums = new int[18];
	public int intStartTile;
	public int intMouseX;
	public int intMouseY;
	//~ public int intHelp;
	public boolean drawSettlement = true;
	public boolean drawRoad = false;
	public int intDrawX;
	public int intDrawY = 90;
	public int intDeltaY = 56;
	public int intDeltaX = 100;
	public int intPlayer = 0; // Red = 0, Blue = 1, White = 2, Orange = 3

	private int intCount;
	private String strPlayerColour = "r";
	// private JTextArea settlements = new JTextArea();
	// private JTextArea roads = new JTextArea();
	private JButton changeDraw = new JButton("/");
	private JButton redPlayer = new JButton("r");
	private JButton bluePlayer = new JButton("b");
	private JButton whitePlayer = new JButton("w");
	private JButton orangePlayer = new JButton("o");
	
	public static Server server = null;
	public static Client client = null;
	public static boolean createServer = false;
	public static boolean createClient = false;
	public static String strUsername;
	public static int intPhase;
	public static String[][] strTiles = new String[5][9];
	public static String[][] strSettlements = new String[12][11];
	public static String[][] strRoads = new String[11][11];

	
	// Methods
	public static void createPlayer ()
	{
		if (createServer == true)
		{
			server = new Server(strIP, intPort, strUsername);
			server.intPlayers = 1;
			System.out.println("server created");
		
		}
		else if (createClient == true)
		{
			client = new Client(strIP, intPort, strUsername);
			System.out.println("client created");
		}
	}
	
	public static String[][] loadMap () throws IOException
	{
		BufferedReader map = null;
		String[] strMapLine = new String[5];
		String[][] strMap = new String[5][9];
		int intCount;

		try
		{
			map = new BufferedReader(new FileReader("catan-tiles.csv"));
		}
		catch (IOException e)
		{

		}

		for (intCount = 0; intCount < 5; intCount++)
		{
			try
			{
				strMapLine[intCount] = map.readLine();
			}
			catch (IOException e)
			{
			}
			strMap[intCount] = strMapLine[intCount].split(",");
		}

		return strMap;
	}
	
	public static String[][] loadSettlements () throws IOException
	{
		BufferedReader map = null;
		String[] strMapLine = new String[12];
		String[][] strMap = new String[12][11];
		int intCount;

		try
		{
			map = new BufferedReader(new FileReader("catan-settlements-map.csv"));
		}
		catch (IOException e)
		{

		}

		for (intCount = 0; intCount < 12; intCount++)
		{
			try
			{
				strMapLine[intCount] = map.readLine();
			}
			catch (IOException e)
			{
			}
			strMap[intCount] = strMapLine[intCount].split(",");
		}

		return strMap;
	}
	
	public static String[][] loadRoads () throws IOException
	{
		BufferedReader map = null;
		String[] strMapLine = new String[11];
		String[][] strMap = new String[11][11];
		int intCount;

		try
		{
			map = new BufferedReader(new FileReader("catan-roads-map.csv"));
		}
		catch (IOException e)
		{

		}

		for (intCount = 0; intCount < 11; intCount++)
		{
			try
			{
				strMapLine[intCount] = map.readLine();
			}
			catch (IOException e)
			{
			}
			strMap[intCount] = strMapLine[intCount].split(",");
		}

		return strMap;
	}
	
	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource() == thetimer)
		{
			thepanel.repaint();
			
			/*
			int intRow;
			int intColumn;
			
			settlements.setText("");
			roads.setText("");
			
			// Display arrays in TextArea
			for (intRow = 0; intRow < 12; intRow ++)
			{
				for (intColumn = 0; intColumn < 11; intColumn ++)
				{
					settlements.append(strSettlements[intRow][intColumn] + " ");
				}
				settlements.append("\n");
			}
			
			for (intRow = 0; intRow < 11; intRow ++)
			{
				for (intColumn = 0; intColumn < 11; intColumn ++)
				{
					roads.append(strRoads[intRow][intColumn] + " ");
				}
				roads.append("\n");
			}
			*/
		}
		if (evt.getSource() == buttonIP)
		{
			
			strIP = textIP.getText();
			buttonIP.setVisible(false);
			textIP.setVisible(false);
			labelIP.setVisible(false);
						
			buttonReady.setVisible(true);
			
			createClient = true;
			
			CatanMain.createPlayer();
		}
		else if (evt.getSource() == buttonPort)
		{
			try
			{
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
					blnClickable = true;
					System.out.println("New port is now " + intPort);
					
				}
				else
				{
					System.out.println("Port must have 4 digits");
				}
				
			}
			catch (NumberFormatException e)
			{
				System.out.println("Port invalid.");
			}
			
		}
		else if (evt.getSource() == buttonServer)
		{
			SuperSocketMaster ssmserver = new SuperSocketMaster(3000,this);//for getting address
			strIP = ssmserver.getMyAddress();
			ssmserver.disconnect();
			
			createServer = true;
			CatanMain.createPlayer();
			buttonServer.setVisible(false);
			buttonClient.setVisible(false);
		
			// ssm.sendText("0, " + intPlayers + "");

			buttonReady.setVisible(true);
			labelServerIP.setText("Server IP: " + strIP);
			labelServerIP.setVisible(true);
			
			// from here i guess the game would start since the server is up.
		}
		else if (evt.getSource() == buttonClient)
		{
			isClient = true;
			buttonServer.setVisible(false);
			buttonClient.setVisible(false);
			labelIP.setVisible(true);
			buttonIP.setVisible(true);
			textIP.setVisible(true);
		}
		else if (evt.getSource() == buttonUser)
		{
			strUsername = textUser.getText();
			System.out.println("Username: " + strUsername);
			
			buttonUser.setVisible(false);
			textUser.setVisible(false);
			labelUser.setVisible(false);
			
			buttonClient.setVisible(true);
			buttonServer.setVisible(true);
			// for user name
		}
		else if (evt.getSource() == buttonReady)
		{
			if (isReady == false)
			{
				if (isClient == false)
				{
					server.intReady = server.intReady + 1;
				}
				else if (isClient == true)
				{
					client.sendReady(true);
				}
				
				isReady = true;
				buttonReady.setText("Ready");	
				buttonReady.setEnabled(false);
			}
		}
		else if (evt.getSource() == changeDraw)
		{
			if (drawSettlement == true)
			{
				drawSettlement = false;
				drawRoad = true;
				
				System.out.println("road mode");
			}
			else if (drawRoad == true)
			{
				drawSettlement = true;
				drawRoad = false;
				
				System.out.println("settlement mode");
			}
		}
		else if (evt.getSource() == redPlayer)
		{
			intPlayer = 0;
			strPlayerColour = "r";
		}
		else if (evt.getSource() == bluePlayer)
		{
			intPlayer = 1;
			strPlayerColour = "b";
		}
		else if (evt.getSource() == whitePlayer)
		{
			intPlayer = 2;
			strPlayerColour = "w";
		}
		else if (evt.getSource() == orangePlayer)
		{
			intPlayer = 3;
			strPlayerColour = "o";
		} 
		if (evt.getSource() == buttonNext){
			thepanel.intHelp ++;
			System.out.println(thepanel.intHelp);
			if (thepanel.intHelp > 4){
			thepanel.blnMainMenu = true;
			buttonNext.setVisible(false);
			buttonBack.setVisible(false);
			thepanel.blnHelp = false;
			thepanel.intHelp = 0;
			}	
		}
		if (evt.getSource() == buttonBack){
			thepanel.intHelp --;
			if (thepanel.intHelp < 0){
			thepanel.blnMainMenu = true;
			buttonNext.setVisible(false);
			buttonBack.setVisible(false);
			thepanel.blnHelp = false;
			thepanel.intHelp = 0;
				}
			}
	}
	
	public void mouseMoved (MouseEvent evt)
	{
		
		if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 300 && evt.getY() <= 350)
		{
			thepanel.intRedText = 1;
			
		}
		else if (evt.getX() >= 900 && evt.getX() <= 1075 && evt.getY() >= 400 && evt.getY() <= 450)
		{
			thepanel.intRedText = 2;
			
		}
		else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 475 && evt.getY() <= 525)
		{
			thepanel.intRedText = 3;
			
		}
		else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 550 && evt.getY() <= 600)
		{
			thepanel.intRedText = 4;
			
		}
		else
		{
			thepanel.intRedText = 0;
		}
		
		intMouseX = evt.getX();
		intMouseY = evt.getY();
	}
	
	public void mouseDragged (MouseEvent evt)
	{
		
	}
	
	public void mouseClicked (MouseEvent evt)
	{
		System.out.println("Clicked");
		if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 300 && evt.getY() <= 350 && blnClickable == true)
		{
			System.out.println("Play Option");
			thepanel.blnMainMenu = false;
			blnClickable = false; // so you cant click if the options arent visible
			labelUser.setVisible(true);
			buttonUser.setVisible(true);
			textUser.setVisible(true);
			
			// opens server or client option. port will be in settings
			
			// place these after username
			// buttonServer.setVisible(true);
			// buttonClient.setVisible(true);
			
		}
		else if (evt.getX() >= 900 && evt.getX() <= 1075 && evt.getY() >= 400 && evt.getY() <= 450
				&& blnClickable == true)
		{
			// place settings
			System.out.println("Settings Option");
			textPort.setVisible(true);
			buttonPort.setVisible(true);
			thepanel.blnMainMenu = false;
			thepanel.blnSettings = true;
			blnClickable = false;
			
		}
		else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 475 && evt.getY() <= 525)
		{
			// Place help menu screens here.
			System.out.println("Help Option");
			thepanel.blnMainMenu = false;
			buttonNext.setVisible(true);
			buttonBack.setVisible(true);
			thepanel.blnHelp = true;
			
			
		}
		else if (evt.getX() >= 900 && evt.getX() <= 1000 && evt.getY() >= 550 && evt.getY() <= 600)
		{
			System.out.println("Exit Option");
			System.exit(0);
		}
		
		int intXCell; // Column
		int intYCell; // Row
		int intRow;
		
		intMouseX = evt.getX();
		intMouseY = evt.getY();
		
		System.out.println(intMouseX + ", " + intMouseY);
		
		if (drawSettlement == true)
		{
			intDrawY = 90;
			for (intRow = 1; intRow <= 12; intRow++)
			{
				if (intRow == 1 || intRow == 12)
				{
					intDrawX = 240;
				}
				else if (intRow == 2 || intRow == 3 || intRow == 10 || intRow == 11)
				{
					intDrawX = 190;
				}
				else if (intRow == 4 || intRow == 5 || intRow == 8 || intRow == 9)
				{
					intDrawX = 140;
				}
				else if (intRow == 6 || intRow == 7)
				{
					intDrawX = 90;
				}

				for (intCount = 0; intDrawX <= 590; intDrawX = intDrawX + 100)
				{
					if (intMouseX >= intDrawX && intMouseX <= intDrawX + 20
							&& intMouseY >= intDrawY && intMouseY <= intDrawY + 20)
					{
						intXCell = (int) Math.round((intMouseX - 100) / 50.0);
						intYCell = (int) Math.round((intMouseY / 43.0) - 2.1);
						
						System.out.println("hi");
						
						if (strSettlements[intYCell][intXCell].equals("_"))
						{
							thepanel.strSettlements[intYCell][intXCell] = strPlayerColour;
							strSettlements[intYCell][intXCell] = strPlayerColour;

							System.out.println("settlements [" + intXCell + "][" + intYCell + "]");

							// ADD FEATURE TO DISABLE SURROUNDING SPOTS (dependent on row number)
							if (intRow == 1 || intRow == 3 || intRow == 5 || intRow == 7 || intRow == 9 || intRow == 11)
							{
								thepanel.strSettlements[intYCell + 1][intXCell + 1] = "x";
								thepanel.strSettlements[intYCell + 1][intXCell - 1] = "x";
								strSettlements[intYCell + 1][intXCell + 1] = "x";
								strSettlements[intYCell + 1][intXCell - 1] = "x";
								if (intRow != 1)
								{
									thepanel.strSettlements[intYCell - 1][intXCell] = "x";
									strSettlements[intYCell - 1][intXCell] = "x";
								}
							}
							else if (intRow == 2 || intRow == 4 || intRow == 6 || intRow == 8 || intRow == 10 || intRow == 12)
							{
								thepanel.strSettlements[intYCell - 1][intXCell + 1] = "x";
								thepanel.strSettlements[intYCell - 1][intXCell - 1] = "x";
								strSettlements[intYCell - 1][intXCell + 1] = "x";
								strSettlements[intYCell - 1][intXCell - 1] = "x";
								if (intRow != 12)
								{
									thepanel.strSettlements[intYCell + 1][intXCell] = "x";
									strSettlements[intYCell + 1][intXCell] = "x";
								}
							}
							
							// ADD IF STATEMENTS TO ONLY ALLOW SETTLEMENTS CONNECTED TO ROAD SEGMENTS
						}
					}
				}
				if (intDeltaY == 30)
				{
					intDeltaY = 56;
				}
				else if (intDeltaY == 56)
				{
					intDeltaY = 30;
				}

				intDrawY = intDrawY + intDeltaY;
			}
		}
		else if (drawRoad == true)
		{
			intDeltaY = 56;
			intDrawY = 100;
			for (intRow = 1; intRow <= 11 ; intRow++)
			{
				if (intRow == 1 || intRow == 11)
				{
					intDrawX = 200;
					intDeltaX = 50;
				}
				else if (intRow == 2 || intRow == 10)
				{
					intDrawX = 185;
					intDeltaX = 100;
				}
				else if (intRow == 3 || intRow == 9)
				{
					intDrawX = 150;
					intDeltaX = 50;
				}
				else if (intRow == 4 || intRow == 8)
				{
					intDrawX = 135;
					intDeltaX = 100;
				}
				else if (intRow == 5 || intRow == 7)
				{
					intDrawX = 100;
					intDeltaX = 50;
				}
				else if (intRow == 6)
				{
					intDrawX = 85;
					intDeltaX = 100;
				}

				for (intCount = 0; intDrawX <= 590; intDrawX = intDrawX + intDeltaX)
				{
					if (intRow == 1 || intRow == 3 || intRow == 5 || intRow == 7 ||
							intRow == 9 || intRow == 11)
					{
						if (intMouseX >= intDrawX && intMouseX <= intDrawX + 50
								&& intMouseY >= intDrawY && intMouseY <= intDrawY + 30)
						{
							intXCell = (int) Math.floor((intMouseX - 100) / 50.0);
							intYCell = (int) Math.round((intMouseY / 43.0) - 2.8);
							
							if (strRoads[intYCell][intXCell].equals("_"))
							{
								thepanel.strRoads[intYCell][intXCell] = strPlayerColour;
								strRoads[intYCell][intXCell] = strPlayerColour;

								System.out.println("road [" + intXCell + "][" + intYCell + "]");
								System.out.println(intMouseX + ", " + intMouseY);
							}
						}
					}
					else if (intRow == 2 || intRow == 4 || intRow == 6 || intRow == 8 ||intRow == 10)
					{
						if (intMouseX >= intDrawX && intMouseX <= intDrawX + 30
								&& intMouseY >= intDrawY && intMouseY <= intDrawY + 56)
						{
							intXCell = (int) Math.round((intMouseX - 100) / 50.0);
							intYCell = (int) Math.round((intMouseY / 43.0) - 2.8);
							
							if (strRoads[intXCell][intYCell].equals("_"))
							{
								thepanel.strRoads[intYCell][intXCell] = strPlayerColour;
								strRoads[intYCell][intXCell] = strPlayerColour;

								System.out.println("road [" + intXCell + "][" + intYCell + "]");
								System.out.println(intMouseX + ", " + intMouseY);
							}
						}
					}
				}
				
				if (intDeltaY == 30)
				{
					intDeltaY = 56;
				}
				else if (intDeltaY == 56)
				{
					intDeltaY = 30;
				}

				intDrawY = intDrawY + intDeltaY;
			}
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
	public CatanMain ()
	{
		thepanel = new AnimationPanel();
		thepanel.setLayout(null);
		thepanel.setPreferredSize(new Dimension(1280, 720));
		thepanel.addMouseMotionListener(this);
		
		buttonIP = new JButton("Enter");
		buttonIP.setFont(thepanel.f24);
		buttonIP.setSize(200, 100);
		buttonIP.setLocation(1000, 600);
		buttonIP.addActionListener(this);
		thepanel.add(buttonIP);
		buttonIP.setContentAreaFilled(false);
		buttonIP.setBorderPainted(true);
		buttonIP.setVisible(false);
		
		buttonPort = new JButton("Enter"); // button in settings
		buttonPort.setFont(thepanel.f24);
		// This is for making the JButton invisible but functioning
		// buttonPort.setContentAreaFilled(false);
		// buttonPort.setBorderPainted(false);
		buttonPort.setSize(200, 100);
		buttonPort.setLocation(1000, 600);
		buttonPort.addActionListener(this);
		buttonPort.setVisible(false);
		buttonPort.setContentAreaFilled(false);
		buttonPort.setBorderPainted(true);
		thepanel.add(buttonPort);
		
		buttonServer = new JButton("Server");// choose server option
		buttonServer.setFont(thepanel.f24);
		buttonServer.setSize(200, 100);
		buttonServer.setLocation(300, 250);
		buttonServer.addActionListener(this);
		buttonServer.setVisible(false);
		thepanel.add(buttonServer);
		
		buttonClient = new JButton("Client");// choose client option
		buttonClient.setFont(thepanel.f24);
		buttonClient.setSize(200, 100);
		buttonClient.setLocation(800, 250);
		buttonClient.addActionListener(this);
		buttonClient.setVisible(false);
		thepanel.add(buttonClient);
		
		buttonUser = new JButton("Enter");// enter button for user name
		buttonUser.setFont(thepanel.f24);
		buttonUser.setSize(200, 100);
		buttonUser.setLocation(1000, 600);
		buttonUser.addActionListener(this);
		buttonUser.setVisible(false);
		buttonUser.setContentAreaFilled(false);
		buttonUser.setBorderPainted(true);
		thepanel.add(buttonUser);
		
		buttonReady = new JButton("Not Ready");
		buttonReady.setFont(thepanel.f24);
		buttonReady.setSize(200, 100);
		buttonReady.setLocation(575, 600);
		buttonReady.addActionListener(this);
		buttonReady.setContentAreaFilled(false);
		buttonReady.setBorderPainted(false);
		buttonReady.setBackground(Color.LIGHT_GRAY);
		buttonReady.setOpaque(true);
		buttonReady.setVisible(false);
		
		thepanel.add(buttonReady);
		
		buttonNext = new JButton("Next >");// enter button for user name
		buttonNext.setFont(thepanel.f24);
		buttonNext.setSize(200, 75);
		buttonNext.setLocation(1000, 600);
		buttonNext.addActionListener(this);
		buttonNext.setVisible(false);
		buttonNext.setContentAreaFilled(false);
		buttonNext.setBorderPainted(true);
		//~ buttonNext.setBackground(Color.LIGHT_GRAY);
		//~ buttonNext.setOpaque(true);
		thepanel.add(buttonNext);
		
		buttonBack = new JButton("< Back");// enter button for user name
		buttonBack.setFont(thepanel.f24);
		buttonBack.setSize(200, 75);
		buttonBack.setLocation(80, 600);
		buttonBack.addActionListener(this);
		buttonBack.setVisible(false);
		buttonBack.setContentAreaFilled(false);
		buttonBack.setBorderPainted(true);
		thepanel.add(buttonBack);
		
		textIP = new JTextField("");// entering ip if client
		textIP.setSize(250, 40);
		textIP.setLocation(540, 400);
		textIP.setVisible(false);
		thepanel.add(textIP);
		
		textPort = new JTextField("");// for entering port in settings
		textPort.setSize(250, 40);
		textPort.setLocation(540, 360);
		textPort.setVisible(false);
		thepanel.add(textPort);
		
		textUser = new JTextField("");
		textUser.setSize(250, 40);
		textUser.setLocation(540, 360);
		textUser.setVisible(false);
		thepanel.add(textUser);
		
		labelUser = new JLabel("Enter you Username: ");
		labelUser.setFont(thepanel.f24);
		labelUser.setSize(300, 120);
		labelUser.setLocation(550, 290);
		labelUser.setVisible(false);
		thepanel.add(labelUser);
		
		labelIP = new JLabel("Enter the Server's IP:");
		labelIP.setFont(thepanel.f24);
		labelIP.setSize(300, 120);
		labelIP.setLocation(540, 310);
		labelIP.setVisible(false);
		thepanel.add(labelIP);
		
		labelServerIP = new JLabel(""); // will update once ip is received from server
		labelServerIP.setFont(thepanel.f24);
		labelServerIP.setSize(400, 120);
		labelServerIP.setLocation(550, 290);
		labelServerIP.setVisible(false);
		thepanel.add(labelServerIP);
		
		// ~ textIP = new JTextField("");
		// ~ textIP.setSize(400,50);
		// ~ textIP.setLocation(0,310);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 100, 30);
		textField.addActionListener(this);
		textField.setVisible(false);
		thepanel.add(textField);
		
		changeDraw.setBounds(100, 100, 30, 30);
		changeDraw.addActionListener(this);
		changeDraw.setVisible(false);
		thepanel.add(changeDraw);
		
		redPlayer.setBounds(0, 0, 50, 30);
		redPlayer.addActionListener(this);
		redPlayer.setVisible(false);
		thepanel.add(redPlayer);
		
		bluePlayer.setBounds(50, 0, 50, 30);
		bluePlayer.addActionListener(this);
		bluePlayer.setVisible(false);
		thepanel.add(bluePlayer);
		
		whitePlayer.setBounds(100, 0, 50, 30);
		whitePlayer.addActionListener(this);
		whitePlayer.setVisible(false);
		thepanel.add(whitePlayer);
		
		orangePlayer.setBounds(150, 0, 50, 30);
		orangePlayer.addActionListener(this);
		orangePlayer.setVisible(false);
		thepanel.add(orangePlayer);
		
		theframe = new JFrame("Settlers of Catan");
		theframe.addKeyListener(this);
		thepanel.addMouseListener(this);
		thepanel.addMouseMotionListener(this);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setVisible(true);
		thetimer = new Timer(1000 / 30, this);
		thetimer.start();
		theframe.setResizable(false);
		
		/*
		 * 
		 * this is all part of noob chat. not needed yet thearea = new JTextArea();
		 * 
		 * 
		 * thescroll = new JScrollPane(thearea); thescroll.setBounds(0,50,400,250);
		 * 
		 * thefield = new JTextField(""); thefield.setSize(400,50);
		 * thefield.setLocation(0,310);
		 * 
		 * thebutton = new JButton("Send"); thebutton.setSize(400, 50);
		 * thebutton.setLocation(0, 370); thebutton.addActionListener(this);
		 * 
		 * thepanel.add(thescroll); thepanel.add(thefield); thepanel.add(thebutton);
		 */
		
		theframe.setContentPane(thepanel);
		theframe.pack();
		theframe.setResizable(false);
		
		/*
		 * ssm = new SuperSocketMaster(3000, this);
		 * 
		 * 
		 * ssm = new SuperSocketMaster(657, this); ssm.connect();
		 * System.out.println(ssm.getMyAddress());
		 * 
		 */
	}
	
	// Main method
	public static void main (String[] args)
	{
		new CatanMain();
	}
}

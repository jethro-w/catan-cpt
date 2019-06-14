import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Client implements ActionListener, MouseListener
{
	// Properties
	/** Player name */
	public int intPlayerID = 0; // Red = 0, Blue = 1, White = 2, Orange = 3
	/** Number of grain resource cards the player has. */
	public int intGrain;
	/** Number of ore resource cards the player has. */
	public int intOre;
	/** Number of brick resource cards the player has. */
	public int intBrick;
	/** Number of wood resource cards the player has. */
	public int intWood;
	/** Number of wool resource cards the player has. */
	public int intWool;
	/** Number of victory points the player has. */
	public int intVP;
	/** Total number of road segments the player has. */
	public int intRoadSegs;
	/** Total number of knight cards the player has. Knights can be found by purchasing development cards. */
	public int intKnights;
	/** Total number of settlements that a player has. A player will always start with two during setup phase. */
	public int intSettlements;
	/** Total number of cities that a player has. Cities are upgraded settlements. */
	public int intCities;
	/** Longest consecutive road segment that a player has. */
	public int intLCRS;
	/** Whether or not the player has the largest army (ie. most knights). If so, the player gets points for having this attribute. */
	public boolean hasLargestArmy = false;
	/** Whether or not the player has the longest road (ie. longest consecutive road segments). If so, the player gets points for having this attribute. */
	public boolean hasLongestRoad = false;
	public SuperSocketMaster ssm;
	public int intSocket;
	public String strIP;
	public String strUsername;
	public int intPlayers;
	public int intReady;
	public int intPhase;
	public JFrame frame = new JFrame();
	public AnimationPanel panel = new AnimationPanel();
	public Timer timer = new Timer(1000 / 10, this);
	public String[][] strTiles = new String[5][9];
	public String[][] strSettlements = new String[12][11];
	public String[][] strRoads = new String[11][11];	public int intStartTile;
	public int intMouseX;
	public int intMouseY;
	public boolean drawSettlement = true;
	public boolean drawRoad = false;
	public int intDrawX;
	public int intDrawY = 90;
	public int intDeltaY = 56;
	public int intDeltaX = 100;
	
	private int intCount;
	private String strPlayerColour = "r";
	private String strSSMLine;
	private String[] strSSMSplit;
	private JButton changeDraw = new JButton("/");
	private JButton redPlayer = new JButton("r");
	private JButton bluePlayer = new JButton("b");
	private JButton whitePlayer = new JButton("w");
	private JButton orangePlayer = new JButton("o");
	// private Timer timer;
	
	// Methods
	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource() == ssm)
		{
			strSSMLine = ssm.readText();
			strSSMSplit = strSSMLine.split(",");
			
			System.out.println("Server: " + strSSMLine);
			
			if (strSSMSplit[0].contentEquals("0"))
			{
				
			}
			else if (strSSMSplit[0].contentEquals("1"))
			{
				// Phase number 1 ("game")
				if (strSSMSplit[1].contentEquals("start"))
				{
					intPhase = 1;
					
					panel = new AnimationPanel();
					panel.setLayout(null);
					panel.setPreferredSize(new Dimension(1280, 720));
					panel.addMouseListener(this);
					
					changeDraw.setBounds(100, 100, 30, 30);
					changeDraw.addActionListener(this);
					panel.add(changeDraw);
					
					redPlayer.setBounds(0, 0, 50, 30);
					redPlayer.addActionListener(this);
					panel.add(redPlayer);
					
					bluePlayer.setBounds(50, 0, 50, 30);
					bluePlayer.addActionListener(this);
					panel.add(bluePlayer);
					
					whitePlayer.setBounds(100, 0, 50, 30);
					whitePlayer.addActionListener(this);
					panel.add(whitePlayer);
					
					orangePlayer.setBounds(150, 0, 50, 30);
					orangePlayer.addActionListener(this);
					panel.add(orangePlayer);
					
					frame = new JFrame("New Animations :)");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setContentPane(panel);
					frame.pack();
					frame.setVisible(true);
					frame.setResizable(false);
				}
				else if (strSSMSplit[1].contentEquals("roads"))
				{
					
				}
				else if (strSSMSplit[1].contentEquals("tiles"))
				{
					
				}
				else if (strSSMSplit[1].contentEquals("settlements"))
				{
					
				}
			}
			else if (strSSMSplit[0].contentEquals("2"))
			{
				// Phase number 2 (win/lose)
			}
			else if (strSSMSplit[0].contentEquals("3"))
			{
				// Phase number 3 (chat)
			}
		}
		else if (evt.getSource() == timer)
		{
			panel.repaint();
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
			intPlayerID = 0;
			strPlayerColour = "r";
		}
		else if (evt.getSource() == bluePlayer)
		{
			intPlayerID = 1;
			strPlayerColour = "b";
		}
		else if (evt.getSource() == whitePlayer)
		{
			intPlayerID = 2;
			strPlayerColour = "w";
		}
		else if (evt.getSource() == orangePlayer)
		{
			intPlayerID = 3;
			strPlayerColour = "o";
		}
	}
	public void sendReady(boolean isReady)
	{
		if (isReady == true)
		{
			ssm.sendText("0,ready,0");
			System.out.println("ready");
		}
		else
		{
			ssm.sendText("0,not,0");
			System.out.println("not ready");
		}
	}
	/** Generates two random numbers between 1 and 6 adds them to simulate a dice roll. */
	public void rollDice ()
	{
		
	}
	/** Builds a settlement at the indicated intersection. Uses one wheat, one wool, one brick, and one wood. */
	public void buildSettlement (int intT1, int intT2, int intT3)
	{
		
	}
	/** Builds a settlement at the indicated line segment. Uses one wood and one brick. */
	public void buildRoad (int intT1, int intT2)
	{
		
	}
	/** Upgrades a settlement to a city at the indicated intersection. Uses two wheat and three ore. */
	public void upgradeToCity (int intT1, int intT2, int intT3)
	{
		
	}
	/** When the player rolls a 7 or the player plays a knight, the robber is moved to the indicated tile. That tile will be deactivated and the player 
	 * moving the robber can steal a resource from any player that borders that tile. */
	public void moveRobber (int intTile)
	{
		
	}
	/** Plays a development card that the player owns. Only one development card may be played per turn. */
	public void playDev (int intCardNumber)
	{
		
	}
	/** Trades four of the same resource for one resource card with the bank. */
	public void bankTrade (String resGive, String resGet)
	{
		
	}
	/** Trades any of the player's resource cards for any of another player's cards when agreed upon by both players. */
	public void playerTrade (String resGive[], String resGet[])
	{
		
	}
	/** When the player rolls a 7, any player with over seven resource cards must discard half their resource cards (rounded up). This is used in tandem with
	 * the moveRobber method if any player has over seven resource cards. */
	public void forceDiscard ()
	{
		
	}
	public void mouseClicked (MouseEvent evt)
	{
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
							panel.strSettlements[intYCell][intXCell] = strPlayerColour;
							strSettlements[intYCell][intXCell] = strPlayerColour;

							System.out.println("settlements [" + intXCell + "][" + intYCell + "]");

							// ADD FEATURE TO DISABLE SURROUNDING SPOTS (dependent on row number)
							if (intRow == 1 || intRow == 3 || intRow == 5 || intRow == 7 || intRow == 9 || intRow == 11)
							{
								panel.strSettlements[intYCell + 1][intXCell + 1] = "x";
								panel.strSettlements[intYCell + 1][intXCell - 1] = "x";
								strSettlements[intYCell + 1][intXCell + 1] = "x";
								strSettlements[intYCell + 1][intXCell - 1] = "x";
								if (intRow != 1)
								{
									panel.strSettlements[intYCell - 1][intXCell] = "x";
									strSettlements[intYCell - 1][intXCell] = "x";
								}
							}
							else if (intRow == 2 || intRow == 4 || intRow == 6 || intRow == 8 || intRow == 10 || intRow == 12)
							{
								panel.strSettlements[intYCell - 1][intXCell + 1] = "x";
								panel.strSettlements[intYCell - 1][intXCell - 1] = "x";
								strSettlements[intYCell - 1][intXCell + 1] = "x";
								strSettlements[intYCell - 1][intXCell - 1] = "x";
								if (intRow != 12)
								{
									panel.strSettlements[intYCell + 1][intXCell] = "x";
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
								panel.strRoads[intYCell][intXCell] = strPlayerColour;
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
								panel.strRoads[intYCell][intXCell] = strPlayerColour;
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
	public void mousePressed (MouseEvent e)
	{
		
	}
	public void mouseReleased (MouseEvent e)
	{
		
	}
	public void mouseEntered (MouseEvent e)
	{
		
	}
	public void mouseExited (MouseEvent e)
	{
		
	}
	
	// Constructor
	public Client (String strIP, int intSocket, String strUsername)
	{
		ssm = new SuperSocketMaster(strIP, intSocket, this);
		ssm.connect();
		
		ssm.sendText("0,not,1");
		
		// timer = new Timer (1000, this);
		// timer.start();
		
		System.out.println("client initialized");
		System.out.println(strIP + "," + intSocket);
	}
}

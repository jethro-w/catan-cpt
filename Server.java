import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.Timer;

public class Server implements ActionListener
{
	// Properties
	/** Player name */
	public int intPlayerID;
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
	public int intPlayers = 0;
	public int intReady = 0;
	public String[][] strTiles = new String[5][9];
	public String[][] strSettlements = new String[12][11];
	public String[][] strRoads = new String[11][11];
	public int intPhase;

	private String strSSMLine;
	private String[] strSSMSplit;
	private Timer timer;
	private JButton changeDraw = new JButton("/");
	private JButton redPlayer = new JButton("r");
	private JButton bluePlayer = new JButton("b");
	private JButton whitePlayer = new JButton("w");
	private JButton orangePlayer = new JButton("o");
	// private String strMapArray;
	// private int intRow;
	// private int intColumn;
	
	// Implemented Methods
	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource() == ssm)
		{
			strSSMLine = ssm.readText();
			strSSMSplit = strSSMLine.split(",");
			
			System.out.println("Client: " + strSSMLine);
			
			if (strSSMSplit[0].equals("0"))
			{				
				if (strSSMSplit[1].equals("ready"))
				{
					intReady ++;
					
					/*
					if (strSSMSplit[2].contentEquals("1"))
					{
						intPlayer ++;
						intReady ++;
					}
					*/
				}
				else if (strSSMSplit[1].equals("not"))
				{					
					if (intReady <= 0)
					{
						intReady = 0;
					}
					if (strSSMSplit[2].contentEquals("1"))
					{
						intPlayers ++;
						
						System.out.println("Added player.");
					}
				}
				
				if (intPlayers == intReady)
				{
					// Enter Phase 1
					ssm.sendText("1,start");
					CatanMain.intPhase = 1;
				}
			}
			else if (strSSMSplit[0].contentEquals("1"))
			{
				// Phase number 1 (placing)
			}
			else if (strSSMSplit[0].contentEquals("2"))
			{
				// Phase number 2 (game)
			}
			else if (strSSMSplit[0].contentEquals("3"))
			{
				// Phase number 3 (win/lose screen)
			}
			else if (strSSMSplit[0].contentEquals("4"))
			{
				// Phase number 4 (chat)
				
			}
		}
		else if (evt.getSource() == timer)
		{
			/*
			if (intPhase == 1)
			{
				for (intRow = 0; intRow < 5; intRow ++)
				{
					for (intColumn = 0; intColumn < 9; intColumn ++)
					{
						strMapArray = strMapArray + strTiles[intRow][intColumn];
					}
				}
				ssm.sendText("1,map," + strMapArray);
			}
			*/
			if (intReady != intPlayers)
			{
				System.out.println("Players: " + intPlayers);
				System.out.println("Readys: " + intReady);
			}
			else if (intReady == intPlayers)
			{
				System.out.println("all ready");
			}
		}
	}
	
	// Methods
	public void checkReady()
	{
		
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
	
	// Constructor
	/** Constructor
	 * Constructs with parameters:
	 * @param strIP
	 * @param intSocket
	 * @param strUsername
	 */
	public Server (String strIP, int intSocket, String strUsername)
	{
		ssm = new SuperSocketMaster(intSocket, this);
		strIP = ssm.getMyAddress();
		ssm.connect();
		
		timer = new Timer(1000, this);
		timer.start();
		
		System.out.println(strIP + "," + intSocket);
		
		/*
		settlements.setBounds(700, 100, 200, 200);
		panel.add(settlements);
		
		roads.setBounds(700, 400, 200, 200);
		panel.add(roads);
		*/
		
		try
		{
			strTiles = CatanMain.loadMap();
			strSettlements = CatanMain.loadSettlements();
			strRoads = CatanMain.loadRoads();
		}
		catch (IOException e)
		{
			System.out.println("Could not load map(s)");
		}

		int intColumn;
		int intRow;
		int intRand = 0;
		int intOre = 0;
		int intBrick = 0;
		int intWheat = 0;
		int intWood = 0;
		int intWool = 0;
		int intDesert = 0;
		boolean hasMaxOre = false;
		boolean hasMaxBrick = false;
		boolean hasMaxWheat = false;
		boolean hasMaxWood = false;
		boolean hasMaxWool = false;
		boolean hasDesert = false;
		
		// Copy array to AnimationPanel
		for (intRow = 0; intRow < 5; intRow++)
		{
			for (intColumn = 0; intColumn < 9; intColumn++)
			{
				if (strTiles[intRow][intColumn].equals("_"))
				{
					// Generate random tile
					intRand = (int)(Math.random() * 11);
					
					while (((intRand == 0 || intRand == 1) && hasMaxOre == true) || ((intRand == 2 || intRand == 3) && hasMaxBrick == true)
							|| ((intRand == 4 || intRand == 5) && hasMaxWheat == true) || ((intRand == 6 || intRand == 7) && hasMaxWood == true)
							|| ((intRand == 8 || intRand == 9) && hasMaxWool == true) || (intRand == 10 && hasDesert == true))
					{
						intRand = (int) (Math.random() * 11);
						System.out.println(intRand);
					}

					if (intRand == 0 || intRand == 1)
					{
						CatanMain.strTiles[intRow][intColumn] = "0";
						intOre++;
						if (intOre == 3)
						{
							hasMaxOre = true;
						}
					}
					if (intRand == 2 || intRand == 3)
					{
						CatanMain.strTiles[intRow][intColumn] = "1";
						intBrick++;
						if (intBrick == 3)
						{
							hasMaxBrick = true;
						}
					}
					if (intRand == 4 || intRand == 5)
					{
						CatanMain.strTiles[intRow][intColumn] = "2";
						intWheat++;
						if (intWheat == 4)
						{
							hasMaxWheat = true;
						}
					}
					if (intRand == 6 || intRand == 7)
					{
						CatanMain.strTiles[intRow][intColumn] = "3";
						intWood++;
						if (intWood == 4)
						{
							hasMaxWood = true;
						}
					}
					if (intRand == 8 || intRand == 9)
					{
						CatanMain.strTiles[intRow][intColumn] = "4";
						intWool++;
						if (intWool == 4)
						{
							hasMaxWool = true;
						}
					}
					if (intRand == 10)
					{
						CatanMain.strTiles[intRow][intColumn] = "5";
						intDesert++;
						if (intDesert == 1)
						{
							hasDesert = true;
						}
					}
				}
				else if (strTiles[intRow][intColumn].equals("x"))
				{
					CatanMain.strTiles[intRow][intColumn] = "x";
				}
			}
		}
		
		for (intRow = 0; intRow < 12; intRow ++)
		{
			for (intColumn = 0; intColumn < 11; intColumn ++)
			{
				if (strSettlements[intRow][intColumn].equals("_"))
				{
					CatanMain.strSettlements[intRow][intColumn] = "_";
				}
				else if (strSettlements[intRow][intColumn].equals("x"))
				{
					CatanMain.strSettlements[intRow][intColumn] = "x";
				}
			}
		}
		
		for (intRow = 0; intRow < 11; intRow ++)
		{
			for (intColumn = 0; intColumn < 11; intColumn ++)
			{
				if (strRoads[intRow][intColumn].equals("_"))
				{
					CatanMain.strRoads[intRow][intColumn] = "_";
				}
				else if (strRoads[intRow][intColumn].equals("x"))
				{
					CatanMain.strRoads[intRow][intColumn] = "x";
				}
			}
		}
	}
}

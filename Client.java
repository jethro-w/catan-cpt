import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client implements ActionListener
{
	// Properties
	/** Player name */
	public int intPlayer;
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
	
	private String strSSMLine;
	private String[] strSSMSplit;
	// private Timer timer;
	
	// Implemented Methods
	public void actionPerformed (ActionEvent evt)
	{
		if (evt.getSource() == ssm)
		{
			strSSMLine = ssm.readText();
			
			strSSMSplit = strSSMLine.split(",");
			
			if (strSSMSplit[0].contentEquals("0"))
			{
				
			}
			else if (strSSMSplit[0].contentEquals("1"))
			{
				// Phase number 1 (placing)
				intPhase = 1;
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
	}
	
	// Methods
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

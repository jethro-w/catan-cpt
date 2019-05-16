public class player
{
	// Properties
	public int intPlayer;
	public int intGrain;
	public int intOre;
	public int intBrick;
	public int intWood;
	public int intWool;
	public int intVP = 2;
	public int intRoadSegs;
	public int intKnights;
	public int intSettlements;
	public int intCities;
	/** Longest consecutive road segment that a player has */
	public int intLCRS;
	public boolean hasLargestArmy = false;
	public boolean hasLongestRoad = false;
	
	// Methods
	public void rollDice ()
	{
		
	}
	public void buildSettlement (int intT1, int intT2, int intT3)
	{
		
	}
	public void buildRoad (int intT1, int intT2)
	{
		
	}
	public void upgradeToCity (int intT1, int intT2, int intT3)
	{
		
	}
	public void moveRobber (int intTile)
	{
		
	}
	public void playDev (int intCardNumber)
	{
		
	}
	public void bankTrade (String resGive, String resGet)
	{
		
	}
	public void playerTrade (String resGive[], String resGet[])
	{
		
	}
	public void forceDiscard ()
	{
		
	}
	
	// Constructor
	public player (int intPlayer, int intGrain, int intOre, int intBrick, int intWood, int intWool,
			int intRoadSegs, int intKnights, int intSettlements, int intCities, int intLCRS)
	{
		this.intPlayer = intPlayer;
		this.intGrain = intGrain;
		this.intOre = intOre;
		this.intBrick = intBrick;
		this.intWood = intWood;
		this.intWool = intWool;
		this.intRoadSegs = intRoadSegs;
		this.intKnights = intKnights;
		this.intSettlements = intSettlements;
		this.intCities = intCities;
		this.intLCRS = intLCRS;
	}
}

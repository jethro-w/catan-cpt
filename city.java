public class city extends settlement
{

	// Properties
	/** is the number of points the player has */
	int intVP = 2;
	/** is the number that player is assigned */

	// Methods
	/** draws a city if there are 3 tiles surrounding the player */
	public void draw (int intPlayer, int intT1, int intT2, int intT3)
	{
	}

	/** draws a city if there are 2 tiles surrounding the player */
	public void draw (int intPlayer, int intT1, int intT2)
	{
	}

	// Constructor
	/** contructs a city */
	public city(int intPlayer, int intT1, int intT2, int intT3)
	{
		super(intPlayer, intT1, intT2, intT3);
	}

}

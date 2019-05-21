import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mapTest
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader map = new BufferedReader(new FileReader("catan-map.csv"));
		String[] strMapLine = new String[12];
		String[][] strMap = new String [12][11];
		int intCount;
		int intCount2;
		
		for (intCount = 0; intCount < 12; intCount++)
		{
			strMapLine[intCount] = map.readLine();
			strMap[intCount] = strMapLine[intCount].split(",");
		}
		
		
	}
}

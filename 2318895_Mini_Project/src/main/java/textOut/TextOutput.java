package textOut;

import java.io.FileWriter;
import java.io.IOException;

public class TextOutput
{
	public static void textPrint(String datatoWrite)
	{
		try 
		{
			FileWriter writer = new FileWriter("./src/Textoutput/textoutput.txt");
			writer.write(datatoWrite);
			writer.close();
		} 
		catch (IOException e)
		{
			
			System.out.println("File not found");
		}
	}
}

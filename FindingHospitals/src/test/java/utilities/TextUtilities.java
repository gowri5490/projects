package utilities;

import java.io.FileWriter;
import java.io.IOException;

public class TextUtilities 
{
	public void writeText(String output) throws IOException
	{

		FileWriter writer = new FileWriter("./Outputs/TextOutput/Output.txt",true);//Creating a writer object
		writer.append(output+"\n");//Writing the Output to the TEXT Document;
		writer.close();//closing the resource after use;
	}
}

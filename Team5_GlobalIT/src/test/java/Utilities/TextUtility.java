package Utilities;

import java.io.FileWriter;
import java.io.IOException;

public class TextUtility
{
	
	public void writeText(String output) throws IOException
	{
		
				FileWriter writer = new FileWriter("./outputs/TextOutput/Output.txt",true);//Creating a writer object
				writer.append(output+"\n");//Writing the Output to the TEXT Document;
				writer.close();//closing the resource after use;
	}
}

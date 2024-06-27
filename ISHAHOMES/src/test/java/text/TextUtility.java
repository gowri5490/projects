package text;

//Importing all the required packages;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/*
For Writing The Output in the TEXT FILE;
*/
public class TextUtility {

	//writeOutput() method with the List of string argument to write the output in TEXT FILE;
	public static void writeOutput(List<String> outputs) throws IOException
	{
		
		//Creating a file object for the desired loction; 
		File file = new File("./src/TextOutput/Output.txt");
		
		/*
		 * This while is for deleting the exisiting TEXT Document
		 * and Creating a fresh TEXT Document;
		 */
		
		while(true)
		{
			if(file.exists())
			{
				file.delete();
			}
			else
			{
				file.createNewFile();
				break;
			}
		}
		if(file.exists())
		{
			FileWriter writer = new FileWriter(file);//Creating a writer object;
			for(String output : outputs)
			writer.write(output+"\n");//Writing the Output to the TEXT Document;
			writer.close();//closing the resource after use;
		}
	}
}


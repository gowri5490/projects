package getUrl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Getlink 
{
	
	//A static method to get the url from a text file and returning it within a list
	public static List<String> getURl()
	
	{
		//Creating a list to store the url
		List<String> mylist = new ArrayList<String>();
		
		try
		{
			//Reading the text file
			File link_text = new File("./src/main/resources/Data/BaseUrl");
			Scanner sc = new Scanner(link_text);
			
			//Adding the url in the list
			while(sc.hasNextLine())
			{
				mylist.add(sc.nextLine());
			}
			sc.close();
			
		} 
		
		catch (Exception e) 
		{
			System.out.println("File not Found");
		}
		
		//Returning the list
		return mylist;
	}

}

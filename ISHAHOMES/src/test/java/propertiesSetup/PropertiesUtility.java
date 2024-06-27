package propertiesSetup;

//Importing all the required packages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * This class is to get the URL of the project(Ishahomes home page)
 * getURL()-->returns url string from the .properties file
 */
public class PropertiesUtility 
{
	static String URL;
	
	public static String getURL() throws FileNotFoundException, IOException
	{
		File file = new File("./src/test/resources/URL/URL.properties");//file path;
		try(InputStream input = new FileInputStream(file))
		{
			Properties properties = new Properties(); //creating the object of properties;
			properties.load(input);//loading the inputstream;

			URL = properties.getProperty("ISHA_URL");//Getting the mail;
		}
		catch(Exception exception){}
		return URL;//returning the url;
	}
}

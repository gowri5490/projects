package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtility
{
String value;
	
	public String getValue(String Key) throws FileNotFoundException, IOException
	{
		File file = new File("./src/test/resources/URL/URL.properties");//file path;
		try(InputStream input = new FileInputStream(file))
		{
			Properties properties = new Properties(); //creating the object of properties;
			properties.load(input);//loading the inputstream;
			value = properties.getProperty(Key);//Getting the mail;
		}
		catch(Exception exception){}
		return value;//returning the url;
	}
}

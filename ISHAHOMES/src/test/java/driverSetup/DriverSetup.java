package driverSetup;

//Importing all the required Packages;
import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * DriverSetup class with methods to opening the mentioned brower;
 * Maximizing the window;
 * Adding time outs for slow network sutiation;
 * Deleting the cookies;
 * Getting the Url;
 * Closing the Browser;
 */
public class DriverSetup 
{
	public static WebDriver driver;//return this driver to the main method;
	
	public static WebDriver openBrowser()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Browser Name (Chrome or Edge): ");//user input;
		while(true)
		{
			String browserName = scanner.nextLine();
			if(browserName.equalsIgnoreCase("Chrome"))//For chrome;
			{
				driver = new ChromeDriver();//Assigning Chrome driver;
				break;
			}
			else if(browserName.equalsIgnoreCase("Edge"))//For edge;
			{
				driver = new EdgeDriver();//Assigning Edge Driver;
				break;
			}
			else
			{
				System.out.println("Invalid Browser Name\nRe-Enter The Browser Name (Chrome or Edge): ");//if name is invalid;
			}
		}
		driver.manage().window().maximize();//maximizing;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//timeouts of 10 second;
		driver.manage().deleteAllCookies();//deleting Cookies;
		
		scanner.close();//closing the resource;
		
		return driver;//returning the driver;
	}
	
	public static void openURL(String url)
	{
		driver.get(url);//Getting the URL;
	}
	
	public static void closeBrowser(WebDriver driver) 
	{
		driver.quit();//Closing the browser;
	}
}

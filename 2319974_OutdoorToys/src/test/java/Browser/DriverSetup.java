package Browser;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class DriverSetup {

	public static WebDriver driver;
	public static WebDriver getWebDriver()
	{
		//Creating a scanner object to store driver name
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag)
		{
			System.out.print("Enter the browser name:");
			String browser = sc.next();
			
			//Returning the respective driver according to the input
			if(browser.equalsIgnoreCase("chrome"))
			{
	
				driver = new ChromeDriver();
				
				flag = false;
			}
			else if(browser.equalsIgnoreCase("edge"))
			{

				driver = new EdgeDriver();
				flag = false;
			}
			else
			{
				System.out.println("Browser should be either 'Chrome' or 'Edge'");
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		sc.close();
	
		return driver;
	}

}

package Browser;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	private static WebDriver driver;
	public static WebDriver getWebDriver()
	{
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag)
		{
			System.out.print("Enter the browser name:");
			String browser = sc.next();
			if(browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				flag = false;
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				flag = false;
			}
			else
			{
				System.out.println("Browser should be either 'Chrome' or 'Edge'");
			}
		}
		sc.close();
		return driver;
	}

}

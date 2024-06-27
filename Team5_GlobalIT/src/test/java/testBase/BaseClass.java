package testBase;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import Utilities.PropertiesUtiliy;
import Utilities.TakeScreenshot;
import Utilities.TextUtility;


public class BaseClass 
{
	protected WebDriver driver;
	protected TakeScreenshot capture;
	JavascriptExecutor js;
	protected WebDriverWait myWait ;
	protected TextUtility writer;
	
	@BeforeClass
	@Parameters("Browser")
	public void beforeTest(String br) throws IOException 
	{
		if(br.equals("Chrome"))
			driver = new ChromeDriver();
		else if(br.equals("Edge")) 
			driver = new EdgeDriver();
		System.out.println("Browser Lanched");
		capture = new TakeScreenshot();
		FileWriter write = new FileWriter("./outputs/TextOutput/Output.txt");//Creating a writer object
		write.append("Test Starts");
		write.close();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(PropertiesUtiliy.getURL());
		js=(JavascriptExecutor)driver;
		writer=new TextUtility();
		myWait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}

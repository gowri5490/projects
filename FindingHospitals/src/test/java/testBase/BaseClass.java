package testBase;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjectModel.EmployeeHealthElements;
import pageObjectModel.LabTestPageElements;
import pageObjectModel.PractoHomePageElements;
import pageObjectModel.SearchPageElements;
import pageObjectModel.SergeriesPageElements;
import utilities.ExcelUtilities;
import utilities.PropertiesUtility;
import utilities.TakeScreenshot;
import utilities.TextUtilities;

public class BaseClass 
{
	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected Logger logger;
	protected LabTestPageElements labElements;
	protected PractoHomePageElements practoElements; 
	protected EmployeeHealthElements employeeElements;
	protected SearchPageElements searchElements;
	protected SergeriesPageElements sergeryElement;
	protected Actions builder;
	protected WebDriverWait myWait;
	protected TextUtilities writer;
	protected TakeScreenshot capture;
	protected ExcelUtilities excel;
	protected PropertiesUtility property;
	protected String occupation;
	protected String details;
	
	
	@BeforeSuite
	public void beforeSuite() throws IOException
	{
		FileWriter write = new FileWriter("./Outputs/TextOutput/Output.txt");//Creating a writer object
		write.append("Test Starts");
		write.close();
	}
	
	@BeforeMethod
	@Parameters("Browser")
	public void beforeMethod(String br) throws IOException 
	{
		if(br.equals("Chrome"))
			driver = new ChromeDriver();
		else if(br.equals("Edge")) 
			driver = new EdgeDriver();
		System.out.println("Browser Lanched");
		labElements = new LabTestPageElements(driver);
		practoElements = new PractoHomePageElements(driver);
		employeeElements = new EmployeeHealthElements(driver);
		searchElements = new SearchPageElements(driver);
		sergeryElement = new SergeriesPageElements(driver);
		writer = new TextUtilities();
		capture = new TakeScreenshot();
		excel = new ExcelUtilities();
		property= new PropertiesUtility();
		logger = LogManager.getLogger(this.getClass());
		js = (JavascriptExecutor) driver;
		builder = new Actions(driver);
		occupation =  property.getValue("Occupation");
		details = property.getValue("Details");
		myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		logger.info("*****Browser Lanched*****");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(property.getValue("Test_URL"));
		
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

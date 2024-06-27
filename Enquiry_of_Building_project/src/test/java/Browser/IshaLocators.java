package Browser;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IshaLocators {

	public static  WebDriver driver;
	public static String baseUrl;
	public int totalProjects;
	public static WebDriver createDriver()
	{
		//Driver Setup 
		driver = DriverSetup.getWebDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	public static void navigateURL()
	{
		// Navigate to the given URL and maximize the browser
		baseUrl = "https://ishahomes.com/";
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='livprop_popup']//a")).click();
	}
	public static void clickCpLink()
	{
		//Navigate to the completed projects page by clicking on “Completed Projects” menu link.
		WebElement cpLink = driver.findElement(By.xpath("//li[@id=\"menu-item-25810\"]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(cpLink).click().perform();
		
	}
	
	public static void clickAllButton()
	{
		// click "All" button to display all the completed projects on the web page
		WebElement All = driver.findElement(By.xpath("//ul[@class=\"boosted-tabs-nav nav\"]/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(All).click().perform();
	}
	public static int projectsCount()
	{ 
		// count the total no of projects
		List<WebElement> projectslist = driver.findElements(By.xpath("//div[@id='boosted-tab-0']//div[@class='isha_project_title']//a"));
		int count =projectslist.size();
		return count;
	}
	
	public static String[] displayProjectNames() throws InterruptedException
	{
		//print the total number of completed projects in the console
		// return the first five completed projects 
		List<WebElement> projectslist = driver.findElements(By.xpath("//div[@id='boosted-tab-0']//div[@class='isha_project_title']//a"));
		int count =projectslist.size();
		Thread.sleep(5000);
		String arr[]= new String[count];
		for(int i =0;i<count;i++)
		{
			String projectname = projectslist.get(i).getText();
			arr[i] = projectname;
			if(i==4)
			{
				break;
			}
			
		}
		return arr;
	}
	
	public static void clickEnquireNowButton() throws NoSuchElementException, InterruptedException
	{
		// click on the "Enquire Now" Button
		Actions action = new Actions(driver);
		WebElement EnquireNow= driver.findElement(By.linkText("Enquire Now"));
		action.moveToElement(EnquireNow).click().perform();
	}
	
	public static void clickVendorEnquiry() throws NoSuchElementException, InterruptedException
	{
		// click on the "VendorEnquiry" Link
		Actions action = new Actions(driver);
		WebElement VendorEnquiry = driver.findElement(By.linkText("Vendor Enquiry"));
		action.moveToElement(VendorEnquiry).click().perform();
		
	}
	
	public static String getEmailId()
	{
		// return the email displayed in the page and print it in the console
		String EmailID = driver.findElement(By.xpath("//div[@class=\"cont-pop\"]//a")).getText();
		return EmailID;
	}
	
	public static void getFinalOutputScreenshot() throws IOException
	{
		//Get the Email dialog box as the final output screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		
//		WebElement EmailBox = driver.findElement(By.xpath("//div[@class='dialog-widget-content dialog-lightbox-widget-content animated']/div/div"));
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\2318604\\eclipse-workspace\\Mini_project\\src\\test\\java\\images\\img.png");
		FileUtils.copyFile(source, target);
	}
	
	public static void closeBrowser()
	{
		//closing the browser after all the executions 
		driver.quit();
	}
}

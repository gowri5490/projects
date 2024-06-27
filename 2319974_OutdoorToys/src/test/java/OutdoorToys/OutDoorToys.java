package OutdoorToys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Browser.DriverSetup;
import dataExcel.ExcelData;



public class OutDoorToys{
	
	//Declaring static variable for implement driver and htmlReport
	static WebDriver driver;
	static String[] Elements=null;
	static int count=1;
	static ExtentSparkReporter htmlReporter;
	static ExtentReports extent;
	static ExtentTest test;
	
	//Get driver from DriverSetup class and return the Driver
	public WebDriver setupDriver()
	{
		
		//Initialize the htmlReporter path for store the HTML file
		htmlReporter = new ExtentSparkReporter("C:\\Users\\2319974\\Downloads\\2319974_OutdoorToys\\2319974_OutdoorToys\\Extend_Report\\Report.html");
	    
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Final Report");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		htmlReporter.config().setTheme(Theme.DARK);
	
		
		//Get driver from DriverSetup class
		driver = DriverSetup.getWebDriver();
		
		 //Using implicit wait to handle the synchronization issue
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	  
	    
	}
	
	//Implement this static method for take a Screenshot wherever needed and store it in a file
	
		public static void TakeScreenShot(WebDriver driver) throws IOException
		{
		    TakesScreenshot ts=(TakesScreenshot)driver;
		    File src=ts.getScreenshotAs(OutputType.FILE);
		    File trg=new File("C:\\Users\\2319974\\Downloads\\2319974_OutdoorToys\\2319974_OutdoorToys\\ScreenShot\\img" + count + ".png");
		    FileUtils.copyFile(src, trg);
		    count++;
		}
			
	
	//Launch the browser using this method
	public void advancePage() throws Exception
	{
		
		driver.get("https://www.ebay.com");
		
		
		ExtentTest test1=extent.createTest("Click Advance in current URL");
		WebElement advance=driver.findElement(By.id("gh-as-a"));
	
		advance.click();

		test1.log(Status.INFO, "Wait for advance menu open");
		test1.log(Status.PASS, "Successfully Advance menu open");
		
		TakeScreenShot(driver);
		
	}
	
	public void findItems() throws IOException, InterruptedException
	{
		//Call this method to get the excel data
		Elements=ExcelData.getExcel();
		
		ExtentTest test2=extent.createTest("Fill the Find Fields");
		WebElement iName=driver.findElement(By.id("_nkw"));
		iName.sendKeys(Elements[0]);
		
		test2.log(Status.INFO, "Excel data retrive and fill the Fields");
		
		test2.log(Status.PASS, "Successfully Added all Fields");
		
		Select wrds=new Select(driver.findElement(By.name("_in_kw")));
		wrds.selectByVisibleText(Elements[1]);
		
		Select cate=new Select(driver.findElement(By.xpath("//select[@id='s0-1-17-4[0]-7[3]-_sacat']")));
		cate.selectByVisibleText(Elements[2]);
		
		TakeScreenShot(driver);
	}
	
	
	
	
	
	
	
	public void specialSearch() throws InterruptedException, IOException
	{
		ExtentTest test3=extent.createTest("Click the Title and description checkbox");
		
		WebElement searchIncluding=driver.findElement(By.xpath("//span//input[@name='LH_TitleDesc']"));
		searchIncluding.click();
		
		test3.log(Status.INFO, "Checking in the Title and description checkbox");
		test3.log(Status.PASS, "Sucessfully checkedin the Title and description checkbox");
		
		TakeScreenShot(driver);
		
		ExtentTest test4=extent.createTest("Click the New checkbox in the condition section");
		
		WebElement condition=driver.findElement(By.xpath("//input[@id='s0-1-17-6[4]-[0]-LH_ItemCondition']"));
		condition.click();
		
		test4.log(Status.INFO, "Click the New checkbox in the condition section");
		test4.log(Status.PASS, "Sucessfully checked in the New checkbox from the condition section");
		
		TakeScreenShot(driver);
		
		ExtentTest test5=extent.createTest("Click the free return from the show results section");
		
		WebElement showResults1=driver.findElement(By.xpath("//input[@id='s0-1-17-5[5]-[0]-LH_FR']"));
		showResults1.click();
		
		test5.log(Status.INFO, "Free result checkbox must be selected");
		test5.log(Status.PASS, "Sucessfully selected the free result checkbox");
		
		TakeScreenShot(driver);
		
		ExtentTest test6=extent.createTest("Click the returns accepted from the show results section");
		
		WebElement showResults2=driver.findElement(By.xpath("//input[@id='s0-1-17-5[5]-[1]-LH_RPA']"));
		showResults2.click();
		
		test6.log(Status.INFO, "Returns accepted checkbox must be selected");
		test6.log(Status.PASS, "Sucessfully selected the returns accepted checkbox");
		
		TakeScreenShot(driver);
		
		ExtentTest test7=extent.createTest("Click the worldwide radio button from the item loation section");
		
		WebElement itemLocation=driver.findElement(By.xpath("//input[@id='s0-1-17-6[7]-[3]-LH_PrefLoc']"));
		itemLocation.click();
		test7.log(Status.INFO, "Worldwide radio button from the item loation radio button has to be selected");
		test7.log(Status.PASS, "Sucessfully selected the worldwide radio button from the item location section");
		
		TakeScreenShot(driver);
		
		//test3.log(null, null)
	}
	
	public void Search() throws InterruptedException, IOException
	{
		
		ExtentTest test8=extent.createTest("Fill and click the Special search options");
		
		WebElement submit=driver.findElement(By.xpath("//div[@class='adv-form__actions']//button[@class='btn btn--primary']"));
		submit.click();
		
		test8.log(Status.INFO, "Checking if the search button is working");
		test8.log(Status.PASS, "Successfully searched the page");
		
//		Thread.sleep(2000);
//		
		
		TakeScreenShot(driver);
	}
	
	public void getItems() throws Exception
	{
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Curren page 'href' values");
		int count=1,i=0,j=0;
		int size=links.size();
		String[] itemName=new String[size];
		String[] linksName=new String[size];
		
		for(WebElement link:links)
		{
			String toyName=link.getText();
			
			if(toyName.contains(Elements[3]))
			{
				if(!toyName.equals("Building Toys"))
				{
				String[] name=toyName.split("Opens");
				String linkName=link.getAttribute("href");
				
					itemName[i]=name[0];
					linksName[j]=linkName;
	
				System.out.println("Item"+count+" Name:"+name[0]);
				System.out.println("Item"+count+" Link:"+link.getAttribute("href"));
				System.out.println();
				System.out.println("-------------------");
				
				count++;
				i++;
				j++;
				
				}
			}
		}
		ExcelData.excelOutput(itemName,linksName);
	}
	public static void saveReport()
	{
		extent.flush();
	}
}
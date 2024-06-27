package Main;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import driverSetup.DriverSetup;
import excelOut.ExcelOutput;
import getExcelData.ExtractData;
import getUrl.Getlink;
import textOut.TextOutput;

public class Javascript_Executor_Usage 

{
	//Declaring and initializing the count variable
	static int count=1;
	
	//A static method to take screenshots wherever needed and store it in a file
	public static void TakeScreenshot(WebDriver driver) throws IOException
	
	{
		   File source = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
	       File dest = new File("./src/Screenshots/img"+count+".png");
	       FileHandler.copy(source, dest);
	       count++;
	}
	
	 //Main method
	 public static void main(String args[]) throws IOException, InterruptedException
	 
	{
		   //Receiving needed web driver from DriverSetup class
		   WebDriver driver; 
		   driver = DriverSetup.getWebDriver();
		  
		   while(true)
		  {
			  if(driver==null)
			  {
				 driver = DriverSetup.getWebDriver();
			  }
			  else
			  {
				  break;
			  }
		  }
		   
		   //Typecasting the driver to javascript executor and assigning it to a variable
		   JavascriptExecutor executor = (JavascriptExecutor)driver;
		   
		   //Maximizing the window
		   driver.manage().window().maximize();
		   
		   //Using implicit wait to handle the synchronization issue
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   
		   //Receiving the url from a text file in a list
		   List<String> mylink = Getlink.getURl();
		   
		   //Opening the first url
		   driver.get(mylink.get(0));
		   
		   
		   //Using sleep function to pause the execution for 2 seconds
		   try 
		  {
			Thread.sleep(2000);
		  }
		   catch (InterruptedException e) 
		  {
			e.printStackTrace();
		  }
		  
		   //Taking screenshot
		   TakeScreenshot(driver);
		   
	       //Clicking the alert button
	       executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@id = 'btnAlert']")));
	       
	       //Using sleep function to pause the execution for 2 seconds
	       try 
	      {
			Thread.sleep(2000);
	      }
		   catch (InterruptedException e) 
	      {
			e.printStackTrace();
		  }
	       
	       //Taking screenshot 
	       TakeScreenshot(driver);
	      
	       //Closing the alert by clicking ok button
	       executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[text()='Ok']"))); 
	       Thread.sleep(2000);
	       //Navigating to the second url
	       driver.navigate().to(mylink.get(1));
	       
	       //Using sleep function to pause the execution for 2 seconds
	       try 
	      {
			Thread.sleep(2000);
	      }
		   catch (InterruptedException e) 
	      {
		    e.printStackTrace();
		  }
	      
	       //Clicking the register link 
	       executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[text() = 'Register']")));
	      
	       //Taking screenshot
	       TakeScreenshot(driver);
	      
	       //Receiving data from excel file to fill the form and store it in a list
	       List<String> mydata = ExtractData.getData();
	 
	       //Entering the value of name
	       executor.executeScript("arguments[0].value='"+ mydata.get(0) +"';",driver.findElement(By.xpath("//input[@id = 'name' and @name = 'name']")));
	      
	       //Entering the value of address
	       executor.executeScript("arguments[0].value='"+ mydata.get(1) +"';",driver.findElement(By.xpath("//input[@id = 'address']")));
	      
	       //Clicking the gender
	       executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/label[4]/input")));
	      
	       //Clicking the hobby
	       executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@id = 'music']")));
	      
           //Selecting the option from dropdown
	       executor.executeScript("arguments[0].value ='"+ mydata.get(2)+"';",driver.findElement(By.xpath("//select[@id = 'country']")));
	       
	       //Selecting the option from dropdown
	       executor.executeScript("arguments[0].value ='"+ mydata.get(3)+"';",driver.findElement(By.xpath("//select[@id = 'city']")));
	    
           //Entering the value of date
	       driver.findElement(By.xpath("//input[@id = 'dob']")).sendKeys(mydata.get(4));
	      
	       //Scrolling the page to the bottom
	       executor.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	    
	       //Clicking the submit button
	       executor.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[contains(text(),'Submit')]")));
	       
	       //Taking screenshot
	       TakeScreenshot(driver);
	       
	       //Scrolling the page to the top
	       executor.executeScript("window.scroll(0,0)");
	      
	       //Taking screenshot
	       TakeScreenshot(driver);
	       
	       //Creating the variable to store the result
	       String actual_result = null;
	       
           try
          {
	        actual_result = driver.findElement(By.xpath("//*[@id=\"registration-form\"]/div/p")).getText();
          }
           catch(Exception e)
          {
        	   System.out.println("All data provided");
          }
           
           try
          {
    	    actual_result = driver.findElement(By.xpath("//*[@id=\"registration-form\"]/p")).getText();
          }
           catch(Exception e)
          {
        	   System.out.println("Some data was missing");
          }
           
	       String expected_result = "User registration successful.";
	       
	       //Verifying submission according to the result
	       if(actual_result.equals(expected_result))
	      { 
	    	 System.out.println(actual_result);
	    	 System.out.println("Submission is successful");
	    	 ExcelOutput.excelPrint(actual_result);
	    	 TextOutput.textPrint(actual_result);
	      }
	       else
	      {
	         System.out.println("Submission is unsuccessful");
	    	 ExcelOutput.excelPrint(actual_result);
	    	 TextOutput.textPrint(actual_result);
	      }
	       
	       //Quitting the driver
	       driver.quit();
	      
	  }
      
}

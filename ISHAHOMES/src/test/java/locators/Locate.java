package locators;

//Importing the required packages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Locate class with methods to click on various webelement like
 * Completed project;
 * Click On Enquire;
 * Click on VendorEnquiry;
 * Get Number of completed project by ishahomes;
 * Returning the first five project completed by them;
 * Getting mail id;
 * Closing the live chat pop up;
 */
public class Locate 
{
	static String outputToDocuments;
	public static void clickOnCompletedProjects(WebDriver driver)
	{
		//Clicking on the Completed Project option;
		driver.findElement(By.xpath("//*[@id='menu-item-25810']")).click();
	}
	
	public static int numberCompletedProjects(WebDriver driver)
	{
		//Finding the div of completed projet;
		WebElement completedProjectContainer = driver.findElement(By.xpath("//*[@id=\"boosted-tab-0\"]/div[1]/section/div/div"));

		//Storing the webelements of completed project from the container ;
		List<WebElement> completedProjectList = completedProjectContainer.findElements(By.partialLinkText("Isha"));
		
		return completedProjectList.size();
	}

	public static String[] nameOfProjects(WebDriver driver)
	{
		//Creating a String Array To Return the list of names of first five project;
		String[] projects = new String[5];
		
		//Finding the div of completed projet;
		WebElement completedProjectContainer = driver.findElement(By.xpath("//*[@id=\"boosted-tab-0\"]/div[1]/section/div/div"));

		//Storing the webelements of completed project from the container ;
		List<WebElement> completedProjectList = completedProjectContainer.findElements(By.partialLinkText("Isha"));

		//Adding the First Five From the List to the string array
		int counter=0;//TO Break the loop on the Sixth iteration;
		for(WebElement project : completedProjectList)
		{
			projects[counter] = project.getText();//Adding the First Five to the List;
			counter++;
			if(counter==5)
			{
				break;
			}
		}
		return projects;
	}

	public static void clickOnEnquire(WebDriver driver)
	{
		//Clicking on Enquire Now;
		driver.findElement(By.partialLinkText("Enquire Now")).click();
	}

	public static void clickOnVendorEnquiry(WebDriver driver)
	{
		//Clicking on Vendor enquiry;
		driver.findElement(By.partialLinkText("Vendor Enquiry")).click();
	}

	public static String getMail(WebDriver driver) 
	{
		//Returning the required email id.
		return driver.findElement(By.partialLinkText("@ishahomes.com")).getText();
	}
	public static void closeLiveChat(WebDriver driver)
	{
		//Closing the live chat only if it is present;
		try
		{
			driver.findElement(By.id("livchat_close")).click();
		}
		catch(Exception exception){}
	}
	

}

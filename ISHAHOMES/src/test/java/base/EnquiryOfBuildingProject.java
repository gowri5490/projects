package base;

//Importing All the required packages;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import driverSetup.DriverSetup;
import excel.ExcelUtility;
import locators.Locate;
import propertiesSetup.PropertiesUtility;
import screenShot.Screenshot;
import text.TextUtility;

/*
 * EnquiryOfBuildingProject Class
 * with main method for testing
 * which invokes all the other utility classes related to the project; 
 */

public class EnquiryOfBuildingProject
{
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		//Invoking the openBrowser() static method of DriverSetup class to lanuch the browser;
		WebDriver driver = DriverSetup.openBrowser();
		
		//Getting the URL from the PropertiesUtility class by invoking the static method getURL;
		String URL = PropertiesUtility.getURL();
		
		//Opening the url by static method openURL() of DriverSetup class;
		DriverSetup.openURL(URL);
		
		//Getting Screenshot of the Home page of ISHA Homes;
		Screenshot.captureScreenShot(driver,"HomePage");
		
		//List of String to store the output to write on excel and text file;
		List<String> outputToDocuments = new ArrayList<String>();
		
		//Closing the Live Chat 
		Locate.closeLiveChat(driver);
		
		//Screenshot of home after closing the live chat;
		Screenshot.captureScreenShot(driver,"HomePageWithoutLivechat");
		
		//Clicking on the Completed Project option;
		Locate.clickOnCompletedProjects(driver);
		
		//Closing the Live Chat 
		Locate.closeLiveChat(driver);
		
		//Screenshot of completed project page; 
		Screenshot.captureScreenShot(driver,"CompletedProject");
		
		//Printing the Total Completed Project;
		System.out.println("The Total Number Of Completed Project By ISHA HOMES Is : " + Locate.numberCompletedProjects(driver));

		//Appending the Output to the outputToDocuments List;
		outputToDocuments.add("The Total Number Of Completed Project By ISHA HOMES Is : " + Locate.numberCompletedProjects(driver));

		//Getting the array of string of completed projects;
		String[] projects = Locate.nameOfProjects(driver);
		
		//Printing the first five projects to the console and adding to the outputtodocument List;
		System.out.println("First Five Completed Project Of Isha Homes :");
		for(String project : projects)
		{
			System.out.println(project);
			outputToDocuments.add(project);
		}
				
		//Clicking on Enquire Now;
		Locate.clickOnEnquire(driver);
						
		//Screenshot after clicking Enquirenow;
		Screenshot.captureScreenShot(driver,"Enquirenow");
		
		//Clicking on Vendor enquiry;
		Locate.clickOnVendorEnquiry(driver);

		//Getting the Mail ID;
		String mailId = Locate.getMail(driver);
		System.out.println("Mail Id For Contacting ISHA HOMES : " + mailId);//Printing Mail Id of ISHA HOMES to console;
		outputToDocuments.add("Mail Id For Contacting ISHA HOMES : " + mailId);//Appending the Output to the outputToDocuments List;

		//ScreenShot of the Mail id page;
		Screenshot.captureScreenShot(driver,"VendorEmail");
		
		//Adding output to the EXCEL file;
		ExcelUtility.writeOutput(outputToDocuments);
		
		//Adding output to the TEXT file;
		TextUtility.writeOutput(outputToDocuments);
		
		//Closing the driver
		DriverSetup.closeBrowser(driver);
	}
}
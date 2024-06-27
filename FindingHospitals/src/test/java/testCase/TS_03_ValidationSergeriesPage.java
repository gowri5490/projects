package testCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TS_03_ValidationSergeriesPage extends BaseClass
{
	List<String> outputs = new ArrayList<String>();
	int i=1;
	@Test(priority=11)
	public void contactDetails() throws IOException 
	{	
		logger.info("*******TS_03_ValidationSergeriesPage has started*******");
		logger.info("*****TC_11 Print Contact Details has started*****");
		practoElements.clickOnSergeries();
		logger.info("clicked on 'Surgeries' header");
		String contact= sergeryElement.getContactInfo();
		logger.info("captured contact info");
		System.out.println("Practo Care Contact Is :" + contact);
		logger.info("displayed captured contact info");
		outputs.add("Practo Care Contact Is :" + contact);
		writer.writeText("Practo Care Contact Is :" + contact);
		String regex = "^[0-9]{11}$";
		capture.captureScreenShot(driver, "/Sergeries/contact");
		Assert.assertEquals(contact.matches(regex), true); 
		logger.info("*****TC_11 Print Contact Details has been closed*****");
	}

	@Test(priority=12)
	public void practoCareBenifits() throws IOException, InterruptedException 
	{
		logger.info("*****TC_12 Print Practo Care Benefits Details has started*****");
		practoElements.clickOnSergeries();
		logger.info("clicked on 'Surgeries' header");
		js.executeScript("window.scrollBy(0,2850)");
		boolean benifits= sergeryElement.isBenefitsAvailable();
		logger.info("checking Practo Care Benefits details are present or not");
		System.out.println("Practo Care Benifits is visible :"+benifits);
		writer.writeText("Practo Care Benifits is visible :"+benifits);
		outputs.add("Practo Care Benifits is visible :"+benifits);
		List<WebElement> allBenefits =sergeryElement.getBeneDescription();
		logger.info("captured practo care benefits description");
		System.out.println("Care Benefits:");
		outputs.add("Care Benefits:");
		writer.writeText("Care Benefits:");
		for(WebElement x : allBenefits)
		{
			System.out.println(x.getText());
			writer.writeText(x.getText());
			outputs.add(x.getText());
		}
		logger.info("displayed practo care benefits desciption");
		capture.captureScreenShot(driver, "/Sergeries/Care Benefits");
		Assert.assertEquals(benifits, true);
		logger.info("*****TC_12 Print Practo Care Benefits Details has been closed*****");
	}

	@Test(priority=13)
	public void howItWorks() throws IOException
	{
		logger.info("*****TC_13 Print How It Works Details has started*****");
		practoElements.clickOnSergeries();
		logger.info("clicked on 'Surgeries' header");
		js.executeScript("window.scrollBy(0,3950)");
		boolean working= sergeryElement.isHowItWorkAvailable();
		logger.info("checking How It Works available or not");
		System.out.println("working is visible :"+working);
		writer.writeText("working is visible :"+working);
		outputs.add("working is visible :"+working);
		System.out.println("How It Works:");
		writer.writeText("How It Works:");
		outputs.add("How It Works:");
		List<WebElement> workDec =sergeryElement.getHowItWork();
		logger.info("captured How It Works list");
		for(WebElement x : workDec)
		{
			System.out.println(x.getText());
			writer.writeText(x.getText());
			outputs.add(x.getText());
		}
		logger.info("displayed How It Works list");
		capture.captureScreenShot(driver, "/Sergeries/How It Works");
		Assert.assertEquals(working, true);
		logger.info("*****TC_13 Print How It Works Details has been closed*****");

	}
	
	@Test(priority=14)
	public void allSurgeries() throws IOException
	{
		logger.info("*****TC_14 Print All Surgeries list has started*****");
		practoElements.clickOnSergeries();
		logger.info("clicked on 'Surgeries' header");
		js.executeScript("window.scrollBy(0,750)");
		List<WebElement> segeries =sergeryElement.getSugeries();
		logger.info("captured All surgeries list");
		System.out.println("All Sergeries:");
		writer.writeText("All Sergeries:");
		outputs.add("All Sergeries:");
		for(WebElement x : segeries)
		{
			System.out.println(x.getText());
			writer.writeText(x.getText());
			outputs.add(x.getText());
		}
		logger.info("displayed All surgeries list");
		capture.captureScreenShot(driver, "/Sergeries/Surgeries");
		Assert.assertEquals(segeries.size()>0, true);
		logger.info("*****TC_14 Print All Surgeries list has been closed*****");
	}
	
	@Test(priority=15)
	public void allDepartment() throws IOException
	{
		logger.info("*****TC_15 Print All Departments list has started*****");
		practoElements.clickOnSergeries();
		logger.info("clicked on 'Surgeries' header");
		js.executeScript("window.scrollBy(0,1300)");
		List<WebElement> departments =sergeryElement.getDepartment();
		logger.info("captured All departments list");
		System.out.println("All Departments: ");
		writer.writeText("All Departments: ");
		outputs.add("All Departments: ");
		for(WebElement x : departments)
		{
			System.out.println(x.getText());
			writer.writeText(x.getText());
			outputs.add(x.getText());
		}	
		logger.info("displayed All departments list");
		excel.write(outputs, "Test-Scenario-3");
		capture.captureScreenShot(driver, "/Sergeries/Departments");
		Assert.assertEquals(departments.size()>0, true);
		logger.info("*****TC_15 Print All Departments list has been closed*****");
		logger.info("*******TS_03_ValidationSergeriesPage has been closed*******");
	}
}

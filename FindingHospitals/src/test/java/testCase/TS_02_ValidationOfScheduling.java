package testCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testBase.BaseClass;
import utilities.ExcelUtilities;

public class TS_02_ValidationOfScheduling extends BaseClass
{
	List<String> outputs = new ArrayList<String>();
	int i=1;
	@DataProvider(name = "data")
	public String[][] getDetails() throws IOException
	{
		ExcelUtilities excel = new ExcelUtilities(); 
		String[][] data = excel.getData();
		return data;
	}
	public void fillCommonDetails(String name,String company,String org,String interest) throws InterruptedException
	{
		employeeElements.enterName(name);
		employeeElements.enterOrganization(company);
		employeeElements.selectOrgSize(org);
		employeeElements.selectInterestedIn(interest);
	}

	@Test(priority = 6)
	public void isHealthIsClickable() throws IOException
	{
		logger.info("*******TS_02_ValidationOfScheduling has started*******");
		logger.info("*****TC_06 Health Menu Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		practoElements.clickOnCorporate();
		logger.info("clicked on Corporates");
		practoElements.clickOnHealth();
		logger.info("clicked on Health & Wellness plans");
		System.out.println(driver.getTitle());
		logger.info("captured the title after clicking");
		writer.writeText(driver.getTitle());
		outputs.add(driver.getTitle());
		capture.captureScreenShot(driver, "/Scheduling/Schedule Page");
		Assert.assertEquals(driver.getTitle().contains("Health & Wellness Plans"),true);
		logger.info("*****TC_06 Health Menu Validation has been closed*****");
	}
	@Test(priority =7,dataProvider = "data")
	public void withAllValidDetails(String[] data) throws IOException, InterruptedException 
	{
		logger.info("*****TC_07 Form Validation has started*****");
		outputs.add("TEST-CASE-"+i);
		practoElements.clickOnCorporate();
		logger.info("clicked on Corporates");
		practoElements.clickOnHealth();
		logger.info("clicked on Health & Wellness plans");
		fillCommonDetails(data[0],data[1],data[2],data[3]);
		logger.info("filled form with common details");
		employeeElements.enterContact(data[4]);
		logger.info("filled phone number details");
		employeeElements.enterEmail(data[5]);
		logger.info("filled email id details");
		logger.info("checking whether submit button is enabled");
		if((employeeElements.getSubmitElement()).isEnabled())
		{
			logger.info("submit button is enabled");
			System.out.println("Submit Button Is Clickable");
			writer.writeText("Submit Button Is Clickable");
			outputs.add("Submit Button Is Clickable");
		}
		else
		{
			logger.info("submit button is disabled");
			System.out.println("Submit Button Not Clickable");
			writer.writeText("Submit Button Not Clickable");
			outputs.add("Submit Button Not Clickable");
		}
		capture.captureScreenShot(driver, "/Scheduling/Form"+i++);
		Assert.assertEquals((employeeElements.getSubmitElement()).isEnabled(),Boolean.parseBoolean(data[6].replace("z","")));
		logger.info("*****TC_07 Form Validation has been closed*****");
	}
	@Test(priority = 8)
	public void validationOfThankYouMessage() throws IOException, InterruptedException 
	{
		logger.info("*****TC_08 Thank You Message Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		practoElements.clickOnCorporate();
		logger.info("clicked on Corporates");
		practoElements.clickOnHealth();
		logger.info("clicked on Health & Wellness plans");
		String[] detail = details.split(" ");
		fillCommonDetails(detail[0],detail[1],detail[2],detail[3].replace("-", " "));
		logger.info("filled form with common details");
		employeeElements.enterContact(detail[4]);
		logger.info("filled phone number details");
		employeeElements.enterEmail(detail[5]);
		logger.info("filled email id details");
		employeeElements.clickOnSubmit();
		logger.info("clicked on submit button");
		//For Captcha
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualMessage = employeeElements.getConformationMessage();
		logger.info("captured thank you message");
		System.out.println(actualMessage);
		writer.writeText(actualMessage);
		outputs.add(actualMessage);
		excel.write(outputs, "Test-Scenario-2");
		capture.captureScreenShot(driver, "/Scheduling/Thank You Message");
		Assert.assertEquals(actualMessage, "THANK YOU");
		logger.info("*****TC_08 Thank You Message Validation has been closed*****");
	}
}


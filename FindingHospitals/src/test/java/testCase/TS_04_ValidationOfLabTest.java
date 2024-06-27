package testCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;

public class TS_04_ValidationOfLabTest extends BaseClass
{
	List<String> outputs = new ArrayList<String>();
	int i=1;
	@Test(priority = 16)
	public void isLabTestclickable() throws IOException 
	{
		logger.info("*******TS_04_ValidationOfLabTest has started*******");
		logger.info("*****TC_16 Lab Test Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		practoElements.clickOnLabTest();
		logger.info("clicked on 'Lab Tests' header");
		labElements.clickOnACity();
		logger.info("clicked on a city");
		System.out.println(driver.getTitle());
		logger.info("captured the title of the page after clicking city");
		writer.writeText(driver.getTitle());
		outputs.add(driver.getTitle());
		capture.captureScreenShot(driver, "/Labtest/Lap-test");
		Assert.assertEquals(driver.getTitle(), "Blood Tests | Book Diagnostic Tests from Home at Best Prices | Practo","Didn't Navigate To Required Page");
		logger.info("*****TC_16 Lab Test Validation has been closed*****");
	}
	
	@Test(priority = 17)
	public void topCitiesBlockAvailable() throws IOException
	{
		logger.info("*****TC_17 Top Cities Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		practoElements.clickOnLabTest();
		List <WebElement> topCities = labElements.getTopCitiesList();
		logger.info("captured top cities list");
		System.out.println("Top Cities Are:");
		writer.writeText("Top Cities Are:");
		outputs.add("Top Cities Are:");
		for(WebElement x : topCities)
		{
			System.out.println(x.getText());
			writer.writeText(x.getText());
			outputs.add(x.getText());
		}
		logger.info("displayed top cities list");
		capture.captureScreenShot(driver, "/Labtest/Top-Cities");
		Assert.assertEquals(topCities.size()>0,true,"No Top Cities");	
		logger.info("*****TC_17 Top Cities Validation has been closed*****");
	}
	
	@Test(priority = 18)
	public void allCitiesBlockAvailable() throws IOException
	{
		logger.info("*****TC_18 All Cities Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		practoElements.clickOnLabTest();
		logger.info("clicked on 'Lab Tests' header");
		System.out.println("All Cities Are:");
		writer.writeText("All Cities Are:");
		outputs.add("All Cities Are:");
		List <WebElement> allCities = labElements.getAllCitiesList();
		logger.info("captured all cities list");
		for(WebElement x : allCities)
		{
			System.out.println(x.getText());
			writer.writeText(x.getText());
			outputs.add(x.getText());
		}
		logger.info("displayed all cities list");
		capture.captureScreenShot(driver, "/Labtest/All-Cities");
		Assert.assertEquals(allCities.size()>0,true,"All Cities Name Not Present");	
		logger.info("*****TC_18 All Cities Validation has been closed*****");
	}
	
	@Test(priority = 19)
	public void needHelpBlockValidation() throws IOException 
	{
		logger.info("*****TC_19 Need Help Block Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		practoElements.clickOnLabTest();
		logger.info("clicked on 'Lab Tests' header");
		labElements.clickOnACity();
		logger.info("clicked on a city");
		String contactNumber = labElements.getContactInfo();
		logger.info("captured contact information");
		System.out.println("Contact Number For Labtest Booking Help: "+contactNumber);
		writer.writeText("Contact Number For Labtest Booking Help: "+contactNumber);
		outputs.add("Contact Number For Labtest Booking Help: "+contactNumber);
		logger.info("displayed contact information");
		String regex = "^\\+[0-9]{2} [0-9]{10}";
		capture.captureScreenShot(driver, "/Labtest/Contact");
		Assert.assertEquals(contactNumber.matches(regex),true);
		logger.info("*****TC_19 Need Help Block Validation has been closed*****");
	}
	
	@Test(priority = 20)
	public void addToCartValidation() throws IOException, InterruptedException
	{
		logger.info("*****TC_20 Add to Cart Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		practoElements.clickOnLabTest();
		logger.info("clicked on 'Lab Tests' header");
		labElements.clickOnACity();
		logger.info("clicked on a random city");
		Thread.sleep(2000);
		myWait.until(ExpectedConditions.visibilityOf(labElements.contactElement()));
		List <WebElement> testList = labElements.getAddToCartWebElements();
		logger.info("captured elements that can be added list");
		for(WebElement addToCart : testList)
		{
			Thread.sleep(2000);
			builder.scrollToElement(addToCart);
			Thread.sleep(2000);
			js.executeScript("arguments[0].click()",addToCart);
			break;
		}
		logger.info("added elements to the cart");
		int inCartElements = labElements.numberOfItemInCart() ;
		logger.info("captured number of items in cart");
		System.out.println("Number Of Element Added To Cart: "+inCartElements);
		writer.writeText("Number Of Element Added To Cart: "+inCartElements);
		outputs.add("Number Of Element Added To Cart: "+inCartElements);
		logger.info("displayed size of cart");
		excel.write(outputs, "Test-Scenario-4");
		capture.captureScreenShot(driver, "/Labtest/Cart");
		Assert.assertEquals(inCartElements, 1);
		logger.info("*****TC_20 Add to Cart Validation has been closed*****");
		logger.info("*******TS_04_ValidationOfLabTest has been closed*******");
	}
}

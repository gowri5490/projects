package testCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TS_01_ValidationOfHomePage extends BaseClass
{
	int i=1;
	List<String> outputs = new ArrayList<String>();
	@Test(priority =1)
	public void logoValidation() throws IOException
	{
		logger.info("*******TS_01_ValidationOfHomePage has started*******");
		logger.info("*****TC_01 LogoValidation has started*****");
		outputs.add("TEST-CASE-"+i++);
		Boolean displayed = practoElements.isLogoPresent();
		logger.info("checking logo is present or not");
		if(displayed)
		{
			logger.info("logo is present");
			System.out.println("Logo is present.");
			writer.writeText("Logo is present.");
			outputs.add("Logo is present.");
		}
		capture.captureScreenShot(driver, "/HomePage/Logo");
		Assert.assertEquals(displayed,true,"The logo is not displayed!!!");
		logger.info("*****TC_01 LogoValidation has been closed*****");
	}

	@Test(priority = 2)
	public void downloadValidation() throws IOException
	{
		logger.info("*****TC_02 Download Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight-1000)");
		Boolean displayed = practoElements.isDownloadOptionPresent();
		logger.info("checking download option is present or not");
		if(displayed)
		{
			logger.info("download option is present");
			System.out.println("Download option is present.");
			writer.writeText("Download option is present.");
			outputs.add("Download option is present.");
		}
		capture.captureScreenShot(driver, "/HomePage/Download button");
		Assert.assertEquals(displayed,true,"The Download Option is not displayed!!!");	
		logger.info("*****TC_02 Download Validation has been closed*****");
	}

	@Test(priority = 3)
	public void copyRightValidation() throws IOException 
	{
		logger.info("*****TC_03 CopyRight Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Boolean copyright = practoElements.isCopyRightsDetailsPresent();
		logger.info("checking copyright details are present or not");
		capture.captureScreenShot(driver, "/HomePage/Copyrights");
		if(copyright)
		{
			logger.info("copyright details present");
			System.out.println("The Copyright Is There.");
			writer.writeText("The Copyright Is There.");
			outputs.add("The Copyright Is There.");
			Assert.assertTrue(copyright);
		}
		else 
		{
			logger.error("copyright details are not present");
			outputs.add("TEST-CASE-"+i++);
			System.out.println("Copyright Is Not There!!");
			writer.writeText("Copyright Is Not There!!");
			outputs.add("Copyright Is Not There!!");
			Assert.fail();		
		}
		logger.info("*****TC_03 CopyRight Validation has been closed*****");

	}

	@Test(priority = 4)
	public void loginValidation() throws IOException
	{
		logger.info("*****TC_04 Login Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		Boolean loginSignup = practoElements.isLoginIsPresent();
		logger.info("checking login button is present or not");
		if(loginSignup)
		{
			logger.info("login button is present");
			System.out.println("The Log in Button Is Present");
			writer.writeText("The Log in Button Is Present");
			outputs.add("The Log in Button Is Present");
		}
		capture.captureScreenShot(driver, "/HomePage/Login or Signup button");
		Assert.assertEquals(true, loginSignup,"Login/Signup button is not there!!");
		logger.info("*****TC_04 Login Validation has been closed*****");
	}

	@Test(priority = 5)
	public void functionalityValidation() throws IOException
	{
		logger.info("*****TC_05 Functionality Validation has started*****");
		outputs.add("TEST-CASE-"+i++);
		List<WebElement> functionalities = practoElements.getFunctionalityContainer();
		logger.info("captured list of functionalities");
		System.out.println("Functionalities are:");
		outputs.add("Functionalities are:");
		writer.writeText("Functionalities are:");
		for(WebElement x:functionalities)
		{
			System.out.println(x.getText());
			writer.writeText(x.getText());
			outputs.add(x.getText());

		}
		logger.info("displayed list of functionalities");
		excel.write(outputs, "Test-Scenario-1");
		capture.captureScreenShot(driver, "/HomePage/Functionalities");
		Assert.assertEquals(functionalities.size()>0,true,"Not Present");
		logger.info("*****TC_05 Functionality Validation has been closed*****");
		logger.info("*******TS_01_ValidationOfHomePage has been closed*******");
	}

}

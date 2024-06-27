package pageObject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeCognizantHome extends TestBasePage
{
	public BeCognizantHome(WebDriver driver) 
	{
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
	
	By helpbutton=By.xpath("//*[@id='O365_MainLink_Help']");
	
	By username=By.xpath("//*[@id='mectrl_currentAccount_primary']");
	
	@FindBy(xpath="//*[@id='O365_MainLink_Me']")
	WebElement userinfo;
	
	@FindBy(xpath="//*[@id='mectrl_currentAccount_primary']") 
	WebElement lable_username_loc;
	
	@FindBy(xpath="//*[@id='mectrl_currentAccount_secondary']") 
	WebElement lable_email_loc;
	
	@FindBy(xpath = "//div[contains(@class,'ms-OverflowSet-item item')]//button[@name='Corporate Functions']")
	WebElement drop_corporate_loc;
	
	@FindBy(xpath = "//span[text()='Security and Technology']")
	WebElement drop_sequrity_loc;
	
	@FindBy(xpath = "//div[@title='IT']")
	WebElement drop_it_loc;
	
	//Actions
	public String getUserDetails() throws InterruptedException, IOException
	{
		myWait.until(ExpectedConditions.elementToBeClickable(helpbutton));  //wait till help button displayed
		Thread.sleep(5000);
		userinfo.click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(username));//wait till user name displayed
		capture.captureScreenShot(driver, "User Details");
		System.out.println(lable_username_loc.getText());
		outputs.add(lable_username_loc.getText());
		writer.writeText(lable_username_loc.getText());
		System.out.println(lable_email_loc.getText());
		writer.writeText(lable_email_loc.getText());
		outputs.add(lable_email_loc.getText());
		return lable_email_loc.getText();
	}
	
	public void clickOnCorporate() throws InterruptedException
	{
		drop_corporate_loc.click();
	}
	public void clickOnSequrity() throws InterruptedException
	{
		drop_sequrity_loc.click();
	}
	public void clickOnIT() throws InterruptedException
	{
		Thread.sleep(1000);
		drop_it_loc.click();
	}
	public String getTitel() throws Exception
	{
		capture.captureScreenShot(driver, "BeCognizant Homepage");
		clickOnCorporate();
		clickOnSequrity();
		clickOnIT();
		capture.captureScreenShot(driver, "After Clicking On IT");
		myWait.until(ExpectedConditions.titleContains("Global"));
		System.out.println("Title of page: "+driver.getTitle());
		writer.writeText("Title of page: "+driver.getTitle());
		outputs.add("Title of page: "+driver.getTitle());
		return driver.getTitle();
	}

}

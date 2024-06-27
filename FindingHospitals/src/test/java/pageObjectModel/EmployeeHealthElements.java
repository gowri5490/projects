package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EmployeeHealthElements extends BasePage
{
	public EmployeeHealthElements(WebDriver driver)
	{
		super(driver);
	}
	
	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	@FindBy(xpath = "//*[@id='name']")
	WebElement txt_name_loc;
	
	@FindBy(xpath = "//*[@id='organizationName']")
	WebElement txt_orgname_loc;
	
	@FindBy(xpath = "//input[@id = 'contactNumber']")
	WebElement txt_contact_loc;
	
	@FindBy(xpath = "//input[@id = 'officialEmailId']")
	WebElement txt_email_loc;
	
	By drop_size_loc = By.id("organizationSize");
	
	By drop_interested_loc = By.id("interestedIn");
	
	@FindBy(xpath = "//button[contains(text(), 'Schedule a demo')]")
	WebElement btn_submit_loc;
	
	@FindBy(xpath = "//div[@class='u-text--bold text-alpha']")
	WebElement lab_thank_loc;
	
	public void enterName(String name)
	{
		txt_name_loc.sendKeys(name);
	}
	
	public void enterOrganization(String orgname)
	{
		txt_orgname_loc.sendKeys(orgname);
	}
	
	public void enterContact(String phnum)
	{
		txt_contact_loc.sendKeys(phnum);
	}
	
	public void enterEmail(String mail)
	{
		txt_email_loc.sendKeys(mail);
	}
	
	
	public void clickOnSubmit()
	{
		btn_submit_loc.click();
	}
	
	public WebElement getSubmitElement()
	{
		return btn_submit_loc;
	}
	
	public void selectOrgSize(String option)
	{
		WebElement organizationSize = myWait.until(ExpectedConditions.visibilityOfElementLocated(drop_size_loc));
		Select organization = new Select(organizationSize);
        organization.selectByVisibleText(option);
	}
	
	public void selectInterestedIn(String option)
	{
		WebElement interestedIn = myWait.until(ExpectedConditions.visibilityOfElementLocated(drop_interested_loc));
		Select organization = new Select(interestedIn);
        organization.selectByVisibleText(option);
	}
	
	public String getConformationMessage()
	{
		return lab_thank_loc.getText();
	}
}

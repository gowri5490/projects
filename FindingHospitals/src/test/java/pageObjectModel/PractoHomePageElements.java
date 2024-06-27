package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PractoHomePageElements extends BasePage
{
	public PractoHomePageElements(WebDriver driver)
	{
		super(driver);
	}

	@FindBy( xpath = "//div[@class='product-tab__title' and text()='Lab Tests']" )
	WebElement btn_labTest_loc;
	
	@FindBy( xpath = "//span[@class='nav-interact']" )
	WebElement btn_corporate_loc;
	
	@FindBy( xpath = "//a[@class='nav-interact' and contains(text(),'Health')]" )
	WebElement btn_health_loc;
	
	@FindBy( xpath = "//div[@class='product-tab__title' and text()='Surgeries']" )
	WebElement btn_sergeries_loc;
	
	@FindBy( xpath = "//span[@class='practo-logo']" )
	WebElement img_logo_loc;
	
	@FindBy( xpath = "//div[@class='downloads']" )
	WebElement lab_download_loc;
	
	@FindBy( xpath = "//div[@class='c-copyright']" )
	WebElement lab_copy_loc;
	
	@FindBy( xpath = "//a[@class='btn-border nav-login nav-interact ']" )
	WebElement btn_login_loc;
	
	@FindBy( xpath = "//div[@class='row-1 u-font--bold u-font--20 u-t-c--grey_7']" )
	List <WebElement> con_functionality_loc;
	
	public void clickOnLabTest()
	{
		btn_labTest_loc.click();
	}
	
	public void clickOnCorporate()
	{
		btn_corporate_loc.click();
	}
	
	public void clickOnHealth()
	{
		btn_health_loc.click();
	}
	
	public void clickOnSergeries()
	{
		btn_sergeries_loc.click();
	}
	
	public boolean isLogoPresent()
	{
		return img_logo_loc.isDisplayed();
	}
	
	public boolean isDownloadOptionPresent()
	{
		return lab_download_loc.isDisplayed();
	}
	
	public boolean isCopyRightsDetailsPresent()
	{
		return lab_copy_loc.isDisplayed();
	}
	
	public boolean isLoginIsPresent()
	{
		return btn_login_loc.isDisplayed();
	}
	
	public List<WebElement> getFunctionalityContainer()
	{
		return con_functionality_loc;
	}
	
}

package pageObjectModel;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LabTestPageElements extends BasePage
{

	public LabTestPageElements(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy( xpath = "//div[contains(@class,'city-selector__city ')][4]" )
	WebElement btn_randomCity_loc;
	
	@FindBy( xpath = "//div[text()='TOP CITIES']//following::ul/li" )
	List <WebElement> con_topCities_loc;
	
	@FindBy( xpath = "//div[contains(@class,'city-selector__city ')]" )
	List <WebElement> con_allCities_loc;
	
	@FindBy( xpath = "//div[@class='call-to-order__cta-text']" )
	WebElement lab_contactNumber_loc;
	
	@FindBy( xpath = "//div[text()='ADD']" )
	List <WebElement> con_addToCart_loc;
	
	@FindBy( xpath = "//span[contains(@class,'c-home-v2--cart-tests')]" )
	WebElement lab_numberOfItemAddedToCart_loc;
	
	public void clickOnACity()
	{
		btn_randomCity_loc.click();
	}
	
	public List<WebElement> getTopCitiesList()
	{
		return con_topCities_loc;
	}
	
	public List<WebElement> getAllCitiesList()
	{
		return con_allCities_loc;
	}
	
	public String getContactInfo()
	{
		return lab_contactNumber_loc.getText();
	}
	
	public List<WebElement> getAddToCartWebElements()
	{
		return con_addToCart_loc;
	}
	
	public int numberOfItemInCart()
	{
		return Integer.parseInt(lab_numberOfItemAddedToCart_loc.getText());
	}
	public WebElement contactElement()
	{
		return lab_contactNumber_loc;
	}
}

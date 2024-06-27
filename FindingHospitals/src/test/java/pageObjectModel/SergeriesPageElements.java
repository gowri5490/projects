package pageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SergeriesPageElements extends BasePage
{

	public SergeriesPageElements(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy( xpath = "//h1[@class='text-module_base__1vdUh text-white-1 font-bold']" )
	WebElement lab_contact_loc;
	
	@FindBy( xpath = "//h1[@class='text-module_base__1vdUh text-24px mb-12px font-bold']" )
	WebElement lab_benefits_loc;
	
	@FindBy( xpath = "//h1 [@class='text-module_base__1vdUh font-bold mb-12px text-24px']" )
	WebElement lab_work_loc;
	
	@FindBy(xpath = "//div[@class='list-module_itemContent__QEeb7']/h1")
	List<WebElement> con_desc_loc;
	
	@FindBy(xpath = "//div[@class='list-module_itemContent__QEeb7 w-5/6 pb-20px pt-8px']/h1")
	List<WebElement> con_work_loc;
	
	@FindBy(xpath = "//div[@class='rounded-12px border-white-2 border']//p")
	List<WebElement> con_surgery_loc;
	
	@FindBy(xpath = "//h1[@class='text-module_base__1vdUh text-16px font-bold text-black']")
	List<WebElement> con_dep_loc;
	
	public String getContactInfo()
	{
		return lab_contact_loc.getText();
	}
	
	public boolean isBenefitsAvailable()
	{
		return lab_benefits_loc.isDisplayed();
	}
	
	public boolean isHowItWorkAvailable()
	{
		return lab_work_loc.isDisplayed();
	}
	
	public List<WebElement> getBeneDescription()
	{
		return con_desc_loc;
	}
	
	public List<WebElement> getHowItWork()
	{
		return con_work_loc;
	}
	
	public List<WebElement> getSugeries()
	{
		return con_surgery_loc;
	}
	
	public List<WebElement> getDepartment()
	{
		return con_dep_loc;
	}
	
	
	
}

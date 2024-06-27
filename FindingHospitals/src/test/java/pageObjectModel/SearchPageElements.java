package pageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageElements extends BasePage
{
	public SearchPageElements(WebDriver driver) 
	{
		super(driver);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
	WebElement loc_searchbox;
	
	@FindBy(xpath="//div[@id='c-omni-container']/div/div[1]/div//input")
	WebElement loc_ans;
	
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-city'][1]")
	WebElement loc_searchRes;
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement prof_searchbox;
	
	@FindBy(xpath="//div[@data-qa-id='omni-suggestions-list']/div/div[1]")
	WebElement prof_res;
	
	@FindBy(xpath="//div[@data-qa-id='no_results_heading']/span")
	WebElement invalid_search_capture;
	
	@FindBy(xpath="//h1[@class='u-xx-large-font u-bold']")
	WebElement validatelocation;
	
	@FindBy(xpath="//div[@role='button' and @data-qa-id='doctor_gender_section']")
	WebElement genderDropdown;
	
	@FindBy(xpath="//li[@data-qa-id='male']")
	WebElement genderSelection;
	
	@FindBy(xpath="//div[@role='button'][2]")
	WebElement patientStoriesDropdown;
	
	@FindBy(xpath="//ul[@data-qa-id='doctor_review_count_list']/li[@class='c-dropdown__list__item'][1]")
	WebElement patientStoriesSelection;
	
	@FindBy(xpath="//div[@role='button'][3]")
	WebElement experienceDropdown;
	
	@FindBy(xpath="//li[@aria-label='5+ Years of experience']")
	WebElement experienceSelection;
	
	@FindBy(xpath="//div[@role='button'][4]")
	WebElement AllfiltersDropdown;
	
	@FindBy(xpath="//label[2]//div[@data-qa-id='Fees_radio']")
	WebElement feesSelection;
	
	@FindBy(xpath="//span/span[contains(text(), 'Male Doctor')]")
	WebElement validateGender;
	
	@FindBy(xpath="//span//span[contains(text(),'Patient Stories')]")
	WebElement validatePatientStories;
	
	@FindBy(xpath="//span//span[contains(text(),'5+ Years of experience')]")
	WebElement validateExperience;
	
	@FindBy(xpath="//div[@class='u-grey_3-text']//div[@class='u-d-flex']//span")
	List<WebElement> prof_list;
	
	@FindBy(className="listing-doctor-card")
	List<WebElement> resultlist;
	
	WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
	public void search(String location) throws InterruptedException
	{
		WebElement search =  myWait.until(ExpectedConditions.visibilityOf(loc_searchbox));
		search.clear();
		myWait.until(ExpectedConditions.visibilityOf(loc_searchbox));
		search.sendKeys(location);
		WebElement searchresult =  myWait.until(ExpectedConditions.visibilityOf(loc_searchRes));
		searchresult.click();
	}
	public void profession(String prof) throws InterruptedException
	{
		WebElement search =  myWait.until(ExpectedConditions.visibilityOf(prof_searchbox));
		search.clear();
		myWait.until(ExpectedConditions.visibilityOf(prof_searchbox));
		search.sendKeys(prof);
		Thread.sleep(2000);
		WebElement searchresult =  myWait.until(ExpectedConditions.visibilityOf(prof_res));
		js.executeScript("arguments[0].click()", searchresult);
	}
	public String invalidSearch() throws InterruptedException
	{
		return invalid_search_capture.getText();
	}
	
	public String matchLocation() throws Exception
	{
		Thread.sleep(1000);
		return validatelocation.getText();
 	}
	public void automateGenderDropdown()
	{
		genderDropdown.click();
		genderSelection.click();
	}
	public void automatepatientStoriesDropdown()
	{
		patientStoriesDropdown.click();
	    patientStoriesSelection.click();
	}
	public void automateExperienceDropdown()
	{
		experienceDropdown.click();
		experienceSelection.click();
	}
	public String genderDropdown()
	{
		
		return genderSelection.getText();
	}
	public String patientStoriesDropdown()
	{
		
		return patientStoriesSelection.getText();
	}
	public String experienceDropdown()
	{
		
		return experienceSelection.getText();
	}
	public void fees()
	{
		AllfiltersDropdown.click();
		feesSelection.click();
	}
	public String genderValidation()
	{
		return validateGender.getText();
	}
	public String patientStoriesValidation()
	{
		return validatePatientStories.getText();
	}
	public String experienceValidation()
	{
		return validateExperience.getText();
	}
	
	public String getCities()
	{
		return loc_ans.getAttribute("value");
	}
	public List<WebElement> professionVerification()
	{
		return prof_list;
	}
	public List<WebElement> printDoctorsDetails()
	{
		return resultlist;
	}


}

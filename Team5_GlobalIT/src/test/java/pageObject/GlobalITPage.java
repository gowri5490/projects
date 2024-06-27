package pageObject;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtility;

public class GlobalITPage extends TestBasePage
{
	public GlobalITPage(WebDriver driver)
	{
		super(driver);
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//*[@data-automation-id='HeroTitle']")
	List<WebElement> container_app_loc;
	
	@FindBy(xpath = "//div[@data-automation-id='CanvasLayout']/div[2]//span[@role='heading']")
	WebElement lable_news_loc;
	
	@FindBy(id = "it-awards")
	WebElement lable_awards_loc;
	
	@FindBy(xpath = "//div[@data-theme-emphasis='1']//div[@data-automation-id='BaseCollection-FreshData']//a[@data-automation-id='newsItemTitle']")
	List <WebElement> container_news_loc;
	
	@FindBy(xpath = "//div[contains(@class, 'itemArea')]")
	List<WebElement> container_awards_loc;
	
	
	//Action
	public String[] getAppName() throws Exception
	{
		capture.captureScreenShot(driver, "Apps");
		int i = 0;
		String[] apps  = new String[container_app_loc.size()];
		System.out.println("Apps present are:");
		for(WebElement app : container_app_loc)
		{
			System.out.println(app.getText());
			writer.writeText(app.getText());
			outputs.add(app.getText());
			apps[i++]=app.getText();
		}
		return apps;
	}
	
	public String getLableTextOfNews() throws Exception
	{
		js.executeScript("document.querySelector('article>div>div').scrollTop=800");
		Thread.sleep(2000);
		capture.captureScreenShot(driver, "News Section");
		System.out.println("Lable: "+lable_news_loc.getText());
		writer.writeText("Lable: "+lable_news_loc.getText());
		outputs.add("Lable: "+lable_news_loc.getText());
		return lable_news_loc.getText();
	}
	
	public String getLableTextOfAwards() throws Exception
	{
		js.executeScript("document.querySelector('article>div>div').scrollTop=1900");
		Thread.sleep(2000);
		capture.captureScreenShot(driver, "Awards Section");
		System.out.println("Lable: "+lable_awards_loc.getText());
		writer.writeText("Lable: "+lable_awards_loc.getText());
		outputs.add("Lable: "+lable_awards_loc.getText());
		return lable_awards_loc.getText();
	}
	
	public void printNumberOfNews() throws Exception
	{
		System.out.println("Total news:"+container_news_loc.size());
		writer.writeText("Total news:"+container_news_loc.size());
		outputs.add("Total news:"+container_news_loc.size());
	}
	
	public int getNumberOfMismatchingTooltip() throws Exception
	{
		js.executeScript("document.querySelector('article>div>div').scrollTop=800");
		printNumberOfNews();
		int mismatchCount = 0;
		for(WebElement x : container_news_loc)
		{
			String actualMessage=x.getText();
			String tooltip = x.getAttribute("title");
			if(!(actualMessage.equals(tooltip))) 
			{
				System.out.println(actualMessage);
				mismatchCount++;
			}
		}
		if(mismatchCount==0)
		{
			System.out.println("All Tool Tips Are Verified Correctly.");
			writer.writeText("All Tool Tips Are Verified Correctly.");
			outputs.add("All Tool Tips Are Verified Correctly.");
			ExcelUtility.write(outputs);
		}
		return mismatchCount;
	}
}

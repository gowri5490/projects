package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AwardsPage extends GlobalITPage
{

	public AwardsPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath = "//div[@id='spPageCanvasContent']//div[@data-automation-id='Canvas']/div/div[1]/div/div/div[2]//p")
	List<WebElement> container_content_loc;
	
	public int printAndReturnContentsCount() throws InterruptedException
	{
		int contentAvailable = 0;
		js.executeScript("document.querySelector('article>div>div').scrollTop=2000");
		List<WebElement> awards = driver.findElements(By.xpath("//div[contains(@class, 'itemArea')]"));
		System.out.println(awards.size());
		for(int i = 1;i<=awards.size();i++)
		{
			Thread.sleep(2000);
			WebElement element=driver.findElement(By.xpath("//div[contains(@class,'itemArea')]["+i+"]//a[@role='presentation']"));
			element.click();
			Thread.sleep(2000);
			List<WebElement> listn= driver.findElements(By.xpath("//div[@id='spPageCanvasContent']//div[@data-automation-id='Canvas']/div/div[1]/div/div/div[2]//p"));
			for(WebElement x:listn)		
				System.out.println(x.getText());
			driver.navigate().back();
			Thread.sleep(2000);
			js.executeScript("document.querySelector('article>div>div').scrollTop=2000");
			contentAvailable++;
			System.out.println();
		}
		return contentAvailable;
	}
		
	public int sizeOfContent() 
	{
		return container_content_loc.size();
	}
}
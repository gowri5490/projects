package testCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_07_AwardsContentVerification extends TC_06_NewsToolTipVerification
{
	@Test(priority = 6)
	public void awardContentVerification() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int contentAvailable = 0;
		js.executeScript("document.querySelector('article>div>div').scrollTop=2000");
		List<WebElement> awards = driver.findElements(By.xpath("//div[contains(@class, 'itemArea')]"));
		System.out.println("Awards count: "+awards.size());
		for(int i = 1;i<=awards.size();i++)
		{
			Thread.sleep(2000);
			WebElement element=driver.findElement(By.xpath("//div[contains(@class,'itemArea')]["+i+"]//a[@role='presentation']"));
			element.click();
			Thread.sleep(2000);
			capture.captureScreenShot(driver, "Award Content "+i);
			List<WebElement> listn= driver.findElements(By.xpath("//div[@id='spPageCanvasContent']//div[@data-automation-id='Canvas']/div/div[1]/div/div/div[2]//p"));
			for(WebElement x:listn)		
			{
				System.out.println(x.getText());
				writer.writeText(x.getText());
			}
			driver.navigate().back();
			driver.navigate().refresh();
			Thread.sleep(2000);
			js.executeScript("document.querySelector('article>div>div').scrollTop=2000");
			contentAvailable++;
			System.out.println();
		}
		Assert.assertEquals(awards.size(), contentAvailable,"Not Verified");
	}
}

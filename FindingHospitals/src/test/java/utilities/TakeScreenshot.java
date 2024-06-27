package utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class TakeScreenshot 
{
	public void captureScreenShot(WebDriver driver,String title) throws IOException
	{
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//Screenshot of Dom;
		File destinationFile = new File("./outputs/Screenshots/" + title + ".png");//Proxy file created to copy the screenshot;
		Files.copy(sourceFile, destinationFile);//copying the scrrenshot to the proxy;
	}

	public void captureScreenShot(WebElement x, String title) throws IOException {
		// TODO Auto-generated method stub
		File sourceFile = ((TakesScreenshot) x).getScreenshotAs(OutputType.FILE);//Screenshot of Dom;
		File destinationFile = new File("./outputs/Screenshots/" + title + ".png");//Proxy file created to copy the screenshot;
		Files.copy(sourceFile, destinationFile);//copying the scrrenshot to the proxy;
	}
}

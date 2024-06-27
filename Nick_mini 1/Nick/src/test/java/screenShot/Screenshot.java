package screenShot;

//Importing all the required package;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

/*
 * This Class is to take screen shot of the DOM ;
 * captureScreenShot(WebDriver driver,String title) method --> It takes screen shot and store it in the name of title;
 */

public class Screenshot 
{
	public static void captureScreenShot(WebDriver driver,String title) throws IOException
	{
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//Screenshot of Dom;
		File destinationFile = new File("./src/Screenshots/" + title + ".png");//Proxy file created to copy the screenshot;
		Files.copy(sourceFile, destinationFile);//copying the scrrenshot to the proxy;
	}

	public static void captureScreenShot(WebElement x, String title) throws IOException {
		// TODO Auto-generated method stub
		File sourceFile = ((TakesScreenshot) x).getScreenshotAs(OutputType.FILE);//Screenshot of Dom;
		File destinationFile = new File("./src/Screenshots/" + title + ".png");//Proxy file created to copy the screenshot;
		Files.copy(sourceFile, destinationFile);//copying the scrrenshot to the proxy;
	
	}
}

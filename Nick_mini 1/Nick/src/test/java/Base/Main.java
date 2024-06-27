package Base;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Driver.DriverSetup;
import Excel.ExcelUsage;
import TextUsage.TextUsage;
import screenShot.Screenshot;


public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver;
		
		//Getting browser name as input from the user;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Browser Name (Chrome or Edge): ");
		String browserName = scanner.nextLine();
		
		//Validating the browser name and setting up the right browse driver;
		while(true)
		{
			driver = DriverSetup.getWebDriver(browserName);
			if(driver==null)
			{
				System.out.println("Invalid Browser Name\nRe Enter The Browser Name (Chrome or Edge): ");
				browserName=scanner.nextLine();//Getting Valid browser name as an input; 
				
				//Setting up the driver by DriverSetup class;
				driver = DriverSetup.getWebDriver(browserName);
			}
			else
			{
				break;
			}
		}
		
		//Maximizing the browser;
		driver.manage().window().maximize();
		
		//Adding implicit wait;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.openlibrary.org/");
		Screenshot.captureScreenShot(driver, "HomeScreen");
		
		List<String> outputToTextFile = new ArrayList<String>();
		Thread.sleep(1000);
		List<WebElement> category=driver.findElements(By.xpath("//*[@class='category-item carousel__item slick-slide slick-current slick-active' or @class='category-item carousel__item slick-slide slick-active']"));
		Thread.sleep(1000);
		for (WebElement x:category)
		{
			System.out.println(x.getText());
			outputToTextFile.add(x.getText());
		}
		driver.findElement(By.xpath("//*[@id=\"contentBody\"]/div[11]/div[2]/div/button[2]")).click();
		Thread.sleep(1000);
		
		List<WebElement> category2=driver.findElements(By.xpath("//*[@class='category-item carousel__item slick-slide slick-current slick-active' or @class='category-item carousel__item slick-slide slick-active']"));
		Thread.sleep(1000);
		int i=0;
		for (WebElement x:category2)
		{
			if(i<3)
			{
			System.out.println(x.getText());
			outputToTextFile.add(x.getText());
			}
			else
			{
				break;
			}
		}
		Screenshot.captureScreenShot(driver, "Content");
		driver.findElement(By.xpath("//*[@id=\"contentBody\"]/div[10]/div[2]/div/button[2]")).click();
		Thread.sleep(1000);//*[@id="contentBody"]/div[10]/div[2]/div/button[2]
		List<WebElement> category3=driver.findElements(By.xpath("//*[@class='category-item carousel__item slick-slide slick-current slick-active' or @class='category-item carousel__item slick-slide slick-active']"));
		for (WebElement x:category3)
		{
			System.out.println(x.getText());
			outputToTextFile.add(x.getText());
		}
		
		
		
		driver.findElement(By.xpath("//*[@id=\"header-bar\"]/ul[1]/li[2]/div")).click();
		Screenshot.captureScreenShot(driver, "Menu");
		driver.findElement(By.partialLinkText("Subjects")).click();
		Screenshot.captureScreenShot(driver, "Subjects");
		driver.findElement(By.partialLinkText("See more...")).click();
		WebElement a = driver.findElement(By.id("contentBody"));
		Screenshot.captureScreenShot(driver, "content");
		List<WebElement> b = a.findElements(By.xpath("//*[@id=\"contentBody\"]/ul/li"));
		for(WebElement x:b)
		{
			if(x.getText().contains("Tamil"))
			{
				Screenshot.captureScreenShot(x, "Tamilbook");
				String c[]=x.getText().split(" ");
				int y=Integer.parseInt(c[1].replace(",", ""));
				//System.out.println(y);
				if(y>=1000)
				{
					System.out.println("Tamil books are more than 1000");
					outputToTextFile.add("Tamil books are more than 1000");
				}
				else
				{
					System.out.println("Tamil books are less than 1000");
					outputToTextFile.add("Tamil books are less than 1000");
				}
			}
		}
		TextUsage.write(outputToTextFile);
		ExcelUsage.write(outputToTextFile);
		scanner.close();
		driver.quit();
	}
}

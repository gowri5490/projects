package driverSetup;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverSetup

{
	
	public static WebDriver getWebDriver()
	
	{
	
	//Creating a scanner object to store driver name 
	Scanner sc = new Scanner(System.in);
	String input;
	System.out.println("Enter chrome to get chrome driver and edge to get edge driver");
	input = sc.nextLine();
	sc.close();
	
	//Returning the respective driver according to the input
	if(input.equalsIgnoreCase("chrome"))
	{
		return new ChromeDriver();
	}
	else if(input.equalsIgnoreCase("edge"))
	{
		return new EdgeDriver();
	}
	else 
	{
		return null;
	}
	
	}
	
}

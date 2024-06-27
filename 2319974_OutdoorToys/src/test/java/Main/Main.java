package Main;
import Browser.DriverSetup;
import OutdoorToys.OutDoorToys;
import dataExcel.ExcelData;
public class Main  {
	public static void main(String args[]) throws Exception
	{
		OutDoorToys toys = new OutDoorToys();
		toys.setupDriver();
		
		toys.advancePage();
		
		toys.findItems();
		
		toys.specialSearch();
		
		toys.Search();
		
		toys.getItems();
	
		toys.saveReport();
		
		Thread.sleep(3000);
		DriverSetup.driver.quit();
		
	}

}

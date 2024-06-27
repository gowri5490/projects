package Browser;

import java.io.IOException;
import java.util.NoSuchElementException;

import Excel.WriteDataIntoExcel;

public class Main{
	
	
	public static void main(String[] args) throws IOException, NoSuchElementException, InterruptedException
	{
		
		IshaLocators.createDriver();
		IshaLocators.navigateURL();
		IshaLocators.clickCpLink();
		IshaLocators.clickAllButton();
		int totalProjects = IshaLocators.projectsCount();
		System.out.println(totalProjects);
		String projects[] = IshaLocators.displayProjectNames();
		System.out.println("First 5 Completed Project Names are ");
		for(int i=0; i<5;i++)
		{
			System.out.println("Project "+(i+1)+":"+projects[i]);
			
		}
		IshaLocators.clickEnquireNowButton();
		IshaLocators.clickVendorEnquiry();
		String Email = IshaLocators.getEmailId();
		System.out.println("Email for Vendor Enquiry: "+ Email);
		IshaLocators.getFinalOutputScreenshot();
		IshaLocators.closeBrowser();
		
		String ExcelPath = "C:\\Users\\2318604\\eclipse-workspace\\Enquiry_of_Building_project\\src\\test\\java\\Excel\\OutputData.xlsx";
		String SheetName = "Output";
		WriteDataIntoExcel.createSheet(ExcelPath, SheetName);
		String headings[] = {"Total Projects","Project Name","vendor Enquiry Email" };
		WriteDataIntoExcel.firstRow(ExcelPath,SheetName,0,headings);
		WriteDataIntoExcel.sendTotalProjects(ExcelPath, SheetName, totalProjects);
		WriteDataIntoExcel.projectsName(ExcelPath, SheetName, projects);
		WriteDataIntoExcel.sendVendorEmail(ExcelPath,SheetName,Email);
	}
	
}
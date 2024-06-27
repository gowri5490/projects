package getExcelData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractData 

{
	//Method to store the data from the excel file and returning the list
	public static List<String> getData() throws IOException
	
	{
		//Creating a list to store data
		List<String> mylist = new ArrayList<String>();
		FileInputStream input = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		
		//Reading the excel sheet
		try {
		String path="./src/main/resources/Data/FormData.xlsx";
		input = new FileInputStream(path);
		workbook = new XSSFWorkbook(input);
		sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum();
		int cells = sheet.getRow(0).getLastCellNum();
		
		//Adding the data in a list using for loop
		for(int i=0;i<=rows;i++)
		{
			XSSFRow row = sheet.getRow(i);
			if(row!=null) 
			{
				for(int j=0;j<cells;j++) 
				{
					XSSFCell cell = row.getCell(j);
					if(cell!=null)
					{
						mylist.add(cell.getStringCellValue());
					}
				}
			}
		}
		
		
		} catch(Exception e) {
			System.out.println("Data not found");
		}
		
		  
		  finally
		  {
			  //Closing the file
			  workbook.close();
			  input.close();
		  }
		  
		  //Returning the list
		  return mylist;
		}
	}



package excel;

//Importing all the required packages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
For Writing The Output in the EXCEL FILE;
*/
public class ExcelUtility
{
	//writeOutput() method with the List of string argument to write the output in EXCEL FILE;
	public static void writeOutput(List<String> outputs) throws IOException
	{
		Workbook workbook = new XSSFWorkbook();//creating a new WorkBook;
		Sheet sheet = workbook.createSheet("ISHA-OUTPUT");//creating a new sheet named ISHA-OUTPUT;
		int rownum = 0;
		for(String output : outputs)
		{
			Row row = sheet.createRow(rownum++);//Creating a row;
			row.createCell(row.getLastCellNum()+1).setCellValue(output);//Creating a cell and setting the value;
		}
		//To write in Excel
		try 
		{
			FileOutputStream writer = new FileOutputStream(new File("./src/ExcelOutput/Output.xlsx"));//Creation of EXCEL Document;
			workbook.write(writer);//Writing the Output in EXCEL Document;
			writer.close();//closing the resource after use;
		}
		catch (FileNotFoundException e){}
		finally
		{
			workbook.close();//closing the resource after use;
		}
	}
	
}

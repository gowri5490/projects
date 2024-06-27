package excelOut;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOutput 
{
	
	public static void excelPrint(String datatoWrite) throws IOException
	{
		FileOutputStream file = new FileOutputStream("./src/Exceloutput/outputdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFCell cell = sheet.createRow(0).createCell(0);
		cell.setCellValue(datatoWrite);
		workbook.write(file);
		workbook.close();
		file.close();
	}

}

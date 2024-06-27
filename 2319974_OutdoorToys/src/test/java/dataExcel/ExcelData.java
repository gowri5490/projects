package dataExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelData {
	
	//Read the data from Excel and return the inputs
	public static String[] getExcel()
	{
		
		String[] inputs=new String[4];
	try
	{
		FileInputStream fl=new FileInputStream(System.getProperty("user.dir")+"\\ExcelData\\ExcelInput.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(fl);
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		XSSFRow row=sheet.getRow(1);
		
		XSSFCell cell1=row.getCell(0);
		XSSFCell cell2=row.getCell(1);
		XSSFCell cell3=row.getCell(2);
		XSSFCell cell4=row.getCell(3);
		
		inputs[0]=cell1.toString();
		inputs[1]=cell2.toString();
		inputs[2]=cell3.toString();
		inputs[3]=cell4.toString();
	}
	catch(Exception e)
	{
		System.out.println(e);
		
	}
	
	return inputs;
	
}
	
	//Write the data into Excel file 
	public static void excelOutput(String[] ItemName,String[] LinkName) throws Exception
	{
	
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\ExcelData\\ExcelOutput.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet();
		
		XSSFRow row=sheet.createRow(0);
		
		row.createCell(0).setCellValue("ITEM NAME");
		
		row.createCell(1).setCellValue("LINK NAME");
		int Size=ItemName.length;
		
		for(int i=1;i<Size;i++)
		{
		XSSFRow row1=sheet.createRow(i);
		
		row1.createCell(0).setCellValue(ItemName[i]);
		
		row1.createCell(1).setCellValue(LinkName[i]);
		
		}
		workbook.write(file);
		
		workbook.close();
		
		file.close();
	}

}

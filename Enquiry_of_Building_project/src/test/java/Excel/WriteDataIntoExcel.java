package Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class WriteDataIntoExcel {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	
	public static void createSheet(String myfile,  String sheetname) throws IOException
	{
		fo = new FileOutputStream(myfile);
		wb = new XSSFWorkbook();
		sh= wb.createSheet(sheetname);
		wb.write(fo);
		wb.close();
		fo.close();
	}
	
	public static void firstRow(String myfile, String sheetname, int rownum, String []data) throws IOException, NullPointerException
	{
		fi = new FileInputStream(myfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetname);
		row = sh.getRow(rownum);
		if(row==null)
		{
			row = sh.createRow(rownum);
			for(int i=0;i<data.length;i++)
			{
				cell = row.getCell(i);
				if(cell==null)
				{
					cell =row.createCell(i);
					cell.setCellValue(data[i]);			
				}
			}
		}
		
		fo = new FileOutputStream(myfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void sendTotalProjects(String myfile, String sheetname, int count) throws IOException, NullPointerException {
		fi = new FileInputStream(myfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetname);  
		row = sh.getRow(1);
		String tp = String.valueOf(count);
		  if(row == null) 
		  {
			  row = sh.createRow(1);
			  cell= row.getCell(0);
			  if(cell==null)
			  {
				  cell = row.createCell(0);
				  
			  }
			  cell.setCellValue(tp);
		  }
		  else {
			  cell= row.getCell(0);
				  if(cell==null)
				  {
					  cell = row.createCell(0);
					  
				  }
				  cell.setCellValue(tp);
		  }
		  
		  fo = new FileOutputStream(myfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		  
	}
	
	public static void projectsName(String myfile, String sheetname, String []data)throws IOException, NullPointerException
	{
		fi = new FileInputStream(myfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetname);
		for(int i=1;i<=data.length;i++)
		{
			row = sh.getRow(i);
			
			if(row == null) 
			{
				row = sh.createRow(i);
				cell= row.getCell(1);
				if(cell==null)
				{
					cell = row.createCell(1);
					
				}
				cell.setCellValue(data[i-1]);
			}
			else {
				cell= row.getCell(1);
				if(cell==null)
				{
					cell = row.createCell(1);
					
				}
				cell.setCellValue(data[i-1]);
			}
			
		}
		  fo = new FileOutputStream(myfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
	}
	
	
	public static void sendVendorEmail(String myfile, String sheetname, String email) throws IOException, NullPointerException {
		fi = new FileInputStream(myfile);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheetname);  
		row = sh.getRow(1);
		  if(row == null) 
		  {
			  row = sh.createRow(1);
			  cell= row.getCell(2);
			  if(cell==null)
			  {
				  cell = row.createCell(2);
				  
			  }
			  cell.setCellValue(email);
		  }
		  else {
				  cell= row.getCell(2);
				  if(cell==null)
				  {
					  cell = row.createCell(2);
					  
				  }
				  cell.setCellValue(email);
		  }
		  
		  fo = new FileOutputStream(myfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		  
	}
	

}

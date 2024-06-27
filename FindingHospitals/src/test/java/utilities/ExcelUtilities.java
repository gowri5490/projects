package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities 
{
	public void write(List<String> outputToTextFile,String titel) throws EncryptedDocumentException, IOException {
		File ff = new File("./Outputs/ExcelOutputs/"+titel+".xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet s = wb.createSheet("Output");
		int row=0;
		for(String x:outputToTextFile)
		{
			Row r=s.createRow(row++);
			r.createCell(0).setCellValue(x);
		}
		try
		{
			FileOutputStream file = new FileOutputStream(ff);
			wb.write(file);
			file.close();
			wb.close();
		}catch(Exception e) {}
	}

	public String[][] getData() throws IOException 
	{
		
		FileInputStream fi = new FileInputStream("./src/test/resources/Excel Inputs/Test-data 1.xlsx");
		Workbook wb = new XSSFWorkbook(fi);
		Sheet s = wb.getSheetAt(0);
		String[][] data = new String[s.getLastRowNum()-2][s.getRow(1).getLastCellNum()];
		for(int row = 1;row<s.getLastRowNum()-1;row++)
		{
			Row r =s.getRow(row);
			for(int col=0;col<r.getLastCellNum();col++)
			{
				data[row-1][col] = r.getCell(col).getStringCellValue();
			}
		}
		wb.close();
		return data;
	}
}

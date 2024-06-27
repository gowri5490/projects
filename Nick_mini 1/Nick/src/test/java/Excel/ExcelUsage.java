package Excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUsage {

	public static void write(List<String> outputToTextFile) throws EncryptedDocumentException, IOException {
		File ff = new File("./src/OUTPUT.xlsx");
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
	
}

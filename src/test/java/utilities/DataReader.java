package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

	
	public static HashMap<String,String> values=new HashMap();
	
	
	public static List<Map<String,String>> data(String filePath,String sheetName) throws IOException
	{	
	List<Map<String,String >> mydata=new ArrayList<>();
	FileInputStream file=new FileInputStream(filePath);
	XSSFWorkbook workbook=new XSSFWorkbook(file);
	XSSFSheet sheet=workbook.getSheet(sheetName);
	int totalRows=sheet.getLastRowNum();
	XSSFRow headerRow=sheet.getRow(0);
	
	for(int i=1;i<=totalRows;i++)
	{
		XSSFRow currentRow=sheet.getRow(i);
		HashMap<String,String> currentHash=new HashMap<String,String>();
		for(int j=0;j<=currentRow.getLastCellNum();j++)
		{
			
			XSSFCell currentCell=currentRow.getCell(j);
			currentHash.put(headerRow.getCell(j).toString(), currentCell.toString());
		}
		mydata.add(currentHash);
	}
	
	file.close();
	return mydata;
	}
}

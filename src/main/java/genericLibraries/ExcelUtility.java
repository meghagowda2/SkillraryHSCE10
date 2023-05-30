package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class conatins reusable methods to perrform operation on excel
 * @author MUKESH GOWDA
 *
 */

public class ExcelUtility 
{ private Workbook workbook;

/**
 * This method is used to initialise excel file
 * @param excelPath
 */
	public void excelInitialization(String excelPath)
	{
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to read single data from excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum)
	{
		DataFormatter df = new DataFormatter();
		String data=df.formatCellValue(workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
		return data;
}
/**
 * This method is used to fetch multiple data from excel
 * @param sheetName
 * @return
 */
	public Map<String, String> getDataFromExcel(String sheetName) {
		DataFormatter df = new DataFormatter();
		Map<String ,String> map=new HashMap();
		Sheet sheet = workbook.getSheet(sheetName);
		for(int i =0;i<=sheet.getLastRowNum();i++)
		{
			String key =df.formatCellValue(sheet.getRow(i).getCell(0));
			String value =df.formatCellValue(sheet.getRow(i).getCell(1));
			map.put(key, value);
			
		}
		return map;
		
}
	/**
	 * This method is used to write data to excel
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param excelPath
	 * @param data
	 */

public void writeToExcel(String sheetName, int rowNum, int cellNum, String excelPath, Date data)
{
	Cell cell =workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
	cell.setCellValue(data);
	FileOutputStream fos=null;
	try {
		 fos = new FileOutputStream(excelPath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		workbook.write(fos);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/**
 * This method is used to close excel
 */
public void closeExcel()
{
	try {
		workbook.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			
	
}
	
}

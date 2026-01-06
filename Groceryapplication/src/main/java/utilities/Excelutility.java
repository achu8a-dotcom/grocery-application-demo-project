package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class Excelutility {
	
	static FileInputStream f; //used to read i/p file
 	static XSSFWorkbook w; //used to read the complete workbook
 	static XSSFSheet sh; //used to read the sheet in workbook
	
	public static String readStringData(int row, int col,String sheet) throws IOException { 
		
		String filepath=Constant.TESTDATAFILE;
 		f = new FileInputStream(filepath); 
 		w = new XSSFWorkbook(f); // used to allocate a memory for the workbook
 		sh = w.getSheet(sheet); //used to select the sheet in the workbook
 		XSSFRow r = sh.getRow(row); // used to read value from the row
 		XSSFCell c = r.getCell(col); 
 		return c.getStringCellValue(); 
  
 	} 
  
 	public static String readIntegerData(int row, int col,String sheet) throws IOException { 
 		String filepath=Constant.TESTDATAFILE;
 		f = new FileInputStream(filepath); 
 		w = new XSSFWorkbook(f); 
 		sh = w.getSheet(sheet); 
 		XSSFRow r = sh.getRow(row); 
 		XSSFCell c = r.getCell(col); 
 		int val =   (int) c.getNumericCellValue();  //convert double to int using typecasting 
 		return String.valueOf(val);   //convert int to string using valueOf() method 
 		//return val; 
 	 
 	} 
  


}

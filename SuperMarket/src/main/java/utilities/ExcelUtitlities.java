package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;



public class ExcelUtitlities 
{
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	public static String readStringData(int row, int col,String sheet) throws IOException 
	{
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}

	public static double readIntegerData(int row, int col, String sheet) throws IOException 
	{
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);//workbook
		sh = w.getSheet(sheet);//sheet
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getNumericCellValue();
		
	
	}
	/*
	public void excelMain()
	{
		String s=ExcelCode.readStringData(0, 0);//calling static method ie classname.methodname
		System.out.println(s);
		double s1=ExcelCode.readIntegerData(0, 1);//calling static method ie classname.methodname
		System.out.println(s1);
	}
	*/
	

}
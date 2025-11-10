package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
		//To read details from the file
			static FileInputStream f;
			//To read details from workbook
			static XSSFWorkbook wb;
			//To read details from the sheet
			static XSSFSheet sh;
			
			public static String getStringData(int a,int b,String sheet) throws IOException  
			{
				f=new FileInputStream("C:\\Users\\hp\\git\\Automation1\\GroceryApplication\\src\\test\\resources\\testdata Grocery Login.xlsx\\");
				wb= new XSSFWorkbook(f);
				sh=wb.getSheet(sheet);
				XSSFRow r =sh.getRow(a);
				XSSFCell c = r.getCell(b);
				return c.getStringCellValue();
			}
			 public static String getStringDetails(int a,int b,String sheet) throws IOException
				{
					f=new FileInputStream("C:\\Users\\hp\\git\\Automation1\\GroceryApplication\\src\\test\\resources\\testdata Grocery Login.xlsx\\");
					wb=new XSSFWorkbook(f);
					sh=wb.getSheet(sheet);
					XSSFRow r=sh.getRow(a);
					XSSFCell c=r.getCell(b);
					return c.getStringCellValue();
				}
			public static String getIntegerData(int a,int b,String sheet) throws IOException
			{
				f=new FileInputStream("C:\\Users\\hp\\git\\Automation1\\GroceryApplication\\src\\test\\resources\\testdata Grocery Login.xlsx\\");
				wb=new XSSFWorkbook(f);
				sh=wb.getSheet(sheet);
				//get the row at index a using getRow() method
				XSSFRow r=sh.getRow(a);
				//get the cell in column b of that row use getCell() method
				XSSFCell c=r.getCell(b);
				int d=(int)c.getNumericCellValue();
				//(int) : type casting convert double to integer
				return String.valueOf(d); 
				//integer value convert into string:  type conversion String.valueof()
			}
			public static String getFloatData(int a,int b,String sheet) throws IOException
			{
				f=new FileInputStream("C:\\Users\\hp\\git\\Automation1\\GroceryApplication\\src\\test\\resources\\testdata Grocery Login.xlsx\\");
				wb=new XSSFWorkbook(f);
				sh=wb.getSheet(sheet);
				XSSFRow r=sh.getRow(a);
				XSSFCell c=r.getCell(b);
				float d=(float)c.getNumericCellValue();
				return String.valueOf(d); 
			}

}

package exceltest;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class UpdateExcelDemo {

   public static void main(String[] args) throws IOException {
	
	       File file = new File("C:\\Users\\USER\\Desktop\\amin.xls");
	       // Read XSL file
	       FileInputStream inputStream = new FileInputStream(file);
	
	       // Get the workbook instance for XLS file
	       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	
	       // Get first sheet from the workbook
	       HSSFSheet sheet = workbook.getSheetAt(0);
	
	       HSSFCell cell = sheet.getRow(15).getCell(1);
	       cell.setCellValue("Referance:34/22");
	       Date aujourdhui = new Date();
	       DateFormat shortDateFormat = DateFormat.getDateInstance(
	    	        DateFormat.SHORT);
	       DateFormat shortDateFormatEN = DateFormat.getDateTimeInstance(
	    	        DateFormat.SHORT,
	    	        DateFormat.SHORT, new Locale("EN","en"));
	       System.out.println(shortDateFormat.format(aujourdhui));
	       HSSFCell cell2 = sheet.getRow(17).getCell(1);
	       cell2.setCellValue("Date:"+ shortDateFormat.format(aujourdhui));
	       HSSFCell cell1 = sheet.getRow(10).getCell(6);
	       cell1.setCellValue("Facture");
	     
	       
	       inputStream.close();
	
	       // Write File
	       FileOutputStream out = new FileOutputStream(file);
	       workbook.write(out);
	       out.close();

   }

}
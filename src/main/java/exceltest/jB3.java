package exceltest;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
public class jB3 extends Connexion  implements ActionListener  {
	static File file; 
	static String mf ;
	int x;
	public static void Ouvrir() throws IOException {
		try{
			ra=jb.getSelectedIndex();
		       ra=ra+1;
		        System.out.println("ra="+ra);

		     
	          cnx2=getInstance(); 
	          st2=cnx2.createStatement();
	          rst2=st2.executeQuery("SELECT \"Mf_Clt\"\r\n"
	          		+ "  FROM client where \"Nom_Clt\" ='"+(String)jb.getSelectedItem()+"'  ;\r\n"
	          		+ "");
	          int w=0;
	          while (rst2.next()) {
	        	  File file = new File("C:\\Users\\USER\\Desktop\\amin.xls");
			       // Read XSL file
			       FileInputStream inputStream = new FileInputStream(file);
			
			       // Get the workbook instance for XLS file
			       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			
			       // Get first sheet from the workbook
			       HSSFSheet sheet = workbook.getSheetAt(0);
			       HSSFCell cell6 = sheet.getRow(18).getCell(6);	
			        mf =rst2.getString("Mf_Clt");
		  	        cell6.setCellValue(mf);
				       System.out.println(cell6);
				       inputStream.close();
				   	
				       // Write File
				       FileOutputStream out = new FileOutputStream(file);
				       workbook.write(out);
				       out.close();
	  	     

	           }}catch(SQLException e){
	               System.out.println(e.getMessage());
	           }
	
		

		       
	
	
	}

   
	public void update() throws IOException {
		if (jb1.getSelectedItem() == "Facture") {
			x = s ;
		       System.out.println("Facture N:"+x);
		}else if (jb1.getSelectedItem() == "Offre") {
			x=No+1;
		       System.out.println("Offre N:"+x);

		}else {
			x=Bl;
		       System.out.println("Bl N:"+x);

		}

	       File file = new File("C:\\Users\\USER\\Desktop\\amin.xls");
	       // Read XSL file
	       FileInputStream inputStream = new FileInputStream(file);
	
	       // Get the workbook instance for XLS file
	       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	
	       // Get first sheet from the workbook
	       HSSFSheet sheet = workbook.getSheetAt(0);
	
	       HSSFCell cell = sheet.getRow(15).getCell(1);
	       
	       cell.setCellValue("Referance:"+x+"/23");
	       Date aujourdhui = new Date();
	       DateFormat shortDateFormat = DateFormat.getDateInstance(
	    	        DateFormat.SHORT);
	       System.out.println(shortDateFormat.format(aujourdhui));
	       HSSFCell cell2 = sheet.getRow(17).getCell(1);
	       ab=shortDateFormat.format(aujourdhui);
	       cell2.setCellValue("Date:"+ab );
	       HSSFCell cell1 = sheet.getRow(8).getCell(6);
	       cell1.setCellValue((String)jb1.getSelectedItem());
	       HSSFCell cell3 = sheet.getRow(15).getCell(6);
	       String rb=(String)jb.getSelectedItem();
	       cell3.setCellValue(rb);
	       
	       Ouvrir();
	       cell5 = sheet.getRow(32).getCell(10).getNumericCellValue();
	        System.out.println("prix="+cell5);
		       HSSFCell cell6 = sheet.getRow(18).getCell(6);	

  	        cell6.setCellValue("MF:"+mf);

	       inputStream.close();
	
	       // Write File
	       FileOutputStream out = new FileOutputStream(file);
	       workbook.write(out);
	       out.close();

	}	  
	
	



		@Override
			public void actionPerformed(ActionEvent e) {
			   
			   if(e.getSource()==jB3);
			   
			   try {
				update();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			   
			   
			   
			   
			   file = new File("C:\\Users\\USER\\Desktop\\amin.xls");

				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				}

				
		}
	

}

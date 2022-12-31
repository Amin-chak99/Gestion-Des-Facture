package exceltest;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

public class Connexion  {
	static JTable table ;
	static JScrollPane pane ;
	static JLabel L1=new  JLabel("Date");
	static  JLabel L2=new  JLabel("Fichier");
	static  JLabel L3=new  JLabel("Client");
	static  JLabel L4=new  JLabel("Etat");	
	static	  JButton jB=new JButton("Ajouter");
	static JButton jB1=new JButton("Analyse");
	static  JButton jB2=new JButton("Suprimer");
	static  JButton jB4=new JButton("Modifier");
	static  JButton jB3=new JButton("Ouvrir");
	static JComboBox<String> comboBox =new JComboBox<String>();
	static JComboBox<String> comboBox_1 =new JComboBox<String>();

 	static Connection cnx ; 
	static Statement st;
	static ResultSet rst ;
	static Connection cnx1 ; 
	static Statement st1;
	static ResultSet rst1 ;
	static Connection cnx2 ; 
	static Statement st2;
	static ResultSet rst2 ;
	static Connection cnx3 ; 
	static Statement st3;
	static ResultSet rst3 ;
	static int c ;
	static Object valueAt1 ;
	static JTextField textField;
	static DefaultTableModel  model ,model1 ,model2 ;
    static Connexion con = new Connexion() ;
	static int row ;
	static JComboBox<String> jb=new JComboBox<String>();
	static JComboBox<String> jb1=new JComboBox<String>();
	static JComboBox<String> jb2=new JComboBox<String>();

    static int ra ;
	static int s;
	static int No;
	static int Bl;
	static String cf , cf1;
	static String ab ,aazz;
    static double cell5 ,cell55;
	static JButton btnNewButton , btnNewButton1;
	static JTextField textField_1,textField_2;
	static JTable table3 ,table4;
	static File file ;

    public static void SupprimerParID(Object valueAt12){
        try{
           String query="DELETE FROM facture WHERE \"Id_Fac\"="+valueAt1; 
           cnx3=getInstance(); 
           st3=cnx3.createStatement();
           st3.executeUpdate(query);
           System.out.println("eleve bien supprimé");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void ChiffreAffaire(){

		try{
	          cnx2=getInstance(); 
	          st2=cnx2.createStatement();
	          rst2=st2.executeQuery("SELECT SUM(\"Prix_Fac\") aaac  \r\n"
	          		+ "FROM Facture");
	          
	          int w=0;
	          while (rst2.next()) {
	        	  
	         
	           aazz=rst2.getString("aaac");
	          System.out.println(aazz);

	          }
	           }catch(SQLException e){
	               System.out.println(e.getMessage());
	           }
		
    }
    public static void ChiffreAffaireclient(){

 		try{
 	          cnx2=getInstance(); 
 	          st2=cnx2.createStatement();
 	         int cbb =comboBox.getSelectedIndex()+1;
 	          rst2=st2.executeQuery("SELECT SUM(\"Prix_Fac\") aaacc  \r\n"
 	          		+ "FROM Facture where \"Clt_Fac\"="+cbb);
 	          
 	          int w=0;
 	          while (rst2.next()) {
 	        	  
 	         
 	           cf=rst2.getString("aaacc");
 	          System.out.println(cf);

 	          }
 	           }catch(SQLException e){
 	               System.out.println(e.getMessage());
 	           }
 		
     }
    
    public static void etat(Object valueAt12) {
    	
    	try{
    		String etats=(String)jb2.getSelectedItem();
            System.out.println(etats);

   		 String query="UPDATE \"Reglement\"\r\n"
   		 		+ "   SET  \"Reg\"= '"+etats+"'\r\n"
   		 		+ " WHERE \"Id_Reg\"="+valueAt1 ;
            
             cnx3=getInstance(); 
             st3=cnx3.createStatement();
             st3.executeUpdate(query);
             System.out.println("etat modifier");
              
          }catch(SQLException e){
              System.out.println(e.getMessage());
          }
    	
    }
    
    public static void ChiffreAffaireMoi(){

 		try{
 	          cnx2=getInstance(); 
 	          st2=cnx2.createStatement();
 	          
 	         String cbb1 =(String)comboBox_1.getSelectedItem();
 	         
 	        TemporalAdjuster temporalAdjuster= TemporalAdjusters.lastDayOfMonth();
  int cb1=Integer.parseInt(cbb1);
        // using adjuster for local date-time
        LocalDate localDate= LocalDate.of(2022, cb1, 01);
        LocalDate lastDayOfMonth= localDate.with(temporalAdjuster);
        System.out.println("last day of the "
                + "month for localdate "
                + localDate + ": "
                + lastDayOfMonth);
 	          rst2=st2.executeQuery("SELECT SUM(\"Prix_Fac\") a1  \r\n"
 	          		+ "FROM Facture where \"Date_Fac\"between  '2022-"+cbb1+"-01' and '"+lastDayOfMonth+"'");
 	          
 	          int w=0;
 	          while (rst2.next()) {
 	        	  
 	         
 	           cf1=rst2.getString("a1");
 	          System.out.println(cf1);

 	          }
 	           }catch(SQLException e){
 	               System.out.println(e.getMessage());
 	           }
 		
     }
    
    
    
	public static void read() throws IOException {
		   ra=jb.getSelectedIndex();
	       ra=ra+1;
	        System.out.println("ra="+ra);

	        file = new File("C:\\Users\\USER\\Desktop\\amin.xls");
	       // Read XSL file
	       FileInputStream inputStream = new FileInputStream(file);
	
	       // Get the workbook instance for XLS file
	       HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
	
	       // Get first sheet from the workbook
	       HSSFSheet sheet = workbook.getSheetAt(0);
	        cell55 = sheet.getRow(32).getCell(10).getNumericCellValue();
	        System.out.println("prix="+cell55);
	        
		       inputStream.close();
		
		       // Write File
		       FileOutputStream out = new FileOutputStream(file);
		       workbook.write(out);
		       out.close();
	}
	
	
	
public static void ajouter(int s) {

	try{
		String query="INSERT INTO \"Reglement\"(\r\n"
				+ "            \"Id_Reg\", \"Reg\")\r\n"
				+ "    VALUES ("+s+", 'Non Reglé');\r\n"
				+ "";
         cnx3=getInstance(); 
         st3=cnx3.createStatement();
         st3.executeUpdate(query);
         System.out.println("ajouté");
          
      }catch(SQLException e){
          System.out.println(e.getMessage());
      }
	
}

	  public static void AjouterP(int s,String ab,int a ,double cell5){
	    	try {
				read();
			 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  try {
	    	
	    	String query="INSERT INTO facture(\r\n"
	    			+ "            \"Id_Fac\", \"Date_Fac\", \"Clt_Fac\", \"Prix_Fac\")\r\n"
	    			+ "    VALUES ( '"+s+"','"+ab+"','"+ra+"','"+cell55+"');\r\n";
	        cnx1=getInstance(); 
	        st=cnx.createStatement();
	       

	        st.executeUpdate(query);
	        System.out.println("eleve bien ajouté");

	    }catch(SQLException e){
	        System.out.println(e.getMessage());
	    }
	    
	    }
	  public static void AjouterO(int s,String ab,int a ,double cell5){
	    	try {
				read();
			 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  try {
	    	
	    	String query="INSERT INTO offre(\r\n"
	    			+ "            \"Id_Off\", \"Date_Off\", \"Clt_Off\", \"Prix_Off\")\r\n"
	    			+ "    VALUES ( '"+No+"','"+ab+"','"+ra+"','"+cell55+"');\r\n";
	        cnx1=getInstance(); 
	        st=cnx.createStatement();
	        st.executeUpdate(query);
	        
	        System.out.println("Offre bien ajouté");

	    }catch(SQLException e){
	        System.out.println(e.getMessage());
	    }
	    
	    }
   

						
		//Class.forName("org.postgresql.Driver");
		//	System.out.print("Driver Ok");
		private static String url = "jdbc:postgresql://localhost:5432/MEF";
		private static String user ="postgres";
		private static String passwd ="11099990";
		private static Connection connect ;
        static JTextField tf1 = new JTextField(); 
        
  

public static Connection getInstance(){ 
	if (connect == null) {
		
		try {
			connect = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connetion effective");
}
		
	 catch (Exception e) {
		 e.printStackTrace();
	 }
	
	}
		return connect;}

public static ArrayList<String[]> getEleves()  {
	ArrayList<String[]> datalist = new ArrayList<String[]>();
	String req="SELECT \"Id_Fac\", \"Date_Fac\", \"Nom_Clt\", \"Prix_Fac\" , \"Reg\"\r\n"
			+ "FROM \"facture\"  \r\n"
			+ "LEFT OUTER JOIN \"client\"\r\n"
			+ "ON \"Clt_Fac\" =  \"Id_Clt\" \r\n"
			+ "LEFT OUTER JOIN \"Reglement\" \r\n"
			+ "ON \"Id_Fac\"  =\"Id_Reg\" \r\n"
			+ "order by \"Id_Fac\";\r\n"
			+ "";
      try {
    	  cnx=getInstance(); 
		st=cnx.createStatement();
		 rst=st.executeQuery(req); 
	      while (rst.next()) {
	    	 
	    	  datalist.add(new String[] {rst.getString("Id_Fac"),rst.getString("Date_Fac"),
	    			  rst.getString("Nom_Clt"),rst.getString("Prix_Fac"),rst.getString("Reg")});
	    	  s= rst.getInt("Id_Fac");
	    	  s++;
	      }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	return datalist;
}




public static ArrayList<String[]> getEleves1()  {
	ArrayList<String[]> datalist1 = new ArrayList<String[]>();
	int xx=comboBox.getSelectedIndex()+1;
	String req="SELECT distinct \"Id_Fac\", \"Date_Fac\", \"Prix_Fac\"\r\n"
			+ "  FROM facture , client where \"Clt_Fac\"="+xx
			+ " order by \"Id_Fac\" ;\r\n"
			+ " ";
      try {
    	  cnx=getInstance(); 
		st=cnx.createStatement();
		 rst=st.executeQuery(req); 
	      while (rst.next()) {
	    	 
	    	  datalist1.add(new String[] {rst.getString("Id_Fac"),rst.getString("Date_Fac"),
	    			  rst.getString("Prix_Fac")});
	    	  s= rst.getInt("Id_Fac");
	    	  s++;
	      }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	return datalist1	;
}



public static ArrayList<String[]> getEleves2()  {
	ArrayList<String[]> datalist2 = new ArrayList<String[]>();	  
     String cbb1 =(String)comboBox_1.getSelectedItem();
     
    TemporalAdjuster temporalAdjuster= TemporalAdjusters.lastDayOfMonth();
int cb1=Integer.parseInt(cbb1);
// using adjuster for local date-time
LocalDate localDate= LocalDate.of(2022, cb1, 01);
LocalDate lastDayOfMonth= localDate.with(temporalAdjuster);
System.out.println("last day of the "
       + "month for localdate "
       + localDate + ": "
       + lastDayOfMonth);
	String req="SELECT distinct \"Id_Fac\", \"Nom_Clt\", \"Prix_Fac\"\r\n"
			+ "  FROM facture , client where \"Id_Clt\"=\"Clt_Fac\" and \"Date_Fac\"between  '2022-"+cbb1+"-01' and '"+lastDayOfMonth+"'order by \"Id_Fac\"";
      try {
    	  cnx=getInstance(); 
		st=cnx.createStatement();
		 rst=st.executeQuery(req); 
	      while (rst.next()) {
	    	 
	    	  datalist2.add(new String[] {rst.getString("Id_Fac"),rst.getString("Nom_Clt"),
	    			  rst.getString("Prix_Fac")});
	    	  s= rst.getInt("Id_Fac");
	    	  s++;
	      }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
	return datalist2	;
}




public static void initialisation2() {
	ArrayList<String[]> listEleves2 ;
	listEleves2= con.getEleves2();
		 String titles[] = { "Facture N°", "Client","Prix TTC" };
	        model2 = new DefaultTableModel();
	    for(int i=0; i< titles.length;i++) 
	        model2.addColumn(titles[i]);

		for(int i=0; i<listEleves2.size();i++)
	        model2.addRow(listEleves2.get(i));
	    table4.setModel(model2);

   
    }




public static void initialisation1() {
	ArrayList<String[]> listEleves1 ;
	listEleves1= con.getEleves1();
		 String titles[] = { "Facture N°", "Date","Prix TTC" };
	        model1 = new DefaultTableModel();
	    for(int i=0; i< titles.length;i++) 
	        model1.addColumn(titles[i]);

		for(int i=0; i<listEleves1.size();i++)
	        model1.addRow(listEleves1.get(i));
	    table3.setModel(model1);

   
    }


public static void initialisation() {
	ArrayList<String[]> listEleves ;
	
		listEleves= con.getEleves();
		 String titles[] = { "Facture N°", "Date", "Client","Prix TTC","Etat" };
	        model = new DefaultTableModel();
	    for(int i=0; i< titles.length;i++) 
	        model.addColumn(titles[i]);

		for(int i=0; i<listEleves.size();i++)
	        model.addRow(listEleves.get(i));
	    table.setModel(model);

   
    }

public static void main(String[] args) throws SQLException {
	System.out.println("R"+row );
	getEleves();
	
			try{
		          cnx2=getInstance(); 
		          st2=cnx2.createStatement();
		          rst2=st2.executeQuery("SELECT \"Nom_Clt\"\r\n"
		          		+ "  FROM client order by \"Id_Clt\" ;\r\n"
		          		+ "");
		          int w=0;
		          while (rst2.next()) {
		        	  
		        	jb.addItem(rst2.getString("Nom_Clt"));
		        	comboBox.addItem(rst2.getString("Nom_Clt"));
		        	w++;

		           }}catch(SQLException e){
		               System.out.println(e.getMessage());
		           }
			
          table = new JTable(model);
          table.setShowGrid(true);
          table.setShowVerticalLines(true);
      	initialisation();

          pane = new JScrollPane(table);
          pane.setPreferredSize(new Dimension(500, 350));
          Box box1 = Box.createHorizontalBox();

          JFrame f = new JFrame("Socité Maintenace Electro froid");
          JPanel panel = new JPanel();
          panel.add(pane);
          box1.add(panel);
          f.setSize(600, 500);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  f.setLocationRelativeTo(null);
          
          f.setVisible(true);
		  f.setResizable(false);
          table.addMouseListener(new table());

      	jb.setPreferredSize(new Dimension(130,20));
    	
    		tf1.setPreferredSize(new Dimension(70,20));
    		jb1.setPreferredSize(new Dimension(70,20));
    		jb1.addItem("Facture");
    		jb1.addItem("Offre");
    		jb1.addItem("Bon de Livraison");
    		jb2.setPreferredSize(new Dimension(70,20));
    		jb2.addItem("");
    		jb2.addItem("Reglé");
    		jb2.addItem("Non Reglé");

          JPanel panel1 = new JPanel();

          panel1.add(L1);
          panel1.add(tf1);
          panel1.add(L2);
          panel1.add(jb1);
          panel1.add(L3);
          panel1.add(jb);
          panel1.add(L4);
          panel1.add(jb2);

          Box box2= Box.createHorizontalBox();
          box2.add(panel1);
          Box boxFinal = Box.createVerticalBox();
          boxFinal.add(box1);
          boxFinal.add(box2);
          f.setLayout(new BorderLayout());
          JPanel P2 = new JPanel();
          P2.add(jB);
          P2.add(jB1);
          P2.add(jB2);
          P2.add(jB4);
          P2.add(jB3);

          jB.addActionListener(new jB());
          jB1.addActionListener(new jB1());
          jB2.addActionListener(new jB2());
          jB3.addActionListener(new jB3());
          jB4.addActionListener(new jB4());

          boxFinal.add(P2);
          f.add(boxFinal, BorderLayout.NORTH);


      	
	
		

}

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}

public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



}

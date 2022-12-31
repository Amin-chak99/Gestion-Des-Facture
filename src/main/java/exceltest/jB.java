package exceltest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class jB extends Connexion implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	
	
if(e.getSource()==jB ) {
		
			int a=s++;
			int c=No++;
			int b=jb.getSelectedIndex()+1;
			if (jb1.getSelectedItem() == "Facture") {
				AjouterP(a,ab, ra ,cell5);
				ajouter(a);

			}else if (jb1.getSelectedItem() == "Offre") {
				AjouterO(c,ab, ra ,cell5);


			}else {
				
			       System.out.println("Bl ");

			}
			

				table.setModel(model);
	 			

		}
tf1.setText(null);
	jb.setSelectedIndex(0);  

				initialisation();

		}}
	
package exceltest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jB2 extends Connexion   implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jB2);

		
		SupprimerParID(valueAt1);


		tf1.setText(null);
		jb.setSelectedIndex(0);
		initialisation();

	}

}

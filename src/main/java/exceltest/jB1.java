package exceltest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class jB1 extends Connexion  implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jB1);
		ChiffreAffaire();
		analyse cnt = new analyse();
		analyse.main(null);

	}

}
package exceltest;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class table extends Connexion implements MouseListener {
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 row = table.getSelectedRow()+1;
        
		System.out.println(row );
		
	    valueAt1 =table.getValueAt(row-1,0);
	    Object valueAt2 = table.getValueAt(row-1,1);
	    Object valueAt3 = table.getValueAt(row-1,2);
	    Object valueAt4 = table.getValueAt(row-1,2);
	    
	    tf1.setText((String) valueAt2);
	    jb.setSelectedItem((String) valueAt4);
		

	    getEleves();
        System.out.println("s="+valueAt1);

	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

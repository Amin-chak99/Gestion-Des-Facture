package exceltest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class analyse extends Connexion {

	private JFrame frame;
	private JTextField textField;
	 
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					analyse window = new analyse();
					window.frame.setSize(460, 400);
					window.frame.setLocationRelativeTo(null);

					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public analyse() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Etat de Facturation et chiffre d'affaire");
		frame.setResizable(false);

		frame.setBounds(100, 100, 450, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chiffre d'Affaire Annuel:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 24, 129, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setBounds(159, 22, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Chiffre d'Affaire par Client :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 55, 141, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		comboBox.setBounds(159, 51, 96, 21);
		frame.getContentPane().add(comboBox);
		
		textField_1 = new JTextField();
		 textField.setText(aazz);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(310, 52, 96, 19);

		frame.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chiffre d'Affaire par Mois :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 190, 141, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", ""}));
		comboBox_1.setBounds(159, 186, 96, 21);
		frame.getContentPane().add(comboBox_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(310, 187, 96, 19);
		textField_2.setText(cf1);
		
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Facture :");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 91, 141, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		
		
		table_1 = new JTable();
		table_1.setBounds(0, 0, 1, 1);
		frame.getContentPane().add(table_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Facture :");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(10, 222, 141, 13);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		 btnNewButton = new JButton("ok");
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\Green_tick.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setBounds(257, 51, 50, 20);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new acl());

        table3 = new JTable(model1);

		JScrollPane scrollPane_1 = new JScrollPane(table3);
		scrollPane_1.setBounds(10, 114, 416, 67);
		frame.getContentPane().add(scrollPane_1);
		
		btnNewButton1 = new JButton("ok");
		btnNewButton1.setBounds(257, 186, 50, 20);
		frame.getContentPane().add(btnNewButton1);
		
        table4 = new JTable(model2);

		JScrollPane scrollPane = new JScrollPane(table4);
		scrollPane.setBounds(10, 245, 416, 92);
		frame.getContentPane().add(scrollPane);
		btnNewButton1.addActionListener(new acl1());
	}
}

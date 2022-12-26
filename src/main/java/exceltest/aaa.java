package exceltest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class aaa {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aaa window = new aaa();
					window.frame.setSize(450, 300);
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
	public aaa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Facturation Socité MEF	");
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Soci\u00E9t\u00E9 Maintenace Electro-Froide (MEF)");
		lblNewLabel.setForeground(new Color(0, 0, 204));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 10, 352, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BienVenu ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(157, 33, 125, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Utilisateur");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(116, 90, 79, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mot de Passe");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(116, 151, 79, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField.setBounds(205, 88, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(15);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setBounds(205, 145, 96, 19);
		frame.getContentPane().add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 68, 378, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 199, 378, 2);
		frame.getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("Connecter");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(29, 211, 96, 26);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String MotdePasse = passwordField.getText();
				String Utilisateur =textField.getText();
				if (MotdePasse.contains("01293556") && Utilisateur.contains("mounir mef")) {
					passwordField.setText(null);
					textField.setText(null);
					Connexion cnt = new Connexion();
					try {
						Connexion.main(null);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Mot de passe ou nom utilisateur invalide");
					passwordField.setText(null);
					textField.setText(null);
				}
			}});
			
		
		
		
		
		
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("Effacer");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(175, 211, 96, 26);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(null);
				textField.setText(null);
			}});
			
		
		JButton btnNewButton_2 = new JButton("Quitter");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(317, 211, 90, 26);
		frame.getContentPane().add(btnNewButton_2);
		frame.getContentPane().add(btnNewButton);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "vous avez sur de quitter cette aplication ","Facturation MEF",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}});
	}}

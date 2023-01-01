package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Librarian;
import filesData.LibrarianAccounts;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewLibrarianAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public NewLibrarianAccount() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 318);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 249, 279);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\images\\add-user.png"));
		lblNewLabel.setBounds(0, 0, 249, 279);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel();
		lblName.setForeground(new Color(0, 100, 0));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setText("Password");
		lblName.setBounds(270, 177, 74, 19);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel();
		lblAge.setText("Age");
		lblAge.setForeground(new Color(0, 100, 0));
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge.setBounds(270, 113, 74, 19);
		contentPane.add(lblAge);
		
		JLabel lblUsername = new JLabel();
		lblUsername.setText("Username ");
		lblUsername.setForeground(new Color(0, 100, 0));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(270, 147, 74, 19);
		contentPane.add(lblUsername);
		
		JLabel lblName_1 = new JLabel();
		lblName_1.setText("Name ");
		lblName_1.setForeground(new Color(0, 100, 0));
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName_1.setBounds(270, 83, 74, 19);
		contentPane.add(lblName_1);
		
		textField = new JTextField();
		textField.setBounds(350, 84, 227, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(350, 114, 227, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(350, 147, 227, 20);
		contentPane.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(350, 178, 227, 20);
		contentPane.add(passwordField);
		
		JButton jButton1 = new JButton();
		jButton1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Librarian l = new Librarian();
				LibrarianAccounts la = new LibrarianAccounts();
				l.name = textField.getText();
				l.username = textField_2.getText();
				l.password = passwordField.getText();
				
				if(l.name.isEmpty() || textField_1.getText().isEmpty() || l.username.isEmpty() || l.password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Can not be Empty");
				}
				else if(la.IsLibrarianExisting(l.name)){
					JOptionPane.showMessageDialog(null, "The name of Librarian is Existing");
				}
				else {
					l.age = Integer.parseInt(textField_1.getText());
					la.SaveLibrarianAccount(l);
					dispose();
					LibrarianAction lc = new LibrarianAction(l.username);
					lc.setLocationRelativeTo(null);
					lc.setVisible(true);
				}
			}
		});
		jButton1.setBackground(new Color(0, 100, 0));
		jButton1.setForeground(new Color(255, 250, 250));
		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jButton1.setText("Create");
		jButton1.setBounds(418, 221, 159, 33);
		contentPane.add(jButton1);
		
		JButton btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginLibrarian lb = new LoginLibrarian();
				lb.setLocationRelativeTo(null);
				lb.setVisible(true);
			}
		});
		btnBack.setText("Back");
		btnBack.setForeground(new Color(255, 250, 250));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBackground(new Color(0, 100, 0));
		btnBack.setBounds(259, 221, 149, 33);
		contentPane.add(btnBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 100, 0));
		panel_1.setBounds(247, 0, 356, 72);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setBounds(22, 5, 324, 56);
		panel_1.add(jLabel1);
		jLabel1.setForeground(new Color(255, 250, 250));
		jLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
		jLabel1.setText("New Librarian Account");
	}
}

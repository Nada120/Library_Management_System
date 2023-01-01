package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import classes.Student;
import filesData.StudentAccounts;
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

public class NewStudentAccount extends JFrame {

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
	public NewStudentAccount() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 313);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 249, 274);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\images\\add-user.png"));
		lblNewLabel.setBounds(0, 0, 249, 274);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 100, 0));
		panel_1.setBounds(247, 0, 316, 78);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setForeground(new Color(255, 250, 250));
		jLabel1.setFont(new Font("Dialog", Font.BOLD, 20));
		jLabel1.setText("New Student Account");
		jLabel1.setBounds(10, 0, 288, 78);
		panel_1.add(jLabel1);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setForeground(new Color(0, 100, 0));
		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabel2.setText("name");
		jLabel2.setBounds(259, 89, 76, 21);
		contentPane.add(jLabel2);
		
		JLabel lblAge = new JLabel();
		lblAge.setText("Age");
		lblAge.setForeground(new Color(0, 100, 0));
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge.setBounds(259, 121, 76, 21);
		contentPane.add(lblAge);
		
		JLabel lblUsername = new JLabel();
		lblUsername.setText("Username");
		lblUsername.setForeground(new Color(0, 100, 0));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(259, 153, 76, 21);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel();
		lblPassword.setText("Password");
		lblPassword.setForeground(new Color(0, 100, 0));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(259, 185, 76, 21);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(336, 89, 212, 21);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(336, 121, 212, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(336, 153, 212, 21);
		contentPane.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(336, 185, 212, 20);
		contentPane.add(passwordField);
		
		JButton jButton1 = new JButton();
		jButton1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Student l = new Student();
				StudentAccounts la = new StudentAccounts();
				l.name = textField.getText();
				l.username = textField_2.getText();
				l.password = passwordField.getText();
				
				if(l.name.isEmpty() || textField_1.getText().isEmpty() || l.username.isEmpty() || l.password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Can not be Empty");
				}
				else if(la.IsStudentExisting(l.name)){
					JOptionPane.showMessageDialog(null, "The name of Student is Existing");
				}
				else {
					l.age = Integer.parseInt(textField_1.getText());
					la.SaveStudentAccount(l);
					dispose();
					StudentAction lc = new StudentAction(l.username);
					lc.setLocationRelativeTo(null);
					lc.setVisible(true);
				}
				
			}
		});
		jButton1.setText("Create");
		jButton1.setForeground(new Color(255, 250, 250));
		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jButton1.setBackground(new Color(0, 100, 0));
		jButton1.setBounds(407, 217, 141, 33);
		contentPane.add(jButton1);
		
		JButton jButton1_1 = new JButton();
		jButton1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginStudent l = new LoginStudent();
				l.setLocationRelativeTo(null);
				l.setVisible(true);
			}
		});
		jButton1_1.setText("Back");
		jButton1_1.setForeground(new Color(255, 250, 250));
		jButton1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jButton1_1.setBackground(new Color(0, 100, 0));
		jButton1_1.setBounds(259, 217, 138, 33);
		contentPane.add(jButton1_1);
	}
}

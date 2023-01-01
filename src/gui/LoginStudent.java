package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import classes.Student;
import filesData.StudentAccounts;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginStudent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public LoginStudent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 299);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(0, 0, 731, 91);
		contentPane.add(panel);
		
		JLabel lblLibrarianLogin = new JLabel();
		lblLibrarianLogin.setIcon(null);
		lblLibrarianLogin.setBounds(0, 0, 731, 91);
		panel.add(lblLibrarianLogin);
		lblLibrarianLogin.setText("Student Login");
		lblLibrarianLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibrarianLogin.setForeground(new Color(255, 250, 250));
		lblLibrarianLogin.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainScreen ms = new MainScreen();
				ms.setLocationRelativeTo(null);
				ms.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(".\\images\\backArrow.png"));
		btnNewButton.setBackground(new Color(0, 100, 0));
		btnNewButton.setBounds(0, 0, 76, 91);
		panel.add(btnNewButton);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setText("User Name");
		jLabel1.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel1.setForeground(new Color(0, 100, 0));
		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jLabel1.setBounds(281, 102, 140, 33);
		contentPane.add(jLabel1);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Password");
		jLabel2.setHorizontalAlignment(SwingConstants.LEFT);
		jLabel2.setForeground(new Color(0, 100, 0));
		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jLabel2.setBounds(281, 144, 140, 31);
		contentPane.add(jLabel2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(426, 102, 295, 33);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(426, 144, 295, 31);
		contentPane.add(passwordField);
		
		JButton btnCreate = new JButton();
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NewStudentAccount ns = new NewStudentAccount();
				ns.setLocationRelativeTo(null);
				ns.setVisible(true);
			}
		});
		btnCreate.setText("Create");
		btnCreate.setForeground(new Color(255, 250, 250));
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCreate.setBackground(new Color(0, 100, 0));
		btnCreate.setBounds(281, 196, 205, 39);
		contentPane.add(btnCreate);
		
		JButton jButton1 = new JButton();
		jButton1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Student s = new Student();
				StudentAccounts sa = new StudentAccounts();
				s.username = textField.getText();
				s.password = passwordField.getText();
				if(s.username.isEmpty() || s.password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Username and Password can not be Empty");
				}
				else if(sa.IsPasswordUsernameExisting(s.username, s.password)) {
					if(sa.IsStudentDeleted(s.username, s.password)) {
						JOptionPane.showMessageDialog(null, "You have been Deleted");
					}
					else {
						dispose();
						StudentAction sc = new StudentAction(s.username);
						sc.setLocationRelativeTo(null);
						sc.setVisible(true);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Username and Password is not correct");
				}
			}
		});
		jButton1.setText("Login");
		jButton1.setForeground(new Color(255, 250, 250));
		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jButton1.setBackground(new Color(0, 100, 0));
		jButton1.setBounds(503, 196, 218, 39);
		contentPane.add(jButton1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 250));
		panel_1.setBounds(0, 91, 271, 169);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setIcon(new ImageIcon(".\\images\\person.png"));
		lblNewLabel.setBounds(0, 0, 271, 169);
		panel_1.add(lblNewLabel);
	}
}
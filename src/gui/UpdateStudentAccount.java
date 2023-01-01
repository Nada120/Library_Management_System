package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import classes.Student;
import filesData.StudentAccounts;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStudentAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UpdateStudentAccount(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 331);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAge = new JLabel();
		lblAge.setForeground(new Color(0, 100, 0));
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setText("Age");
		lblAge.setBounds(233, 130, 114, 28);
		contentPane.add(lblAge);
		
		JLabel lblUserName = new JLabel();
		lblUserName.setForeground(new Color(0, 100, 0));
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserName.setText("User Name");
		lblUserName.setBounds(233, 89, 114, 30);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel();
		lblPassword.setForeground(new Color(0, 100, 0));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setText("Password");
		lblPassword.setBounds(233, 164, 114, 34);
		contentPane.add(lblPassword);
		
		JLabel lblUpdateTheAccount = new JLabel();
		lblUpdateTheAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTheAccount.setForeground(new Color(0, 100, 0));
		lblUpdateTheAccount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUpdateTheAccount.setText("Update The Account");
		lblUpdateTheAccount.setBounds(233, 11, 331, 48);
		contentPane.add(lblUpdateTheAccount);
		
		JButton jButton1 = new JButton();
		jButton1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
					Student l = new Student();
					StudentAccounts la = new StudentAccounts();
					l.username = textField.getText();
					l.password = passwordField.getText();
					if(l.username.isEmpty() && l.password.isEmpty() && textField_1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Can not All be Empty");
					}
					if(!l.username.isEmpty()) {
						la.UpdateUsernameStudentAccount(l.username, username);
						JOptionPane.showMessageDialog(null, "Username is Updated");
						dispose();
						UpdateStudentAccount n = new UpdateStudentAccount(l.username);
						n.setLocationRelativeTo(null);
						n.setVisible(true);
					}
					if(!l.password.isEmpty()) {
						la.UpdatePasswordStudentAccount(l.password, username);
						JOptionPane.showMessageDialog(null, "Password is Updated"); 
					}
					if(!textField_1.getText().isEmpty()) {
						la.UpdateAgeStudentAccount(textField_1.getText(), username);
						JOptionPane.showMessageDialog(null, "Age is Updated");
					}
			}
		});
		jButton1.setBackground(new Color(0, 100, 0));
		jButton1.setForeground(new Color(255, 250, 250));
		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jButton1.setText("Update");
		jButton1.setBounds(392, 222, 156, 35);
		contentPane.add(jButton1);
		
		textField = new JTextField();
		textField.setBounds(351, 89, 197, 31);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(351, 128, 197, 31);
		contentPane.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(351, 164, 197, 34);
		contentPane.add(passwordField);
		
		JButton btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentAction s = new StudentAction(username);
				s.setLocationRelativeTo(null);
				s.setVisible(true);
			}
			
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBackground(new Color(0, 100, 0));
		btnBack.setForeground(new Color(255, 250, 250));
		btnBack.setText("Back");
		btnBack.setBounds(233, 222, 156, 35);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(0, 0, 214, 292);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(".\\images\\profile.png"));
		lblNewLabel.setBounds(0, 11, 214, 96);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(username);
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 118, 214, 30);
		panel.add(lblNewLabel_1);
	}
}

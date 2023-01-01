package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import classes.Librarian;
import filesData.StudentAccounts;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DeleteStudent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public DeleteStudent(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setForeground(new Color(0, 100, 0));
		jLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
		jLabel1.setText("Remove Student ");
		jLabel1.setBounds(478, 11, 184, 33);
		contentPane.add(jLabel1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 470, 397);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\images\\students.png"));
		lblNewLabel.setBounds(0, 0, 470, 397);
		panel.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel();
		lblStudentId.setForeground(new Color(0, 100, 0));
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentId.setText("Student ID");
		lblStudentId.setBounds(478, 57, 83, 26);
		contentPane.add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(561, 57, 225, 26);
		contentPane.add(textField);
		
		JButton btnDelete = new JButton();
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LibrarianAction la = new LibrarianAction(username);
				la.setLocationRelativeTo(null);
				la.setVisible(true);
			}
		});
		btnDelete.setBackground(new Color(0, 100, 0));
		btnDelete.setForeground(new Color(255, 250, 250));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setText("Back");
		btnDelete.setBounds(478, 96, 149, 33);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			Librarian l = new Librarian();
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID can not be Empty");
				}
				else {
					l.DeleteStudent(textField.getText());
					JOptionPane.showMessageDialog(null, "The Student has been Deleted");
					dispose();
					DeleteStudent d = new DeleteStudent(username);
					d.setLocationRelativeTo(null);
					d.setVisible(true);
				}
			}
		});
		btnBack.setText("Delete");
		btnBack.setForeground(new Color(255, 250, 250));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBackground(new Color(0, 100, 0));
		btnBack.setBounds(637, 96, 149, 33);
		contentPane.add(btnBack);
		
		// Table code
		StudentAccounts s = new StudentAccounts();
		String[][] rec = s.ReadStudentAccount();
	    String[] header = {"ID", "Name", "Age", "Username"};
		JTable table_1 = new JTable(rec, header);
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setBackground(new Color(255, 250, 250));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_1.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(478, 165, 308, 211);
		contentPane.add(scrollPane);
		
	}
}

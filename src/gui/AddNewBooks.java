package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Books;
import filesData.AllBooks;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewBooks extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AddNewBooks(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setForeground(new Color(0, 100, 0));
		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabel2.setText("Title");
		jLabel2.setBounds(10, 146, 93, 25);
		contentPane.add(jLabel2);
		
		JLabel lblDetails = new JLabel();
		lblDetails.setText("Details");
		lblDetails.setForeground(new Color(0, 100, 0));
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDetails.setBounds(10, 182, 93, 23);
		contentPane.add(lblDetails);
		
		JLabel lblPubilsher = new JLabel();
		lblPubilsher.setText("pubilsher");
		lblPubilsher.setForeground(new Color(0, 100, 0));
		lblPubilsher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPubilsher.setBounds(10, 216, 93, 25);
		contentPane.add(lblPubilsher);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(100, 146, 212, 25);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(100, 183, 212, 25);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(100, 218, 212, 25);
		contentPane.add(textField_2);
		
		JButton jButton1 = new JButton();
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Books b = new Books();
				AllBooks ab = new AllBooks();
				b.details = textField_1.getText();
				b.title = textField.getText();
				b.publisher = textField_2.getText();
				if(b.details.isEmpty() || b.title.isEmpty() || b.publisher.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Can not All be Empty");
				}
				else {
					ab.SaveBooks(b);
					JOptionPane.showMessageDialog(null, "The Book has been Added");
					dispose();
					AddNewBooks a = new AddNewBooks(username);
					a.setLocationRelativeTo(null);
					a.setVisible(true);
				}
			}
		});
		jButton1.setForeground(new Color(255, 250, 250));
		jButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jButton1.setText("Add Book");
		jButton1.setBackground(new Color(0, 100, 0));
		jButton1.setBounds(165, 266, 147, 33);
		contentPane.add(jButton1);
		
		JButton btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LibrarianAction la = new LibrarianAction(username);
				la.setLocationRelativeTo(null);
				la.setVisible(true);
			}
		});
		btnBack.setText("Back");
		btnBack.setForeground(new Color(255, 250, 250));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBackground(new Color(0, 100, 0));
		btnBack.setBounds(10, 266, 145, 33);
		contentPane.add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(0, 0, 628, 93);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel jLabel1 = new JLabel();
		jLabel1.setBounds(10, 11, 304, 82);
		panel.add(jLabel1);
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setForeground(new Color(255, 250, 250));
		jLabel1.setBackground(new Color(255, 250, 250));
		jLabel1.setText("Add New Book");
		jLabel1.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\images\\books.jpg"));
		lblNewLabel.setBounds(344, 0, 284, 93);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 100, 0));
		panel_1.setBounds(343, 91, 285, 230);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBooks = new JLabel();
		lblBooks.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBooks.setText("Books");
		lblBooks.setHorizontalAlignment(SwingConstants.LEFT);
		lblBooks.setForeground(new Color(255, 250, 250));
		lblBooks.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBooks.setBackground(new Color(255, 250, 250));
		lblBooks.setBounds(10, 11, 265, 43);
		panel_1.add(lblBooks);
		
		
		// add table of data books
		AllBooks a = new AllBooks();
	    String[][] rec = a.ReadAllBooks();
	    String[] header = {"ID", "Title", "Details", "Publisher"};
		JTable table_1 = new JTable(rec, header);
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setBackground(new Color(255, 250, 250));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_1.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(10, 65, 265, 150);
		panel_1.add(scrollPane);
		
		
	}
}

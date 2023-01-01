package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import classes.Books;
import filesData.AllBooks;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrowingBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public BorrowingBook(String username) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 318);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setForeground(new Color(0, 100, 0));
		jLabel2.setFont(new Font("Tahoma", Font.BOLD, 20));
		jLabel2.setText("Borrowing Book");
		jLabel2.setBounds(10, 30, 261, 28);
		contentPane.add(jLabel2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(281, 0, 284, 279);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Books");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 93, 102, 29);
		panel.add(lblNewLabel);
		
		JLabel lblBookName = new JLabel();
		lblBookName.setForeground(new Color(0, 100, 0));
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBookName.setText("Book ID");
		lblBookName.setBounds(10, 94, 87, 28);
		contentPane.add(lblBookName);
		
		JLabel lblReturnDate = new JLabel();
		lblReturnDate.setText("Return Date");
		lblReturnDate.setForeground(new Color(0, 100, 0));
		lblReturnDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReturnDate.setBounds(10, 136, 87, 28);
		contentPane.add(lblReturnDate);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(98, 94, 173, 28);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(98, 138, 173, 28);
		contentPane.add(textField_1);
		
		JButton btnBorrow = new JButton();
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AllBooks ab = new AllBooks();
				Books b = new Books();
				if(textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Can not All be Empty");
				}
				else {
					if(ab.IsBorrowedBook(textField.getText())) {
						JOptionPane.showMessageDialog(null, "This Book is Already Taken");
					}
					else {
						b.BorrowingBook(textField.getText());
						JOptionPane.showMessageDialog(null, "You have Borrowed this Book");
					}
				}
			}
		});
		btnBorrow.setBackground(new Color(0, 100, 0));
		btnBorrow.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBorrow.setForeground(new Color(255, 250, 250));
		btnBorrow.setText("Borrow");
		btnBorrow.setBounds(141, 203, 130, 35);
		contentPane.add(btnBorrow);
		
		JButton btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudentAction s = new StudentAction(username);
				s.setLocationRelativeTo(null);
				s.setVisible(true);
			}
		});
		btnBack.setText("Back");
		btnBack.setForeground(new Color(255, 250, 250));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnBack.setBackground(new Color(0, 100, 0));
		btnBack.setBounds(10, 203, 121, 35);
		contentPane.add(btnBack);
		
		// Table code
		AllBooks a = new AllBooks();
		String[][] rec = a.ReadAllBooks();
	    String[] header = {"ID", "Title", "Details", "Publisher"};
		JTable table_1 = new JTable(rec, header);
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setBackground(new Color(255, 250, 250));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_1.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(10, 123, 258, 145);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\images\\books.jpg"));
		lblNewLabel_1.setBounds(0, 0, 284, 82);
		panel.add(lblNewLabel_1);
	}
}

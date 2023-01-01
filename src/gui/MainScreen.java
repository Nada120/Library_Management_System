package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setBackground(new Color(255, 250, 250));
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\images\\book.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 356);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(0, 0, 226, 207);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBackground(new Color(255, 250, 250));
		lblNewLabel.setIcon(new ImageIcon(".\\images\\main-screen.png"));
		lblNewLabel.setBounds(0, 0, 225, 209);
		panel.add(lblNewLabel);
		
		JButton jButton2 = new JButton();
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginLibrarian lb = new LoginLibrarian();
				lb.setLocationRelativeTo(null);
				lb.setVisible(true);
			}
		});
		jButton2.setBounds(10, 227, 241, 63);
		contentPane.add(jButton2);
		jButton2.setText("Librarian");
		jButton2.setForeground(new Color(255, 250, 250));
		jButton2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		jButton2.setBackground(new Color(0, 100, 0));
		
		JButton jButton3 = new JButton();
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginStudent ls = new LoginStudent();
				ls.setLocationRelativeTo(null);
				ls.setVisible(true);
			}
		});
		jButton3.setText("Student");
		jButton3.setForeground(new Color(255, 250, 250));
		jButton3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		jButton3.setBackground(new Color(0, 100, 0));
		jButton3.setBounds(261, 227, 245, 63);
		contentPane.add(jButton3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 100, 0));
		panel_1.setBounds(225, 0, 304, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Library");
		lblNewLabel_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setBackground(new Color(255, 250, 250));
		lblNewLabel_1.setBounds(10, 38, 270, 44);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Management");
		lblNewLabel_1_1.setForeground(new Color(255, 250, 250));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1_1.setBackground(new Color(255, 250, 250));
		lblNewLabel_1_1.setBounds(10, 93, 270, 44);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("System");
		lblNewLabel_1_2.setForeground(new Color(255, 250, 250));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1_2.setBackground(new Color(255, 250, 250));
		lblNewLabel_1_2.setBounds(10, 148, 270, 44);
		panel_1.add(lblNewLabel_1_2);
	}
}

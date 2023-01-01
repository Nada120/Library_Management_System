
package gui;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentAction extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	public StudentAction(String username) {
		setBackground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\images\\book.png"));
		getContentPane().setBackground(new Color(255, 250, 250));
        initComponents(username);
    }

    private void initComponents(String username) {

        jLabel1 = new javax.swing.JLabel();
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 45));
        jLabel1.setBackground(new Color(255, 250, 250));
        jLabel1.setForeground(new Color(0, 100, 0));
        jButton1 = new javax.swing.JButton();
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		UpdateStudentAccount u = new UpdateStudentAccount(username);
        		u.setLocationRelativeTo(null);
        		u.setVisible(true);
        	}
        });
        jButton1.setBackground(new Color(0, 100, 0));
        jButton1.setForeground(new Color(255, 250, 250));
        jButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		BorrowingBook b = new BorrowingBook(username);
        		b.setLocationRelativeTo(null);
        		b.setVisible(true);
        	}
        });
        jButton2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jButton2.setBackground(new Color(0, 100, 0));
        jButton2.setForeground(new Color(255, 250, 250));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Student");

        jButton1.setText("Update Account");

        jButton2.setText("Borrow A Book");
        
        panel = new JPanel();
        panel.setBackground(new Color(0, 100, 0));
        
        btnHome = new JButton();
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		MainScreen m = new MainScreen();
        		m.setLocationRelativeTo(null);
        		m.setVisible(true);
        	}
        });
        btnHome.setText("Home");
        btnHome.setForeground(new Color(255, 250, 250));
        btnHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnHome.setBackground(new Color(0, 100, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 245, Short.MAX_VALUE)
        				.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        				.addComponent(btnHome, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        				.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(71)
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
        			.addGap(31)
        			.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(94, Short.MAX_VALUE))
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        panel.setLayout(null);
        
        lblNewLabel = new JLabel(username);
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setForeground(new Color(255, 250, 250));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(104, 299, 160, 97);
        panel.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setIcon(new ImageIcon(".\\images\\profile.png"));
        lblNewLabel_1.setBounds(0, 299, 94, 97);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(".\\images\\study.png"));
        lblNewLabel_2.setBounds(0, 0, 264, 300);
        panel.add(lblNewLabel_2);
        getContentPane().setLayout(layout);

        pack();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JButton btnHome;
}

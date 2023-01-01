
package gui;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianAction extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	public LibrarianAction(String username) {
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
        		DeleteStudent d = new DeleteStudent(username);
        		d.setLocationRelativeTo(null);
        		d.setVisible(true);
        	}
        });
        jButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jButton1.setForeground(new Color(255, 250, 250));
        jButton1.setBackground(new Color(0, 100, 0));
        jButton2 = new javax.swing.JButton();
        jButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		AddNewBooks a = new AddNewBooks(username);
        		a.setLocationRelativeTo(null);
        		a.setVisible(true);
        	}
        });
        jButton2.setBackground(new Color(0, 100, 0));
        jButton2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jButton2.setForeground(new Color(255, 250, 250));
        jButton3 = new javax.swing.JButton();
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		UpdateLibrarianAccount l = new UpdateLibrarianAccount(username);
        		l.setLocationRelativeTo(null);
        		l.setVisible(true);
        	}
        });
        jButton3.setForeground(new Color(255, 250, 250));
        jButton3.setBackground(new Color(0, 100, 0));
        jButton3.setFont(new Font("Tahoma", Font.PLAIN, 20));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Librarian");

        jButton1.setText("Remove Student");

        jButton2.setText("Add Book");

        jButton3.setText("Update Account");
        
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
        
        lblNewLabel_2 = new JLabel("");
        
        lblNewLabel = new JLabel("");
        lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(new ImageIcon(".\\images\\librarian.png"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 245, Short.MAX_VALUE)
        						.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        						.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
        						.addComponent(jLabel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNewLabel_2))
        				.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(jLabel1)
        			.addGap(18)
        			.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addGap(28))
        		.addGroup(layout.createSequentialGroup()
        			.addGap(39)
        			.addComponent(lblNewLabel_2)
        			.addContainerGap(287, Short.MAX_VALUE))
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
        );
        panel.setLayout(null);
        
        lblNewLabel_1 = new JLabel(username);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setForeground(new Color(255, 250, 250));
        lblNewLabel_1.setBackground(new Color(255, 250, 250));
        lblNewLabel_1.setBounds(112, 0, 187, 154);
        panel.add(lblNewLabel_1);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(".\\images\\profile.png"));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setBounds(0, 0, 102, 154);
        panel.add(lblNewLabel_3);
        getContentPane().setLayout(layout);

        pack();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private JPanel panel;
    private JButton btnHome;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_3;
    // End of variables declaration//GEN-END:variables
}

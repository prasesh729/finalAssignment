package hostelms1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import javax.swing.JFrame;
import java.awt.Color;

public class login implements ActionListener{

	JFrame f;
	JLabel title_lbl;
	JTextField uname_TF;
    JButton login_btn;
    JPasswordField pswd_F;
	
	public static void main(String[] args) {
		new login();

	}

	public login() {
		f=new JFrame("Login");
		f.getContentPane().setFont(new Font("Arial", Font.PLAIN, 18));

		//-----------------------------------------------------title lbl---------------------------------
	    title_lbl=new JLabel("LOGIN PAGE");
	    title_lbl.setForeground(Color.WHITE);
	    title_lbl.setFont(new Font("Arial", Font.BOLD, 30));
	    title_lbl.setBounds(172, 21, 209, 80);
	    f.getContentPane().add(title_lbl);
	    f.setSize(552, 488);
	    f.getContentPane().setLayout(null);
	    
	    JLabel uname = new JLabel("Username :-");
	    uname.setForeground(Color.WHITE);
	    uname.setFont(new Font("Arial", Font.PLAIN, 20));
	    uname.setBounds(69, 128, 132, 49);
	    f.getContentPane().add(uname);
	    
	    JLabel pswd_lbl = new JLabel("Password :-");
	    pswd_lbl.setForeground(Color.WHITE);
	    pswd_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    pswd_lbl.setBounds(69, 226, 132, 44);
	    f.getContentPane().add(pswd_lbl);

//--------------------------------------------------------------text field--------------------------------------------------------- 
	    uname_TF = new JTextField();
	    uname_TF.setForeground(Color.BLACK);
	    uname_TF.setFont(new Font("Arial", Font.PLAIN, 20));
	    uname_TF.setBounds(226, 134, 226, 44);
	    f.getContentPane().add(uname_TF);
	    uname_TF.setColumns(10);
	    
	    login_btn = new JButton("Login ");
	    login_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    login_btn.setBounds(226, 331, 122, 49);
	    login_btn.addActionListener(this);
	    f.getContentPane().add(login_btn);
	    
	    pswd_F = new JPasswordField();
	    pswd_F.setFont(new Font("Arial", Font.PLAIN, 20));
	    pswd_F.setBounds(226, 227, 226, 43);
	    f.getContentPane().add(pswd_F);
	    
	    JLabel login_bg_image = new JLabel("");
	    login_bg_image.setBackground(Color.WHITE);
	    login_bg_image.setIcon(new ImageIcon("images/lhostel_bg (1).jpg"));
	    login_bg_image.setBounds(0, 0, 538, 451);
	    f.getContentPane().add(login_bg_image);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    		
	}

//-------------------------------------------------------------login btn fucntion------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		
			if(e.getSource() == login_btn){
			String uname = uname_TF.getText();
			String pswd = pswd_F.getText();
			try {		
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelms", "root", "Tha@chaina729");
            PreparedStatement st = (PreparedStatement) con.prepareStatement("Select username, password from userdetails where username=? and password=?");

			st.setString(1, uname);
			st.setString(2, pswd);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
			JOptionPane.showMessageDialog(f, "You have successfully logged in");
			f.dispose();
			new adashboard();
			}
			
			else {
			JOptionPane.showMessageDialog(f, "Wrong Username & Password");
			uname_TF.setText("");
			pswd_F.setText("");
			}
			}
			
			catch (SQLException sqlException) {
			sqlException.printStackTrace();
			}
			}}
	}	



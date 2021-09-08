package hostelms1;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class aregister implements ActionListener{

	JFrame f;
	JLabel title_lbl;
	JTextField uname_tf,fname_tf,lname_tf,contact_tf,
	age_tf,address_tf;
	JButton register_btn, clear_btn;
	JPasswordField pswd_f,cpswd_f;
	JComboBox gender_cbox;
	 
	
	public static void main(String[] args) {
		new aregister();

	}


	public aregister() {
		f=new JFrame("");

	    title_lbl=new JLabel("REGISTER");
	    title_lbl.setFont(new Font("Arial", Font.BOLD, 26));
	    title_lbl.setBounds(279, 10, 152, 80);
	   
	    f.getContentPane().add(title_lbl);
	    f.setSize(669, 744);
	    f.getContentPane().setLayout(null);
	
	    
	//---------------------------------------------------------------label----------------------------------------------------------
	    JLabel fname_lbl = new JLabel("First Name :");
	    fname_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    fname_lbl.setBounds(85, 97, 130, 39);
	    f.getContentPane().add(fname_lbl);
	    
	    JLabel uname_lbl = new JLabel("User Name :");
	    uname_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    uname_lbl.setBounds(85, 217, 130, 39);
	    f.getContentPane().add(uname_lbl);
	    
	    JLabel gender_lbl = new JLabel("Gender :");
	    gender_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    gender_lbl.setBounds(85, 275, 130, 39);
	    f.getContentPane().add(gender_lbl);
	    
	    JLabel age_lbl = new JLabel("Age :");
	    age_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    age_lbl.setBounds(85, 333, 130, 39);
	    f.getContentPane().add(age_lbl);
	    
	    JLabel contact_lbl = new JLabel("Contact No :");
	    contact_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    contact_lbl.setBounds(85, 395, 130, 39);
	    f.getContentPane().add(contact_lbl);
	    
	    JLabel address_lbl = new JLabel("Address :");
	    address_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    address_lbl.setBounds(85, 454, 130, 39);
	    f.getContentPane().add(address_lbl);
	    
	    JLabel pswd_lbl = new JLabel("Password :");
	    pswd_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    pswd_lbl.setBounds(85, 513, 130, 39);
	    f.getContentPane().add(pswd_lbl);
	    
	    JLabel cpswd_lbl = new JLabel("Confirm Password :");
	    cpswd_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    cpswd_lbl.setBounds(85, 569, 198, 39);
	    f.getContentPane().add(cpswd_lbl);
	    
	    JLabel lname_lbl = new JLabel("Last Name :");
	    lname_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    lname_lbl.setBounds(85, 156, 130, 39);
	    f.getContentPane().add(lname_lbl);
	    
	    
	 //-------------------------------------------------------------------------Fields --------------------------------------------------------   
	   
	    fname_tf= new JTextField();
	    fname_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    fname_tf.setBounds(283, 97, 274, 39);
	    f.getContentPane().add(fname_tf);
	    fname_tf.setColumns(10);
	    	    
	    lname_tf = new JTextField();
	    lname_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    lname_tf.setColumns(10);
	    lname_tf.setBounds(283, 156, 274, 39);
	    f.getContentPane().add(lname_tf);
	    
	    uname_tf = new JTextField();
	    uname_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    uname_tf.setColumns(10);
	    uname_tf.setBounds(283, 217, 274, 39);
	    f.getContentPane().add(uname_tf);
	    
	    age_tf = new JTextField();
	    age_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    age_tf.setColumns(10);
	    age_tf.setBounds(283, 333, 274, 39);
	    f.getContentPane().add(age_tf);
	    
	    contact_tf = new JTextField();
	    contact_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    contact_tf.setColumns(10);
	    contact_tf.setBounds(283, 395, 274, 39);
	    f.getContentPane().add(contact_tf);
	    
	    address_tf = new JTextField();
	    address_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    address_tf.setColumns(10);
	    address_tf.setBounds(283, 454, 274, 39);
	    f.getContentPane().add(address_tf);
	    
	    pswd_f = new JPasswordField();
	    pswd_f.setBounds(283, 516, 274, 39);
	    f.getContentPane().add(pswd_f);
	    
	    cpswd_f = new JPasswordField();
	    cpswd_f.setBounds(283, 572, 274, 39);
	    f.getContentPane().add(cpswd_f);
	    
	    gender_cbox = new JComboBox();
	    gender_cbox.setFont(new Font("Arial", Font.PLAIN, 20));
	    gender_cbox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
	    gender_cbox.setBounds(283, 278, 274, 39);
	    f.getContentPane().add(gender_cbox);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	 
	    //-------------------------BUTTON-------------------------------
	    register_btn = new JButton("Register");
	    register_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    register_btn.setBounds(279, 637, 152, 47);
	    register_btn.addActionListener(this);
	    f.getContentPane().add(register_btn);
	    
	    clear_btn = new JButton("Clear");
	    clear_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    clear_btn.setBounds(441, 637, 115, 47);
	    clear_btn.addActionListener(this);
	    f.getContentPane().add(clear_btn);
	    		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		
		//-----------------------------------------------------------------------CLEAR BTN FUNCTION-----------------------------------------------------------------------------	
		if(e.getSource() == clear_btn){
			fname_tf.setText("");
			lname_tf.setText("");
			uname_tf.setText("");
			age_tf.setText("");
			gender_cbox.setToolTipText("");
			contact_tf.setText("");
			address_tf.setText("");
			pswd_f.setText("");
			cpswd_f.setText("");		
		}
		
		
		//-----------------------------------------------------------------------REGITSER BTN FUNCTION-----------------------------------------------------------------------
			
		if(e.getSource() == register_btn){
			String fname = fname_tf.getText();
			String lname = lname_tf.getText();
			String uname = uname_tf.getText();
			String age = age_tf.getText();
			String gender = gender_cbox.getSelectedItem().toString();
			String c_no = contact_tf.getText();
			String address = address_tf.getText();
			String pswd = pswd_f.getText();
			String cpswd = cpswd_f.getText();
			
			try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelms", "root", "Tha@chaina729");
            PreparedStatement st = connection.prepareStatement("Insert into userdetails values (?,?,? ,?,?,?,?,?,?)");
        	   
            if (fname.equals("")) {
				JOptionPane.showMessageDialog(f, "Firstname cannot be empty");
			}
            
            else if(uname.equals("")){
            	JOptionPane.showMessageDialog(f, "Username cannot be empty");
            }
            
            else if(age.equals("")){
            	JOptionPane.showMessageDialog(f, "age cannot be empty");
            }
                    
            else if(c_no.equals("")){
            	JOptionPane.showMessageDialog(f, "Contact NO cannot be empty");
            }
            
            else if(pswd.equals("")){
            	JOptionPane.showMessageDialog(f, "Password cannot be empty");
            }
            
                       
       else {
    	    
            String fpswd = pswd_f.getText();
			String spswd = cpswd_f.getText();
			
			if (fpswd.equals(spswd)){
				   
				   st.setString(1, fname);
		 			st.setString(2, lname);
		 			st.setString(3, uname);
		 	 	    st.setString(4, age);
		 	 	    st.setString( 5,gender);
		 	 		st.setString(6, c_no);
		 	 		st.setString(7, address);
		 	 		st.setString(8, pswd);
		 	 		st.setString(9, cpswd);
					int ct = st.executeUpdate();
				if (ct > 0) {
					JOptionPane.showMessageDialog(f, "You have successfully registered");
					f.dispose();
					new login();
					}
					
					else {
					JOptionPane.showMessageDialog(f, "Plz again register");

					}
				}
			
			else {
				JOptionPane.showMessageDialog(f, "Password doesnotmatch ");
			}	
	  }		
}			
			catch (SQLException sqlException) {
			sqlException.printStackTrace();
			}
		}
				
	}	
	
	

				
	
}

package hostelms1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adashboard implements ActionListener {

	JFrame f;
	JLabel title_lbl,fname_lbl;
	JLayeredPane Room_lpane,Profile_lpane;
	JTextField uname_tf,fname_tf,lname_tf,contact_tf,age_tf,address_tf;
    JButton update_btn,clear_btn,delete_btn;
    JComboBox gender_cbox;
    JTable table;
   
    
	public static void main(String[] args) {
		new adashboard();

	}


	public adashboard() {
		f=new JFrame("Hostel");
		

		title_lbl=new JLabel("HOSTEL MANAGEMNET SYSTEM");
		title_lbl.setFont(new Font("Arial", Font.BOLD, 36));
	    title_lbl.setBounds(429, 27, 603, 80);
	    
	    
	    f.getContentPane().add(title_lbl);
	    f.setSize(1400, 829);
	    f.getContentPane().setLayout(null);
	   // f.showTabledata();
	    
	    JTabbedPane mainf_tpane = new JTabbedPane(JTabbedPane.TOP);
	    mainf_tpane.setBounds(44, 117, 1297, 639);
	    f.getContentPane().add(mainf_tpane);
	    mainf_tpane.setFont(new Font("Arial", Font.PLAIN, 20));
	    
	    Profile_lpane = new JLayeredPane();
	    mainf_tpane.addTab("Profile", null, Profile_lpane, null);
	    
	    fname_lbl = new JLabel("First Name :");
	    fname_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    fname_lbl.setBounds(71, 44, 130, 39);
	    Profile_lpane.add(fname_lbl);
	    
	    JLabel lname_lbl = new JLabel("Last Name :");
	    lname_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    lname_lbl.setBounds(71, 118, 130, 39);
	    Profile_lpane.add(lname_lbl);
	    
	    fname_tf = new JTextField();
	    fname_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    fname_tf.setColumns(10);
	    fname_tf.setBounds(273, 44, 274, 39);
	    Profile_lpane.add(fname_tf);
	    
	    lname_tf = new JTextField();
	    lname_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    lname_tf.setColumns(10);
	    lname_tf.setBounds(273, 118, 274, 39);
	    Profile_lpane.add(lname_tf);
	    
	    uname_tf = new JTextField();
	    uname_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    uname_tf.setColumns(10);
	    uname_tf.setBounds(273, 191, 274, 39);
	    Profile_lpane.add(uname_tf);
	    
	    JLabel uname_lbl = new JLabel("User Name :");
	    uname_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    uname_lbl.setBounds(71, 191, 130, 39);
	    Profile_lpane.add(uname_lbl);
	    
	    JLabel gender_lbl = new JLabel("Gender :");
	    gender_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    gender_lbl.setBounds(71, 329, 130, 39);
	    Profile_lpane.add(gender_lbl);
	    
	    JLabel age_lbl = new JLabel("Age :");
	    age_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    age_lbl.setBounds(71, 265, 130, 39);
	    Profile_lpane.add(age_lbl);
	    
	    JLabel contact_lbl = new JLabel("Contact No :");
	    contact_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    contact_lbl.setBounds(71, 394, 130, 39);
	    Profile_lpane.add(contact_lbl);
	    
	    JLabel address_lbl = new JLabel("Address :");
	    address_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    address_lbl.setBounds(71, 459, 130, 39);
	    Profile_lpane.add(address_lbl);
	    
	    age_tf = new JTextField();
	    age_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    age_tf.setColumns(10);
	    age_tf.setBounds(273, 265, 274, 39);
	    Profile_lpane.add(age_tf);
	    
	    contact_tf = new JTextField();
	    contact_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    contact_tf.setColumns(10);
	    contact_tf.setBounds(273, 394, 274, 39);
	    Profile_lpane.add(contact_tf);
	    
	    address_tf = new JTextField();
	    address_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    address_tf.setColumns(10);
	    address_tf.setBounds(273, 459, 274, 39);
	    Profile_lpane.add(address_tf);
	    
	    update_btn  = new JButton("UPDATE");
	    update_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    update_btn.setBounds(273, 520, 137, 56);
	    update_btn.addActionListener(this);
	    Profile_lpane.add(update_btn);
	    
	    clear_btn = new JButton("CLEAR");
	    clear_btn.addActionListener(this);
	    	
	    clear_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    clear_btn.setBounds(420, 520, 130, 56);
	    Profile_lpane.add(clear_btn);
	    
	    gender_cbox = new JComboBox();
	    gender_cbox.setFont(new Font("Arial", Font.PLAIN, 20));
	    gender_cbox.setModel(new DefaultComboBoxModel(new String[] {"Male\t", "Female"}));
	    gender_cbox.setBounds(273, 327, 274, 42);
	    Profile_lpane.add(gender_cbox); 
	    
	    JPanel viewusers_panel = new JPanel();
	    viewusers_panel.setBounds(615, 44, 618, 532);
	    Profile_lpane.add(viewusers_panel);
	    viewusers_panel.setLayout(null);
	    
	    JScrollPane profile_spane = new JScrollPane();
	    profile_spane.setBounds(10, 10, 598, 446);
	    viewusers_panel.add(profile_spane);
	    
	    table = new JTable();
	    table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		DefaultTableModel RecordTable = (DefaultTableModel)table.getModel();
                int SelectedRows =table.getSelectedRow();
                fname_tf.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
                lname_tf.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
                uname_tf.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
                age_tf.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
                gender_cbox.setToolTipText(RecordTable.getValueAt(SelectedRows, 4).toString());
                contact_tf.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
                address_tf.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
            
                

	    		
	    	}
	    });
	    
	    
	    table.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"First Name", "Last Name", "User Name", "Age", "Gender", "Contact No", "Address"
	    	}
	    ));
	    table.setFont(new Font("Arial", Font.PLAIN, 18));
	    profile_spane.setViewportView(table);
	    	    
	    
	    JButton viewdetails_btn = new JButton("VIEW ALL DETAILS ");
	    viewdetails_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    viewdetails_btn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		 try {
	    		        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelms","root","Tha@chaina729");
	    		        Statement st = myConn.createStatement();
	    		        String sql = "select firstname,lastname,username,age,gender,contact_no,address,password,cpassword from userdetails";
	    		        ResultSet rs = st.executeQuery(sql);
	    		       
	    		        while(rs.next()) {
	    				    String fname = rs.getString("firstname");
	    					String lname = rs.getString("lastname");
	    					String uname = rs.getString("username");
	    					String age = rs.getString("age");
	    					String gender = rs.getString("gender");
	    					String c_no = rs.getString("contact_no");
	    					String address = rs.getString("address");
	    					String pswd = rs.getString("password");
	    					String cpswd = rs.getString("cpassword");
	    		            String tbData [] = {fname,lname,uname,age,gender,c_no,address};
	    		           
	    		            DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
	    		           
	    		            tblModel.addRow(tbData);
	    		        }
	    		   
	    		    myConn.close();
	    		       
	    		    }catch(Exception ex) {
	    		        System.out.println(ex.getMessage());
	    		        }
	    		    }
	    	
	    });
	    
	    viewdetails_btn.setBounds(10, 466, 297, 56);
	    viewusers_panel.add(viewdetails_btn);
	    
	    delete_btn = new JButton("DELETE");
	    delete_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    delete_btn.setBounds(317, 466, 291, 56);
	    delete_btn.addActionListener(this);
	    viewusers_panel.add(delete_btn);
	   
	    Room_lpane = new JLayeredPane();
	    mainf_tpane.addTab("Room", null, Room_lpane, null);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    String fname = fname_tf.getText();
        String lname = lname_tf.getText();
        String uname = uname_tf.getText();
        String age = age_tf.getText();
        String gender = gender_cbox.getSelectedItem().toString();;
        String contact = contact_tf.getText();
        String address = address_tf.getText();
        
       
        
        if (e.getSource() == delete_btn) {
            Dao sdc= new Dao();
            String query = "delete from userdetails where username = '"+uname+"' ";
            int val= sdc.insert(query);
            if (val>0) {
                JOptionPane.showMessageDialog(f,"Data Deleted Successflly");   
                ((DefaultTableModel)table.getModel()).setNumRows(0);
                fname_tf.setText("");
        		lname_tf.setText("");
        		uname_tf.setText("");
        		age_tf.setText("");
        		gender_cbox.setToolTipText("");
        		contact_tf.setText("");
        		address_tf.setText("");
            }
            else {
                JOptionPane.showMessageDialog(f, "Failed to Delete the data");
            }
        }
        
        if (e.getSource() == clear_btn) {
        	fname_tf.setText("");
		lname_tf.setText("");
		uname_tf.setText("");
		age_tf.setText("");
		gender_cbox.setToolTipText("");
		contact_tf.setText("");
		address_tf.setText("");
        ((DefaultTableModel)table.getModel()).setNumRows(0);
        }
      
       
        if (e.getSource() == update_btn) {
            Dao sdc= new Dao();
            String query =" update userdetails set firstname = '"+fname+"', lastname='"+lname+"',username='"+uname+"',age='"+age+"',gender='"+gender+"',contact_no='"+contact+"',address='"+address+"' where username ='"+uname+"' ";
            int val= sdc.insert(query);
            if (val>0) {
                JOptionPane.showMessageDialog(f,"Data Updated Successflly");
                ((DefaultTableModel)table.getModel()).setNumRows(0);
                fname_tf.setText("");
        		lname_tf.setText("");
        		uname_tf.setText("");
        		age_tf.setText("");
        		gender_cbox.setToolTipText("");
        		contact_tf.setText("");
        		address_tf.setText("");
            }
            else {
                JOptionPane.showMessageDialog(f, "Failed to Update data");
            }
        }
		
	}
	
}	





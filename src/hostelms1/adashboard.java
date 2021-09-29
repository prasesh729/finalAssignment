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
	JLabel title_lbl;
	JLayeredPane Room_lpane,Profile_lpane;
	JTextField uname_tf,fname_tf,lname_tf,contact_tf,age_tf,address_tf;
    JButton update_btn,clear_btn,delete_btn,adduser_btn;
    JComboBox gender_cbox,rtype_cbox,roomstatus_cbox;
    JTable profile_table;
    JButton Radd_room_btn,Rupdate_btn,Rdelete_btn;
    JTextField rno_tf,rfloor_tf,rfee_tf;
    JTable roomtable;
    JLabel rtype_lbl, rfee_lbl,roomS_lbl,rfloor_lbl, room_lbl;
    JLabel hostel_bgimg,Room_bgimg;
         
	public static void main(String[] args) {
		new adashboard();

	}


	public adashboard() {
		//---------------------------------------------------------NEW WINDOW OR FRAME CREATED---------------------------------------------------
		f=new JFrame("Hostel");		
		title_lbl=new JLabel("HOSTEL MANAGEMENT SYSTEM");
		title_lbl.setForeground(Color.ORANGE);
		title_lbl.setFont(new Font("Arial", Font.BOLD, 36));
	    title_lbl.setBounds(429, 27, 603, 80);
	    	    
	    f.getContentPane().add(title_lbl);
	    f.setSize(1400, 829);
	    f.getContentPane().setLayout(null);	   
	    
	    
	    //----------------------------------------------------MAIN PANE FOR PROFILE AND ROOM TAB-------------------------------------
	    JTabbedPane mainf_tpane = new JTabbedPane(JTabbedPane.TOP);
	    mainf_tpane.setBounds(44, 117, 1297, 639);
	    f.getContentPane().add(mainf_tpane);
	    mainf_tpane.setFont(new Font("Arial", Font.PLAIN, 20));
	    	    
	    Profile_lpane = new JLayeredPane();
	    mainf_tpane.addTab("Profile", null, Profile_lpane, null);
	    
	    //---------------------------------------------PROFILE LABEL---------------------------------------------
	    JLabel fname_lbl = new JLabel("First Name :");
	    fname_lbl.setForeground(Color.WHITE);
	    fname_lbl.setBackground(Color.BLACK);
	    fname_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    fname_lbl.setBounds(71, 44, 130, 39);
	    Profile_lpane.add(fname_lbl);
	    
	    JLabel lname_lbl = new JLabel("Last Name :");
	    lname_lbl.setForeground(Color.WHITE);
	    lname_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    lname_lbl.setBounds(71, 118, 130, 39);
	    Profile_lpane.add(lname_lbl);
	    
	    JLabel uname_lbl = new JLabel("User Name :");
	    uname_lbl.setForeground(Color.WHITE);
	    uname_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    uname_lbl.setBounds(71, 191, 130, 39);
	    Profile_lpane.add(uname_lbl);
	    
	    JLabel gender_lbl = new JLabel("Gender :");
	    gender_lbl.setForeground(Color.WHITE);
	    gender_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    gender_lbl.setBounds(71, 329, 130, 39);
	    Profile_lpane.add(gender_lbl);
	    
	    JLabel age_lbl = new JLabel("Age :");
	    age_lbl.setForeground(Color.WHITE);
	    age_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    age_lbl.setBounds(71, 265, 130, 39);
	    Profile_lpane.add(age_lbl);
	    
	    JLabel contact_lbl = new JLabel("Contact No :");
	    contact_lbl.setForeground(Color.WHITE);
	    contact_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    contact_lbl.setBounds(71, 394, 130, 39);
	    Profile_lpane.add(contact_lbl);
	    
	    JLabel address_lbl = new JLabel("Address :");
	    address_lbl.setForeground(Color.WHITE);
	    address_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    address_lbl.setBounds(71, 459, 130, 39);
	    Profile_lpane.add(address_lbl);
	   
	    
	    //----------------------------------------------PROFILE TEXTFIELD AND COMBO BOX ---------------------------------------------------------
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
	    
	    gender_cbox = new JComboBox();
	    gender_cbox.setFont(new Font("Arial", Font.PLAIN, 20));
	    gender_cbox.setModel(new DefaultComboBoxModel(new String[] {"Male\t", "Female"}));
	    gender_cbox.setBounds(273, 327, 274, 42);
	    Profile_lpane.add(gender_cbox);

	    
	  //------------------------------------------PANEL AND SCROLLPANE FOR PROFILETABLE-------------------------------------------------
	    JPanel viewUD_panel = new JPanel();
	    viewUD_panel.setBounds(615, 44, 618, 532);
	    Profile_lpane.add(viewUD_panel);
	    viewUD_panel.setLayout(null);
	    
	    JScrollPane profile_spane = new JScrollPane();
	    profile_spane.setBounds(10, 10, 598, 446);
	    viewUD_panel.add(profile_spane);
	    
	    
	    //-----------------------------------------------------PROFILE TABLE-------------------------------------------------
	    profile_table = new JTable();
	    profile_table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		DefaultTableModel RecordTable = (DefaultTableModel)profile_table.getModel();
                int SelectedRows =profile_table.getSelectedRow();
                fname_tf.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
                lname_tf.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
                uname_tf.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
                age_tf.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
                gender_cbox.setToolTipText(RecordTable.getValueAt(SelectedRows, 4).toString());
                contact_tf.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
                address_tf.setText(RecordTable.getValueAt(SelectedRows, 6).toString());                            		
	    	}
	    });	  	    
	    profile_table.setModel(new DefaultTableModel(
	    	new Object[][] {	    	},
	    	new String[] {
	    		"First Name", "Last Name", "User Name", "Age", "Gender", "Contact No", "Address"
	    	}
	    ));
	    profile_table.setFont(new Font("Arial", Font.PLAIN, 14));
	    profile_spane.setViewportView(profile_table);
	    	 
	    
	  //-----------------------------------------------------PROFILE BUTTON-------------------------------------------------
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
	    
	    delete_btn = new JButton("DELETE");
	    delete_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    delete_btn.setBounds(317, 466, 291, 56);
	    delete_btn.addActionListener(this);
	    viewUD_panel.add(delete_btn);
	    
	    adduser_btn = new JButton("ADD USER");
	    adduser_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    adduser_btn.setBounds(71, 520, 175, 56);
	    adduser_btn.addActionListener(this);
	    Profile_lpane.add(adduser_btn);
	    
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
	    		           
	    		            DefaultTableModel tblModel = (DefaultTableModel)profile_table.getModel();	    		           
	    		            tblModel.addRow(tbData);
	    		        }	    		   
	    		    myConn.close();
	    		       
	    		    }catch(Exception ex) {
	    		        System.out.println(ex.getMessage());
	    		        }
	    		    }	    	
	    });  
	    viewdetails_btn.setBounds(10, 466, 297, 56);
	    viewUD_panel.add(viewdetails_btn);
	    
	    JLabel dashboard_bgimg = new JLabel("");
	    dashboard_bgimg.setIcon(new ImageIcon("D:\\hostel_bg (1).jpg"));
	    dashboard_bgimg.setBounds(0, 0, 1292, 601);
	    Profile_lpane.add(dashboard_bgimg);
	    	    	   
	    
	    //---------------------------------------------ROOM WINDOW TEXT FIELD AND COMBO BOX-----------------------------------------------
	    Room_lpane = new JLayeredPane();
	    mainf_tpane.addTab("Room", null, Room_lpane, null);
	    
	    rno_tf = new JTextField();
	    rno_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    rno_tf.setBounds(258, 43, 311, 47);
	    Room_lpane.add(rno_tf);
	    rno_tf.setColumns(10);
	       
	    rfloor_tf = new JTextField();
	    rfloor_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    rfloor_tf.setColumns(10);
	    rfloor_tf.setBounds(258, 334, 311, 47);
	    Room_lpane.add(rfloor_tf);
	    
	    rfee_tf = new JTextField();
	    rfee_tf.setFont(new Font("Arial", Font.PLAIN, 20));
	    rfee_tf.setColumns(10);
	    rfee_tf.setBounds(258, 433, 311, 47);
	    Room_lpane.add(rfee_tf);
	    
	    roomstatus_cbox = new JComboBox();
	    roomstatus_cbox.setModel(new DefaultComboBoxModel(new String[] {"BOOKED\t\t", "NOT BOOKED"}));
	    roomstatus_cbox.setFont(new Font("Arial", Font.PLAIN, 20));
	    roomstatus_cbox.setBounds(258, 140, 311, 46);
	    Room_lpane.add(roomstatus_cbox);
	    
	    rtype_cbox = new JComboBox();
	    rtype_cbox.setFont(new Font("Arial", Font.PLAIN, 20));
	    rtype_cbox.setModel(new DefaultComboBoxModel(new String[] {"COOLER ROOM", "AC ROOM ", "NORMAL ROOM"}));
	    rtype_cbox.setBounds(258, 241, 311, 46);
	    Room_lpane.add(rtype_cbox);
	    	   
	    
	    //--------------------------------------------------ROOM LABEL--------------------------------------------
	    room_lbl = new JLabel("Room No :");
	    room_lbl.setForeground(Color.WHITE);
	    room_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    room_lbl.setBounds(81, 40, 125, 47);
	    Room_lpane.add(room_lbl);
	    
	    roomS_lbl = new JLabel("Room Status :");
	    roomS_lbl.setForeground(Color.WHITE);
	    roomS_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    roomS_lbl.setBounds(81, 140, 150, 47);
	    Room_lpane.add(roomS_lbl);
	    
	    rfloor_lbl = new JLabel("Floor :");
	    rfloor_lbl.setForeground(Color.WHITE);
	    rfloor_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    rfloor_lbl.setBounds(81, 331, 150, 47);
	    Room_lpane.add(rfloor_lbl);
	    
	    rtype_lbl = new JLabel("Type :");
	    rtype_lbl.setForeground(Color.WHITE);
	    rtype_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    rtype_lbl.setBounds(81, 241, 150, 47);
	    Room_lpane.add(rtype_lbl);
	    
	    rfee_lbl = new JLabel("Fee :");
	    rfee_lbl.setForeground(Color.WHITE);
	    rfee_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
	    rfee_lbl.setBounds(81, 430, 150, 47);
	    Room_lpane.add(rfee_lbl);
	    
	    	   	    
	    //------------------------------------------PANEL AND SCROLLPANE FOR ROOMTABLE-------------------------------------------------
	    JPanel viewRoom_panel = new JPanel();
	    viewRoom_panel.setBounds(624, 43, 618, 548);
	    Room_lpane.add(viewRoom_panel);
	    viewRoom_panel.setLayout(null);
	    
	    JScrollPane room_spane = new JScrollPane();
	    room_spane.setBounds(10, 10, 598, 462);
	    viewRoom_panel.add(room_spane);
	  
	    //--------------------------------------------- ROOM TABLE -------------------------------------------------
	    roomtable = new JTable();
	    roomtable.setFont(new Font("Arial", Font.PLAIN, 14));
	    roomtable.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		DefaultTableModel RecordTable = (DefaultTableModel)roomtable.getModel();
                int SelectedRows =roomtable.getSelectedRow();
                rno_tf.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
                roomstatus_cbox.setToolTipText(RecordTable.getValueAt(SelectedRows, 1).toString());
                rtype_cbox.setToolTipText(RecordTable.getValueAt(SelectedRows, 2).toString());
                rfloor_tf.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
                rfee_tf.setText(RecordTable.getValueAt(SelectedRows,4).toString());
                             		
	    	}
	    });
	    
	    roomtable.setModel(new DefaultTableModel(
	    	new Object[][] {
	    	},
	    	new String[] {
	    		"Room No", "Room Status", "Type", "Floor", "Fee"
	    	}
	    ));
	    room_spane.setViewportView(roomtable);
	    
	    	    
	  //--------------------------------------------------------ROOMS WINDOWS BUTTON AND VIEW ALL ROOMS FUNCTION------------------------------------------------------------- 
	    Rdelete_btn = new JButton("DELETE");
	    Rdelete_btn.addActionListener(this);
	    Rdelete_btn.setBounds(317, 482, 291, 56);
	    Rdelete_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    viewRoom_panel.add(Rdelete_btn);
	    
	    Radd_room_btn = new JButton("ADD ROOM");
	    Radd_room_btn.addActionListener(this);
	    Radd_room_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    Radd_room_btn.setBounds(258, 520, 155, 56);
	    Room_lpane.add(Radd_room_btn);
	    
	    Rupdate_btn = new JButton("UPDATE");
	    Rupdate_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    Rupdate_btn.setBounds(419, 520, 150, 56);
	    Rupdate_btn.addActionListener(this);
	    Room_lpane.add(Rupdate_btn);
	    
	    JButton roomdetails_btn = new JButton("VIEW ALL ROOMS ");
	    roomdetails_btn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
    		        Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelms","root","Tha@chaina729");
    		        Statement st = Conn.createStatement();
    		        ((DefaultTableModel)roomtable.getModel()).setNumRows(0);
    		        String sql = "select room_no,room_status,type,floor,fee from room_details";
    		       // 
    		        ResultSet rs = st.executeQuery(sql);
    		       
    		        while(rs.next()) {
    				    String room_n = rs.getString("room_no");
    					String room_status = rs.getString("room_status");
    					String type = rs.getString("type");
    					String floor = rs.getString("floor");
    					String fee = rs.getString("fee");   				
    		            String tbData1 [] = {room_n,room_status,type,floor,fee};
    		            
    		            DefaultTableModel tblModel = (DefaultTableModel)roomtable.getModel();    		           
    		            tblModel.addRow(tbData1);
    		        }
    		       		    Conn.close();
    		       
    		    }catch(Exception ex) {
    		        System.out.println(ex.getMessage());
    		        }
    		    }  	
	    });
	    roomdetails_btn.setBounds(10, 482, 297, 56);
	    roomdetails_btn.setFont(new Font("Arial", Font.PLAIN, 20));
	    viewRoom_panel.add(roomdetails_btn);
	    
	    Room_bgimg = new JLabel("");
	    Room_bgimg.setIcon(new ImageIcon("D:\\hostel_bg (1).jpg"));
	    Room_bgimg.setBounds(0, 0, 1292, 601);
	    Room_lpane.add(Room_bgimg);
	    
	    hostel_bgimg = new JLabel("bg");
	    hostel_bgimg.setIcon(new ImageIcon("D:\\hostel_bg (1).jpg"));
	    hostel_bgimg.setBounds(0, 0, 1386, 792);
	    f.getContentPane().add(hostel_bgimg);
	    	   	    	    	   	  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);		
	}

	
	//-------------------------------------------------BUTTON FUNCTION----------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {						
	    String fname = fname_tf.getText();
        String lname = lname_tf.getText();
        String uname = uname_tf.getText();
        String age = age_tf.getText();
        String gender = gender_cbox.getSelectedItem().toString();;
        String contact = contact_tf.getText();
        String address = address_tf.getText();
        
        //---------------------------------------------PROFILE DELETE BTN FUNCTION------------------------------------------------------
        if (e.getSource() == delete_btn) {
            Dao sdc= new Dao();
            String query = "delete from userdetails where username = '"+uname+"' ";
            int val= sdc.insert(query);
            if (val>0) {
                JOptionPane.showMessageDialog(f,"Data Deleted Successflly");   
                ((DefaultTableModel)profile_table.getModel()).setNumRows(0);
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
        
        //-------------------------------------------------PROFILE ADD USER BTN FUNCTION------------------------------------------------------ 
        if (e.getSource() == adduser_btn) {
        	new adduser();
         }
        
      //-------------------------------------------------PROFILE CLEAR BTN FUNCTION------------------------------------------------------ 
        if (e.getSource() == clear_btn) {
        	fname_tf.setText("");
		lname_tf.setText("");
		uname_tf.setText("");
		age_tf.setText("");
		gender_cbox.setToolTipText("");
		contact_tf.setText("");
		address_tf.setText("");
        ((DefaultTableModel)profile_table.getModel()).setNumRows(0);
        }
      
        //-------------------------------------------------PROFILE UPDATE BTN FUNCTION------------------------------------------------------ 
        if (e.getSource() == update_btn) {
            Dao sdc= new Dao();
            String query =" update userdetails set firstname = '"+fname+"', lastname='"+lname+"',username='"+uname+"',age='"+age+"',gender='"+gender+"',contact_no='"+contact+"',address='"+address+"' where username ='"+uname+"' ";
            int val= sdc.insert(query);
            if (val>0) {
                JOptionPane.showMessageDialog(f,"Data Updated Successflly");
                ((DefaultTableModel)profile_table.getModel()).setNumRows(0);
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
        
//---------------------------------------------ROOM  ADD BUTTON FUNCTION------------------------------------------------------  
        
        String r_no = rno_tf.getText();
		String rstatus = roomstatus_cbox.getSelectedItem().toString();
		String rtype = rtype_cbox.getSelectedItem().toString();
		String rfloor = rfloor_tf.getText();
		String rfee = rfee_tf.getText();
        
    	if(e.getSource() == Radd_room_btn){
			try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelms", "root", "Tha@chaina729");
            PreparedStatement st = connection.prepareStatement("Insert into room_details values (?,?,? ,?,?)");
                 	   
            if (r_no.equals("")) {
				JOptionPane.showMessageDialog(f, "Room No cannot be empty");
			}
           		
			else {
				st.setString(1, r_no);
	 			st.setString(2, rstatus);
	 			st.setString(3, rtype);
	 	 	    st.setString(4, rfloor);
	 	 	    st.setString( 5,rfee); 	
				int ct = st.executeUpdate();
						
		    if (ct > 0) {
				JOptionPane.showMessageDialog(f, "You have successfully added the room");
				rno_tf.setText("");
				roomstatus_cbox.setToolTipText("");
				rtype_cbox.setToolTipText("");
				rfloor_tf.setText("");
				rfee_tf.setText("");				
				}
				
				else {
				JOptionPane.showMessageDialog(f, "Plz add again");
                   	}   
				}  
            }
					
			catch (SQLException sqlException) {
			sqlException.printStackTrace();
			}
	     }
    	
    	//---------------------------------------------ROOM  DELETE BUTTON FUNCTION------------------------------------------------------ 
    	   if (e.getSource() == Rdelete_btn) {
               Dao dc= new Dao();
               String query = "delete from room_details where room_no = '"+r_no+"' ";
               int val= dc.insert(query);
               if (val>0) {
                   JOptionPane.showMessageDialog(f,"Data Deleted Successflly");   
                   ((DefaultTableModel)roomtable.getModel()).setNumRows(0);
                   rno_tf.setText("");
   				   roomstatus_cbox.setToolTipText("");
   				   rtype_cbox.setToolTipText("");
   				   rfloor_tf.setText("");
   				   rfee_tf.setText("");    
               }
               
               else {
                   JOptionPane.showMessageDialog(f, "Failed to Delete the data");
               }
           }     
        
    	
	}
}
	





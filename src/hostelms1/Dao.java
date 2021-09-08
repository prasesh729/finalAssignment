package hostelms1;
import java.sql.*;

public class Dao {

        Connection con;
	    Statement st;
	    int ans;
	    private ResultSet rows;

	 

	/////////////////////////////////////////////// CONNECTING THE DATABASE /////////////////////////////////////////
	    public Dao() {
	        try {
	            //Class.forName("con.mysql.jdbc.Driver");
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelms","root","Tha@chaina729");
	            if(con!=null) {
	            st =con.createStatement();
	            }        
	        } catch(Exception e) {
	            e.printStackTrace();
	        }    
	    }
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    

	 

	///////////////////////////////////////////// INSERTING QUERY ////////////////////////////////////////////////////
	    public int insert(String query) {    
	        try {
	            ans = st.executeUpdate(query);
	            }catch (SQLException throwables) {
	                throwables.printStackTrace();
	                }
	        return ans;
	        }
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    
	    
	    
	/////////////////////////////////////////////// SELECTING QUERY /////////////////////////////////////////////////////    
	    public ResultSet select(String query) {
	        try {
	            rows = st.executeQuery(query);
	        }
	        catch(SQLException throwables) {
	            throwables.printStackTrace();
	        }
	        return rows;
	        
	    }
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	 

	    public static void main(String[] args) {
	        new Dao();
	        }
	    
	    

	 

	}



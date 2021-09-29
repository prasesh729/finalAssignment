package testing;

public class login_class {

	String username ="prash";
	String password= "prasesh";
	
	public boolean userLogin(String username, String password) {
		boolean result = false;
		
		if(username == username && password == password) {
			result = true;			
		}
				
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}

package testing;

public class register_class {
	
		private String firstname,lastname,username,dob,age,contact_no,address,gender,password,cpassword;
			
			public register_class() {
				
			}
			
			
			public register_class(String firstname,String lastname,String username,String age,String gender
					,String contact_no,String address,String password,String cpassword) {
				this.firstname = firstname;
				this.lastname = lastname;
				this.username = username;
				this.age = age;
				this.gender =gender;
				this.contact_no = contact_no;
				this.address = address;
				this.password = password;
				this.cpassword = cpassword;
				
			}
			
			public void setfirstname (String firstname) {
				 this.firstname = firstname;
			}
			public String firstname () {
				return this.firstname;
				
			}
			public void setlastname (String lastname) {
				this.lastname = lastname;
			}
			public String getlastname () {
				return this.lastname;
			}
			
			public void setusername (String username) {
				this.username = username;
			}
			public String getusername() {
				return this.username;
			}
			public void setage (String age) {
				this.age = age;
			}
			public String getage() {
				return this.age;
			}
			public void setgender (String gender) {
				 this.gender = gender;
			}
			public String getgender () {
				return this.gender;
				
			}
			public String getcontact_no() {
				return this.contact_no;
			}
			public void setcontact_no (String contact_no) {
				 this.contact_no = contact_no;
			}
			public String getaddress() {
				return this.contact_no;
			}
			public void setaddress (String address) {
				 this.address = address;
			}
			public void setpassword (String password) {
				 this.password = password;
			}
			public String getpassword () {
				return this.password;

	}
			public void setcpassword (String cpassword) {
				 this.cpassword = cpassword;
			}
			public String getcpassword () {
				return this.cpassword;

	}

}


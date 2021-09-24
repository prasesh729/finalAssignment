package testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//import testing.login_test_class;

class login_classTest {

    @Test
	// login pass test
	void test() {
		String username ="prash";
		String password = "prasesh";
		
		login_class ltc = new login_class();
		boolean result = ltc.userLogin(username,password);
		
		assertEquals(true,result);

	}
    
    
    
	@Test
	// login fail test
	void test1() {
		String username ="pasd";
		String password = "hero";
		
		login_class ltc = new login_class();
		boolean result = ltc.userLogin(username,password);
		
		assertEquals(false,result);

	}

}


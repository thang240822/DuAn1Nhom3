package Test.Test2;


import static org.testng.Assert.assertEquals;

import org.junit.Test;


public class LoginTest {
	checkLoginTrue ndao = new checkLoginTrue();

	@Test
	public void checkLogin1() {
		String user = "NLMT";
		String pass = "123";
		boolean expected = false;
		boolean actual = ndao.login(user,pass);
		assertEquals(actual,expected);
	}
	
	@Test
	public void checkLogin2() {
		String user = "";
		String pass = "";
		boolean expected = false;
		boolean actual = ndao.login(user,pass);
		assertEquals(actual,expected);
	}
	
	@Test
	public void checkLogin3() {
		String user = "";
		String pass = "1234";
		boolean expected = false;
		boolean actual = ndao.login(user,pass);
		assertEquals(actual,expected);
	}
	
	@Test
	public void checkLogin4() {
		String user = "NLMT2";
		String pass = "";
		boolean expected = false;
		boolean actual = ndao.login(user,pass);
		assertEquals(actual,expected);
	}
	
	@Test
	public void checkLogin5() {
		String user = "NLMT";
		String pass = "0921";
		boolean expected = false;
		boolean actual = ndao.login(user,pass);
		assertEquals(actual,expected);
	}
}

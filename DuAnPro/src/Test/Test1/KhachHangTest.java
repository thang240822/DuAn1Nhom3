package Test.Test1;

import static org.junit.Assert.*;

import org.junit.Test;

import Entity.KhachHang;

public class KhachHangTest {
	@Test
	public void testGetMaKH() {
		KhachHang instance = new KhachHang();
		String expResult = null;
		String result = instance.getMaKH();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setMaKH method, of class KhachHang.
	 */
	@Test
	public void testSetMaKH() {

		String maKH = "A11";
		KhachHang instance = new KhachHang();
		instance.setMaKH(maKH);
		String expected = "A11";
		String result = instance.getMaKH();
		assertEquals(expected, result);
	}

	@Test(expected = Exception.class)
	public void testSetMaKHWithEmpty() {

		String maKH = "";
		KhachHang instance = new KhachHang();
		instance.setsDT(maKH);

	}

	/**
	 * Test of getTenKH method, of class KhachHang.
	 */
	@Test
	public void testGetTenKH() {
		KhachHang instance = new KhachHang();
		String expResult = null;
		String result = instance.getTenKH();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setTenKH method, of class KhachHang.
	 */
	@Test
	public void testSetTenKH() {
		String tenKH = "Ngo Le Minh Thnag";
		KhachHang instance = new KhachHang();
		instance.setTenKH(tenKH);
		String expected = "Ngo Le Minh Thnag";
		String result = instance.getTenKH();
		assertEquals(expected, result);
	}

	/**
	 * Test of getsDT method, of class KhachHang.
	 */
	@Test
	public void testGetsDT() {

		KhachHang instance = new KhachHang();
		String expResult = null;
		String result = instance.getsDT();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setsDT method, of class KhachHang.
	 */
	@Test
	public void testSetsDT() {

		String sDT = "0377889933";
		KhachHang instance = new KhachHang();
		instance.setsDT(sDT);
		String expected = "0377889933";
		String result = instance.getsDT();
		assertEquals(expected, result);
	}

	@Test(expected = Exception.class)
	public void testSetsDTwithError() {

		String sDT = "-df0377889933";
		KhachHang instance = new KhachHang();
		instance.setsDT(sDT);

	}

	/**
	 * Test of getDiaChi method, of class KhachHang.
	 */

	@Test
	public void testSetEmail() {

		String email = "thang@gmail.com";
		KhachHang instance = new KhachHang();
		instance.setEmail(email);
		String expected = "thang@gmail.com";
		String result = instance.getEmail();
		assertEquals(expected, result);
	}

	@Test(expected = Exception.class)
	public void testSetEmailHWithEmpty() {

		String email = "";
		KhachHang instance = new KhachHang();
		instance.setsDT(email);

	}
	
	/**
	 * Test of toString method, of class KhachHang.
	 */
	@Test
	public void testToString() {
		KhachHang instance = new KhachHang();
		String expResult = null;
		String result = instance.toString();
		assertEquals(expResult, result);

	}
}

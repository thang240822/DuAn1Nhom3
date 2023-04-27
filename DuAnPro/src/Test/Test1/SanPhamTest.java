package Test.Test1;

import static org.junit.Assert.*;

import org.junit.Test;

import Entity.SanPham;

public class SanPhamTest {
	@Test
	public void testGetMaSP() {
		SanPham instance = new SanPham();
		String expResult = null;
		String result = instance.getMaSP();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setMaSP method, of class SanPham.
	 */
	@Test
	public void testSetMaSP() {
		String maSP = "A1";
		SanPham instance = new SanPham();
		instance.setMaSP(maSP);
		String expexted = "A1";
		String result = instance.getMaSP();
		assertEquals(expexted, result);
	}

	/**
	 * Test of getNhanHieu method, of class SanPham.
	 */
	@Test
	public void testGetNhanHieu() {
		System.out.println("getNhanHieu");
		SanPham instance = new SanPham();
		String expResult = null;
		String result = instance.getNhanHieu();
		assertEquals(expResult, result);
	
	}

	/**
	 * Test of setNhanHieu method, of class SanPham.
	 */
	@Test
	public void testSetNhanHieu() {
		System.out.println("setNhanHieu");
		String nhanHieu = "NIKE";
		SanPham instance = new SanPham();
		instance.setNhanHieu(nhanHieu);
		String expected = "NIKE";
		String result = instance.getNhanHieu();
		assertEquals(expected, result);
	
	}

	/**
	 * Test of getTen method, of class SanPham.
	 */
	@Test
	public void testGetTen() {

		SanPham instance = new SanPham();
		String expResult = null;
		String result = instance.getTen();
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of setTen method, of class SanPham.
	 */
	@Test
	public void testSetTen() {

		String ten = "Áo Nike Sportswear Faux Fur";
		SanPham instance = new SanPham();
		instance.setTen(ten);
		String expexted = "Áo Nike Sportswear Faux Fur";
		String result = instance.getTen();
		assertEquals(expexted, result);
	}

	/**
	 * Test of getMau method, of class SanPham.
	 */
	@Test
	public void testGetMau() {
		SanPham instance = new SanPham();
		String expResult = null;
		String result = instance.getMau();
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of setMau method, of class SanPham.
	 */
	@Test
	public void testSetMau() {
		String mau = "Black";
		SanPham instance = new SanPham();
		instance.setMau(mau);
		String expected = "Black";
		String result = instance.getMau();
		assertEquals(expected, result);
	}

	/**
	 * Test of getSize method, of class SanPham.
	 */
	@Test
	public void testGetSize() {
		SanPham instance = new SanPham();
		String expResult = null;
		String result = instance.getSize();
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of setSize method, of class SanPham.
	 */
	@Test
	public void testSetSize() {

		String size = "S";
		SanPham instance = new SanPham();
		instance.setSize(size);
		String expexted = "S";
		String result = instance.getSize();
		assertEquals(expexted, result);
	}

	/**
	 * Test of getSoLuong method, of class SanPham.
	 */
	@Test
	public void testGetSoLuong() {

		SanPham instance = new SanPham();
		Integer expResult = 0;
		Integer result = instance.getSoLuong();
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of setSoLuong method, of class SanPham.
	 */
	@Test
	public void testSetSoLuong() {

		Integer soLuong = 20;
		SanPham instance = new SanPham();
		instance.setSoLuong(soLuong);
		Integer actual = instance.getSoLuong();
		assertEquals(actual, soLuong);
		
	}
	@Test(expected = Exception.class)
	public void testSetSoLuongWithZero() {

		Integer soLuong = 0;
		SanPham instance = new SanPham();
		instance.setSoLuong(soLuong);
		
		
	}
	@Test(expected = Exception.class)
	public void testSetSoLuongWithNegative() {

		Integer soLuong = -12;
		SanPham instance = new SanPham();
		instance.setSoLuong(soLuong);
		
		
	}
	/**
	 * Test of getGiaTien method, of class SanPham.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetGiaTien() {
		SanPham instance = new SanPham();
		Double expResult = 0.0;
		Double result = instance.getGiaTien();
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of setGiaTien method, of class SanPham.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testSetGiaTien() {
		Double giaTien = 8000000.00;
		SanPham instance = new SanPham();
		instance.setGiaTien(giaTien);
		Double expected = 8000000.00;
		Double result = instance.getGiaTien();
		assertEquals(expected, result);
		
	}

	/**
	 * Test of getHinh method, of class SanPham.
	 */
	@Test
	public void testGetHinh() {
		SanPham instance = new SanPham();
		String expResult = null;
		String result = instance.getHinh();
		assertEquals(expResult, result);
	
	}

	/**
	 * Test of setHinh method, of class SanPham.
	 */
	@Test
	public void testSetHinh() {

		String hinh = "1.png";
		SanPham instance = new SanPham();
		instance.setHinh(hinh);
		String expexted = "1.png";
		String result = instance.getHinh();
		assertEquals(expexted, result);
	}

	/**
	 * Test of toString method, of class SanPham.
	 */
	@Test
	public void testToString() {
		SanPham instance = new SanPham();
		String expResult = null;
		String result = instance.toString();
		assertEquals(expResult, result);
		
	}
}

package Test.Test1;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Entity.HoaDon;

public class HoaDonTest {
	@Test
	public void testGetMaHD() {
		HoaDon instance = new HoaDon();
		String expResult = null;
		String result = instance.getMaHD();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setMaHD method, of class HoaDon.
	 */
	@Test
	public void testSetMaHD() {
		String maHD = "001";
		HoaDon instance = new HoaDon();
		instance.setMaHD(maHD);
		String expected = "001";
		assertEquals(expected, instance.getMaHD());

	}

	@Test
	public void testGetSoLuong() {
		HoaDon instance = new HoaDon();
		Integer expResult = null;
		Integer result = instance.getSoLuong();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setSoLuong method, of class HoaDon.
	 */
	@Test
	public void testSetSoLuong() {

		Integer soLuong = 1;
		HoaDon instance = new HoaDon();
		instance.setSoLuong(soLuong);
		int expected = 1;
		int result = instance.getSoLuong();
		assertEquals(expected, result, 0.0);
	}

	@Test
	public void testSetSoLuongWithNagative() {

		Integer soLuong = -100;
		HoaDon instance = new HoaDon();
		Exception exception = assertThrows(Exception.class, () -> instance.setSoLuong(soLuong));
		instance.setSoLuong(soLuong);

	}

	@Test
	public void testSetSoLuongWithLarge() {

		Integer soLuong = 10000000;
		HoaDon instance = new HoaDon();
		Exception exception = assertThrows(Exception.class, () -> instance.setSoLuong(soLuong));
		instance.setSoLuong(soLuong);

	}

	@Test
	public void testGetMaKH() {
		HoaDon instance = new HoaDon();
		String expResult = null;
		String result = instance.getMaKH();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setMaKH method, of class HoaDon.
	 */
	@Test
	public void testSetMaKH() {
		String maKH = "A11";
		HoaDon instance = new HoaDon();
		instance.setMaKH(maKH);
		String expected = "A11";
		assertEquals(expected, instance.getMaKH());

	}

	@Test
	public void testGetThanhTien() {

		HoaDon instance = new HoaDon();
		Double expResult = null;
		Double result = instance.getThanhTien();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setThanhTien method, of class HoaDon.
	 */
	@Test
	public void testSetThanhTien() {
		Double thanhTien = (double) 4000000;
		HoaDon instance = new HoaDon();
		instance.setThanhTien(thanhTien);
		Double expected = (double) 4000000;
		Double result = instance.getThanhTien();
		assertEquals(expected, result, 0.0);
	}

	@Test
	public void testGetTrangThai() {

		HoaDon instance = new HoaDon();
		String expResult = null;
		String result = instance.getTrangThai();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setTrangThai method, of class HoaDon.
	 */
	@Test
	public void testSetTrangThai() {

		String trangThai = "Đang vận chuyển";
		HoaDon instance = new HoaDon();
		instance.setTrangThai(trangThai);
		String expected = "Đang vận chuyển";
		String result = instance.getTrangThai();
		assertEquals(expected, result);
	}

	@Test
	public void testGetMaNV() {
		HoaDon instance = new HoaDon();
		String expResult = null;
		String result = instance.getMaNV();
		assertEquals(expResult, result);

	}

	/**
	 * Test of setMaNV method, of class HoaDon.
	 */
	@Test
	public void testSetMaNV() {
		String maNV = "NLMT";
		HoaDon instance = new HoaDon();
		instance.setMaNV(maNV);
		String expected = "NLMT";
		String result = instance.getMaNV();
		assertEquals(expected, result);
	}

	/**
	 * Test of getMaSP method, of class HoaDon.
	 */
	@Test
	public void testGetMaSP() {
		HoaDon instance = new HoaDon();
		String expResult = null;
		String result = instance.getMaSP();
		assertEquals(expResult, result);
		
	}

	/**
	 * Test of setMaSP method, of class HoaDon.
	 */
	@Test
	public void testSetMaSP() {
		String maSP = "A1";
		HoaDon instance = new HoaDon();
		instance.setMaSP(maSP);
		String expected = "A1";
		String result = instance.getMaSP();
		assertEquals(expected, result);
	}

	
}

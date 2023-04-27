package Test.Test2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import DAO.HoaDonDAO;
import Entity.HoaDon;
import Ultils.XJdbc;

public class HoaDonTest {
	HoaDonDAO hoaDonDAO = new HoaDonDAO();


	public void HoaDonDAOTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {

	}

	@After
	public void tearDown() {
	}

	@Test(expected = Exception.class)
	public void testInsertWithNullModel() {

		HoaDon entity = null;

		hoaDonDAO.insert(entity);

	}

	@Test(expected = Exception.class)
	public void testInsertWithEmptyModel() {

		HoaDon entity = new HoaDon();

		hoaDonDAO.insert(entity);

	}

	@Test
	public void testInsertWithValidModel() {
		HoaDon entity = new HoaDon();
		entity.setMaHD("007");
		entity.setSoLuong(1);
		entity.setNgayLapHD(new Date());
		entity.setMaKH("A11");
		entity.setThanhTien(100000.0);
		entity.setTrangThai("Đã vẫn chuyển");
		entity.setMaNV("NLMT");
		entity.setMaSP("A1");

		hoaDonDAO.insert(entity);
	}

	@Test(expected = Exception.class)
	public void testUpdateWithNullModel() {

		HoaDon entity = null;
		HoaDonDAO instance = new HoaDonDAO();
		instance.update(entity);

	}

	@Test
	public void testUpdateWithEmptyModel() {

		HoaDon entity = new HoaDon();
		HoaDonDAO instance = new HoaDonDAO();
		instance.update(entity);

	}

	@Test
	public void testUpdateWithVaidModel() {
		HoaDon entity = new HoaDon();
		entity.setMaHD("007");
		entity.setSoLuong(1);
		entity.setNgayLapHD(new Date());
		entity.setMaKH("A11");
		entity.setThanhTien(100000.0);
		entity.setTrangThai("Đã vẫn chuyển");
		entity.setMaNV("NLMT");
		entity.setMaSP("A1");

		hoaDonDAO.update(entity);
	}

	@Test
	public void testDeleteWithEmptyId() {
		String MaHD = "";
		HoaDonDAO instance = new HoaDonDAO();
		instance.delete(MaHD);

	}

	@Test
	public void testDeleteWithNullId() {
		String MaHD = null;
		HoaDonDAO instance = new HoaDonDAO();
		instance.delete(MaHD);

	}

	@Test()
	public void testDeleteWithValidId() {
		String MaHD = "007";
		HoaDonDAO instance = new HoaDonDAO();
		instance.delete(MaHD);

	}

	

	
}

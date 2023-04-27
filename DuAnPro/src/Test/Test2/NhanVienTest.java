package Test.Test2;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DAO.NhanVienDAO;
import DAO.NhanVienDAO;
import DAO.NhanVienDAO;
import Entity.NhanVien;
import Entity.NhanVien;
import Entity.NhanVien;

public class NhanVienTest {
	public void NhanVienDAOTest() {
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

		NhanVien entity = null;

		NhanVienDAO instance = new NhanVienDAO();
		instance.insert(entity);

	}

	@Test(expected = Exception.class)
	public void testInsertWithEmptyModel() {

		NhanVien entity = new NhanVien();

		NhanVienDAO instance = new NhanVienDAO();
		instance.insert(entity);


	}

	@Test
	public void testInsertWithValidModel() {
		NhanVien entity = new NhanVien();
		entity.setMaNV("NLMT1");
		entity.setMatKhau("123");
		entity.setTenNV("NgoLeMinhThang1");
		entity.setGioiTinh(false);
		entity.setVaiTro(false);
		NhanVienDAO instance = new NhanVienDAO();
		instance.insert(entity);

	}

	

	@Test(expected = Exception.class)
	public void testUpdateWithNullModel() {

    	  NhanVien entity = null;
          NhanVienDAO instance = new NhanVienDAO();
          instance.update(entity);

	}
    
    @Test
	public void testUpdateWithEmptyModel() {

    	NhanVien entity = new NhanVien();
        NhanVienDAO instance = new NhanVienDAO();
        instance.update(entity);
        
	}
    @Test
    public void testUpdate() {

        NhanVien entity = new NhanVien();
        entity.setMaNV("NLMT1");
		entity.setMatKhau("1234");
		entity.setTenNV("NgoLeMinhThang1");
		entity.setGioiTinh(true);
		entity.setVaiTro(false);
        NhanVienDAO instance = new NhanVienDAO();
        instance.update(entity);
       
    }

	 @Test
		public void testDeleteWithEmptyId() {
			String MaKD = "";
			 NhanVienDAO instance = new NhanVienDAO();
			instance.delete(MaKD);

		}

		@Test
		public void testDeleteWithNullId() {
			String MaKD = null;
			 NhanVienDAO instance = new NhanVienDAO();
			instance.delete(MaKD);

		}

		@Test()
		public void testDeleteWithValidId() {
			String MaKD = "NLMT1";
			 NhanVienDAO instance = new NhanVienDAO();
			instance.delete(MaKD);

		}
}

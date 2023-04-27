package Test.Test2;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import Entity.HoaDon;
import Entity.KhachHang;

public class KhachHangTest {
	public void KhachHangDAOTest() {
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
        KhachHang entity = null;
        KhachHangDAO instance = new KhachHangDAO();
        instance.insert(entity);
        
    }
    @Test(expected = Exception.class)
    public void testInsertWithEmptyModel() {
        KhachHang entity = new KhachHang();
        KhachHangDAO instance = new KhachHangDAO();
        instance.insert(entity);
        
    }
    
    @Test
    public void testInsertWithValidModel() {
        KhachHang entity = new KhachHang();
        entity.setMaKH("Q4");
        entity.setTenKH("Ngo Le Minh Thang");
        entity.setsDT("0792071643");
        entity.setDiaChi("Vung Tau City");
        entity.setEmail("thang@gmail.com");
        KhachHangDAO instance = new KhachHangDAO();
        instance.insert(entity);
        
    }
    
    @Test(expected = Exception.class)
	public void testUpdateWithNullModel() {

    	  KhachHang entity = null;
          KhachHangDAO instance = new KhachHangDAO();
          instance.update(entity);

	}
    
    @Test
	public void testUpdateWithEmptyModel() {

    	KhachHang entity = new KhachHang();
        KhachHangDAO instance = new KhachHangDAO();
        instance.update(entity);
        
	}
    @Test
    public void testUpdate() {

        KhachHang entity = new KhachHang();
        entity.setMaKH("Q4");
        entity.setTenKH("Ngo Le Minh Thang");
        entity.setsDT("0792071643");
        entity.setDiaChi("Vung Tau City");
        entity.setEmail("thang123@gmail.com");
        KhachHangDAO instance = new KhachHangDAO();
        instance.update(entity);
       
    }

    @Test
	public void testDeleteWithEmptyId() {
		String MaKD = "";
		 KhachHangDAO instance = new KhachHangDAO();
		instance.delete(MaKD);

	}

	@Test
	public void testDeleteWithNullId() {
		String MaKD = null;
		 KhachHangDAO instance = new KhachHangDAO();
		instance.delete(MaKD);

	}

	@Test()
	public void testDeleteWithValidId() {
		String MaKD = "Q4";
		 KhachHangDAO instance = new KhachHangDAO();
		instance.delete(MaKD);

	}


    
}

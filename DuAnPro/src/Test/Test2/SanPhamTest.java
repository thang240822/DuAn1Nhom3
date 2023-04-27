package Test.Test2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DAO.SanPhamDAO;
import Entity.SanPham;



public class SanPhamTest {
	public void SanPhamDAOTest() {
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
        SanPham entity = null;
        SanPhamDAO instance = new SanPhamDAO();
        instance.insert(entity);
        
    }
    @Test(expected = Exception.class)
    public void testInsertWithEmptyModel() {
        SanPham entity = new SanPham();
        SanPhamDAO instance = new SanPhamDAO();
        instance.insert(entity);
        
    }
    
    @Test
    public void testInsertWithValidModel() {
        SanPham entity = new SanPham();
        entity.setMaSP("T1");
        entity.setNhanHieu("NIKE");
        entity.setTen("Áo NIKE");
        entity.setMau("Black");
        entity.setSize("XXL");
        entity.setSoLuong(50);
        entity.setGiaTien(300000.0);
        entity.setHinh("2.png");
        SanPhamDAO instance = new SanPhamDAO();
        instance.insert(entity);
        
    }
    
    @Test(expected = Exception.class)
	public void testUpdateWithNullModel() {

    	  SanPham entity = null;
          SanPhamDAO instance = new SanPhamDAO();
          instance.update(entity);

	}
    
    @Test
	public void testUpdateWithEmptyModel() {

    	SanPham entity = new SanPham();
        SanPhamDAO instance = new SanPhamDAO();
        instance.update(entity);
        
	}
    @Test
    public void testUpdate() {

        SanPham entity = new SanPham();
        entity.setMaSP("T1");
        entity.setNhanHieu("NIKE");
        entity.setTen("Áo NIKE");
        entity.setMau("Black");
        entity.setSize("XXL");
        entity.setSoLuong(1000);
        entity.setGiaTien(800000.0);
        entity.setHinh("2.png");
        
        SanPhamDAO instance = new SanPhamDAO();
        instance.update(entity);
       
    }

    @Test
	public void testDeleteWithEmptyId() {
		String MaKD = "";
		 SanPhamDAO instance = new SanPhamDAO();
		instance.delete(MaKD);

	}

	@Test
	public void testDeleteWithNullId() {
		String MaKD = null;
		 SanPhamDAO instance = new SanPhamDAO();
		instance.delete(MaKD);

	}

	@Test()
	public void testDeleteWithValidId() {
		String MaKD = "T1";
		 SanPhamDAO instance = new SanPhamDAO();
		instance.delete(MaKD);

	}
   
}

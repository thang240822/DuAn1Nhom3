package Test.Test1;

import static org.junit.Assert.*;

import org.junit.Test;

import Entity.KhachHang;
import Entity.NhanVien;

public class NhanVienTest {
	@Test
    public void testGetMaNV() {
        NhanVien instance = new NhanVien();
        String expResult = null;
        String result = instance.getMaNV();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of setMaNV method, of class NhanVien.
     */
    @Test
    public void testSetMaNV() {
        String maNV = "NLMT";
        NhanVien instance = new NhanVien();
        instance.setMaNV(maNV);
        String expected = "NLMT";
        String result = instance.getMaNV();
        assertEquals(expected, result);
       
    }

    /**
     * Test of getMatKhau method, of class NhanVien.
     */
    @Test
    public void testGetMatKhau_0args() {
        NhanVien instance = new NhanVien();
        String expResult = null;
        String result = instance.getMatKhau();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setMatKhau method, of class NhanVien.
     */
    @Test
    public void testSetMatKhau() {
        String matKhau = "123";
        NhanVien instance = new NhanVien();
        instance.setMatKhau(matKhau);
        String expected = "123";
        String result = instance.getMatKhau();
        assertEquals(expected, result);
      
    }
    

	@Test(expected = Exception.class)
	public void testSetMatKhauWithEmpty() {

		String mk = "";
		KhachHang instance = new KhachHang();
		instance.setsDT(mk);

	}
	@Test(expected = Exception.class)
	public void testSetMatKhauWithLarge() {

		String mk = "sagdiabnsdbasdiusadsadas";
		KhachHang instance = new KhachHang();
		instance.setsDT(mk);

	}

    /**
     * Test of getTenNV method, of class NhanVien.
     */
    @Test
    public void testGetTenNV() {
        NhanVien instance = new NhanVien();
        String expResult = null;
        String result = instance.getTenNV();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setTenNV method, of class NhanVien.
     */
    @Test
    public void testSetTenNV() {
        String tenNV = "Ngô Lê Minh Thắng";
        NhanVien instance = new NhanVien();
        instance.setTenNV(tenNV);
        String expected = "Ngô Lê Minh Thắng";
        String result = instance.getTenNV();
        assertEquals(expected, result);
      
    }

    /**
     * Test of getGioiTinh method, of class NhanVien.
     */
    @Test
    public void testGetGioiTinh() {
        NhanVien instance = new NhanVien();
        boolean expResult = false;
        boolean result = instance.getGioiTinh();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setGioiTinh method, of class NhanVien.
     */
    @Test
    public void testSetGioiTinh() {
        System.out.println("setGioiTinh");
        boolean gioiTinh = false;
        NhanVien instance = new NhanVien();
        instance.setGioiTinh(gioiTinh);
     
    }

    /**
     * Test of getVaiTro method, of class NhanVien.
     */
    @Test
    public void testGetVaiTro() {
        System.out.println("getVaiTro");
        NhanVien instance = new NhanVien();
        boolean expResult = false;
        boolean result = instance.getVaiTro();
        assertEquals(expResult, result);

    }

    /**
     * Test of setVaiTro method, of class NhanVien.
     */
    @Test
    public void testSetVaiTro() {
        System.out.println("setVaiTro");
        boolean vaiTro = false;
        NhanVien instance = new NhanVien();
        instance.setVaiTro(vaiTro);
        
    }

    /**
     * Test of getMatKhau method, of class NhanVien.
     */
    
    
}

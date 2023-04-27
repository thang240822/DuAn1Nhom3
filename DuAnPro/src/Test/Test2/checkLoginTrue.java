package Test.Test2;

import DAO.NhanVienDAO;
import Entity.NhanVien;

public class checkLoginTrue {

	public boolean login(String user, String pass) {
		NhanVienDAO ndao = new NhanVienDAO();
		NhanVien user1 = null;

		try {
			user1 = ndao.selectById(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (user1 != null ) {
			if (!user.equals(user1.getMaNV()) || !pass.equals(user1.getMatKhau())  ) {
				System.out.println("sai tên đăng nhập hoặc mật khẩu");
			} else {
				System.out.println("Đăng nhập thành công");
			}

		} else {
		
			System.out.println("Lỗi check null ");

		}

		return false;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NhanVien;
import Entity.SanPham;
import Ultils.XJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nolan
 */
public class NhanVienDAO extends QLSDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien entity) {
        String sql = "INSERT INTO NhanVien (MaNV,MatKhau,TenNV,GioiTinh,VaiTro) VALUES (?,?,?,?,?)";
        XJdbc.update(sql,
                entity.getMaNV(),
                entity.getMatKhau(),
                entity.getTenNV(),
                entity.getGioiTinh(),

                entity.getVaiTro()
                );
    }

    @Override
    public void update(NhanVien entity) {
        String sql = "UPDATE  NhanVien SET MatKhau=?,TenNV=?,GioiTinh=?,VaiTro=? where MaNV = ?";
        XJdbc.update(sql, 
                entity.getMatKhau(),
                entity.getTenNV(),
                entity.getGioiTinh(),

                entity.getVaiTro(),
                entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM NhanVien WHERE MaNV=?";
        XJdbc.update(sql, id);
    }

    @Override
    public NhanVien selectById(String id) {
        String sql="SELECT * FROM NhanVien WHERE MaNV=?";
        List<NhanVien> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql="SELECT * FROM NhanVien";
        return selectBySql(sql);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
                List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    NhanVien entity=new NhanVien();
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setMatKhau(rs.getString("MatKhau"));
                    entity.setTenNV(rs.getString("TenNV"));
                    entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    entity.setVaiTro(rs.getBoolean("VaiTro"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    public List<NhanVien> selectByKeywordNV(String keyword) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV LIKE ?";
        return selectBySql(sql, "%" + keyword + "%");
    }
    
}

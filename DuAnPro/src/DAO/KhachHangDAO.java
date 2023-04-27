/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.KhachHang;
import Ultils.XJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nolan
 */
public class KhachHangDAO extends QLSDAO<KhachHang, String> {

    @Override
    public void insert(KhachHang entity) {
        String sql = "INSERT INTO KhachHang (MaKH,TenKH,SDT,DiaChi,Email) VALUES (?,?,?,?,?)";
        XJdbc.update(sql,
                entity.getMaKH(),
                entity.getTenKH(),
                entity.getsDT(),
                entity.getDiaChi(),
                entity.getEmail());
    }

    @Override
    public void update(KhachHang entity) {
        String sql = "UPDATE  KhachHang SET TenKH=?,SDT=?,DiaChi=?,Email=? where MaKH = ?";
        XJdbc.update(sql,
                entity.getTenKH(),
                entity.getsDT(),
                entity.getDiaChi(),
                entity.getEmail(),
                entity.getMaKH());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM KhachHang WHERE MaKH=?";
        XJdbc.update(sql, id);
    }

    @Override
    public KhachHang selectById(String id) {
        String sql = "SELECT * FROM KhachHang WHERE MaKH=?";
        List<KhachHang> list = selectBySql(sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM KhachHang";
        return selectBySql(sql);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    KhachHang entity = new KhachHang();
                    entity.setMaKH(rs.getString("MaKH"));
                    entity.setTenKH(rs.getString("TenKH"));
                    entity.setsDT(rs.getString("SDT"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    entity.setEmail(rs.getString("Email"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<KhachHang> selectByKeywordKH(String keyword) {
        String sql = "SELECT * FROM KhachHang WHERE TenKH LIKE ?";
        return selectBySql(sql, "%" + keyword + "%");
    }
}

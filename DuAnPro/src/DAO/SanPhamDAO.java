/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
public class SanPhamDAO extends QLSDAO<SanPham, String> {

    @Override
    public void insert(SanPham entity) {
        String sql = "INSERT INTO SanPham (MaSP,NhanHieu,Ten,Mau,Size,SoLuong,GiaTien,Hinh) VALUES (?,?,?,?,?,?,?,?)";
        XJdbc.update(sql,
                entity.getMaSP(),
                entity.getNhanHieu(),
                entity.getTen(),
                entity.getMau(),
                entity.getSize(),
                entity.getSoLuong(),
                entity.getGiaTien(),
                entity.getHinh()
        );
    }

    @Override
    public void update(SanPham entity) {
        String sql = "UPDATE  SanPham SET NhanHieu=?,Ten=?,Mau=?,Size=?,SoLuong=?,GiaTien=?,Hinh=? where MaSP = ?";
        XJdbc.update(sql,
                entity.getNhanHieu(),
                entity.getTen(),
                entity.getMau(),
                entity.getSize(),
                entity.getSoLuong(),
                entity.getGiaTien(),
                entity.getHinh(),
                entity.getMaSP());

    }

    @Override
    public void delete(String MaSP) {
        String sql = "DELETE FROM SanPham WHERE MaSP=?";
        XJdbc.update(sql, MaSP);
    }

    @Override
    public SanPham selectById(String id) {
        String sql = "SELECT * FROM SanPham WHERE MaSP=?";
        List<SanPham> list = selectBySql(sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SanPham> selectAll() {
        String sql = "SELECT * FROM SanPham";
        return selectBySql(sql);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    SanPham entity = new SanPham();
                    entity.setMaSP(rs.getString("MaSP"));
                    entity.setNhanHieu(rs.getString("NhanHieu"));
                    entity.setTen(rs.getString("Ten"));
                    entity.setMau(rs.getString("Mau"));
                    entity.setSize(rs.getString("Size"));
                    entity.setSoLuong(rs.getInt("SoLuong"));
                    entity.setGiaTien(rs.getDouble("GiaTien"));
                    entity.setHinh(rs.getString("Hinh"));
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

    public List<SanPham> selectByKeywordSP(String keyword) {
        String sql = "SELECT * FROM SanPham WHERE MaSP LIKE ? ";
        return selectBySql(sql, "%" + keyword + "%");
    }

}

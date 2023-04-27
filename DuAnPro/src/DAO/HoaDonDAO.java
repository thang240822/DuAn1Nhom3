/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HoaDon;
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
public class HoaDonDAO extends QLSDAO<HoaDon, String> {

    @Override
    public void insert(HoaDon entity) {
        String sql = "INSERT INTO HoaDon (MaHD,SoLuong,MaKH,ThanhTien,TrangThai,MaNV,MaSP) VALUES (?,?,?,?,?,?,?)";
        XJdbc.update(sql,
                entity.getMaHD(),
                entity.getSoLuong(),
                entity.getMaKH(),
                entity.getThanhTien(),
                entity.getTrangThai(),
                entity.getMaNV(),
                entity.getMaSP());
    }

    @Override
    public void update(HoaDon entity) {
        String sql = "UPDATE  HoaDon SET SoLuong=?,MaKH=?,ThanhTien=?,TrangThai=?,MaNV=?,MaSP=? where MaHD = ?";
        XJdbc.update(sql,
                entity.getSoLuong(),
                entity.getMaKH(),
                entity.getThanhTien(),
                entity.getTrangThai(),
                entity.getMaNV(),
                entity.getMaSP(),
                entity.getMaHD());
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM HoaDon WHERE MaHD=?";
        XJdbc.update(sql, id);
    }

    @Override
    public HoaDon selectById(String id) {
        String sql = "SELECT * FROM HoaDon WHERE MaHD=?";
        List<HoaDon> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HoaDon> selectAll() {
        String sql = "select MaHD,SoLuong,NgayLapHD,MaKH,ThanhTien,TrangThai,MaNV,MaSP,(SoLuong*ThanhTien) as 'ThanhTien' from HoaDon";
        return selectBySql(sql);
    }

    @Override
	public List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    HoaDon entity = new HoaDon();
                    entity.setMaHD(rs.getString("MaHD"));
                    entity.setSoLuong(rs.getInt("SoLuong"));
                    entity.setNgayLapHD(rs.getDate("NgayLapHD"));
                    entity.setMaKH(rs.getString("MaKH"));
                    entity.setThanhTien(rs.getDouble("ThanhTien"));
                    entity.setTrangThai(rs.getString("TrangThai"));
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setMaSP(rs.getString("MaSP"));
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

    public List<Integer> selectYears() {
//        String sql ="select DISTINCT YEAR(ngayKG) from Khoa_Hoc order by YEAR desc";
        String sql = "select DISTINCT YEAR(NgayLapHD) from HoaDon  order by YEAR(NgayLapHD)";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<HoaDon> selectByKeywordHD(String keyword) {
        String sql = "SELECT * FROM HoaDon WHERE MaHD LIKE ?";
        return selectBySql(sql, "%" + keyword + "%");
    }

  
   
}

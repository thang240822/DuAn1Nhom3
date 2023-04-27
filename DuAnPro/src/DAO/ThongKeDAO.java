/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Ultils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nolan
 */
public class ThongKeDAO {

    /*  private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
     try {
     List<Object[]> list = new ArrayList<>();
     ResultSet rs = XJdbc.query(sql, args);
     while (rs.next()) {
     Object[] vals = new Object[cols.length];
     for (int i = 0; i < cols.length; i++) {
     vals[i] = rs.getObject(cols[i]);
     }
     list.add(vals);
     }
     rs.getStatement().getConnection().close();
     return list;
     } catch (Exception e) {
     throw new RuntimeException(e);
     }
     }*/
    public List<Object[]> getDoanhThu(int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeDoanhThu (?)}";
                rs = XJdbc.query(sql, nam);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("ThuongHieu"),
                        rs.getDouble("DoanhThu"),
                        rs.getDouble("ThapNhat"),
                        rs.getDouble("CaoNhat"),
                        rs.getDouble("TrungBinh")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getThongKeTonKho() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{CALL sp_ThongKeTonKho}";
                rs = XJdbc.query(sql);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MaSP"),
                        rs.getString("Ten"),
                        rs.getString("NhanHieu"),
                        rs.getString("Mau"),
                        rs.getInt("SoLuongTon"),};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    /*  public List<Object[]> getDoanhThu(int nam){
     String sql = "{CALL sp_ThongKeDoanhThu (?)}";
     String[] cols = {"ThuongHieu", "DoanhThu", "ThapNhat",  "CaoNhat", "TrungBinh"};
     return this.getListOfArray(sql, cols, nam);
     }*/
    /* public List<Object[]> getThongKeTonKho() {
     String sql = "{CALL sp_ThongKeTonKho}";
     String[] cols = {"MaSP", "Ten", "NhanHieu", "Mau", "SoLuongTon"};
     return this.getListOfArray(sql, cols);
     }*/
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.PhieuThu;
import utils.DBConnection;

public class PhieuThuController extends DataController<PhieuThu> {

    @Override
    public List<PhieuThu> getList() {
        DBConnection dbc = new DBConnection();
        List<PhieuThu> dsThuHocPhi = new ArrayList<>();
        dbc.connect();
        try {
            String sql = "select * from dsthuhocphi";
            if (dbc.prepareStatement(sql)) {
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    dsThuHocPhi.add(new PhieuThu(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getInt("kiHocDong"),
                            dbc.getResultSet().getInt("namHoc"),
                            dbc.getResultSet().getString("ngayThuTien"),
                            dbc.getResultSet().getString("nguoiThuTien"),
                            dbc.getResultSet().getInt("soTienDong")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }

        return dsThuHocPhi;
    }

    @Override
    public PhieuThu getOne(int id) {
        DBConnection dbc = new DBConnection();
        PhieuThu thuHocPhi = null;
        dbc.connect();
        try {
            String sql = "select * from dsthuhocphi where id = " + id + ";";
            if (dbc.prepareStatement(sql)) {
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    thuHocPhi = new PhieuThu(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getInt("kiHocDong"),
                            dbc.getResultSet().getInt("namHoc"),
                            dbc.getResultSet().getString("ngayThuTien"),
                            dbc.getResultSet().getString("nguoiThuTien"),
                            dbc.getResultSet().getInt("soTienDong")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }

        return thuHocPhi;
    }

    @Override
    public void insert(PhieuThu thp) {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        try {
            String sql = "insert into dsthuhocphi(maSV, kiHocDong, namHoc, ngayThuTien, nguoiThuTien, soTienDong)"
                    + "values(?, ?, ?, ?, ?, ?)";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, thp.getMaSV());
                dbc.getPreparedStatement().setInt(2, thp.getKiHocDong());
                dbc.getPreparedStatement().setInt(3, thp.getNamHoc());
                dbc.getPreparedStatement().setString(4, thp.getNgayThuTien());
                dbc.getPreparedStatement().setString(5, thp.getNgayThuTien());
                dbc.getPreparedStatement().setInt(6, thp.getSoTienDong());
                dbc.getPreparedStatement().execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    @Override
    public void delete(int id) {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        try {
            String sql = "delete from dsthuhocphi where id = ?";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setInt(1, id);
                dbc.getPreparedStatement().execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    @Override
    public List<PhieuThu> find(String param) {
        DBConnection dbc = new DBConnection();
        List<PhieuThu> dsThuHocPhi = new ArrayList<>();
        dbc.connect();
        try {
            String sql = "select * from dsthuhocphi where maSV like ?";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, param);
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    dsThuHocPhi.add(new PhieuThu(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getInt("kiHocDong"),
                            dbc.getResultSet().getInt("namHoc"),
                            dbc.getResultSet().getString("ngayThuTien"),
                            dbc.getResultSet().getString("nguoiThuTien"),
                            dbc.getResultSet().getInt("soTienDong")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        return dsThuHocPhi;
    }

    @Override
    public void update(int id, PhieuThu thp) {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        try {
            String sql = "update dsthuhocphi set maSV = ?, kiHocDong = ?, namHoc = ?, ngayThuTien = ?, nguoiThuTien = ?, soTienDong = ? where id = ? ";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, thp.getMaSV());
                dbc.getPreparedStatement().setInt(2, thp.getKiHocDong());
                dbc.getPreparedStatement().setInt(3, thp.getNamHoc());
                dbc.getPreparedStatement().setString(4, thp.getNgayThuTien());
                dbc.getPreparedStatement().setString(5, thp.getNguoiThuTien());
                dbc.getPreparedStatement().setInt(6, thp.getSoTienDong());
                dbc.getPreparedStatement().setInt(7, id);
                System.out.println("query " + dbc.getPreparedStatement());
                dbc.getPreparedStatement().execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }

}

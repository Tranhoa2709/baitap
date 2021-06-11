/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.SinhVien;
import utils.DBConnection;

public class SinhVienController extends DataController<SinhVien> {

    @Override
    public List<SinhVien> getList() {
        DBConnection dbc = new DBConnection();
        List<SinhVien> students = new ArrayList<>();
        dbc.connect();
        try {
            String sql = "select * from student";
            if (dbc.prepareStatement(sql)) {
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    students.add(new SinhVien(dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getString("hoTen"),
                            dbc.getResultSet().getString("lopHoc"),
                            dbc.getResultSet().getString("nienKhoa"),
                            dbc.getResultSet().getString("maNganh")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }

        return students;
    }

    @Override
    public SinhVien getOne(int id) {
        DBConnection dbc = new DBConnection();
        SinhVien user = null;
        dbc.connect();
        try {
            String sql = "select * from student where id = " + id + ";";
            if (dbc.prepareStatement(sql)) {
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    user = new SinhVien(dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getString("hoTen"),
                            dbc.getResultSet().getString("lopHoc"),
                            dbc.getResultSet().getString("nienKhoa"),
                            dbc.getResultSet().getString("maNganh")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }

        return user;
    }

    @Override
    public void insert(SinhVien sv) {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        try {
            String sql = "insert into student(maSV, hoTen, lopHoc, nienKhoa, maNganh) "
                    + "values(?, ?, ?, ?, ?)";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, sv.getMaSV());
                dbc.getPreparedStatement().setString(2, sv.getHoTen());
                dbc.getPreparedStatement().setString(3, sv.getLopHoc());
                dbc.getPreparedStatement().setString(4, sv.getNienKhoa());
                dbc.getPreparedStatement().setString(5, sv.getMaNganh());
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
            String sql = "delete from student where id = ?";
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
    public void update(int id, SinhVien sv) {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        try {
            String sql = "update student set maSV = ?, hoTen = ?, lopHoc = ?, nienKhoa = ?, maNganh = ? where id = ? ";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, sv.getMaSV());
                dbc.getPreparedStatement().setString(2, sv.getHoTen());
                dbc.getPreparedStatement().setString(3, sv.getLopHoc());
                dbc.getPreparedStatement().setString(4, sv.getNienKhoa());
                dbc.getPreparedStatement().setString(5, sv.getMaNganh());
                dbc.getPreparedStatement().setInt(6, id);
                System.out.println("query " + dbc.getPreparedStatement());
                dbc.getPreparedStatement().execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    @Override
    public List<SinhVien> find(String param) {
        DBConnection dbc = new DBConnection();
        List<SinhVien> students = new ArrayList<>();
        dbc.connect();
        try {
            String sql = "select * from student where maSV like '%" + param + "%';";
            if (dbc.prepareStatement(sql)) {
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    students.add(new SinhVien(dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getString("hoTen"),
                            dbc.getResultSet().getString("lopHoc"),
                            dbc.getResultSet().getString("nienKhoa"),
                            dbc.getResultSet().getString("maNganh")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        return students;
    }

    public SinhVien findByMaSV(String maSV) {
        DBConnection dbc = new DBConnection();
        SinhVien sinhVien = null;
        dbc.connect();
        try {
            String sql = "select * from student where maSV = ?";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, maSV);
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    sinhVien = (new SinhVien(dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getString("hoTen"),
                            dbc.getResultSet().getString("lopHoc"),
                            dbc.getResultSet().getString("nienKhoa"),
                            dbc.getResultSet().getString("maNganh")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        return sinhVien;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.PhieuNo;
import utils.DBConnection;

public class PhieuNoController extends DataController<PhieuNo> {
        @Override
    public List<PhieuNo> getList() {
        DBConnection dbc = new DBConnection();
        List<PhieuNo> dsNoHocPhi = new ArrayList<>();
        dbc.connect();
        try {
            String sql = "select * from dsnohocphi";
            if (dbc.prepareStatement(sql)) {
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    dsNoHocPhi.add(new PhieuNo(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getInt("soTienConNo"),
                            dbc.getResultSet().getString("ngayDaoHan")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }

        return dsNoHocPhi;
    }

    @Override
    public PhieuNo getOne(int id) {
        DBConnection dbc = new DBConnection();
        PhieuNo thuHocPhi = null;
        dbc.connect();
        try {
            String sql = "select * from dsnohocphi where id = " + id + ";";
            if (dbc.prepareStatement(sql)) {
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    thuHocPhi = new PhieuNo(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getInt("soTienConNo"),
                            dbc.getResultSet().getString("ngayDaoHan")
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
    public void insert(PhieuNo nhp) {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        try {
            String sql = "insert into dsnohocphi(maSV, soTienConNo, ngayDaoHan) "
                    + "values(?, ?, ?)";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, nhp.getMaSV());
                dbc.getPreparedStatement().setInt(2, nhp.getSoTienConNo());
                dbc.getPreparedStatement().setString(3, nhp.getNgayDaoHan());
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
            String sql = "delete from dsnohocphi where id = ?";
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
    public List<PhieuNo> find(String param) {
        DBConnection dbc = new DBConnection();
        List<PhieuNo> dsNoHocPhi = new ArrayList<>();
        dbc.connect();
        try {
            String sql = "select * from dsnohocphi where maSV like ?";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, param);
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
               while (dbc.getResultSet().next()) {
                    dsNoHocPhi.add(new PhieuNo(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maSV"),
                            dbc.getResultSet().getInt("soTienConNo"),
                            dbc.getResultSet().getString("ngayDaoHan")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        return dsNoHocPhi;
    }

    @Override
    public void update(int id, PhieuNo nhp) {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        try {
            String sql = "update dsnohocphi set maSV = ?, soTienConNo = ?, ngayDaoHan = ? where id = ? ";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, nhp.getMaSV());
                dbc.getPreparedStatement().setInt(2, nhp.getSoTienConNo());
                dbc.getPreparedStatement().setString(3, nhp.getNgayDaoHan());
                dbc.getPreparedStatement().setInt(4, id);
                dbc.getPreparedStatement().execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }

}

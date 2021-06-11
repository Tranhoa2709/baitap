/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.MucHocPhi;
import utils.DBConnection;

public class MucHocPhiController extends DataController<MucHocPhi>  {
    @Override
    public List<MucHocPhi> getList() {
        DBConnection dbc = new DBConnection();
        List<MucHocPhi> dsMucHocPhi = new ArrayList<>();
        dbc.connect();
        try {
            String sql = "select * from muchocphi";
            if (dbc.prepareStatement(sql)) {
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    dsMucHocPhi.add(new MucHocPhi(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maNganh"),
                            dbc.getResultSet().getInt("namHoc"),
                            dbc.getResultSet().getInt("soTien")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }

        return dsMucHocPhi;
    }

    @Override
    public MucHocPhi getOne(int id) {
        DBConnection dbc = new DBConnection();
        MucHocPhi thuHocPhi = null;
        dbc.connect();
        try {
            String sql = "select * from muchocphi where id = " + id + ";";
            if (dbc.prepareStatement(sql)) {
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
                while (dbc.getResultSet().next()) {
                    thuHocPhi = new MucHocPhi(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maNganh"),
                            dbc.getResultSet().getInt("namHoc"),
                            dbc.getResultSet().getInt("soTien")
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
    public void insert(MucHocPhi mhp) {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        try {
            String sql = "insert into muchocphi(maNganh, namHoc, soTien) "
                    + "values(?, ?, ?)";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, mhp.getMaNganh());
                dbc.getPreparedStatement().setInt(2, mhp.getNamHoc());
                dbc.getPreparedStatement().setInt(3, mhp.getSoTien());
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
            String sql = "delete from muchocphi where id = ?";
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
    public List<MucHocPhi> find(String param) {
        DBConnection dbc = new DBConnection();
        List<MucHocPhi> dsMucHocPhi = new ArrayList<>();
        dbc.connect();
        try {
            String sql = "select * from muchocphi where maNganh like ?";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, param);
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
               while (dbc.getResultSet().next()) {
                    dsMucHocPhi.add(new MucHocPhi(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maNganh"),
                            dbc.getResultSet().getInt("namHoc"),
                            dbc.getResultSet().getInt("soTien")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        return dsMucHocPhi;
    }

    @Override
    public void update(int id, MucHocPhi obj) {
        DBConnection dbc = new DBConnection();
        dbc.connect();
        try {
            String sql = "update muchocphi set maNganh = ?, namHoc = ?, soTien = ? where id = ? ";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, obj.getMaNganh());
                dbc.getPreparedStatement().setInt(2, obj.getNamHoc());
                dbc.getPreparedStatement().setInt(3, obj.getSoTien());
                dbc.getPreparedStatement().setInt(4, id);
                dbc.getPreparedStatement().execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }
    
    public MucHocPhi findByMaNganhAndNamHoc(String maNganh, int namHoc){
        DBConnection dbc = new DBConnection();
        MucHocPhi res = null;
        dbc.connect();
        try {
            String sql = "select * from muchocphi where maNganh = ? and namHoc = ?";
            if (dbc.prepareStatement(sql)) {
                dbc.getPreparedStatement().setString(1, maNganh);
                dbc.getPreparedStatement().setInt(2, namHoc);
                dbc.setResultSet(dbc.getPreparedStatement().executeQuery());
               while (dbc.getResultSet().next()) {
                    res = (new MucHocPhi(
                            dbc.getResultSet().getInt("id"),
                            dbc.getResultSet().getString("maNganh"),
                            dbc.getResultSet().getInt("namHoc"),
                            dbc.getResultSet().getInt("soTien")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        return res;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class MucHocPhi {
    private int id;
    private String maNganh;
    private int namHoc;
    private int soTien;

    public MucHocPhi(int id, String maNganh, int namHoc, int soTien) {
        this.id = id;
        this.maNganh = maNganh;
        this.namHoc = namHoc;
        this.soTien = soTien;
    }

    public MucHocPhi(String maNganh, int namHoc, int soTien) {
        this.maNganh = maNganh;
        this.namHoc = namHoc;
        this.soTien = soTien;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    @Override
    public String toString() {
        return "mucHocPhi{" + "id=" + id + ", maNganh=" + maNganh + ", namHoc=" + namHoc + ", soTien=" + soTien + '}';
    }
    
    
    
}

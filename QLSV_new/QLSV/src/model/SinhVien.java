/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class SinhVien {
   private int id;
    private String maSV;
    private String hoTen;
    private String lopHoc;
    private String nienKhoa; 
    private String maNganh;

    public SinhVien(int id, String maSV, String hoTen, String lopHoc, String nienKhoa, String maNganh) {
        this.id = id;
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lopHoc = lopHoc;
        this.nienKhoa = nienKhoa;
        this.maNganh = maNganh;
    }

    public SinhVien(String maSV, String hoTen, String lopHoc, String nienKhoa, String maNganh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lopHoc = lopHoc;
        this.nienKhoa = nienKhoa;
        this.maNganh = maNganh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    @Override
    public String toString() {
        return "ThuHocPhi{" + "id=" + id + ", maSV=" + maSV + ", hoTen=" + hoTen + ", lopHoc=" + lopHoc + ", nienKhoa=" + nienKhoa + ", maNganh=" + maNganh + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class PhieuThu {
    private int id;
    private String maSV;
    private int kiHocDong;
    private int namHoc;
    private String ngayThuTien;
    private String nguoiThuTien;
    private int soTienDong;

    public PhieuThu(int id, String maSV, int kiHocDong, int namHoc, String ngayThuTien, String nguoiThuTien, int soTienDong) {
        this.id = id;
        this.maSV = maSV;
        this.kiHocDong = kiHocDong;
        this.namHoc = namHoc;
        this.ngayThuTien = ngayThuTien;
        this.nguoiThuTien = nguoiThuTien;
        this.soTienDong = soTienDong;
    }

    public PhieuThu(String maSV, int kiHocDong, int namHoc, String ngayThuTien, String nguoiThuTien, int soTienDong) {
        this.maSV = maSV;
        this.kiHocDong = kiHocDong;
        this.namHoc = namHoc;
        this.ngayThuTien = ngayThuTien;
        this.nguoiThuTien = nguoiThuTien;
        this.soTienDong = soTienDong;
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

    public int getKiHocDong() {
        return kiHocDong;
    }

    public void setKiHocDong(int kiHocDong) {
        this.kiHocDong = kiHocDong;
    }

    public int getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(int namHoc) {
        this.namHoc = namHoc;
    }

    public String getNgayThuTien() {
        return ngayThuTien;
    }

    public void setNgayThuTien(String ngayThuTien) {
        this.ngayThuTien = ngayThuTien;
    }

    public String getNguoiThuTien() {
        return nguoiThuTien;
    }

    public void setNguoiThuTien(String nguoiThuTien) {
        this.nguoiThuTien = nguoiThuTien;
    }

    public int getSoTienDong() {
        return soTienDong;
    }

    public void setSoTienDong(int soTienDong) {
        this.soTienDong = soTienDong;
    }

    @Override
    public String toString() {
        return "ThuHocPhi{" + "id=" + id + ", maSV=" + maSV + ", kiHocDong=" + kiHocDong + ", namHoc=" + namHoc + ", ngayThuTien=" + ngayThuTien + ", nguoiThuTien=" + nguoiThuTien + ", soTienDong=" + soTienDong + '}';
    }
    
    
}

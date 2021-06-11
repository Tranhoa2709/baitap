/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class PhieuNo {
    private int id;
    private String maSV;
    private int soTienConNo;
    private String ngayDaoHan;

    public PhieuNo(int id, String maSV, int soTienConNo, String ngayDaoHan) {
        this.id = id;
        this.maSV = maSV;
        this.soTienConNo = soTienConNo;
        this.ngayDaoHan = ngayDaoHan;
    }

    public PhieuNo(String maSV, int soTienConNo, String ngayDaoHan) {
        this.maSV = maSV;
        this.soTienConNo = soTienConNo;
        this.ngayDaoHan = ngayDaoHan;
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

    public int getSoTienConNo() {
        return soTienConNo;
    }

    public void setSoTienConNo(int soTienConNo) {
        this.soTienConNo = soTienConNo;
    }

    public String getNgayDaoHan() {
        return ngayDaoHan;
    }

    public void setNgayDaoHan(String ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

    @Override
    public String toString() {
        return "NoHocPhi{" + "id=" + id + ", maSV=" + maSV + ", soTienConNo=" + soTienConNo + ", ngayDaoHan=" + ngayDaoHan + '}';
    }
    
}

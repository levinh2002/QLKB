/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vivobook
 */
public class thuphiDTO {
    private String MaKB;
    private String MaDV;
    private String SoLuong;
    private String ThanhTien;
    
    private String TenDV;// Dùng cho hàm getThuPhi ở thuphiDAL

    public thuphiDTO() {
    }

    public thuphiDTO(String MaKB, String MaDV, String SoLuong, String ThanhTien, String TenDV) {
        this.MaKB = MaKB;
        this.MaDV = MaDV;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.TenDV = TenDV;
    }

    public String getMaKB() {
        return MaKB;
    }

    public String getMaDV() {
        return MaDV;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setMaKB(String MaKB) {
        this.MaKB = MaKB;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public void setSoLuong(String SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setThanhTien(String ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }
    
}

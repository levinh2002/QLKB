/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vivobook
 */
public class dichvuDTO {
    private String MaDV;
    private String TenDV;
    private String DonGia;

    public dichvuDTO() {
    }

    public dichvuDTO(String MaDV, String TenDV, String DonGia) {
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.DonGia = DonGia;
    }

    public String getMaDV() {
        return MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public String getDonGia() {
        return DonGia;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public void setDonGia(String DonGia) {
        this.DonGia = DonGia;
    }
    
}

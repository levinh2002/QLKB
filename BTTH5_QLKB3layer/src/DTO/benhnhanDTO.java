/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vivobook
 */
public class benhnhanDTO {
    private String MaBN;
    private String TenBN;
    private String NgSinh;
    private String DChi;
    private String DThoai;
    private String GioiTinh;

    public benhnhanDTO() {
    }

    public benhnhanDTO(String MaBN, String TenBN, String NgSinh, String DChi, String DThoai, String GioiTinh) {
        this.MaBN = MaBN;
        this.TenBN = TenBN;
        this.NgSinh = NgSinh;
        this.DChi = DChi;
        this.DThoai = DThoai;
        this.GioiTinh = GioiTinh;
    }

    public String getMaBN() {
        return MaBN;
    }

    public String getTenBN() {
        return TenBN;
    }

    public String getNgSinh() {
        return NgSinh;
    }

    public String getDChi() {
        return DChi;
    }

    public String getDThoai() {
        return DThoai;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setMaBN(String MaBN) {
        this.MaBN = MaBN;
    }

    public void setTenBN(String TenBN) {
        this.TenBN = TenBN;
    }

    public void setNgSinh(String NgSinh) {
        this.NgSinh = NgSinh;
    }

    public void setDChi(String DChi) {
        this.DChi = DChi;
    }

    public void setDThoai(String DThoai) {
        this.DThoai = DThoai;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    
}

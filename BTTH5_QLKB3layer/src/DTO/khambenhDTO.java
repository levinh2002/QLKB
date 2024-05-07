/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vivobook
 */
public class khambenhDTO {
    private String MaKB;
    private String MaBN;
    private String MaBS;
    private String NgayKham;
    private String YeuCauKham;
    private String KetLuan;
    private String ThanhToan;

    public khambenhDTO() {
    }

    public khambenhDTO(String MaKB, String MaBN, String MaBS, String NgayKham, String YeuCauKham, String KetLuan, String ThanhToan) {
        this.MaKB = MaKB;
        this.MaBN = MaBN;
        this.MaBS = MaBS;
        this.NgayKham = NgayKham;
        this.YeuCauKham = YeuCauKham;
        this.KetLuan = KetLuan;
        this.ThanhToan = ThanhToan;
    }

    public String getMaKB() {
        return MaKB;
    }

    public String getMaBN() {
        return MaBN;
    }

    public String getMaBS() {
        return MaBS;
    }

    public String getNgayKham() {
        return NgayKham;
    }

    public String getYeuCauKham() {
        return YeuCauKham;
    }

    public String getKetLuan() {
        return KetLuan;
    }

    public String getThanhToan() {
        return ThanhToan;
    }

    public void setMaKB(String MaKB) {
        this.MaKB = MaKB;
    }

    public void setMaBN(String MaBN) {
        this.MaBN = MaBN;
    }

    public void setMaBS(String MaBS) {
        this.MaBS = MaBS;
    }

    public void setNgayKham(String NgayKham) {
        this.NgayKham = NgayKham;
    }

    public void setYeuCauKham(String YeuCauKham) {
        this.YeuCauKham = YeuCauKham;
    }

    public void setKetLuan(String KetLuan) {
        this.KetLuan = KetLuan;
    }

    public void setThanhToan(String ThanhToan) {
        this.ThanhToan = ThanhToan;
    }
    
}

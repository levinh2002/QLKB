/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Vivobook
 */
public class bacsiDTO {
    private String MaBS;
    private String TenBS;

    public bacsiDTO() {
    }

    public bacsiDTO(String MaBS, String TenBS) {
        this.MaBS = MaBS;
        this.TenBS = TenBS;
    }

    public String getMaBS() {
        return MaBS;
    }

    public String getTenBS() {
        return TenBS;
    }

    public void setMaBS(String MaBS) {
        this.MaBS = MaBS;
    }

    public void setTenBS(String TenBS) {
        this.TenBS = TenBS;
    }
    
    
}

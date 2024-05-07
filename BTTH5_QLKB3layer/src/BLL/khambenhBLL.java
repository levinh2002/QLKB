/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;
import DTO.*;
import DAL.*;
import java.util.ArrayList;

/**
 *
 * @author Vivobook
 */
public class khambenhBLL {
    khambenhDAL khambenhDAL = new khambenhDAL();
    
    public int insertkhambenh(khambenhDTO khambenh) {
        int result = khambenhDAL.insertKhamBenh(khambenh);
        return result;
    }
    
    public khambenhDTO getkhambenh(String MaBN, String MaBS, String NgKham) {
        return khambenhDAL.getkhambenh(MaBN, MaBS, NgKham);
    }
    
    public int updateKetLuan(String KetLuan, String MaKB){
        int result = khambenhDAL.updateKetLuan(KetLuan, MaKB);
        return result;
    }
    
    public ArrayList<khambenhDTO> getkhambenh2(String MaBN, String NgKham) {
        return khambenhDAL.getkhambenh2(MaBN, NgKham);
    }
}

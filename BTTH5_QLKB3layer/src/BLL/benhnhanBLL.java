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
public class benhnhanBLL {
    benhnhanDAL benhnhanDAL = new benhnhanDAL();
    
    public int insertbenhnhan(benhnhanDTO benhnhan) {
        int result = benhnhanDAL.insertBenhNhan(benhnhan);
        return result;
    }
    
    public ArrayList<benhnhanDTO> getbenhnhan(String MaBS, String NgKham) {
        return benhnhanDAL.getbenhnhan(MaBS, NgKham);
    }
    
    public benhnhanDTO getbenhnhan2(String MaBN){
        return benhnhanDAL.getbenhnhan2(MaBN);
    }
}

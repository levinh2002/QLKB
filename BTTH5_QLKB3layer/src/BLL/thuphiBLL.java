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
public class thuphiBLL {
    thuphiDAL thuphiDAL = new thuphiDAL();
    
    public int insertThuPhi(thuphiDTO thuphi) {
        int result = thuphiDAL.insertThuPhi(thuphi);
        return result;
    }
    
    public ArrayList<thuphiDTO> getThuPhi(String MaKB) {
        return thuphiDAL.getThuPhi(MaKB);
    }
}

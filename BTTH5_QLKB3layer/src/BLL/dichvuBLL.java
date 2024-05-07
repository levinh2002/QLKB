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
public class dichvuBLL {
    dichvuDAL dichvuDAL = new dichvuDAL();
    
    public ArrayList<dichvuDTO> getAlldichvu() {
        return dichvuDAL.getALLdichvu();
    }
}

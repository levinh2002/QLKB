/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;

import DTO.*;
import Utils.*;
import java.sql.*;

/**
 *
 * @author Vivobook
 */
public class bacsiDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public ArrayList<bacsiDTO> getALLbacsi(){
        //khởi tạo đối tượng chứa kết quả
        ArrayList<bacsiDTO> result = new ArrayList<bacsiDTO>();
        
        //câu lệnh sql truy vấn
        String sqlSelectALL = "select * from BACSI";
        
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlSelectALL);
            rs = pres.executeQuery();
            
            //gán result set vào Arraylist result 
            while(rs.next()){
                bacsiDTO bacsi = new bacsiDTO();
                bacsi.setMaBS(rs.getString("MaBS"));
                bacsi.setTenBS(rs.getString("TenBS"));
                
                result.add(bacsi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                conn.close();
                pres.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

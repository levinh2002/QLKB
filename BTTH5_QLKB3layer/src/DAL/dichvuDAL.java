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
public class dichvuDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public ArrayList<dichvuDTO> getALLdichvu(){
        //khởi tạo đối tượng chứa kết quả
        ArrayList<dichvuDTO> result = new ArrayList<dichvuDTO>();
        
        //câu lệnh sql truy vấn
        String sqlSelectALL = "select * from DICHVU";
        
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlSelectALL);
            rs = pres.executeQuery();
            
            //gán result set vào Arraylist result 
            while(rs.next()){
                dichvuDTO dv = new dichvuDTO();
                dv.setMaDV(rs.getString("MaDV"));
                dv.setTenDV(rs.getString("TenDV"));
                dv.setDonGia(rs.getString("DonGia"));
                
                result.add(dv);
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

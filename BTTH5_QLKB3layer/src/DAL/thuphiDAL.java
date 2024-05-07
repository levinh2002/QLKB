/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import DTO.*;
import Utils.*;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Vivobook
 */
public class thuphiDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public int insertThuPhi(thuphiDTO thuphi){
        int result = 0;
        String sqlInsert = "Insert into THUPHI (MAKB, MADV, SOLUONG, THANHTIEN) values (?, ?, ?, ?)";
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            pres.setString(1, thuphi.getMaKB());
            pres.setString(2, thuphi.getMaDV());
            pres.setString(3, thuphi.getSoLuong());
            pres.setString(4, thuphi.getThanhTien());
            
            result = pres.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                conn.close();
                pres.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  result;
    }
    
    public ArrayList<thuphiDTO> getThuPhi(String MaKB){
        //khởi tạo đối tượng chứa kết quả
        ArrayList<thuphiDTO> result = new ArrayList<thuphiDTO>();
        
        //câu lệnh sql truy vấn
        String strSQL = "Select * from THUPHI, DICHVU WHERE THUPHI.MADV = DICHVU.MADV AND MAKB = ?";
        
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);
            pres.setString(1, MaKB);
            rs = pres.executeQuery();
            
            while(rs.next()){
                thuphiDTO tp = new thuphiDTO();
                tp.setMaDV(rs.getString("ThuPhi.MaDV"));
                tp.setTenDV(rs.getString("TenDV"));
                tp.setSoLuong(rs.getString("SoLuong"));
                tp.setThanhTien(rs.getString("ThanhTien"));
                
                result.add(tp);
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
        return kb;
    }
}

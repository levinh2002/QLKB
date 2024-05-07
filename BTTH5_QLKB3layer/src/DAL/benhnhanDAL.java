/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.*;
import DTO.*;
import Utils.*;
import java.util.ArrayList;

/**
 *
 * @author Vivobook
 */
public class benhnhanDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public int insertBenhNhan(benhnhanDTO benhnhan){
        int result = 0;
        String sqlInsert = "insert into BENHNHAN values (?, ?, ?, ?, ?, ?)";
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            pres.setString(1, benhnhan.getMaBN());
            pres.setString(2, benhnhan.getTenBN());
            pres.setString(3, benhnhan.getNgSinh());
            pres.setString(4, benhnhan.getDChi());
            pres.setString(5, benhnhan.getDThoai());
            if(benhnhan.getGioiTinh().equals("Nam")==true)
                pres.setBoolean(6, true);
            else
                pres.setBoolean(6, false);
            
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
    
    public ArrayList<benhnhanDTO> getbenhnhan(String MaBS, String NgKham){
        //khởi tạo đối tượng chứa kết quả
        ArrayList<benhnhanDTO> result = new ArrayList<benhnhanDTO>();
        
        //câu lệnh sql truy vấn
        String sqlSelectBN = "Select KHAMBENH.MABN, TENBN from KHAMBENH, BENHNHAN WHERE KHAMBENH.MABN = BENHNHAN.MABN AND MABS=? AND NGAYKHAM=? AND (THANHTOAN=0 OR THANHTOAN IS NULL)";
        
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlSelectBN);
            pres.setString(1, MaBS);
            pres.setString(2, NgKham);
            rs = pres.executeQuery();
            
            //gán result set vào Arraylist result 
            while(rs.next()){
                benhnhanDTO bn = new benhnhanDTO();
                bn.setMaBN(rs.getString("MaBN"));
                bn.setTenBN(rs.getString("TenBN"));
                
                result.add(bn);
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
    
    public benhnhanDTO getbenhnhan2(String MaBN){
        //khởi tạo đối tượng chứa kết quả
        benhnhanDTO bn = new benhnhanDTO();
        
        //câu lệnh sql truy vấn
        String strSQL = "SELECT * FROM BENHNHAN WHERE MABN = ?";
        
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);
            pres.setString(1, MaBN);
            rs = pres.executeQuery();
            
            rs.absolute(1);
            bn.setMaBN(rs.getString("MaBN"));
            bn.setTenBN(rs.getString("TenBN"));
            bn.setNgSinh(rs.getString("NgSinh"));
            bn.setDChi(rs.getString("DChi"));
            bn.setDThoai(rs.getString("DThoai"));
            bn.setGioiTinh(rs.getString("GioiTinh"));
                
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

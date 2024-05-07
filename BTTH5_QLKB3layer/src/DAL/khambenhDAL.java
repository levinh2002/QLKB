/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import java.sql.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import DTO.*;
import Utils.*;
import com.mysql.cj.xdevapi.SqlUpdateResult;
/**
 *
 * @author Vivobook
 */
public class khambenhDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public int insertKhamBenh(khambenhDTO khambenh){
        int result = 0;
        String sqlInsert = "insert into KHAMBENH values (?, ?, ?, ?, ?, ?, ?)";
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            pres.setString(1, khambenh.getMaKB());
            pres.setString(2, khambenh.getMaBN());
            pres.setString(3, khambenh.getMaBS());
            pres.setString(4, khambenh.getNgayKham());
            pres.setString(5, khambenh.getYeuCauKham());
            pres.setString(6, khambenh.getKetLuan());
            pres.setString(7, khambenh.getThanhToan());
            
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
    
    public khambenhDTO getkhambenh(String MaBN, String MaBS, String NgKham){
        //khởi tạo đối tượng chứa kết quả
        khambenhDTO kb = new khambenhDTO();
        
        //câu lệnh sql truy vấn
        String sqlSelectKB = "select * from KHAMBENH WHERE MABN=? AND MABS=? AND NGAYKHAM=? AND (THANHTOAN=0 OR THANHTOAN IS NULL)";
        
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlSelectKB, ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);
            pres.setString(1, MaBN);
            pres.setString(2, MaBS);
            pres.setString(3, NgKham);
            rs = pres.executeQuery();
            
            rs.absolute(1);
            kb.setMaKB(rs.getString("MaKB"));
            kb.setMaBN(rs.getString("MaBN"));
            kb.setMaBS(rs.getString("MaBS"));
            kb.setNgayKham(rs.getString("NgayKham"));
            kb.setYeuCauKham(rs.getString("YeuCauKham"));
            kb.setKetLuan(rs.getString("KetLuan"));
            kb.setThanhToan(rs.getString("ThanhToan"));
                
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
    
    public int updateKetLuan(String KetLuan, String MaKB){
        int result = 0;
        String strUpdate = "Update KHAMBENH set KetLuan = ? where MaKB = ?";
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strUpdate);
            pres.setString(1, KetLuan);
            pres.setString(2, MaKB);
            
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
    
    public ArrayList<khambenhDTO> getkhambenh2(String MaBN, String NgKham){
        //khởi tạo đối tượng chứa kết quả
        ArrayList<khambenhDTO> result = new ArrayList<khambenhDTO>();
        
        //câu lệnh sql truy vấn
        String strSQL = "Select * from KHAMBENH WHERE MABN=? AND NGAYKHAM=?";
        
        try {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL, ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_UPDATABLE);
            pres.setString(1, MaBN);
            pres.setString(2, NgKham);
            rs = pres.executeQuery();
            
            while(rs.next()){
                khambenhDTO kb = new khambenhDTO();
                kb.setMaKB(rs.getString("MaKB"));
                kb.setMaBN(rs.getString("MaBN"));
                kb.setMaBS(rs.getString("MaBS"));
                kb.setNgayKham(rs.getString("NgayKham"));
                kb.setYeuCauKham(rs.getString("YeuCauKham"));
                kb.setKetLuan(rs.getString("KetLuan"));
                kb.setThanhToan(rs.getString("ThanhToan"));
                
                result.add(kb);
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

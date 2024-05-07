/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Vivobook
 */
public class DBUtils {
    private  Connection conn;
    
    public  DBUtils(){};
    
    public Connection createConn(){
      try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlkb?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","314159");

            if (conn == null)
                System.out.println("Kết nối không thành công");
            else
                System.out.println("Kết nối thành công");
        } catch(Exception e){
            e.printStackTrace();
        }
        return conn;  
    }
}

package SGMS;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class ConnDB{  
    Connection con;  
    String url = null;    
    public void connection() throws ClassNotFoundException{    
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SGMS", "root", "YuYi@13255237113");  
            System.out.println("连接成功");   
        }  
        catch(SQLException e){  
            e.printStackTrace();  
        }  
    }  
}  
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
    private Connection conn;
    private PreparedStatement prepState;
    private ResultSet rSet;

    public DbConnection(String dbloc) {
        try {
            conn = DriverManager.getConnection(dbloc);
            System.out.println("Connection Established.");
        }
        catch (SQLException e) {
            System.out.println(e);
            System.out.println("Connection Error.");            
        }
    }
    
    public ResultSet runSelect(String sql) {
        try {
            prepState = conn.prepareStatement(sql);
            rSet = prepState.executeQuery();
        } 
        catch (Exception e) { 
            System.out.println(e);
        }     
            return rSet;        
    }   
    
    public void runDML(String sql) {
        try {
            prepState = conn.prepareStatement(sql);
            prepState.executeUpdate();
            System.out.println("Record Updated Successfully.");
        } 
        catch (Exception e) { 
            System.out.println(e);
        }     
    }   
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Thursday
 */
public class DataBase {
    
    public static DataBase DB = new DataBase();
    public static Connection con;
    private static final String table = new String("jdbc:mysql://localhost:3306/brainstorm");
    private static final String user = new String("hsibayan");
    private static final String password = new String("0987");
    
    
    public DataBase(){
        try {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
        }catch (Exception ex) {
            System.out.println("Error");
        }
        
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/brainstorm","hsibayan","0987");
   
        } catch (SQLException e) {
            System.out.println("You have an error  "+ e);
        }
    }
   
    public static Connection getConnection(){
        return con;
    }
    
    public static DataBase getDB(){
        return DB;
    }
    
    
    public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
        public static void openConnection(){
        try {
           
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/brainstorm","hsibayan", "0987");
            
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
  
}
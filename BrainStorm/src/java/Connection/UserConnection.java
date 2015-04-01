/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import Bean.UserBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thursday
 */
public class UserConnection {
    
    
    public static UserConnection userquery = new UserConnection();
    
    
    public boolean isVerify(String user, String pass, UserBean Bean){
        
        boolean logged = false;
        
        String sql=  "select username ,password , firstname, lastname,userID from user where username = '"+ 
                user +
                "'" ;
        
        try{
            
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           
          if(rs.next()){
              if(rs.getString(1).equals(user) && rs.getString(2).equals(pass)){
               logged=true;
               
               Bean.setUser(rs.getString("username"));
               Bean.setFirstName(rs.getString("firstname"));
               Bean.setLastName(rs.getString("lastname"));
               Bean.setID(rs.getInt("userID"));
           }
          }else System.out.println("USER NOT FOUND "+ user); 
           
               
          
           
        }catch(Exception e){
            System.out.println(e);
        }
           
        return logged;
    }
    
    
    public boolean makeruser(String user,String pass,String fname,String lname ){
        
        boolean r=true;
        String sql = "INSERT INTO user (username, password, firstname, lastname) "
                + "VALUES ('"+ user+"', '"+pass+"', '"+fname+"', '"+lname+"');";
         try{
            
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           //rs = stmt.executeQuery(sql);
           stmt.executeUpdate(sql);
          
           
        }catch(Exception e){
            System.out.println(e);
            r=false;
        }
        
        return r;
    }
    
    
    
    
    
}

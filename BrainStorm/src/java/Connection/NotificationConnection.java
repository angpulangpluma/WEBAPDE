/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import Bean.Group;
import Bean.HomePageBean;
import Bean.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Thursday
 */
public class NotificationConnection {
    
    
        public ArrayList<Member> getGroupmates(int userid,int groupid) {
       
        ArrayList<Member> members;
        members = new ArrayList<Member>();
        
        String sql = "select user.userID, user.firstname, user.lastname from groups, groupmembers , user "+
                "where groups.groupID = groupmembers.groupID "+
                "and user.userID = groupmembers.userID "+
                "and user.userID != "+ userid+" "+
                "and groups.groupID = "+ groupid;

        try {
         
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
               members.add(new Member(rs.getInt(1), rs.getString(2),rs.getString(3)));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return members;
        
    }
    
        
    private int getMaxNotifID(){
        
        String sql = "select max(notifID) from notification";
        int max=0;
        try {
         
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
           if(rs.next()) 
               max=rs.getInt(1);

        } catch (Exception e) {
            System.out.println(e);
        }
        return max;
    }    
     
    public void saveNotif(int uid, int groupid, String notif, ArrayList<Member> members){
        String memberid="";
        String sql = "INSERT INTO notification (`notifID`, `notif`, `goingTo`) VALUES ("+ uid + ",'"+notif+"',"+ memberid +")";
        int max = getMaxNotifID();
        max++;
           try {
            ResultSet rs;
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();

            for(Member m: members){  
             stmt.executeUpdate(  "INSERT INTO notification (`notifID`, `notif`, `goingTo`) VALUES ("+ max + ",'"+notif+"',"+ m.getId()+")");  
             max++;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
    }
    
    
}

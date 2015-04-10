/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import Bean.Group;
import Bean.HomePageBean;
import Bean.Member;
import Bean.Notification;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Thursday
 */
public class NotificationConnection {
        
    
        public int getTopicId(int ideaid){
            
            String sql = "select topic.topicID from idea, topic where idea.topicID = topic.topicID and ideaID = "+ ideaid;            
            int id=-1;
             try {
         
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
           
            if(rs.next()){
             id = rs.getInt(1);           
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
            
            
        }
    
        public ArrayList<Notification> getNotifs(int userid) {
       
        ArrayList<Notification> notifs;
        notifs = new ArrayList<Notification>();
        
        String sql = "select notif, time, firstname, lastname,userID from notification , user "+
                    "where userID = notification.from "+
                    "and goingTo = " +userid+
                    " order by time DESC";

        try {
         
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            Member m;
            int counter=0;
            String dateString;
            while (rs.next() && counter < 5) {
               m = new Member(rs.getInt(5), rs.getString(3),rs.getString(4));
               dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp(2));
               notifs.add(new Notification(rs.getString(1), dateString,m ));
               System.out.println(rs.getString(1));
               counter++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return notifs;
        
    }
    
        public ArrayList<Member> getGroupmates(int userid,int groupid) {
       
        System.out.println("GETTING GROUPMATESS YO!");
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
    
    public String getProjectname(int id){
        
         String sql = "select projectname from project where projectID = "+ id;
        String name="";
        try {
         
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
           if(rs.next()) 
               name=rs.getString(1);

        } catch (Exception e) {
            System.out.println(e);
        }
        return name;
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
         System.out.println("SAVING NOTIF YO!");
         System.out.println(members);
        String memberid="";
        String sql = "INSERT INTO notification (`notifID`, `notif`, `goingTo`) VALUES ("+ uid + ",'"+notif+"',"+ memberid +")";
        int max = getMaxNotifID();
        max++;
           try {
            ResultSet rs;
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();

            for(Member m: members){  
             stmt.executeUpdate(  "INSERT INTO notification (`notifID`, `notif`, `goingTo`, `from` ) VALUES ("+ max + ",'"+notif+"',"+ m.getId()+ ",'"+uid+"' )");  
             max++;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
    }
    
    
}

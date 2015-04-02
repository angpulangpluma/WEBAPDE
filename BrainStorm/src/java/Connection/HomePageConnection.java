/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import Bean.Group;
import Bean.HomePageBean;
import Bean.Project;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Thursday
 */
public class HomePageConnection {
    
    
    public void getGroups(int id, HomePageBean Bean){
        boolean logged = false;
        
        String sql=  "select groups.groupid, groups.groupname, groupmembers.userID "+  
                    "from groups, groupmembers "+
                    "where groups.groupID = groupmembers.groupID and groupmembers.userID = "+ id;
        
        try{
           Group g; 
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
          
           
           while(rs.next()){
               
               g = new Group(rs.getInt(1),rs.getString(2));
               getProject(rs.getInt(1), g);
               getMember(rs.getInt(1), g);
               //
               
               Bean.addGroup(g);
               
           }
                         
        }catch(Exception e){
            System.out.println(e);
        }
            
    }
    
    
    public String getSuggestions(String word){
        
        String sql = "select username,firstname, lastname "
                + "from user "
                + "where firstname LIKE '%"+word+"%' or  lastname LIKE '%"+word+"%'";
        int counter=0;
        String people=null;
         try{
           
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           
           if(rs.next())
               people= rs.getString("firstname") +" "+rs.getString("lastname");
           
           while(rs.next() && counter < 5 ){
               people = people +"\n"+rs.getString("firstname") +" "+rs.getString("lastname");
               counter++;
           }
                         
        }catch(Exception e){
            System.out.println(e);
        }
        
        return people;
    }
    
    
    private void getMember(int id, Group g){
        
        String sql = "select groupID, user.userID, firstname, lastname "+
        "from groupmembers, user "+
        "where groupmembers.userID = user.userID and groupID ="+ id;
        
        try{
           Project p;
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
         
           while(rs.next()){
               g.addMember(rs.getString(3), rs.getString(4));
               //g.addProject(rs.getInt(1), rs.getString(3));
               System.out.println("MEMBER OF ID "+id +" "+rs.getString(3));
           }
                         
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }
    
    private void getProject(int id,Group g){
        
         String sql=  "select projectID, groups.groupID, projectname from project, groups "+
                      "where project.groupID = groups.groupID "+
                      "and groups.groupID = "+ id;
        
         /*
         select  topicID,topicname,projectname 
        from topic, project 
        where topic.projectID = project.ProjectID
         
         */
         
        try{
           Project p;
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
          
           
           while(rs.next()){
               
               g.addProject(rs.getInt(1), rs.getString(3));
               System.out.println("TOPIC OF ID "+id +" "+rs.getString(3));
           }
                         
        }catch(Exception e){
            System.out.println(e);
        }
            
        
        
        
    }
    
    
    
    
}

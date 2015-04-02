/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import Bean.Group;
import Bean.HomePageBean;
import Bean.Idea;
import Bean.Member;
import Bean.ProjectPageBean;
import Bean.Topic;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;


/**
 *
 * @author Thursday
 */
public class ProjectConnection {
 
    
    public void getTopics(ProjectPageBean Bean){
        
        String sql = "select topicID, topicname "
                + "from topic "
                + "where projectID = "+ Bean.getID();
        
        try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           Topic topic;
           
           while(rs.next()){
               topic = new Topic(rs.getInt(1), rs.getString(2));
               System.out.println("Topics are: "+ topic.getName());
                getIdeas(topic);
                Bean.addTopic(topic);
           }
                         
        }catch(Exception e){
            System.out.println("HERE WHYY");
            System.out.println(e);
        }
            
        
    }
    
    private void getIdeas(Topic topic){
        
        String sql= "select ideaID,  idea , user.userID, firstname, lastname ,time " +
                    "from idea, user " +
                    "where idea.userID = user.userID " +
                    "and topicID = "+ topic.gettopicid();
        
            try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           Idea idea;
           Member m;
           
           String dateString;
           while(rs.next()){
             m = new Member(rs.getInt(3),rs.getString(4), rs.getString(5));
             dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("time"));
             idea = new Idea(rs.getInt(1), rs.getString(2),m ,dateString );
             System.out.println("Ideas are "+ idea.getIdea() );
             topic.addIdea(idea);
               
               
           }
                         
        }catch(Exception e){
            System.out.println(e);
        }
           
    }
    
    public void saveIdea(int tid, int uid, String idea){
        
        String sql = "INSERT INTO idea (topicID, userID, idea) VALUES ("+tid+","+ uid+", '"+idea+"')";
        
         try{
 
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           stmt.executeUpdate(sql);
                                  
        }catch(Exception e){
            System.out.println(e);
        }
            
    }
    
    public int getMaxProjID(){
        
        String sql="select MAX(projectID) from project ";
         int max=0;
         try{
 
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs =stmt.executeQuery(sql);
           
           if(rs.next())
             max = rs.getInt(1);
                                  
        }catch(Exception e){
            System.out.println(e);
        }
        
        return max;
    }
    
    
    /*
    public void getGroups(int id, HomePageBean Bean){
        
        
        String sql=  "select projectname, idea.ideaID , topic.topicID , topic.topicname, idea,  idea.userID , user.firstname, user.lastname " +
                     "from idea , topic, project , user " +
                     "where topic.topicID = idea.topicID " +
                     "and project.projectID = topic.projectID " +
                     "and user.userID = idea.userID " +
                     "and project.projectID = "+ id;
        
        try{
           Group g; 
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
          
           
           while(rs.next()){
              
               Bean.addGroup(g);
               
           }
                         
        }catch(Exception e){
            System.out.println(e);
        }
            
    }
   */ 
    
    
}

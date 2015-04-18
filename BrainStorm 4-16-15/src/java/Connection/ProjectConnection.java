/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import Bean.Comment;
import Bean.Group;
import Bean.HomePageBean;
import Bean.Idea;
import Bean.Member;
import Bean.Project;
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
    
    public Member getIdeaOwner(String ideaid){
        
        String sql ="select firstname, lastname,user.userID  from idea, user " +
                    "where idea.userID = user.userID " +
                    "and idea.ideaID = "+ ideaid;
        
        Member member=null;
        
        try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           if(rs.next()){
               member = new Member(rs.getInt(3), rs.getString(1),rs.getString(2));
           }
         }
          catch(Exception e){
            System.out.println(e);
        }
        
        return member;
        
    }
    
    
    
    public String getProjectname2(int id){
        
        String sql = "select projectname from topic , project where topic.projectID = project.projectID and topicID = "+ id;
        
         String name="";
          try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           
           if(rs.next())
              name = rs.getString(1);
                         
        }catch(Exception e){
            System.out.println("HERE WHYY");
            System.out.println(e);
        }
        
        return name;
        
    }
    
    public void getProjectName(Project p){
        String sql = "select projectname from project where project.projectID = " + p.getID();
        
        try{
            Connection con = DataBase.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            
            if (rs.next()){
                p.setName(rs.getString(1));
            } else p.setName(" ");
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public String getTopicname2(int id){
        
        String sql = "select topicname from topic where topicID = "+ id;
        String name="";
          try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           
           if(rs.next())
              name = rs.getString(1);
                         
        }catch(Exception e){
            System.out.println("HERE WHYY");
            System.out.println(e);
        }
        
        return name;
    }
    
    public int getIdeaCount(int projid){
        int result = 0;
        String sql = "select count(*) from idea, topic, project, groups\n" +
"    where idea.topicID = topic.topicID\n" +
"		and topic.projectID = project.projectID\n" +
"		and groups.groupID = project.groupID\n" +
"		and project.projectID = " + projid;
        
        try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           
           if(rs.next()){
              result = rs.getInt(1);
              System.out.println("Idea count: " + result);
           }
                         
        }catch(Exception e){
            System.out.println("HERE WHYY");
            System.out.println(e);
        }
        return result;
    }
    
    public void getTopics(Project Bean){
        
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
    
    public void SaveComment(String userID, String postID, String comment){
        
        String sql = "INSERT INTO comment (`userID`, `postID`, `comment`) VALUES ("+userID+","+ postID+", '"+comment +"')";
        
         try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           stmt.executeUpdate(sql);
         }
          catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    
    public int getGroupID(int topicid){
        String sql ="select groupID " +
                    "from topic, project " +
                    "where project.projectID = topic.projectID " +
                    "and topicID = "+ topicid;
        int gid=-1;
         try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           if(rs.next()){
               gid = rs.getInt(1);
           }
         }
          catch(Exception e){
            System.out.println(e);
        }
        
        return gid;
    }
    
    public String getTopicName(String topicID){
        
        String sql = "select topicName from topic where topicID = "+ topicID;
        String topicname=null;
        try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           if(rs.next()){
               topicname = rs.getString(1);
           }
         }
          catch(Exception e){
            System.out.println(e);
        }
        
        return topicname;
    }
    
    public String getGroupName(int groupid){
        String sql = "select groupName from groups where groupID = " + groupid;
        String result = " ";
        try{
            Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           if(rs.next()){
               result = rs.getString(1);
           }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return result;
    }
    
    public Idea getIdeaComments(int id, Member member){
        
        String sql ="select ideaID, idea, time,topic.topicID, topicname from idea, topic where idea.topicID = topic.topicID and ideaID = "+id;
           Idea idea =null;
        try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           if(rs.next()){
           String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("time"));
           idea = new Idea(rs.getInt(1), rs.getString(2),member, dateString,rs.getString("topicname"),rs.getInt(4)) ;
           System.out.println("Idea is "+idea.getIdea());
           getComments(idea);
           getRating(idea);
           
           }
         }
          catch(Exception e){
            System.out.println(e);
        }
        
        return idea;
    }
    
    public void rate(String uid, String tid, String rate){
        
        String sql = "select * from rating where userid ="+ uid+" and topicid="+ tid;
        
         try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           
           if(rs.next()){  
               System.out.println("UPDATING");
               String sql2 = "UPDATE rating SET rating = "+ rate + " WHERE ratingid= "+ rs.getInt(1);
               stmt.executeUpdate(sql2);
           }else{
               String sql2 = "INSERT INTO rating (userid, topicid, rating) VALUES ("+ uid +","+tid+","+ rate+")";
               stmt.executeUpdate(sql2);
           }
            
         }
          catch(Exception e){
           System.out.println(e);
        }
        
    }
    
    private int getIDRating(String uid, String tid){
        String sql = "select ratingid from rating where userid = "+uid+" and topicid= "+ tid;
        int id=-1;
           try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           
           
           if(rs.next()){
                id= rs.getInt(1);
           }
                
         }
          catch(Exception e){
            System.out.println(e);
        }
        return id;
    }
    
    
    public int memberRate(int uid, int tid){
        
        String sql = "select * from rating where userID = "+uid+" and topicID = "+tid ;
        int rating=-1;
        
         try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           
           if(rs.next()){
               rating = rs.getInt(4);
           }
                
         }
          catch(Exception e){
            System.out.println(e);
        }
        
        return rating;
        
    }
    
    public int getDisagree(int id){
        
        String sql= "select COUNT(*) from rating where topicid= "+id+ " and rating= "+0;
        int disagree=0;
         try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           rs.next();
           disagree = rs.getInt(1);
           
         }
          catch(Exception e){
            System.out.println(e);
        }
        
        return disagree;   
    }
    
    
    
    public int getAgree(int id){
        
        String sql= "select COUNT(*) from rating where topicid= "+id+ " and rating= "+1;
        int agree=0;
         try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           rs.next();
           agree = rs.getInt(1);
           
         }
          catch(Exception e){
            System.out.println(e);
        }
        
        return agree;   
    }
    
    private void getRating(Idea i){
        
        String sql = "select COUNT(ratingid) from rating where rating =1 and topicid= "+i.getIdeaID();
        String sql2 = "select COUNT(ratingid) from rating where rating =0 and topicid= "+i.getIdeaID();
          try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           rs.next();
           
            i.setAgreeCount(rs.getInt(1));
           
           rs=stmt.executeQuery(sql2);
           rs.next();
           
           i.setDisagreeCount(rs.getInt(1));
          
         }
          catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    
    private void getComments(Idea i){
        
        String sql = "select comment, user.userID, firstname , lastname, timestamp "+
                    "from comment, user "+ 
                    "where user.userID = comment.userID and postID = " + i.getIdeaID();
        Comment c;
        Member m;
        try{
           Connection con =  DataBase.getConnection();
           Statement stmt = con.createStatement();
           ResultSet rs;
           rs = stmt.executeQuery(sql);
           String dateString;
          
           while(rs.next()){
               m = new Member(rs.getInt(2), rs.getString(3), rs.getString(4));
               dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("timestamp"));
               c = new Comment(m,rs.getString(1), dateString);
               System.out.println("Comment is"+ c.getCommentDesc() );
               i.addComment(c);
               
           }
         
         }
          catch(Exception e){
           e.printStackTrace();
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
             
             idea.setAgreeCount(getAgree(idea.getIdeaID()));
             idea.setDisagreeCount(getDisagree(idea.getIdeaID()));
             getComments(idea);
             
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
    
    public void saveTopic(int id, int projid, String name){
        
        String sql="INSERT INTO topic (`topicID`, `projectID`, `topicname`) "+
                    "VALUES ("+ id +","+ projid+", '"+ name+ "');";
        
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
        
        String sql="select MAX(topicID) from topic";
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

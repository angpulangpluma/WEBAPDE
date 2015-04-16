/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import java.util.ArrayList;

/**
 *
 * @author student
 */
public class Idea {
    
   
    private int ideaid;
    private String idea;
    private Member member;
    private int agreeCount, disagreeCount;
    private String time;
    private ArrayList<Comment> comments;
    private String topicname;
   private int topicid;
    public Idea(int ideaid,String idea, String time){
        this.ideaid= ideaid;
        this.idea= idea;
        this.time= time;   
        comments = new ArrayList<Comment>();
    }
    
    public Idea(int ideaid, String idea,Member user, String time,String topicname, int topicid ){
        this.ideaid= ideaid;
        this.idea= idea;
        this.member=user;
        this.time= time;
         comments = new ArrayList<Comment>();
         this.topicname= topicname;
         this.topicid=topicid;
    }
   
      public Idea(int ideaid, String idea,Member user, String time){
        this.ideaid= ideaid;
        this.idea= idea;
        this.member=user;
        this.time= time;
         comments = new ArrayList<Comment>();
   
    }
    
    
    public int getTopicid(){
        return this.topicid;
    }
      
    public String getTopicname(){
        return this.topicname;
    }
    
    public ArrayList<Comment> getComments(){
        return this.comments;
    }
    
    public void addComment(Comment i){
        this.comments.add(i);
    }
    
    /* Getters */
    public String getTime(){
        return this.time;
    }
    
    public int getIdeaID(){
        return this.ideaid;
    }
        
    public String getIdea(){
        return this.idea;
    }
    
    public Member getUser() {
        return member;
    }
    
    public int getAgreeCount() {
        return agreeCount;
    }
    
    public int getDisagreeCount() {
        return disagreeCount;
    }
    
    /* Setters */
    

   
    
    public void setAgreeCount(int agreeCount) {
        this.agreeCount = agreeCount;
    }
    
    public void setDisagreeCount(int disagreeCount) {
        this.disagreeCount = disagreeCount;
    }
    
}

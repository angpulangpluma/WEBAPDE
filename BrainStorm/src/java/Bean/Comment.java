/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

/**
 *
 * @author student
 */
public class Comment {
    
    private String description;
    private Member user;
    private Idea idea;
    private String time;
    
    public Comment(Member m, String comment , String time){
        this.user=m;
        this.description = comment;
        this.time= time;
    }
    
    public String getTime(){
        return this.time;
    }
    
    public String getCommentDesc(){
        return this.description;
    }
    
    public Member getCommentUser(){
        return this.user;
    }
    
    public Idea getCommentIdea(){
        return this.idea;
    }
    
    public void setCommentDesc(String description){
        this.description = description;
    }
    
    public void setCommentUser(Member user){
        this.user = user;
    }
    
    public void setCommentIdea(Idea idea){
        this.idea = idea;
    }
    
}

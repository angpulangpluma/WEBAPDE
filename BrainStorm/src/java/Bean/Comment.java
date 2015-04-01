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
    private User user;
    private Idea idea;
    
    public String getCommentDesc(){
        return this.description;
    }
    
    public User getCommentUser(){
        return this.user;
    }
    
    public Idea getCommentIdea(){
        return this.idea;
    }
    
    public void setCommentDesc(String description){
        this.description = description;
    }
    
    public void setCommentUser(User user){
        this.user = user;
    }
    
    public void setCommentIdea(Idea idea){
        this.idea = idea;
    }
    
}

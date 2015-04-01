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
public class Notification {
    
    //datatype of time and date questionable, String for now
    private String time;
    private String date;
    private Topic topic;
    private User user;
    private String type;
    
    private String getNotifTime(){
        return time;
    }
    
    private String getNotifDate(){
        return date;
    }
    
    private Topic getNotifTopic(){
        return topic;
    }
    
    private User getNotifUser(){
        return user;
    }
    
    private String getNotifType(){
        return type;
    }
    
    private void setNotifTime(String time){
        this.time = time;
    }
    
    private void setNotifDate(String date){
        this.date = date;
    }
    
    private void setNotifTopic(Topic topic){
        this.topic = topic;
    }
    
    private void setNotifUser(User user){
        this.user = user;
    }
    
    private void setNotifType(String type){
        this.type = type;
    }
}

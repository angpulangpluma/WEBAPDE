/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;



/**
 *
 * @author Thursday
 */

public class UserBean {

   
    private int id;
    private String firstname;
    private String lastname;
    private String user;
    
    
    
    public void setID(int id){
        this.id= id;
    }
    
    public void setFirstName(String name){
        this.firstname= name;
    }
    
    public void setUser(String user){
        this.user = user;
    }
    
    public String getUser(){
        return this.user;
    }
    
    public void setLastName(String name){
        this.lastname= name;
    }
    
    public int getID(){
        return id;
    }
    
    public String getFirstName(){
        return firstname;
    }
    
    public String getLastName(){
        return lastname;
    }
    
}

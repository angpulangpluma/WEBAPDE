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
public class User {
    
    private String email;
    private String first_name;
    private String last_name;
    private String password;
    private ArrayList<Group> groups;
    
    public String getEmail(){
        return email;
    }
    
    public String getFirstName(){
        return first_name;
    }
    
    public String getLastName(){
        return last_name;
    }
    
    public String getPassword(){
        return password;
    }
    
    public ArrayList<Group> getGroups(){
        return groups;
    }
    
    public Group getGroup(int index){
        if(index>0 && index<groups.size()){
            return groups.get(index);
        } else return null;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setFirstName(String first_name){
        this.first_name = first_name;
    }
    
    public void setLastName(String last_name){
        this.last_name = last_name;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setGroups(ArrayList<Group> groups){
        this.groups = groups;
    }
    
    public void setGroup(Group group){
        this.groups.add(group);
    }
    
}

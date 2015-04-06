/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bean;

import java.util.ArrayList;

/**
 *
 * @author Thursday
 */
public class HomePageBean {
 
    private ArrayList<Group> groups= new ArrayList<Group>();
    private ArrayList<Notification> notifs;
   
    
    public void addGroup(int id, String name){
        groups.add(new Group(id,name));
    }
    
    
    public void addGroup(Group g){
        groups.add(g);
    }
    
    
    public ArrayList<Group> getGroups(){
        return this.groups;
    }
    
    
}

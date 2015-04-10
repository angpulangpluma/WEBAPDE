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
public class ProjectPageBean {
    
    
    private int id;
    private ArrayList<Topic> topics = new ArrayList<Topic>();
    
    public ProjectPageBean(int id){
        this.id= id;
    }
    
    public int getID(){
        return this.id;
    }
    
    public ArrayList<Topic> getTopics(){
        return this.topics;
    }
    
    public void addTopic(Topic t){
        topics.add(t);
    }
    
}
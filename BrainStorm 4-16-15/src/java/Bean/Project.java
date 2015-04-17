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
public class Project {
    
    private int id;
    private String name;
    private ArrayList<Topic> topics = new ArrayList<>();
    private int ideacount;
    
    
    public Project(int id, String name){
        this.id=id;
        this.name= name;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setTopics(ArrayList<Topic> topics){
        this.topics = topics;
    }
    
    public ArrayList<Topic> getTopics(){
        return this.topics;
    }
    
    public Topic getTopic(int i){
        if (i<0 || i>=this.topics.size())
            return null;
        else return this.topics.get(i);
    }
    
    public void addTopic (Topic t){
        this.topics.add(t);
    }
    
    public int getIdeaCount(){
        return this.ideacount;
    }
    
    public void setIdeaCount(int ideacount){
        this.ideacount = ideacount;
    }
    
}

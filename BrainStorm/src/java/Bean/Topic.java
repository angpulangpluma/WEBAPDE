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
public class Topic {
    
    private String name;
    private Project project;
    private int topicid;
    private ArrayList<Idea> ideas = new ArrayList<Idea>();
    
    
    public Topic(int id, String name){
        this.name= name;
        this.topicid = id;
    }
    
    /* Getters */
    
    public int gettopicid(){
        return topicid;
    }

    public String getName() {
        return name;
    }
    
    public Project getProject() {
        return project;
    }
    
    public ArrayList<Idea> getIdeas() {
        return ideas;
    }
    
    public Idea getIdea(int index) {
        if(index > 0 && index < ideas.size())
            return ideas.get(index);
        else
            return null;
    }
    
    /* Setters */
    
    public void setTopicID(int id){
        this.topicid= id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    
    public void setIdeas(ArrayList<Idea> ideas) {
        this.ideas = ideas;
    }
    
    public void addIdea(Idea idea) {
        ideas.add(idea);
    }
}

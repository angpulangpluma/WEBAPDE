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
public class Idea {
    
    private String description;
    private Topic topic;
    private Project project;
    private Group group;
    private User user;
    private int agreeCount, disagreeCount;
    
    /* Getters */
    
    public String getDescription() {
        return description;
    }
    
    public Topic getTopic() {
        return topic;
    }
    
    public Project getProject() {
        return project;
    }
    
    public Group getGroup() {
        return group;
    }
    
    public User getUser() {
        return user;
    }
    
    public int getAgreeCount() {
        return agreeCount;
    }
    
    public int getDisagreeCount() {
        return disagreeCount;
    }
    
    /* Setters */
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    
    public void setGroup(Group group) {
        this.group = group;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setAgreeCount(int agreeCount) {
        this.agreeCount = agreeCount;
    }
    
    public void setDisagreeCount(int disagreeCount) {
        this.disagreeCount = disagreeCount;
    }
    
}

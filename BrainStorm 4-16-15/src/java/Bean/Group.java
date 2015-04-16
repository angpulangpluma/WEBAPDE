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
public class Group {
    
    private int groupid;
    private String groupname;
    private ArrayList<Project> projects;
    private ArrayList<Member> members;
    private String leader;
    
    public Group(int id, String name){
        this.groupid = id;
        this.groupname= name;
        projects= new ArrayList<Project>();
        members = new ArrayList<Member>();
    }
    
    public void setLeader(String leader) {
        this.leader = leader;
    }
    
    public void addProject(int id,String name){
        projects.add(new Project(id,name));
    }
    
    public ArrayList<Member> getMembers(){
        return this.members;
    }
    
    public void addMember(String fname, String lname){
        members.add(new Member(fname,lname));
    }
    
    public String getGroupName(){
        return this.groupname;
    }
    
    public int getID(){
        return this.groupid;
    }
    
    public ArrayList<Project> getProjects(){
        return this.projects;
    }
    
    public Project getProject(int index) {
        if(index > 0 && index < projects.size())
            return projects.get(index);
        else
            return null;
    }
    
    public String getLeader() {
        return leader;
    }
}

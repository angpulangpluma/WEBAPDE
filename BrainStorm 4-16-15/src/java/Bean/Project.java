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
public class Project {
    
    private int id;
    private String name;
    
    
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
    
}

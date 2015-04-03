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
public class Member {
    
    private String fname;
    private String lname;
    private int id;
    
        public Member(String fname,String lname){
        this.id=id;
        this.fname = fname;
        this.lname =lname;
    }
    
    
    public Member(int id, String fname,String lname){
        this.id=id;
        this.fname = fname;
        this.lname =lname;
    }
    
    public int getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.fname;
    }
    
   public String getLastName(){
       return this.lname;
   }
   
   public void setFirstName(String name){
       this.fname =name;
   }
  
   public void setLastName(String name){
       this.lname = name;
   }
   
    
}

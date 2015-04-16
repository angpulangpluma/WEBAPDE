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
public class IdeaPageBean {
    
  
    private Idea selectedIdea;
    private int rating;
    
    public IdeaPageBean( Idea i){   
        this.selectedIdea=i;
    }

    public void setRating(int r){
        this.rating = r;
    }
      
    public int getRating(){
        return this.rating;
    }
    
    public Idea getIdea(){
        return this.selectedIdea;
    }
    
    
}

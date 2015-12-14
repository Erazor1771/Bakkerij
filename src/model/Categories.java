
package model;

import java.util.*;

/**
 *
 * @author lars
 */
public class Categories {
    
    private final List<Category> categoryList;

    public Categories() {
        this.categoryList = new ArrayList();
    }
    
    /**
     * Makes a new Category
     * Validation: Check if String exists, Check If String is not null
     * 
     * @param name Category name, this is a String
     * @return true: if Category object is made else return false
     */
    public boolean makeCategory(String name){
       
        if(!name.isEmpty()){
            Category cat = new Category(name);
            
            if (!categoryList.contains(cat)) {    
                categoryList.add(cat);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Edits an existing Category
     * Validation: for each field
     * 
     * @param cat
     * @param input
     * @return 
     */
    public boolean editCategory(Category cat, String input){
        
        if (true) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Deletes an existing Category
     * Validation: Check if category exists, Check if validation string equals catgory name
     * 
     * @param cat Category Object to be removed
     * @param validation String to validate if the user surely wants to remove the Category
     * @return true if Category Object is removed, returns false if this is not the case.
     */
    public boolean deleteCategory(Category cat, String validation){
        
        if (validation.equals(cat.getName())) {

            for (Category c : categoryList) {
                if (c.getName().equals(cat.getName())) {            
                    categoryList.remove(c);
                    return true;    
                } 
            }   
        } 
        return false;
    }
    
}

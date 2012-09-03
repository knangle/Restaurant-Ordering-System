
package edu.wctc.distjava.model;

import java.util.ArrayList;
import java.util.List;

/**
*
* The OrderConfirmation class is a Model layer class that receives a List 
* containing all of the possible menu choices from the Controller layer.  The 
* List received from the Controller is stripped of nulls (non-selected items) 
* and a new List, containing only the items selected by the customer, is 
* created.
*<p>
* @author Kevin Nangle, knangle@my.wctc.edu
* @version 2
*/
public class OrderConfirmation {
    
    private List allItems = new ArrayList(); 
    
    //Constructor accepts a List from the Controller 
      public OrderConfirmation(List allItems) {
            this.allItems=allItems;
      }
    
     /**
     * Confirm patron's order.
     * 
     */
     public List getChoices() {
        List selections = new ArrayList();
        
            //Remove nulls from List
            for(Object item : allItems){
                if(item != null)
                 selections.add((String)item);
            }
                    
        return selections;
    }
    
}

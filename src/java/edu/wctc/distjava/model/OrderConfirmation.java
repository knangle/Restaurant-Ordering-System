/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class OrderConfirmation {
    private ArrayList<String> choices2 = new ArrayList<String>();
    
    public OrderConfirmation(ArrayList<String> choices1) {
//        this.choices = choices;
        
                for (String item : choices1){
                choices2.add(item);
            }
        }
    

    
    public ArrayList<String> getChoices(){
        ArrayList<String> filteredSelections = new ArrayList<String>();
        for (String item : choices2){
            if(item != null){
                filteredSelections.add(item);
            }
        }
        return filteredSelections;
    }
    
}

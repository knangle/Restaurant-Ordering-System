/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class OrderConfirmation {
    private String item1, item2, item3, item4, item5, item6;

    public OrderConfirmation(String one, String two, String three, String four, 
                            String five, String six) {
    item1 = one;
    item2 = two;
    item3 = three;
    item4 = four;
    item5 = five;
    item6 = six;
    }
    
     /**
     * Confirms patron's order.
     * 
     */
    public List getChoices() {
        List selections = new ArrayList();
        
        if (item1 != null) {
             selections.add(item1);
        }
        if (item2 != null) {
             selections.add(item2);
        }
        if (item3 != null) {
             selections.add(item3);
        }
        if (item4 != null) {
             selections.add(item4);
        }
        if (item5 != null) {
             selections.add(item5);
        }
        if (item6 != null) {
             selections.add(item6);
        }
        return selections;
    }
    
}

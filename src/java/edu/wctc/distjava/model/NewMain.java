/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.model;

import java.util.List;

/**
 *
 * @author Kevin
 */
public class NewMain {

       public static void main(String[] args) throws Exception {
        OrderDBService srv = new OrderDBService();
        List<OrderItem> records = srv.getOrderItemList();
        for(OrderItem oi : records) {
            System.out.println(oi);
        }
    }

}

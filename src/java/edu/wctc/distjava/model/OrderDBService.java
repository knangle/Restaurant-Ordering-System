
package edu.wctc.distjava.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Kevin Nangle
 */
public class OrderDBService implements Serializable{
    private IOrderDAO dao;
    
    
    public OrderDBService() throws Exception {
        dao = new OrderDAO();
        dao.init();
    }

    public OrderDBService(List items) throws Exception {
        dao = new OrderDAO();
        dao.init();
    }

     public List<OrderItem> getOrderItemList() throws Exception {
        return dao.getOrderItemList();
    }
     
     public void writeOrderItemList(List update, int orderNumber) throws Exception {
        dao.writeOrderItemList(update, orderNumber);
    }

}


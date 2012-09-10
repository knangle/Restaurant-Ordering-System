
package edu.wctc.distjava.model;

import java.util.List;

/**
 * 
 * @author Kevin Nangle
 */
public class OrderDBService {
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
     
     public void writeOrderItemList(List update) throws Exception {
        dao.writeOrderItemList(update);
    }

}


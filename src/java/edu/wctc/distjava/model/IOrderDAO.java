
package edu.wctc.distjava.model;

import java.util.List;

/**
 *
 * @author Kevin Nangle
 */
public interface IOrderDAO {

    List<OrderItem> getOrderItemList() throws Exception;
    void init() throws Exception ;
    
    void writeOrderItemList(List update);
}

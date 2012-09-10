
package edu.wctc.distjava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kevin Nangle
 */
public class OrderDAO implements IOrderDAO {
    private IDBManager db;
    private int MAX_RECS = 500;

    public OrderDAO() throws Exception {
    }

    public void init() throws Exception {
        db = new DBManagerGeneric();
        db.init();
    }
    public void writeOrderItemList(List update, int orderNumber){
        
        String orderNo = ""+ orderNumber;
        
            for(Object item : update){
            
        
                try{
                    db.writeRecord((String)item, orderNo);
                }
                catch(Exception e){}
            }
    
    }

    public List<OrderItem> getOrderItemList() throws Exception {
        OrderItem oi = null;
        List<OrderItem> orderList = new ArrayList<OrderItem>();

        String sql = "SELECT * FROM items LIMIT 0, 1000";

        List<Map> rawRecords = db.getAllRecords(sql);
        for(Map map : rawRecords) {
           oi = new OrderItem();
           oi.setOrderID(Integer.parseInt(map.get("order_number").toString()));
           oi.setMenuSelection(map.get("menu_items").toString());
           orderList.add(oi);
        }

        return orderList;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.distjava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kevin
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
    public void writeOrderItemList(List update){
        
        String sql = "INSERT INTO `ordered_items`.`items` (`menu_items`, `order_number`) VALUES ('Tuna Casserole', '90671')";
        
        try{
        db.writeAllRecords(sql);
        }
        catch(Exception e){}

    
    }

    public List<OrderItem> getOrderItemList() throws Exception {
        OrderItem oi = null;
        List<OrderItem> orderList = new ArrayList<OrderItem>();
        // Carefull! You don't want a million records to come back!
        // Use TOP to limit total records returned.
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
//  List<Map> rawRecords = db.getAllRecords(sql);
//        for(Map map : rawRecords) {
//           emp = new Employee();
//           emp.setId(Integer.parseInt(map.get("ID").toString()));
//           emp.setFirstName(map.get("FIRSTNAME").toString());
//           emp.setLastName(map.get("LASTNAME").toString());
//           emp.setEmail(map.get("EMAIL").toString());
//           String sDate = map.get("HIREDATE").toString();
//           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd mm:hh:ss");
//           Date date = sdf.parse(sDate);
//           emp.setHireDate(date);
//           employees.add(emp);
//        }
//
//        return employees;
//    }

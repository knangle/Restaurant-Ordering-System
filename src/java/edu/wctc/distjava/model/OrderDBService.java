
package edu.wctc.distjava.model;

import java.util.List;

/**
 * The purpose of this class is to be the gateway into the database access
 * features. A program will only know about, and will only talk to this class.
 * All other classes and functionality is encapsulated in this class. That way
 * if a change is made to the DAO or the DBManager, it will not break the
 * programs that talk to this class. That type of decoupling is critical to
 * creating flexible, non-rigid, non-fragile code.
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

    // For testing only!! Comment out in production.
//    public static void main(String[] args) throws Exception {
//        EmployeeService srv = new EmployeeService();
//        List<Employee> records = srv.getEmployeeList();
//        for(Employee e : records) {
//            System.out.println(e);
//        }
//    }

}


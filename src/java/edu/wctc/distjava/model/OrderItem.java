
package edu.wctc.distjava.model;

/**
 *
 * @author Kevin
 */
public class OrderItem implements Comparable {
    private int orderID;
    private String menuSelection;

    public OrderItem() {
    }

    public OrderItem(int orderID, String menuSelection) {
        this.orderID = orderID;
        this.menuSelection = menuSelection;
    }
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getMenuSelection() {
        return menuSelection;
    }

    public void setMenuSelection(String menuSelection) {
        this.menuSelection = menuSelection;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItem other = (OrderItem) obj;
        if (this.orderID != other.orderID) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.orderID;
        return hash;
    }

    // Sort on LastName
    public int compareTo(Object obj) {
        OrderItem oi = (OrderItem)obj;
        return this.getMenuSelection().compareTo(oi.getMenuSelection());
    }

    @Override
    public String toString() {
        return "orderID=" + orderID + ", menuSelection=" ;
    }

    
}

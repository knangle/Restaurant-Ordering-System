
package edu.wctc.distjava.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Kevin Nangle
 */
public class DBManagerGeneric extends AbstractDBManager implements IDBManager {

    public DBManagerGeneric() throws Exception {
        super();
    }
    
    public void writeRecord(String item, String ordNo) throws Exception{
        String menuItem = item;
        String orderNumber = ordNo;
        String insertItem = "INSERT INTO `ordered_items`.`items` "
                + "(`menu_items`, `order_number`) VALUES ('" + menuItem + "', "
                + "'" + orderNumber + "')";

		try {
			  Class.forName (getDriverClassName());
                          setConn(DriverManager.getConnection(getUrl(), 
                                  getUserName(), getPassword()));
		}
		catch ( ClassNotFoundException cnfex ) {
		   System.err.println(
			  "Error: Failed to load JDBC driver!" );
		   cnfex.printStackTrace();
		   System.exit( 1 );  // terminate program
		}
		catch ( SQLException sqlex ) {
		   System.err.println( "Error: Unable to connect to database: "
                           + sqlex.getMessage() );
		   sqlex.printStackTrace();
		   System.exit( 1 );  // terminate program
		}

//		Statement stmt = null;
//              stmt = (getConn().createStatement());
//              stmt.executeUpdate(insertItem);                
                
                PreparedStatement ps = getConn().prepareStatement("INSERT INTO "
                        + "`ordered_items`.`items` "
                + "(`menu_items`, `order_number`) VALUES (?,?)");
                ps.setString(1, item);
                ps.setString(2, ordNo);
                ps.executeUpdate();
}
    public List<Map> getAllRecords(String sql) throws Exception {
        setConn(DriverManager.getConnection(getUrl(), getUserName(), 
                getPassword()));
        ResultSetMetaData metaData = null;
        final List<Map> list=new ArrayList<Map>();
        Map record = null;

        try {
            this.setStmt(getConn().createStatement());
            this.setRs(getStmt().executeQuery(sql));
            metaData = this.getRs().getMetaData();
            final int fields=metaData.getColumnCount();

            while( this.getRs().next() ) {
                record = new HashMap();
                for( int i=1; i <= fields; i++ ) {
                    try {
                        record.put( metaData.getColumnName(i), 
                                this.getRs().getObject(i) );
                    } catch(NullPointerException npe) {
                    }
                } 
                list.add(record);
            }

        } catch (SQLException sqle) {
            throw sqle;
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                if(getStmt() !=null) getStmt().close();
                if(getConn() != null) getConn().close();
            } catch(SQLException e) {
                    throw e;
            } 
        } 

        return list; 
    }

}

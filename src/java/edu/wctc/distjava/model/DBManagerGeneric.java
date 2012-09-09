
package edu.wctc.distjava.model;

import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class has the low-level JDBC code for talking to a database. This
 * class is named a "Generic" class because it doesn't have any code that
 * is non-standard. See the DBManagerOracle class for an example of some
 * Oracle-specific code.
 * 
 * @author Instlogin
 */
public class DBManagerGeneric extends AbstractDBManager implements IDBManager {

    public DBManagerGeneric() throws Exception {
        super();
    }

    // C.R.U.D. operations. We'll begin with just one retrieve method, but
    // you should add others, plus the C., U. and D. behaviors
    
    public void writeAllRecords(String sql) throws Exception{
        setConn(DriverManager.getConnection(getUrl(), getUserName(), getPassword()));
        Statement stmt = null;
        String addRecords = sql;
        
        		try {
                        this.setStmt(getConn().createStatement());
                        stmt.executeUpdate(addRecords);
			} catch(Exception e) {
				System.out.println(e);
			}
		   
}
    
    public List<Map> getAllRecords(String sql) throws Exception {
        setConn(DriverManager.getConnection(getUrl(), getUserName(), getPassword()));
        ResultSetMetaData metaData = null;
        final List<Map> list=new ArrayList<Map>();
        Map record = null;

        // do this in an excpetion handler so that we can depend on the
        // finally clause to close the connection
        try {
            this.setStmt(getConn().createStatement());
            this.setRs(getStmt().executeQuery(sql));
            metaData = this.getRs().getMetaData();
            final int fields=metaData.getColumnCount();

            while( this.getRs().next() ) {
                record = new HashMap();
                for( int i=1; i <= fields; i++ ) {
                    try {
                        record.put( metaData.getColumnName(i), this.getRs().getObject(i) );
                    } catch(NullPointerException npe) {
                        // no need to do anything... if it fails, just ignore it and continue
                    }
                } // end for
                list.add(record);
            } // end while

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
            } // end try
        } // end finally

        return list; // will  be null if none found
    }

}


package edu.wctc.distjava.model;

import java.sql.*;

/**
 *
 * @author Kevin Nangle
 */


public class MySQL_DB {
        private Connection conn;
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/ordered_items";
	private String userName = "root";
	private String password = "admin";

	public static void main(String[] args) {
	
		MySQL_DB db = new MySQL_DB();


		db.driverClassName = "com.mysql.jdbc.Driver";
		db.url = "jdbc:mysql://localhost:3306/ordered_items";
		db.userName = "root";
		db.password = "admin";


		try { 
			  Class.forName (db.driverClassName);
			  db.conn = DriverManager.getConnection(db.url, 
                                  db.userName, db.password);
		}
		catch ( ClassNotFoundException cnfex ) {
		   System.err.println(
			  "Error: Failed to load JDBC driver!" );
		   cnfex.printStackTrace();
		   System.exit( 1 );
		}
		catch ( SQLException sqlex ) {
		   System.err.println( "Error: Unable to connect to database: " 
                           + sqlex.getMessage() );
		   sqlex.printStackTrace();
		   System.exit( 1 );  
		}

		Statement stmt = null;
                Statement stmt2 = null;

		ResultSet rs = null;
                ResultSet rs2 = null;


                String sql = "SELECT * FROM items";
                String sql2 = "INSERT INTO `ordered_items`.`items` "
                        + "(`menu_items`, `order_number`) VALUES "
                        + "('Hash Browns', '90671')";
		try {

			stmt = db.conn.createStatement();
                        
			rs = stmt.executeQuery(sql);
                        stmt2 = db.conn.createStatement();
                            stmt2.executeUpdate(sql2);
                        rs2 = stmt.executeQuery(sql);

                        System.out.println("============================");
                        System.out.println("Output from SQL Server...");
                        System.out.println("============================");

			int count = 0;
			while( rs.next() ) {
			
                        System.out.println("\nRecord No: " + (count + 1));
                        System.out.println( "Menu Item: " + rs.getObject(2) );
			count++;
			}
			System.out.println( "==================\n" + count + " "
                                + "records found." );
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			try {
				stmt.close();
				db.conn.close();
			} catch(Exception e) {
				System.out.println(e);
			}
		}

	}


    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }
}


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

		// STEP 4: Now make a connection to the database
		// Checked exceptions demand try-catch
		try {
			  // This loads the class into memory
			  Class.forName (db.driverClassName);

			  // Now let the Driver Manager use the class to create a connection object
			  // It figures this out from the url
			  db.conn = DriverManager.getConnection(db.url, db.userName, db.password);
		}
		catch ( ClassNotFoundException cnfex ) {
		   System.err.println(
			  "Error: Failed to load JDBC driver!" );
		   cnfex.printStackTrace();
		   System.exit( 1 );  // terminate program
		}
		catch ( SQLException sqlex ) {
		   System.err.println( "Error: Unable to connect to database: " + sqlex.getMessage() );
		   sqlex.printStackTrace();
		   System.exit( 1 );  // terminate program
		}

		/*
		 * =========== Now Use JDBC to Work With Your Database ================================
		 */

		// We'll need a statement object to execute the sql query (a statement)
		Statement stmt = null;
                Statement stmt2 = null;

		// We'll need one of these to hold results returned from our query.
		// Remember, not all queries return results.
		ResultSet rs = null;
                ResultSet rs2 = null;

		// Now create an sql query string (most sql is standard, but
		// some database products use proprietary code, like this one for MS-Access)
//		String sql = "SELECT * FROM [dbo].[EMPLOYEE] WHERE "
//                        + "HIREDATE > '1/1/1988' ORDER BY LASTNAME";
                String sql = "SELECT * FROM items";
                String sql2 = "INSERT INTO `ordered_items`.`items` (`menu_items`, `order_number`) VALUES ('Hash Browns', '90671')";
//                INSERT INTO `ordered_items`.`items` (`menu_items`, `order_number`) VALUES ('Hash Browns', '90671');

		try {
			// Next use the connection object created earlier to create a statement object
			stmt = db.conn.createStatement();
                        
			rs = stmt.executeQuery(sql);
                        stmt2 = db.conn.createStatement();
                            stmt2.executeUpdate(sql2);
                        rs2 = stmt.executeQuery(sql);

                        System.out.println("============================");
                        System.out.println("Output from SQL Server...");
                        System.out.println("============================");

                        // The ResultSet contains the records returned by your query.
			// Loop through the ResultSet to extract the data
			int count = 0;
			while( rs.next() ) {
				// Each record contains three display fields which we will reference
				// by number (1 based). Read up on other methods we could use in ResultSet.
                                System.out.println("\nRecord No: " + (count + 1));
//                                System.out.println("\nID: " + rs.getInt(1)); // column one (ResultSet field)
//				System.out.println( "Last Name: " + rs.getObject(1) ); // named field
				System.out.println( "Menu Item: " + rs.getObject(2) );
//				System.out.println( "Email: " + rs.getObject(3) );
//				System.out.println( "Hire Date: " + rs.getObject(4) );
				count++;
			}
			System.out.println( "==================\n" + count + " records found." );
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// Make sure we close the statement and connection objects no matter what.
			// Since these also throw checked exceptions, we need a nested try-catch
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


package edu.wctc.distjava.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kevin Nangle
 */
public abstract class AbstractDBManager implements IDBManager, Serializable {
    private String driverClassName;
    private String url;
    private String userName;
    private String password;
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public void setDriverClassName(String driverClassName) {
        if(driverClassName == null || driverClassName.length() == 0) {
            throw  new IllegalArgumentException();
        }
        this.driverClassName = driverClassName;
    }

    public final String getDriverClassName() {
        return driverClassName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password == null) throw new IllegalArgumentException();
        this.password = password;
    }

    public void setUrl(String url) {
        if(url == null || url.length() == 0) {
            throw  new IllegalArgumentException();
        }
        this.url = url;
    }

    public void setUserName(String userName) {
        if(userName == null) throw new IllegalArgumentException();
        this.userName = userName;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        if(conn == null) throw new IllegalArgumentException();
        this.conn = conn;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        if(rs == null) throw new IllegalArgumentException();
        this.rs = rs;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        if(stmt == null) throw new IllegalArgumentException();
        this.stmt = stmt;
    }


    public void init() throws Exception {
        MySQL_DB cfg = new MySQL_DB();
        driverClassName = cfg.getDriverClassName();
        url = cfg.getUrl();
        userName = cfg.getUserName();
        password = cfg.getPassword();
        cfg = null;
        Class.forName (getDriverClassName());

    }
}

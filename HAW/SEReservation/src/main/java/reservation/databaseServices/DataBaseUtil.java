package reservation.databaseServices;

import java.sql.*;

/**
 * Created by Florian Bauer on 05.01.14.
 * flbaue@posteo.de
 */
public class DataBaseUtil {

    private String dbURL;
    private Connection connection;

    public DataBaseUtil(String dbURL, String dbDriver) {
        this.dbURL = dbURL;
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection = null;
    }

    public boolean tableExists(String tableName) {
        connect();
        boolean result = true;
        try {
            Statement stmt = connection.createStatement();
            stmt.executeQuery("select 1 from " + tableName);
        } catch (SQLException ex) {
            if (ex.getMessage().contains("no such table: " + tableName)) {
                return false;
            } else {
                ex.printStackTrace();
            }
        }

        return result;
    }

    public ResultSet executeQuery(String query) {
        connect();
        ResultSet rs = null;
        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }

    public void execute(String query) {
        connect();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

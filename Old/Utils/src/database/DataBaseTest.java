package database;

import java.sql.*;

/**
 * Florian Bauer
 * flo.bauer@gmx.net
 * Date: 05.09.13
 * Time: 19:27
 */
public class DataBaseTest {

    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static void main(String[] args) throws SQLException {

        try {
            // The newInstance() call is a work around for some
            // broken Java implementations
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/home");
            // Do something with the Connection


            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM User");
            rs.first();

            System.out.println(rs.getString("name"));

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                }  catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
            conn.close();
        }
    }
}

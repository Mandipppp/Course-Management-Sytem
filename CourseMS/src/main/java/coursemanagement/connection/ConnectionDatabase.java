/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mandipraut
 */
public class ConnectionDatabase {
    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static final String URL = "jdbc:mysql://localhost:3306/CMS";

    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASS_NAME);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException{
        Connection connection = ConnectionDatabase.getConnection();
        System.out.println(connection);
    }
    
    //added
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                // Log or handle the exception

            }
        }
    }
}

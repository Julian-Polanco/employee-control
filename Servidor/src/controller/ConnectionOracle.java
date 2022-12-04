package controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Server;

public class ConnectionOracle {

    protected static Connection connect() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE", "POLI01", "POLI01");
            return connection;
        } catch (SQLException e) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "The exception raised is: ", e);
            return null;
        }
    }

}

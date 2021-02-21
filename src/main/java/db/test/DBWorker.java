package db.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBWorker {
    private static final String username = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private Connection connection;


    public DBWorker(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            logger.severe("Error occurred during attempting to try to get a connection");
        } catch (ClassNotFoundException e) {
            logger.severe("Drive class not found");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

package DAOTemplate.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    public static CarDAO getCarDAOInstance(){
        return new CarJDBCDao();
    }
    public static Connection initializeDB(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3333",
                    "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

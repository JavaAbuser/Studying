package JDBC;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class JDBCWithStatement {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/base";
        String userName = "root";
        String password = "root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(url, userName, password);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(
                     "C:\\Users\\Максим\\Desktop\\StudyingPractice\\JDBC_1\\src\\com\\company\\sql\\orders.sql"
             ));
             Scanner scanner = new Scanner(bufferedReader);
             Statement statement = connection.createStatement()) {
            String line = "";
            while (scanner.hasNext()) {
                line = scanner.next();
                if (line.endsWith(";")) {
                    line = line.substring(line.length() - 1);
                }
                statement.executeUpdate(line);
            }
            ResultSet resultSet = null;
            try {
                resultSet = statement.executeQuery("SELECT * FROM base.`order`");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    double price = resultSet.getDouble(3);
                    System.out.println("id = " + id + ", name = " + name + " price = " + price);
                }
            } finally {
                if (resultSet != null) {
                    resultSet.close();
                }
            }
        } catch (IOException e) {
            System.out.println("IOException was throw.");
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("SQL Error code: " + e.getErrorCode());
            e.printStackTrace();
        }
    }
}

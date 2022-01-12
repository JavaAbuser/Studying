package JDBC;

import java.sql.*;

public class JDBCWithPreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException {
        final String URL = "jdbc:mysql://localhost:3306/base";
        final String USERNAME = "root";
        final String PASSWORD = "root";

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO `order` (name, price) VALUES (?, ?)");
                preparedStatement.setString(1, "book");
                preparedStatement.setDouble(2, 20.40);
                preparedStatement.execute();

                ResultSet resultSet = null;
                try {
                    resultSet = preparedStatement.executeQuery("SELECT * FROM `order`");
                    while (resultSet.next()) {
                        int id = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        double price = resultSet.getDouble(3);
                        System.out.println("id = " + id + ", name = " + name + ", price = " + price);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

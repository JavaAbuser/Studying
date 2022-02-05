package DAOTemplate.DAO;

import DAOTemplate.Entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarJDBCDao implements CarDAO{
    Connection connection = null;
    public CarJDBCDao(){
        connection = DAOFactory.initializeDB();
    }

    @Override
    public void add(Car car) {
        int mark = car.getMark();
        String model = car.getModel();
        int price = car.getPrice();

        try {
            Statement statement = connection.createStatement();
            statement.execute("USE car_service;");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO car(mark, model, price)" +
                    "VALUES (?, ?, ?);");
            preparedStatement.setInt(1, mark);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, price);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(car + " was added.");
    }

    @Override
    public List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            statement.execute("USE car_service;");
            statement.executeQuery("SELECT * FROM car;");
            resultSet = statement.getResultSet();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int mark = resultSet.getInt("mark");
                String model = resultSet.getString("model");
                int price = resultSet.getInt("price");
                Car car = new Car(mark, model, price);
                car.setId(id);
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public void delete(Car car) {
        int mark = car.getMark();
        String model = car.getModel();
        int price = car.getPrice();

        try {
            Statement statement = connection.createStatement();
            statement.execute("USE car_service;");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM car WHERE " +
                    "mark = ? AND model = ? AND price = ?");
            preparedStatement.setInt(1, mark);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, price);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(car + " was deleted.");
    }

    @Override
    public Car get(int id) {
        Car car = null;
        try{
            Statement statement = connection.createStatement();
            statement.execute("USE car_service;");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            int carId = resultSet.getInt("id");
            int mark = resultSet.getInt("mark");
            String model = resultSet.getString("model");
            int price = resultSet.getInt("price");
            car = new Car(mark, model, price);
            car.setId(carId);
        } catch (SQLException e) {
            System.out.println("ID is incorrect!");
            e.printStackTrace();
        }
        return car;
    }
}


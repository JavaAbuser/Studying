package DAOTemplate.DAO;

import DAOTemplate.Entity.Car;
import java.util.List;

public interface CarDAO {
    void add(Car car);
    List<Car> getAll();
    void delete(Car car);
    Car get(int id);
}

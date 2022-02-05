package DAOTemplate.Service;

import DAOTemplate.DAO.CarJDBCDao;
import DAOTemplate.Entity.Car;

import java.util.List;

public class CarJDBCService {
    private CarJDBCDao carJDBCDao = new CarJDBCDao();

    public void add(Car car){
        carJDBCDao.add(car);
    }

    public List<Car> getAll(){
        return carJDBCDao.getAll();
    }

    public void delete(Car car){
        carJDBCDao.delete(car);
    }

    public Car get(int id){
        return carJDBCDao.get(id);
    }
}

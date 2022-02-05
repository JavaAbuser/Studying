package DAOTemplate;

import DAOTemplate.Service.CarJDBCService;
import DAOTemplate.Entity.Car;

/**
 * @author Max Steblevskiy(Java Abuser) on 05.02.2022
 */
public class Application {

    public static void main(String[] args) {
//        Car car1 = new Car(1,"328i", 18_000);
//        Car car2 = new Car(2,"Prius", 9_000);
          Car car3 = new Car(1,"X6", 30_000);
//        Car car4 = new Car(3,"Italy", 38_000);
//        Car car5 = new Car(5,"Rio", 5_500);
//        Car car6 = new Car(4,"CR-V", 22_000);
          CarJDBCService carJDBCService = new CarJDBCService();
//        carJDBCService.add(car1);
//        carJDBCService.add(car3);
//        carJDBCService.add(car4);
//        carJDBCService.add(car5);
//        carJDBCService.add(car6);
//        carJDBCService.add(car2);
//        System.out.println(carJDBCService.getAll());
//        carJDBCService.delete(car3);
        System.out.println(carJDBCService.get(21));
    }
}

package Serialization;

import java.io.*;

/**
 * @author Max Steblevskiy(JavaAbuser) on 28.01.2022
 */

public class Main {
    public static void main(String[] args) {
         Car car = new Car("Toyota", 22_000, 2017);
         File file = new File("C:\\Users\\Максим\\Desktop\\StudyingPractice\\Serialization\\src\\Serialization\\file.txt");
         try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
             System.out.println("car before serializing = " + car.toString());
             objectOutputStream.writeObject(car);
             Car car1 = (Car) objectInputStream.readObject();
             System.out.println("car after deserializing = " + car1.toString());
         } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
         }
    }
}

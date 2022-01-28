package ReflectionAPI.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Date;

/**
 * @author Max Steblevskiy(JavaAbuser) on 28.01.2022
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Human human = new Human("Daniel", 23, new Date());

        // getting class "Class" for Human through 3 ways
        Class<?> c1 = Human.class;
        Class<?> c2 = human.getClass();
        Class<?> c3 = Class.forName("ReflectionAPI.Reflection.Human");

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println("\t\tPublic fields: ");
        Field[] publicFields = c1.getFields();
        for(Field publicField : publicFields){
            System.out.println("\tName: " + publicField.getName());
            System.out.println("\tType: " + publicField.getType().getName());
            System.out.println("\tValue: " + publicField.get(human) + "\n");
        }
        System.out.println("\t\tDeclared fields: ");
        Field[] fields = c1.getDeclaredFields();
        for(Field field : fields){
            System.out.println("\tName: " + field.getName());
            System.out.println("\tType: " + field.getType().getName());
            field.setAccessible(true);
            System.out.println("\tValue: " + field.get(human) + "\n");
        }
        System.out.println("\t\tDeclared Methods: ");
        Method[] methods = c1.getDeclaredMethods();
        for(Method method : methods){
            System.out.println("\tName: " + method.getName());
            System.out.println("\tReturn type: " + method.getReturnType());
        }
        System.out.println("Constructors: ");
        Constructor[] constructors = c1.getConstructors();
        for(Constructor constructor : constructors){
            Parameter[] parameters = constructor.getParameters();
            System.out.println("\tConstructor parameters: ");
            int i = 0;
            for(Parameter parameter : parameters){
                i++;
                System.out.println("\t\t\t " + i + ". " + parameter.getType().getName());
            }
        }
    }
}

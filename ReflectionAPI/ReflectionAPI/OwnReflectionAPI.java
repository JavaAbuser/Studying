package ReflectionAPI.ReflectionAPI;

import ReflectionAPI.Reflection.Human;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class OwnReflectionAPI {
    private Human human = null;

    public OwnReflectionAPI(Human human) {
        this.human = human;
    }

    public Class<?> getClassClass() throws ClassNotFoundException {
        Class<?> c1 = Human.class;
        Class<?> c2 = human.getClass();
        Class<?> c3 = Class.forName("ReflectionAPI.Reflection.Human");
        return c1;
    }

    public void getPublicFieldsInfo() throws ClassNotFoundException, IllegalAccessException {
        System.out.println("\t\tPublic fields: ");
        Field[] publicFields = getClassClass().getFields();
        for(Field publicField : publicFields){
            System.out.println("\tName: " + publicField.getName());
            System.out.println("\tType: " + publicField.getType().getName());
            System.out.println("\tValue: " + publicField.get(human) + "\n");
        }
    }

    public void getFieldsInfo() throws ClassNotFoundException, IllegalAccessException {
        System.out.println("\t\tDeclared fields: ");
        Field[] fields = getClassClass().getDeclaredFields();
        for(Field field : fields){
            System.out.println("\tName: " + field.getName());
            System.out.println("\tType: " + field.getType().getName());
            field.setAccessible(true);
            System.out.println("\tValue: " + field.get(human) + "\n");
        }
    }

    public void getMethodInfo() throws ClassNotFoundException {
        System.out.println("\t\tDeclared Methods: ");
        Method[] methods = getClassClass().getDeclaredMethods();
        for(Method method : methods){
            System.out.println("\tName: " + method.getName());
            System.out.println("\tReturn type: " + method.getReturnType());
        }
    }
    public void getConstructorInfo() throws ClassNotFoundException {
        System.out.println("Constructors: ");
        Constructor[] constructors = getClassClass().getConstructors();
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

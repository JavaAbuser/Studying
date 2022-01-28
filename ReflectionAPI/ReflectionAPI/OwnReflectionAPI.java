package ReflectionAPI.ReflectionAPI;

import ReflectionAPI.Reflection.Human;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class OwnReflectionAPI {
    private Human human = null;

    public OwnReflectionAPI(Human human) {
        this.human = human;
    }

    OwnReflectionAPI ownReflectionAPI = new OwnReflectionAPI(human);

    public Class<?> getClassClass() throws ClassNotFoundException {
        Class<?> c1 = Human.class;
        Class<?> c2 = human.getClass();
        Class<?> c3 = Class.forName("ReflectionAPI.Reflection.Human");
        return c1;
    }

    public void getPublicFieldsInfo() throws ClassNotFoundException, IllegalAccessException {
        System.out.println("\t\tPublic fields: ");
        Field[] publicFields = ownReflectionAPI.getClassClass().getFields();
        for(Field publicField : publicFields){
            System.out.println("\tName: " + publicField.getName());
            System.out.println("\tType: " + publicField.getType().getName());
            System.out.println("\tValue: " + publicField.get(human) + "\n");
        }
    }

    public void getFieldsInfo() throws ClassNotFoundException, IllegalAccessException {
        System.out.println("\t\tDeclared fields: ");
        Field[] fields = ownReflectionAPI.getClassClass().getDeclaredFields();
        for(Field field : fields){
            System.out.println("\tName: " + field.getName());
            System.out.println("\tType: " + field.getType().getName());
            field.setAccessible(true);
            System.out.println("\tValue: " + field.get(human) + "\n");
        }
    }

    public void getMethodInfo() throws ClassNotFoundException {
        System.out.println("\t\tDeclared Methods: ");
        Method[] methods = ownReflectionAPI.getClassClass().getDeclaredMethods();
        for(Method method : methods){
            System.out.println("\tName: " + method.getName());
            System.out.println("\tReturn type: " + method.getReturnType());
        }
    }
}

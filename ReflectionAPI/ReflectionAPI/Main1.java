package ReflectionAPI.ReflectionAPI;

import ReflectionAPI.Reflection.Human;

import java.util.Date;

/**
 * @author Max Steblevskiy(JavaAbuser) on 28.01.2022
 */

public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Human human = new Human("Daniel", 23, new Date());
        OwnReflectionAPI ownReflectionAPI = new OwnReflectionAPI(human);

        ownReflectionAPI.getPublicFieldsInfo();
        ownReflectionAPI.getFieldsInfo();
        ownReflectionAPI.getMethodInfo();
        ownReflectionAPI.getConstructorInfo();
    }
}

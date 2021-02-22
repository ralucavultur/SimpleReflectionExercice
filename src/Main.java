import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Class myClassClass = MyClass.class;

        Field[] fields = myClassClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field: " + field.getName());
        }

        Method[] methods = myClassClass.getDeclaredMethods();
        for(Method method:methods){
            System.out.println("Method: " + method.getName());
        }

        try{
            Method method = myClassClass.getMethod("sayHelloWorld");
            method.invoke(myClass);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        try{
            Method method = myClassClass.getMethod("sayHello", String.class);
            method.invoke(myClass, "Raluca");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

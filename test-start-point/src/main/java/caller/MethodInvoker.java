package caller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class MethodInvoker {

    @Autowired
    AllMethods allMethods;

    public boolean invokeMethod(String methodName, Object[] paramList, String parsedFlag){

        Class<?> params[] = new Class[paramList.length];
        for (int i = 0; i < paramList.length; i++) {
            if (paramList[i] instanceof Integer) {
                params[i] = Integer.TYPE;
            } else if (paramList[i] instanceof String) {
                params[i] = String.class;
            }
        }
        System.out.println(methodName);
        try {
            Method myMethod = allMethods.getClass()
                    .getMethod(methodName, params);
            System.out.println(myMethod);
            return (Boolean) myMethod.invoke(allMethods, paramList);
        } catch (NoSuchMethodException nsme){
            System.out.println("No method found!");
            return false;
        } catch (Exception e){
            e.getCause();
            e.getMessage();
            e.printStackTrace();
            return false;
        }
    }


}

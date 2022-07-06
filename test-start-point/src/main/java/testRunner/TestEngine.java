package testRunner;

import caller.MethodInvoker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ababil.generic.actions.tools.*", "com.ababil.common.actions.tools.*", "caller"})
public class TestEngine {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TestEngine.class, args);

        List<String> params = new ArrayList<String>(){{add("a"); add("b"); add("c"); add("d");}};
        Object[] obj = params.toArray();
        context.getBean(MethodInvoker.class).invokeMethod("setAction",obj , null);
    }
}

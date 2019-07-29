package mvc2;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppRun {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx =
                new ClassPathXmlApplicationContext("container2.xml");

        SomeService service1 = appCtx.getBean(SomeService.class);
        SomeService service2 = appCtx.getBean("someService",SomeService.class);
        SomeService service3 = (SomeService) appCtx.getBean("someService");
        service1.call();
        service2.call();
        service3.call();
        appCtx.close();
    }
}
package mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//@Component
@Data
@AllArgsConstructor
public class App {
    private Client client;
    private EventLogger eventLogger;
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("container.xml");
        App app = (App) ctx.getBean("app");
        Event eventToLog = (Event)ctx.getBean("event");
        eventToLog.setMessage("Hello 1");
        System.out.println(eventToLog);
        app.logEvent(eventToLog);
    }

    protected void logEvent(Event event) {
        event.setMessage(event.getMessage().replaceAll(String.valueOf(client.getId()),client.getName()));
        eventLogger.logEvent(event);
    }
}

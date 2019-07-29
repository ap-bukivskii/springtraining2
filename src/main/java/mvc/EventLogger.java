package mvc;

import org.springframework.stereotype.Component;

//@Component
public interface EventLogger {
    void logEvent(Event event);
}

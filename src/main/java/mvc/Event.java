package mvc;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

//@Component
@Data
public class Event {
    private int id;
    private String message;
    private LocalDateTime dateTime;
    private Map<String,List<String>> map;

//    Event(LocalDateTime localDateTime){
//        this.dateTime = localDateTime;
//        this.id = new java.util.Random().nextInt();
//    }
    Event(Map<String,List<String>> map){
        this.map = map;
    }
}

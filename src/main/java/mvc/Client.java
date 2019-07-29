package mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Data
//@Component
public class Client {
    private int id;
    private String name;
}

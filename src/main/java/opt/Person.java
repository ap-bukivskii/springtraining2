package opt;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private String gender;
}

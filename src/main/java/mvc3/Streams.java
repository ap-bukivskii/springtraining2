package mvc3;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    public static String oddNames(List<String> names) {
        return names.stream()
                .filter(s-> names.indexOf(s)%2 == 1)
                .map(s->names.indexOf(s)+". "+ s+", ")
                .collect(Collectors.joining());
    }

    public static String uppercaseAndDesc(List<String> names) {
        return names.stream()
                //.map(String::toUpperCase)
                .map(s->s.toUpperCase()+", ")
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining());
    }

    public static List<Number> toNumbers(Collection<String> numbers) {
        return numbers.stream()
                .flatMap(s->Arrays.stream(s.split(",")))
                .map(String::trim)
                .map(Streams::tryToParse)
                .collect(Collectors.toList());
    }
    private static Number tryToParse (String str) throws RuntimeException{
        try{
            return NumberFormat.getInstance().parse(str);
        }catch (Exception e){throw new RuntimeException(e);}
    }

}

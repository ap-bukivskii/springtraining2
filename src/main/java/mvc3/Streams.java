package mvc3;

import org.springframework.util.StreamUtils;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.iterate;

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
    public static LongStream getRandomStream(long a, long c, long m, long seed){
        return LongStream.iterate(seed,x -> (a*x+c)%m).skip(1);
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Stream.Builder<T> builder = Stream.builder();
        builder.add().andThen()
        return Stream.concat(first,second);
    }


}

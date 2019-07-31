package mvc3;

import org.springframework.util.StreamUtils;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.*;

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
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        //LETS BUILD A BICYCLE!!!!!!!
        List<T> f = first.collect(Collectors.toList());
        List<T> s = second.collect(Collectors.toList());
        int size = Math.min(f.size(),s.size());
        Stream.Builder<T> builder = Stream.builder();

        for(int i=0;i<size;i++){
            builder.add(f.get(i));
            builder.add(s.get(i));
        }
        return builder.build();
    }

}

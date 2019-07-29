package mvc3;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        final long CONST_A = 25214903917L;
        final long CONST_C = 11L;
        final long CONST_M = 281_474_976_710_656L;
        List<String> names = Arrays.asList("Ivan0","Ivan1","Ivan2","Ivan3","Ivan4","Ivan5","aIvan6");
        Collection<String> numbers = Arrays.asList ("1, 2, 0", "4, 5", "2.5,7");
        List <Integer> numerator = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Stream<String> first = numerator.stream().map(i->"first"+i);
        Stream<String> second = numerator.stream().map(i->"second"+i);

        System.out.println(Streams.oddNames(names));
        System.out.println(Streams.uppercaseAndDesc(names));
        System.out.println(Streams.toNumbers(numbers));
        System.out.println("=================");
        Streams.getRandomStream(CONST_A,CONST_C,CONST_M,0).limit(10).forEach(System.out::println);
        Streams.zip(first,second).forEach(System.out::println);
    }
}

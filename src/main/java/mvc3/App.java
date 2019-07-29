package mvc3;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collection<String> numbers = Arrays.asList ("1, 2, 0", "4, 5", "2.5,7");
        ArrayList<Number> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2.5);
        System.out.println(nums);
        for (Number num:nums){
            System.out.println(num.getClass());
        }
        names.add("Ivan0");
        names.add("Ivan1");
        names.add("Ivan2");
        names.add("Ivan3");
        names.add("Ivan4");
        names.add("Ivan5");
        names.add("aivan6");
        System.out.println(Streams.oddNames(names));
        System.out.println(Streams.uppercaseAndDesc(names));
        List n2 = Streams.toNumbers(numbers);
        System.out.println();
        for (Object n:n2){
            System.out.println(n.getClass());
        }

    }
}

package lambda;

public class M {
    public static void main(String[] args) {
        I1 power = x->x*x;
        System.out.println(power.m1(2));
    }
}

@FunctionalInterface
interface I1 {
    int m1(int i);
}
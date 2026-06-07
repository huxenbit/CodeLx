package main;

import java.util.function.IntFunction;
import java.util.function.Predicate;

public class LambdaExpressions {
    private Integer number = 123456;

    public static void main(String[] args) {
        LambdaExpressions lE = new LambdaExpressions();
        System.out.println(lE.crossSum.apply(lE.number));
        System.out.println(lE.lastDigit.apply(lE.number));
        System.out.println(lE.lastTwoDigits.apply(lE.number));
        System.out.println(lE.lastThreeDigits.apply(lE.number));
        System.out.println(lE.isNegative.test(lE.number));
        System.out.println(lE.isZero.test(lE.number));
        System.out.println(lE.isEven.test(lE.number));
        System.out.println(lE.isDivisibleBy3.test(lE.number));
        System.out.println(lE.isDivisibleBy4.test(lE.number));
        System.out.println(lE.isDivisibleBy5.test(lE.number));
        System.out.println(lE.isDivisibleBy8.test(lE.number));
        System.out.println(lE.isDivisibleBy9.test(lE.number));
        System.out.println(lE.isDivisibleBy10.test(lE.number));
        System.out.println(lE.isSmallerThan10000.test(lE.number));
        System.out.println(lE.isMersenne.test(lE.number));
    }

    public IntFunction<Integer> crossSum = x -> {
        x = Math.abs(x);
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    };

    public IntFunction<Integer> lastDigit = x -> x % 10;

    public IntFunction<Integer> lastTwoDigits = x -> x % 100;

    public IntFunction<Integer> lastThreeDigits = x -> x % 1000;

    public Predicate<Integer> isNegative = x -> x < 0;

    public Predicate<Integer> isZero = x -> x == 0;

    public Predicate<Integer> isEven = x -> x % 2 == 0;

    public Predicate<Integer> isDivisibleBy3 = x -> crossSum.apply(x) % 3 == 0;

    public Predicate<Integer> isDivisibleBy4 = x -> lastTwoDigits.apply(x) % 4 == 0;

    public Predicate<Integer> isDivisibleBy5 = x -> lastDigit.apply(x) == 0 || lastDigit.apply(x) == 5;

    public Predicate<Integer> isDivisibleBy8 = x -> lastThreeDigits.apply(x) % 8 == 0;

    public Predicate<Integer> isDivisibleBy9 = x -> crossSum.apply(x) % 9 == 0;

    public Predicate<Integer> isDivisibleBy10 = x -> lastDigit.apply(x) == 0;

    public Predicate<Integer> isSmallerThan10000 = x -> x < 10000;

    public Predicate<Integer> isMersenne = x -> x > 0 && (((x + 1) & x) == 0);
}

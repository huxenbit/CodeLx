import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    Integer testNumber = 9;


    static void main(String[] args) {
        Main main = new Main();

        //mapToQuersumme
        System.out.println(main.mapTo(x -> {
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            return sum;
        }));

        //mapToLastDigit
        System.out.println(main.mapTo(x -> x % 10));

        //mapToTwoLastDigits
        System.out.println(main.mapTo(x -> x % 100));

        //mapToThreeLastDigits
        System.out.println(main.mapTo(x -> x % 1000));

        //Smaller than 0
        System.out.println(main.check(x -> x < 0));

        //Equals 0
        System.out.println(main.check(x -> x == 0));

        //Divisible by 2
        System.out.println(main.check(x -> x % 2 == 0));

        //Divisible by 3
        System.out.println(main.check(x -> {
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            } if (sum % 3 == 0) {
                return true;
            }
            return false;
        }));

        //Divisible by 4
        System.out.println(main.check(x -> {
            int num1 = x % 10;
            int num2 = x % 100;
            if (num1 % 4 == 0 && num2 % 4 == 0) {
                return true;
            }
            return false;
        }));

        //Divisible by 5
        System.out.println(main.check(x -> {
            if ((x % 10) % 5 == 0) {
                return true;
            }
            return false;
        }));

        //Divisible by 8
        System.out.println(main.check(x -> {
            int num1 = x % 10;
            int num2 = x % 100;
            int num3 = x % 1000;

            if (num1 % 8 == 0 && num2 % 8 == 0 && num3 % 8 == 0) {
                return true;
            }
            return false;
        }));

        //Divisible by 9
        System.out.println(main.check(x -> {
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            } if (sum % 9 == 0) {
                return true;
            }
            return false;
        }));

        //Smaller than 10000
        System.out.println(main.check(x -> x < 10000));

        //isMersenne
        System.out.println(main.);
    }

    public Integer mapTo(Function<Integer, Integer> mapper) {
        Integer longNumber = 192837;
        return mapper.apply(longNumber);
    }

    public boolean check(Predicate<Integer> predicate) {
        return predicate.test(testNumber);
    }
}

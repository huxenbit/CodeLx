package main;

public class FactorialFunction implements Function.MyFunction {
    @Override
    public int apply(int x) {
        int result = 1;
        for (int i = 2; i <= x; i++) {
            result *= i;
        }
        return result;
    }
}
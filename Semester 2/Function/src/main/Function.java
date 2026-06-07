package main;

public class Function {

    public interface MyFunction {
        int apply(int x);
    }

    public static void applyAndPrint(int i, int j, MyFunction f) {
        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }

        for (int x = i; x <= j; x++) {
            System.out.println(f.apply(x));
        }
    }

    public static void main(String[] args) {
        // Beispiel: f(x) = x^2
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int x) {
                return x * x;
            }
        });

        // Beispiel: f(x) = x!
        //Anonym
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int x) {
                int result = 1;
                for (int i = 2; i <= x; i++) {
                    result *= i;
                }

                return result;
            }
        });

        //Lambda
        applyAndPrint(1, 5, x -> {
            int result = 1;
            for (int i = 2; i <= x; i++) {
                result *= i;
            }
            return result;
        });

        //Top-Level Klasse
        applyAndPrint(1, 5, new FactorialFunction());

        //Innere Klasse
        FunctionDemo demo = new FunctionDemo();
        applyAndPrint(1, 5, demo.new FactorialInner());


        //Beispiel: f(x) = x * (x + 1)
        //Lambda
        applyAndPrint(1, 5, x -> x * (x + 1));

        //Anonyme Klasse
        applyAndPrint(1, 5, new MyFunction() {
            @Override
            public int apply(int x) {
                return x * (x + 1);
            }
        });

        //Beispiel: f(x) = fib(x)
        //Lambda
        applyAndPrint(1, 10, x -> {
            if (x <= 1) return x;

            int a = 0, b = 1;
            for (int i = 2; i <= x; i++) {
                int tmp = a + b;
                a = b;
                b = tmp;
            }
            return b;
        });

        //Anonyme Klasse
        applyAndPrint(1, 10, new MyFunction() {
            @Override
            public int apply(int x) {
                if (x <= 1) return x;

                int a = 0, b = 1;
                for (int i = 2; i <= x; i++) {
                    int tmp = a + b;
                    a = b;
                    b = tmp;
                }
                return b;
            }
        });
    }

    public static class FunctionDemo {
        public class FactorialInner implements MyFunction {
            @Override
            public int apply(int x) {
                int result = 1;
                for (int i = 2; i <= x; i++) {
                    result *= i;
                }
                return result;
            }
        }
    }
}
public class Calculator {
    /**
     * Wendet eine übergebene Operation op auf a und b an.
     * @param a erster Operand
     * @param b zweiter Operand
     * @param op Operation, die auf die beiden Operanden angewendet wird
     * @return Ergebnis der Operation
     */

    public int compute(int a, int b, BinaryOperation op) {
        return op.apply(a, b);
    }

    public static void main() {
        Calculator calc = new Calculator();

        int x = 5;
        int y = 10;

        //Addition
        int sum = calc.compute(x, y, new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        });

        //Subtraktion
        int diff = calc.compute(x, y, new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a - b;
            }
        });

        //Multiplikation
        int prod = calc.compute(x, y, new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        });

        //Division
        int div = calc.compute(x, y, new BinaryOperation() {
            @Override
            public int apply(int a, int b) {
                if (b != 0) {
                    return a / b;
                }
                System.out.println("Division by zero not possible!");
                return 0;
            }
        });

        System.out.println("Summe: " + sum);
        System.out.println("Differenz: " + diff);
        System.out.println("Produkt: " + prod);
        System.out.println("Division: " + div);
    }
}

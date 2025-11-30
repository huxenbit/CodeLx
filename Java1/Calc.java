import java.util.Scanner;
import java.math.BigDecimal;

public class Calc {

    BigDecimal x;
    BigDecimal y;
    char op;
    boolean calculate;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calc c = new Calc();
        c.input();
        c.calculate();
    }

    void input() {
        // Eingabe der ersten Zahl
        System.out.print("Bitte gib die erste Zahl ein: ");
        x = readBigDecimal();

        // Eingabe der zweiten Zahl
        System.out.print("Gib deine zweite Zahl ein: ");
        y = readBigDecimal();

        // Eingabe des Operators
        System.out.print("Bitte gib den Operator ein (+, -, *, /): ");
        op = scanner.next().charAt(0);

        // Prüfen, ob Operator gültig ist
        if (op == '+' || op == '-' || op == '*' || op == '/') {
            System.out.println("Berechne: " + x + " " + op + " " + y);
            calculate = true;
        } else {
            System.out.println("Error! Ungültiger Operator!");
            calculate = false;
        }
    }

    void calculate() {
        if (!calculate) {
            System.out.println("Berechnung nicht möglich!");
            return;
        }

        BigDecimal result = BigDecimal.ZERO;

        if (op == '+') {
            result = x.add(y);
        } else if (op == '-') {
            result = x.subtract(y);
        } else if (op == '*') {
            result = x.multiply(y);
        } else if (op == '/') {
            if (y.compareTo(BigDecimal.ZERO) != 0) {
                // Division mit 10 Dezimalstellen, Rundung HÄLFTE AUF
                result = x.divide(y, 10, BigDecimal.ROUND_HALF_UP);
            } else {
                System.out.println("Error! Division durch Null!");
                return;
            }
        }

        System.out.println("Ergebnis: " + result.stripTrailingZeros().toPlainString());
    }

    // Methode, um BigDecimal sicher einzulesen
    BigDecimal readBigDecimal() {
        while (true) {
            String input = scanner.next();
            try {
                return new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.print("Ungültige Zahl! Bitte erneut eingeben: ");
            }
        }
    }
}

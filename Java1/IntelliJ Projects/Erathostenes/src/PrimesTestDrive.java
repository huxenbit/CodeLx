import java.util.Scanner;

public class PrimesTestDrive {
    public static void main(String[] args) {
        System.out.print("Max number: ");
        Scanner scanner = new Scanner(System.in);
        Primes.findPrimes(scanner.nextInt());
    }
}

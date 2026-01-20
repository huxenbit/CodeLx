import java.util.Scanner;

public class PrimesTestDrive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter max number to find primes: ");
        int n = scanner.nextInt();
        Primes.findPrimes(n);

        // Ausgabe aller Primzahlen
        for (int i = 2; i < n; i++) {
            if (Primes.isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}

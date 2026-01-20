public class Primes {
    static boolean[] isPrime;

    public static void findPrimes(int n) {

        // Array erstellen und alle Werte auf true setzen (vorerst alle Zahlen als prim markieren)
        isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }

        // Sieb des Eratosthenes: Vielfache jeder Zahl ab i*i markieren
        // Optimierung: nur bis sqrt(n) prüfen, da größere Zahlen bereits markiert sind
        for (int i = 2; (i * i) < n; i++) {
            System.out.print(i + " "); // zeigt die aktuelle Zahl, deren Vielfache markiert werden

            for (int j = (i * i); j < n; j += i) {
                isPrime[j] = false; // Vielfache von i sind keine Primzahlen
            }
        }
        System.out.println();

        // Ausgabe aller Primzahlen
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }
}

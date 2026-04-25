public class Hanoi {

    static void main() {
        Hanoi h = new Hanoi();
        h.solve(3, 'a', 'b', 'c');
    }

    public void solve(int n, char from, char helper, char to) {

        // Abbruchbedingung
        if (n == 1) {
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }

        // 1. n-1 nach Hilfsstab
        solve(n - 1, from, to, helper);

        // 2. größte Scheibe bewegen
        System.out.println("Move disk " + n + " from " + from + " to " + to);

        // 3. n-1 auf Zielstab
        solve(n - 1, helper, from, to);
    }
}
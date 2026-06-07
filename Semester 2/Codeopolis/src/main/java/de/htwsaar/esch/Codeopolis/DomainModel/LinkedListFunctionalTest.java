package de.htwsaar.esch.Codeopolis.DomainModel;

public class LinkedListFunctionalTest {

    public static void main(String[] args) {

        testFilter();
        testForEach();
        testRemoveIf();
        testAddIf();
        testSortComparator();

        System.out.println("\nAlle Tests erfolgreich.");
    }

    // --------------------------------------------------
    // 1. filter
    // --------------------------------------------------
    static void testFilter() {

        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        LinkedList<Integer> filtered = list.filter(x -> x % 2 == 0);

        if (filtered.size() != 2) {
            throw new RuntimeException("Fehler bei filter(): size falsch");
        }

        if (filtered.get(0) != 2 || filtered.get(1) != 4) {
            throw new RuntimeException("Fehler bei filter(): Inhalte falsch");
        }

        System.out.println("testFilter erfolgreich");
    }

    // --------------------------------------------------
    // 2. forEach
    // --------------------------------------------------
    static void testForEach() {

        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        StringBuilder sb = new StringBuilder();

        list.forEach(x -> sb.append(x));

        if (!sb.toString().equals("123")) {
            throw new RuntimeException("Fehler bei forEach()");
        }

        System.out.println("testForEach erfolgreich");
    }

    // --------------------------------------------------
    // 3. removeIf
    // --------------------------------------------------
    static void testRemoveIf() {

        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.removeIf(x -> x % 2 == 0); // entfernt 2 und 4

        if (list.size() != 3) {
            throw new RuntimeException("Fehler bei removeIf(): size falsch");
        }

        if (list.get(0) != 1 || list.get(1) != 3 || list.get(2) != 5) {
            throw new RuntimeException("Fehler bei removeIf(): Inhalte falsch");
        }

        System.out.println("testRemoveIf erfolgreich");
    }

    // --------------------------------------------------
    // 4. addIf
    // --------------------------------------------------
    static void testAddIf() {

        LinkedList<Integer> list = new LinkedList<>();

        list.addIf(10, x -> x > 5);  // wird hinzugefügt
        list.addIf(3, x -> x > 5);   // wird NICHT hinzugefügt

        if (list.size() != 1) {
            throw new RuntimeException("Fehler bei addIf(): size falsch");
        }

        if (list.get(0) != 10) {
            throw new RuntimeException("Fehler bei addIf(): Inhalt falsch");
        }

        System.out.println("testAddIf erfolgreich");
    }

    // --------------------------------------------------
    // 5. sort (Comparator)
    // --------------------------------------------------
    static void testSortComparator() {

        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(4);
        list.addLast(1);
        list.addLast(3);
        list.addLast(2);

        list.sort((a, b) -> a - b);

        if (list.get(0) != 1 ||
                list.get(1) != 2 ||
                list.get(2) != 3 ||
                list.get(3) != 4) {

            throw new RuntimeException("Fehler bei sort(Comparator)");
        }

        System.out.println("testSortComparator erfolgreich");
    }
}
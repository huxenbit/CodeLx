package main;

import java.util.Random;

public class NumberGenerator {
    LinkedList<Integer> linkedList;
    Random random = new Random();

    public NumberGenerator() {
        linkedList = new LinkedList<>();
    }

    public Integer get(int index) {
        return linkedList.get(index);
    }

    public void generateNumbers(int listSize) {
        for (int i = 0; i < listSize; i++) {
            linkedList.addLast(random.nextInt(101));
        }
    }

    public void printList() {
        linkedList.forEach(System.out::println);
    }

    public int size() {
        return linkedList.size();
    }

    public void removeOddNumbers() {
        linkedList.removeIf(s -> s % 2 != 0);
    }

    public void sort() {
       linkedList.sort();
    }
}

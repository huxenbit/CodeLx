package main;

import java.util.LinkedList;
import java.util.Random;

public class Producer {
    private final Random rand = new Random();
    private Integer randomNumber;
    private LinkedList<Integer> integerLinkedList = new LinkedList<>();


    public Integer produceNumber() {
        randomNumber = rand.nextInt(1000);
        return randomNumber;
    }

    public Integer getFirstNumber() {
        LinkedList<Integer> integerLinkedListCopy = new LinkedList<>(integerLinkedList);

        removeFirstNumber();

        return integerLinkedListCopy.getFirst();
    }

    public Integer getSize() {
        return integerLinkedList.size();
    }

    public Integer getLastNumber() {
        LinkedList<Integer> integerLinkedListCopy = new LinkedList<>(integerLinkedList);

        removeLastNumber();

        return integerLinkedListCopy.getLast();
    }

    public LinkedList<Integer> getList() {
        return integerLinkedList;
    }

    public void addFirstNumber(Integer number) {
        integerLinkedList.addFirst(number);
    }

    public void addLastNumber(Integer number) {
        integerLinkedList.addLast(number);
    }

    public void removeFirstNumber() {
        integerLinkedList.removeFirst();
    }

    public boolean removeLastNumber() {
        return integerLinkedList.removeLast() != null;
    }
}

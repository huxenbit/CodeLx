package main;

import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.Comparator;

public class LinkedList<T extends Comparable<T>> {

    private Node first;
    private int size;

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    public LinkedList() {
        first = null;
        size = 0;
    }

    public void addLast(T element) {
        Node newNode = new Node(element);

        if (first == null) {
            first = newNode;
        } else {
            Node current = first;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T value = first.data;
        first = first.next;
        size--;

        return value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);

        Node current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public T set(int index, T element) {
        checkIndex(index);

        Node current = first;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        T old = current.data;
        current.data = element;

        return old;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public T remove(int index) {

        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        Node current = first;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        T removed = current.next.data;
        current.next = current.next.next;

        size--;

        return removed;
    }

    public void addAll(LinkedList<T> other) {

        Iterator<T> it = other.iterator();

        while (it.hasNext()) {
            addLast(it.next());
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void sort() {

        if (size < 2) {
            return;
        }

        boolean swapped;

        do {
            swapped = false;

            Node current = first;

            while (current != null && current.next != null) {

                if (current.data.compareTo(current.next.data) > 0) {

                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    swapped = true;
                }

                current = current.next;
            }

        } while (swapped);
    }

    public LinkedList<T> filter(Predicate<T> predicate) {

        LinkedList<T> result = new LinkedList<>();

        Node current = first;

        while (current != null) {
            if (predicate.test(current.data)) {
                result.addLast(current.data);
            }
            current = current.next;
        }

        return result;
    }

    public void forEach(Consumer<T> consumer) {

        Node current = first;

        while (current != null) {
            consumer.accept(current.data);
            current = current.next;
        }
    }

    public void removeIf(Predicate<T> predicate) {

        // Entferne am Anfang passende Elemente
        while (first != null && predicate.test(first.data)) {
            first = first.next;
            size--;
        }

        Node current = first;

        while (current != null && current.next != null) {

            if (predicate.test(current.next.data)) {
                current.next = current.next.next;
                size--;
            } else {
                current = current.next;
            }
        }
    }

    public void addIf(T element, Predicate<T> predicate) {
        if (predicate.test(element)) {
            addLast(element);
        }
    }

    public void sort(Comparator<T> comparator) {

        if (size < 2) {
            return;
        }

        boolean swapped;

        do {
            swapped = false;

            Node current = first;

            while (current != null && current.next != null) {

                if (comparator.compare(current.data, current.next.data) > 0) {

                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    swapped = true;
                }

                current = current.next;
            }

        } while (swapped);
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T value = current.data;
            current = current.next;

            return value;
        }
    }

    public interface Iterator<E> {
        boolean hasNext();
        E next();
    }
}
package main;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class StringProcessor {
    public LinkedList<String> list;

    public StringProcessor() {
        list = new LinkedList<>();
    }

    public StringProcessor(LinkedList<String> list){
        this.list = list;
    }

    public void add(String text) {
        list.addLast(text);
    }

    public LinkedList<String> filter(Predicate<String> predicate) {
        LinkedList<String> result = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i);

            if (predicate.test(text)) {
                result.addLast(text);
            }
        }

        return result;
    }

    public void applyToAll(String text) {
        for (int i = 0; i < list.size(); i++) {
            String oldData = list.get(i);
            String newData = oldData + text;
            list.set(i, newData);
        }
    }

    public LinkedList<Integer> mapToInt(Function<String, Integer> mapper) {
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i);
            result.addLast(mapper.apply(text));
        }

        return result;
    }

    public void forEach(Consumer<String> consumer) {
        LinkedList<String> newList = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            newList.addLast(list.get(i));
        }

        for (int i = 0; i < newList.size(); i++) {
            consumer.accept(newList.get(i));
        }
    }
}
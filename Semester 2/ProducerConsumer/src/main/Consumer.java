package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Consumer {
    Map<Long, Integer> crossSumMap;
    Map<Integer, Integer> counterMap;

    public Consumer() {
        crossSumMap = new HashMap<>();
        counterMap = new HashMap<>();
    }

    public void consume(Integer number) {
        number = Math.abs(number);
        int crossSum = 0;
        long timeStamp = System.currentTimeMillis();

        while (number > 0) {
            crossSum += number % 10;
            number /= 10;
        }

        Integer counter = count(crossSum);

        if (!counterMap.containsKey(crossSum)) {
            counterMap.replace(crossSum, counter);
        }

        crossSumMap.put(timeStamp, crossSum);
    }

    private Integer count(Integer crossSum) {
        Integer counter = 0;
        for (Map.Entry<Long, Integer> entry : crossSumMap.entrySet()) {
            if (Objects.equals(entry.getValue(), crossSum)) {
                counter++;
            }
        }

        return counter;
    }
}

package main;

import java.util.Random;

public class Main {
    Random random = new Random();
    Producer producer = new Producer();
    Consumer consumer = new Consumer();

    public static void main(String[] args) {
        Main main = new Main();

        main.generateFIFO(main);
        main.consumer.crossSumMap.forEach((key, value) -> {System.out.println("Time: " + key + " Cross-Sum: " + value);});

        System.out.println("###############");

        main.generateLIFO(main);
        main.consumer.crossSumMap.forEach((key, value) -> {System.out.println("Time: " + key + " Cross-Sum: " + value);});
    }

    public void generateFIFO(Main main) {
        for (int i = 0; i < 20; i++) {
            if (main.random.nextInt() > 0) {
                main.producer.addLastNumber(main.producer.produceNumber());
            } else {
                if (!main.producer.getList().isEmpty()) {
                    main.consumer.consume(main.producer.getFirstNumber());
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }

    public void generateLIFO(Main main) {
        for (int i = 0; i < 20; i++) {
            if (main.random.nextInt() > 0) {
                main.producer.addFirstNumber(main.producer.produceNumber());
            } else {
                if (!main.producer.getList().isEmpty()) {
                    main.consumer.consume(main.producer.getFirstNumber());
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}

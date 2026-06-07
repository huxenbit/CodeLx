package test;

import main.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberGeneratorTest {
    NumberGenerator numGen;

    @BeforeEach
    void setup() {
        numGen = new NumberGenerator();
    }

    @Test
    void testGetter() {
        numGen.generateNumbers(6);
        System.out.println(numGen.get(4));
    }

    @Test
    void testGenerateNumbers() {
        numGen.generateNumbers(6);
    }

    @Test
    void testRemoveOddNumbers() {
        numGen.generateNumbers(10);
        numGen.removeOddNumbers();
    }

    @Test
    void testSort() {
        numGen.generateNumbers(6);
        numGen.sort();
    }

    @Test
    void testPrint() {
        numGen.generateNumbers(6);
        numGen.printList();
    }
}

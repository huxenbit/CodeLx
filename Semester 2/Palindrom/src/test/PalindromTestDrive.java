package test;

import main.PalindromIterativ;
import main.PalindromRecursive;

import java.io.FileWriter;
import java.io.IOException;

public class PalindromTestDrive {

    public static void main(String[] args) throws Exception {

        PalindromIterativ palIt = new PalindromIterativ();
        PalindromRecursive palRec = new PalindromRecursive();

        FileWriter fw = new FileWriter("messung.csv");

        fw.write("length,iterative,recursive\n");

        for (int length = 10; length <= 2000; length *= 2) {

            String test = generateString(length);

            long start = System.nanoTime();
            palIt.isPalindrom(test);
            long durIter = System.nanoTime() - start;

            start = System.nanoTime();
            palRec.isPalindrom(test);
            long durRec = System.nanoTime() - start;

            fw.write(length + "," + durIter + "," + durRec + "\n");
        }

        fw.close();
    }

    private static String generateString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append('a');
        }
        return sb.toString();
    }
}

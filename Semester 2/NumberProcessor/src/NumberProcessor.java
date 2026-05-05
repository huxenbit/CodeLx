import java.util.Random;

public class NumberProcessor {
    //Enthält die zu verarbeitenden Daten
    private static int[] values;
    /**
     * Konstruktor enthält das zu analysierende Array.
     * @param args das int-Array, z.B Messwerte oder Punktestände
     */

    static void main(String[] args) {
        NumberProcessor nP = new NumberProcessor();
        nP.printGreaterThan(30);
    }

    public void printGreaterThan(int threshold) {
        Sort.sortArray(values);
        for (int value : values) {
            if (value > threshold) {
                System.out.println("Value: " + "'" + value + "'" + " is greater than: " + "'" + threshold + "'!");
            }
        }
    }

    public NumberProcessor() {
        int[] values = new int[15];
        Random random = new Random();
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(0, 120);
        }
        
        NumberProcessor.values = values.clone();
    }

    static class Sort {
        public static void sortArray(int[] values) {
            for (int i = 0; i < values.length - 1; i++) {
                for (int j = i + 1; j < values.length; j++)
                    if (values[i] > values[j]) {
                        int value = values[i];
                        values[i] = values[j];
                        values[j] = value;
                }
            }
        }
    }
}
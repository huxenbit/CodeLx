package main;

public class PalindromIterativ implements Palindrom {
    public long duration;

    @Override
    public boolean isPalindrom(String wort) {
        long startTime = System.nanoTime();
        wort = wort.toLowerCase();

        int i = 0;
        int j = wort.length() - 1;

        while (i < j) {
            if (wort.charAt(i) != wort.charAt(j)) {
                long endTime = System.nanoTime();
                this.duration = endTime - startTime;
                return false;
            }
            i++;
            j--;
        }

        long endTime = System.nanoTime();
        this.duration = endTime - startTime;
        return true;
    }
}

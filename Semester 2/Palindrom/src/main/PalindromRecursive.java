package main;

public class PalindromRecursive implements Palindrom{
    public long duration;

    @Override
    public boolean isPalindrom(String wort) {
        wort = wort.toLowerCase();
        return check(wort, 0, wort.length() - 1);
    }

    private boolean check(String wort, int links, int rechts) {
        long start = System.nanoTime();
        if (links >= rechts) {
            long end = System.nanoTime();
            this.duration = end - start;
            return true;
        }

        if (wort.charAt(links) != wort.charAt(rechts)) {
            long end = System.nanoTime();
            this.duration = end - start;
            return false;
        }

        return check(wort, links + 1, rechts - 1);
    }
}

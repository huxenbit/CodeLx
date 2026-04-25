package main;

import java.util.Random;

public class Permutation {
    private int[] arr;
    private boolean[] used;


    //Constructor to initialize arrays and class.
    public Permutation(int n) {
        arr = new int[n];
        used = new boolean[n];

        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(10);
            used[i] = false;
        }
    }


    public void startPermutation() {
        permutate(new java.util.ArrayList<>());
    }

    //Recursive method to permutate array.
    public void permutate(java.util.List<Integer> current) {
        if (current.size() == arr.length) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            used[i] = true;
            current.add(arr[i]);

            permutate(current); //Rekursion

            current.remove(current.size() - 1);
            used[i] = false;
        }

    }
}

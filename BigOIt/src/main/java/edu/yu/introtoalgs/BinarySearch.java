package edu.yu.introtoalgs;

import java.util.Random;

public class BinarySearch extends BigOMeasurable {
    private int find;
    int[] a;

    public BinarySearch() {

    }

    @Override
    public void setup(final int n) {
        this.a = new int[n];
        Random rand = new Random();
        int upperbound = 136;
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(upperbound);
        }
    }
    @Override
    public void execute() {
        int lo = 0, hi = a.length - 1;
        Random rand = new Random();
        int upperbound = 136;
        int To_Find = rand.nextInt(upperbound);
        while (hi - lo > 1) {
            int mid = (hi + lo) / 2;
            if (a[mid] < To_Find) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        if (a[lo] == To_Find) {
            System.out.println("Found At Index " + lo );
        }
        else if (a[hi] == To_Find) {
            System.out.println("Found At Index " + hi );
        }
        else {
            System.out.println("Not Found" );
        }
    }
}

package edu.yu.introtoalgs;

import java.util.*;

public class MysteryClass extends BigOMeasurable {
    private int count;
    int[] a;
    public MysteryClass() {

    }

    @Override
    public void setup(final int n) {
        this.a = new int[n];
        this.count = 0;
    }
    @Override
    public void execute() {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
    }
}


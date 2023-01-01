package edu.yu.introtoalgs;

public class LinearClazz extends BigOMeasurable {
    private int find;
    int[] a;
    private int sum = 0;
    public LinearClazz() {

    }

    @Override
    public void setup(final int n) {
        this.a = new int[n];
    }
    @Override
    public void execute() {
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
    }
}

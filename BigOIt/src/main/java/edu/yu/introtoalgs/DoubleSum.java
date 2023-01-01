package edu.yu.introtoalgs;

public class DoubleSum extends BigOMeasurable {
    private int count;
    int[] a;
    public DoubleSum() {

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
                if (a[i] + a[j] == 0) {
                    count++;
                }
            }
        }
    }
}

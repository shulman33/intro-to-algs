package edu.yu.introtoalgs;

/* Implements PrimeCalculator interface with Java's Fork/Join parallelism
 * framework.  The implementation must determine what threshold value to use,
 * but should favor thresholds that produce good results for "end" values of
 * (at least) hundreds of millions).
 *
 * Students may not change the constructor signature or add any other
 * constructor!
 *
 * @author Avraham Leff
 */

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class PrimesFJ implements PrimeCalculator {
    ForkJoinPool pool;


    class PrimeTask extends RecursiveTask<Integer> {
        private long start;
        private long end;

        public PrimeTask(long start, long end){
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            int count = 0;
            int threshold = 100_000;

            if (end - start <= threshold){
            SerialPrimes sp = new SerialPrimes();
            count += sp.nPrimesInRange(start, end);


            }
            else {
                long mid = (start + end) / 2;
                PrimeTask left = new PrimeTask(start, mid);
                PrimeTask right = new PrimeTask(mid + 1, end);
                left.fork();
                int rightAns = right.compute();
                int leftAns = left.join();
                count = leftAns + rightAns;
            }
            return count;
        }
    }

    /** Constructor
     *
     */
    public PrimesFJ() {
        // your code (if any) goes here
        int parallelism = Runtime.getRuntime().availableProcessors();
        this.pool = new ForkJoinPool(parallelism);
    }

    @Override
    public int nPrimesInRange(final long start, final long end) {
        if (end < start || start < 2 || end > Long.MAX_VALUE) {
            throw new IllegalArgumentException();
        }

        return pool.invoke(new PrimeTask(start, end));
    }
}   // PrimesFJ
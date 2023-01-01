package edu.yu.introtoalgs;

/* Implements PrimeCalculator interface by using exactly two threads to
 * partition the range of primes between them.  Each thread uses the "naive"
 * SerialPrimes algorithm to solve its part of the problem.
 *
 * Students may not change the constructor signature or add any other
 * constructor!
 *
 * @author Avraham Leff
 */

public class TwoThreadPrimes implements PrimeCalculator {

  private FirstHalf firstHalf;
  private SecondHalf secondHalf;
  private Thread firstThread;
  private Thread secondThread;

  class FirstHalf implements Runnable{
    private long start;
    private long end;
    private int count;

    public FirstHalf(long start, long end){
      this.start = start;
      this.end = end;
      this.count = 0;
    }

    public void run(){
      SerialPrimes sp = new SerialPrimes();
      this.count = sp.nPrimesInRange(this.start, this.end);
    }

    public int getCount(){
      return this.count;
    }

  }

  class SecondHalf implements Runnable{
    private long start;
    private long end;
    private int count;

    public SecondHalf(long start, long end){
      this.start = start;
      this.end = end;
      this.count = 0;
    }

    public void run(){
      SerialPrimes sp = new SerialPrimes();
      this.count = sp.nPrimesInRange(this.start, this.end);
    }

    public int getCount(){
      return this.count;
    }

  }

  /** Constructor
   *
   */
  public TwoThreadPrimes() {
    // your code (if any) goes here

  }

  @Override
  public int nPrimesInRange(final long start, final long end) {
    // your code (if any) goes here
    if (end < start || start < 2 || end > Long.MAX_VALUE){
      throw new IllegalArgumentException();
    }
    long mid = (start + end) / 2;

    this.firstHalf = new FirstHalf(start, mid);
    this.secondHalf = new SecondHalf(mid + 1, end);

    this.firstThread = new Thread(this.firstHalf);
    this.secondThread = new Thread(this.secondHalf);

    firstThread.start();
    secondThread.start();

    try {
      firstThread.join();
      secondThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return firstHalf.getCount() + secondHalf.getCount();
  }
}

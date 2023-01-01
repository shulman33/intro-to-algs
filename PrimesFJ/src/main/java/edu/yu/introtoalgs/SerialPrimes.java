package edu.yu.introtoalgs;

/** Implements PrimeCalculator using a "naive" serial computation.
 *
 * Students may not change the constructor signature or add any other
 * constructor!
 *
 * @author Avraham Leff
 */

public class SerialPrimes implements PrimeCalculator {
  private int count;

  /** Constructor
   *
   */
  public SerialPrimes() {
    // your code (if any) goes here
    this.count = 0;
  }

  @Override
  public int nPrimesInRange(final long start, final long end) {
    // your code (if any) goes here
    if (end < start || start < 2 || end > Long.MAX_VALUE){
      throw new IllegalArgumentException();
    }
    for (long i = start; i <= end; i++) {
      if (isPrime(i)) {
        this.count++;
      }
    }

    return count;
  }

  private boolean isPrime(long n){
    if (n == 0 || n == 1) {
      return false;
    }
    if (n == 2){
        return true;
    }

    for (long i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}

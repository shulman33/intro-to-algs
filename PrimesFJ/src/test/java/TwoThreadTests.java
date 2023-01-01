import edu.yu.introtoalgs.SerialPrimes;
import edu.yu.introtoalgs.TwoThreadPrimes;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoThreadTests {

    @Test
    public void testTwoThreadPrimes1() {
        TwoThreadPrimes tp = new TwoThreadPrimes();
        assertEquals(8,tp.nPrimesInRange(2, 20));
    }

    @Test
    public void testTwoThreadPrimes2() {
        TwoThreadPrimes tp = new TwoThreadPrimes();
        assertEquals(25,tp.nPrimesInRange(2, 100));
    }

    @Test
    public void tenthousand() {
        TwoThreadPrimes tp = new TwoThreadPrimes();
        assertEquals(1_229,tp.nPrimesInRange(2, 10_000));
    }

    @Test
    public void hundredthousand() {
        TwoThreadPrimes tp = new TwoThreadPrimes();
        assertEquals(9_592,tp.nPrimesInRange(2, 100_000));
    }

    @Test
    public void onemillion(){
        TwoThreadPrimes tp = new TwoThreadPrimes();
        assertEquals(78_498, tp.nPrimesInRange(2, 1_000_000));
    }

    @Test
    public void tenMillion(){
        TwoThreadPrimes tp = new TwoThreadPrimes();
        assertEquals(664_579, tp.nPrimesInRange(2, 10_000_000));
    }

//    @Test
//    public void hundredmill() {
//        TwoThreadPrimes tp = new TwoThreadPrimes();
//        assertEquals(5_761_455,tp.nPrimesInRange(2, 100_000_000));
//    }
}

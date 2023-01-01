import edu.yu.introtoalgs.PrimesFJ;
import edu.yu.introtoalgs.SerialPrimes;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FJTests {
    @Test
    public void onehundredk() {
        PrimesFJ pfj = new PrimesFJ();
        assertEquals(9592, pfj.nPrimesInRange(2, 100_000));
    }
    @Test
    public void onemillion(){
        PrimesFJ pfj = new PrimesFJ();
        assertEquals(78_498, pfj.nPrimesInRange(2, 1_000_000));
    }

    @Test
    public void tenMillion(){
        PrimesFJ pfj = new PrimesFJ();
        assertEquals(664_579, pfj.nPrimesInRange(2, 10_000_000));
    }
//    @Test
//    public void onehundredmillion() {
//        PrimesFJ pfj = new PrimesFJ();
//        assertEquals(5_761_455, pfj.nPrimesInRange(2, 100_000_000));
//    }
//
//    @Test
//    public void twohundredmillion() {
//        PrimesFJ pfj = new PrimesFJ();
//        assertEquals(114_155_44, pfj.nPrimesInRange(2, 200_000_000));
//    }
}

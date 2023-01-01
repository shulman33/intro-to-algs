import edu.yu.introtoalgs.PrimesFJ;
import edu.yu.introtoalgs.SerialPrimes;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SerialTests {

    @Test
    public void testSerialPrimes() {
        SerialPrimes sp = new SerialPrimes();
        assertEquals(5_761_455,sp.nPrimesInRange(2, 100_000_000));
    }

    @Test
    public void onehundredk() {
        SerialPrimes sp = new SerialPrimes();
        assertEquals(9592, sp.nPrimesInRange(2, 100_000));
    }
    @Test
    public void onemillion(){
        SerialPrimes sp = new SerialPrimes();
        assertEquals(78_498, sp.nPrimesInRange(2, 1_000_000));
    }

    @Test
    public void tenMillion(){
        SerialPrimes sp = new SerialPrimes();
        assertEquals(664_579, sp.nPrimesInRange(2, 10_000_000));
    }
}

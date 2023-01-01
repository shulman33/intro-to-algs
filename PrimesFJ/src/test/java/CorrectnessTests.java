import edu.yu.introtoalgs.PrimesFJ;
import edu.yu.introtoalgs.SerialPrimes;
import edu.yu.introtoalgs.TwoThreadPrimes;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CorrectnessTests {

    @Test
    public void youBetterThrow(){

        SerialPrimes sp = new SerialPrimes();
        TwoThreadPrimes tp = new TwoThreadPrimes();
        PrimesFJ pfj = new PrimesFJ();

        assertThrows(IllegalArgumentException.class, () -> sp.nPrimesInRange(1,200));
        assertThrows(IllegalArgumentException.class, () -> sp.nPrimesInRange(200,150));
        assertThrows(IllegalArgumentException.class, () -> sp.nPrimesInRange(2,Long.MAX_VALUE+1));

        assertThrows(IllegalArgumentException.class, () -> tp.nPrimesInRange(1,200));
        assertThrows(IllegalArgumentException.class, () -> tp.nPrimesInRange(200,150));
        assertThrows(IllegalArgumentException.class, () -> tp.nPrimesInRange(2,Long.MAX_VALUE+1));

        assertThrows(IllegalArgumentException.class, () -> pfj.nPrimesInRange(1,200));
        assertThrows(IllegalArgumentException.class, () -> pfj.nPrimesInRange(200,150));
        assertThrows(IllegalArgumentException.class, () -> pfj.nPrimesInRange(2,Long.MAX_VALUE+1));

    }
}

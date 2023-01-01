import edu.yu.introtoalgs.WealthTransfer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WTTests {

    @Test
    public void test1(){
        final int populationSize = 3;
        final WealthTransfer wt = new WealthTransfer(populationSize);
        wt.intendToTransferWealth(1, 2, 50, false);
        wt.intendToTransferWealth(1, 3, 50, false);
        wt.setRequiredWealth(2, 40);
        wt.setRequiredWealth(3, 60);
        final double solution = wt.solveIt();
        assertEquals(120, solution, 0.0001);

    }

    @Test
    public void test5(){
        final int populationSize = 11;
        final WealthTransfer wt = new WealthTransfer(populationSize);
        wt.intendToTransferWealth(1, 2, 75, false);
        wt.intendToTransferWealth(1, 10, 25, false);
        wt.setRequiredWealth(2, 100);
        wt.setRequiredWealth(10, 30);
        final double solution = wt.solveIt();
        assertEquals(133.3333, solution, 0.0001);

    }

}

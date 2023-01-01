import edu.yu.introtoalgs.WealthTransfer;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ExceptionTests {

    @Test
    public void notHundredPercent(){
        final int populationSize = 5;
        assertThrows(IllegalStateException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.intendToTransferWealth(1, 2, 50, false);
            wt.intendToTransferWealth(1, 3, 25, false);
            wt.intendToTransferWealth(1, 4, 24, false);
            wt.solveIt();
        });

        assertThrows(IllegalStateException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(20);
            wt.intendToTransferWealth(1, 2, 50, false);
            wt.intendToTransferWealth(1, 3, 25, false);
            wt.intendToTransferWealth(1, 4, 25, false);
            wt.intendToTransferWealth(2, 6, 25, false);
            wt.intendToTransferWealth(2, 11, 25, false);
            wt.solveIt();
        });
    }

    @Test
    public void intendToTransferIAEExceptions(){
        final int populationSize = 5;
        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.intendToTransferWealth(0, 2, 50, false);
            wt.solveIt();
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.intendToTransferWealth(1, 3, 50, false);
            wt.intendToTransferWealth(1, 3, 50, false);
            wt.solveIt();
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.intendToTransferWealth(6, 2, 50, false);
            wt.solveIt();
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.intendToTransferWealth(1, 6, 50, false);
            wt.solveIt();
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.intendToTransferWealth(1, 0, 50, false);
            wt.solveIt();
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.intendToTransferWealth(1, 1, 50, false);
            wt.solveIt();
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.intendToTransferWealth(1, 3, 0, false);
            wt.solveIt();
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.intendToTransferWealth(1, 3, 130, false);
            wt.solveIt();
        });
    }

    @Test
    public void setWealthIAEExceptions(){
        final int populationSize = 5;
        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.setRequiredWealth(0, 50);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.setRequiredWealth(6, 50);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.setRequiredWealth(1, 23);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.setRequiredWealth(3, 0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            final WealthTransfer wt = new WealthTransfer(populationSize);
            wt.setRequiredWealth(3, -3);
        });
    }
}

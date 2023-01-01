package edu.yu.introtoalgs;
// import HydratedHakofos;
import edu.yu.introtoalgs.HydratedHakofos;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class HydratedHakofosTests {
    @Test
    public void hydratedHakofosTest1() {
        final int[] waterAvailable = {3,7,1,6};
        final int[] waterNeeded =    {6,7,1,3};
        final int actual = new HydratedHakofos().doIt(waterAvailable, waterNeeded);
        assertEquals(2, actual, "incorrect number of hakofos hydrated");
    }

    @Test
    public void hydratedHakofosTest2() {
        final int[] waterAvailable = {3,7,1,6};
        final int[] waterNeeded =    {5,8,1,3};
        final int actual = new HydratedHakofos().doIt(waterAvailable, waterNeeded);
        assertEquals(3, actual, "incorrect number of hakofos hydrated");
    }

    @Test
    public void noValidTables() {
        final int[] waterAvailable = {1,2,3,4,5};
        final int[] waterNeeded = {92,87,45,7,6};
        final int actual = new HydratedHakofos().doIt(waterAvailable, waterNeeded);
        assertEquals(-1, actual, "incorrect number of hakofos hydrated");
    }

}

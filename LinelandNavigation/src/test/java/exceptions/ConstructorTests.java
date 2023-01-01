package exceptions;

import org.junit.Test;
import edu.yu.introtoalgs.LinelandNavigation;

import static org.junit.Assert.assertThrows;

public class ConstructorTests {
    @Test
    public void goalTooHigh () {
        assertThrows(IllegalArgumentException.class,
                ()-> new LinelandNavigation(1_000_001, 1)
        );
    }

    @Test
    public void positionsTooHigh () {
        assertThrows(IllegalArgumentException.class,
                ()-> new LinelandNavigation(1, 1_000_001)
        );
    }

    @Test
    public void goalZero () {
        assertThrows(IllegalArgumentException.class,
                ()-> new LinelandNavigation(0, 1)
        );
    }

    @Test
    public void positionsZero () {
        assertThrows(IllegalArgumentException.class,
                ()-> new LinelandNavigation(1, 0)
        );
    }

    @Test
    public void goalNegative () {
        assertThrows(IllegalArgumentException.class,
                ()-> new LinelandNavigation(-1, 1)
        );
    }

    @Test
    public void positinsNegative () {
        assertThrows(IllegalArgumentException.class,
                ()-> new LinelandNavigation(1, -1)
        );
    }
}

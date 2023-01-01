package exceptions;

import edu.yu.introtoalgs.LinelandNavigation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AddMinedLineSegmentTests {
    LinelandNavigation ln;
    @Test
    public void startNegative () {
        ln = new LinelandNavigation(10, 1);
        assertThrows(IllegalArgumentException.class,
                ()-> ln.addMinedLineSegment(-1, 10)
        );
    }

    @Test
    public void endLessThanStart () {
        ln = new LinelandNavigation(10, 3);
        assertThrows(IllegalArgumentException.class,
                ()-> ln.addMinedLineSegment(5, 4)
        );
    }

    @Test
    public void tooHighEnd () {
        ln = new LinelandNavigation(10, 1);
        assertThrows(IllegalArgumentException.class,
                ()-> ln.addMinedLineSegment(999_998, 1_000_000)
        );
    }

    @Test
    public void permissiblyHigh () {
        ln = new LinelandNavigation(10, 5);
        assertDoesNotThrow(
                () -> ln.addMinedLineSegment(999_998, 999_999)
        );
    }

    /**
     *
     */
    @Test
    public void overlappingMinedLineSegments () {
        ln = new LinelandNavigation(10, 5);
        ln.addMinedLineSegment(1, 3);
        assertDoesNotThrow(
                ()-> ln.addMinedLineSegment(2, 4)
        );
        /*
        assertThrows(IllegalArgumentException.class,
                ()-> ln.addMinedLineSegment(2, 4)
        );
        */
    }

    @Test
    public void tooLargeAMindSegment () {
        ln = new LinelandNavigation(10, 1);
        ln.addMinedLineSegment(1, 1);
        /*
        assertThrows(IllegalArgumentException.class,
                ()-> ln.addMinedLineSegment(1, 1)
        );
        */
        int expected = 0;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    @Test
    public void tooLargeAMindSegment2 () {
        ln = new LinelandNavigation(100, 10);
        ln.addMinedLineSegment(40, 49);
        /*
        assertThrows(IllegalArgumentException.class,
                ()-> ln.addMinedLineSegment(40, 49)
        );
         */
        int expected = 0;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    @Test
    public void permissiblyLargeSegment () {
        ln = new LinelandNavigation(100, 10);
        assertDoesNotThrow(
                () -> ln.addMinedLineSegment(40, 48)
        );
    }

}

import edu.yu.introtoalgs.LinelandNavigation;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ExceptionTests {

    @Test
    public void constructorTest(){
        assertThrows(IllegalArgumentException.class, () -> {
            LinelandNavigation nav = new LinelandNavigation(0, 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LinelandNavigation nav = new LinelandNavigation(1_000_001, 1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LinelandNavigation nav = new LinelandNavigation(10, 1_000_001);
        });
    }

    @Test
    public void addMinedLineSegmentTest(){
        LinelandNavigation nav = new LinelandNavigation(20, 1);
        assertThrows(IllegalArgumentException.class, () -> {
            nav.addMinedLineSegment(-1, 11);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            nav.addMinedLineSegment(0, 11);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            nav.addMinedLineSegment(10, -1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            nav.addMinedLineSegment(10, 0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            nav.addMinedLineSegment(10, 9);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            nav.addMinedLineSegment(10, 1_000_001);
        });
    }
}

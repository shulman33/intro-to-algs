import edu.yu.introtoalgs.LinelandNavigation;

import org.junit.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AddMinedLineSegmentTests {
    @Test
    public void startNegative () {
        assertThrows(IllegalArgumentException.class,
                ()-> new LinelandNavigation(0, 1)
        );
    }
}

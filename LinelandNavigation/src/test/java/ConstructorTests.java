import edu.yu.introtoalgs.LinelandNavigation;

import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ConstructorTests {
    @Test
    public void invalid_constructor () {
        assertThrows(IllegalArgumentException.class, ()-> new LinelandNavigation(-1, -1));
    }

    @Test
    public void invalid_constructor_2 () {
        assertThrows(IllegalArgumentException.class, ()-> new LinelandNavigation(-1, -1));
    }

    @Test
    public void valid_constructor () {
        assertDoesNotThrow( () -> new LinelandNavigation(1, 1));
    }

    /*
    @Test
    public void population_overflow () {
        assertDoesNotThrow( () -> new WealthTransfer(Integer.MAX_VALUE - 10));
    }
     */
}

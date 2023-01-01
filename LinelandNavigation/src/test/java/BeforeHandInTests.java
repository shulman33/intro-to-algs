

import edu.yu.introtoalgs.LinelandNavigation;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

public class BeforeHandInTests {
    @Test
    public void primesFJConstructorTests() {
        Constructor<?>[] constructor = LinelandNavigation.class.getConstructors();
        assertEquals(1, constructor.length);
    }
}

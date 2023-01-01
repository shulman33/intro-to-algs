package edu.yu.introtoalgs;

import edu.yu.introtoalgs.XenoHematology;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionsTests {
    private XenoHematology xenoHematology;

    @Test
    public void negative_input_test_first () {
        this.xenoHematology = new XenoHematology(3);
        assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.setIncompatible(-1, 2));
    }

    @Test
    public void negative_input_test_second () {
        this.xenoHematology = new XenoHematology(3);
        assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.setCompatible(2, -1));
    }

    @Test
    public void invalid_input_test_third () {
        this.xenoHematology = new XenoHematology(3);
        assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.areCompatible(-1, 2));
    }

    @Test
    public void invalid_input_test_fourth () {
        this.xenoHematology = new XenoHematology(3);
        assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.areIncompatible(-1, 2));
    }

    @Test
    public void zero_valid_input_test () {
        this.xenoHematology = new XenoHematology(3);
        assertDoesNotThrow( () -> this.xenoHematology.areIncompatible(0, 1));
    }

    /**
     * Population violation
     */
    @Test
    public void population_violation_test () {
        assertThrows(IllegalArgumentException.class, ()-> new XenoHematology(-1));
    }

    @Test
    public void population_violation_test_equal () {
        this.xenoHematology = new XenoHematology(3);
        assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.areIncompatible(1, 3));
    }

    @Test
    public void population_violation_test_more () {
        this.xenoHematology = new XenoHematology(3);
        assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.areIncompatible(1, 4));
    }

    @Test
    public void population_violation_test_100s () {

        this.xenoHematology = new XenoHematology(3);

        for (int i = 0, j = i; i < 2; i++) {
            assertDoesNotThrow( () -> this.xenoHematology.areCompatible(j, j+1));
            assertDoesNotThrow( () -> this.xenoHematology.areIncompatible(j, j+1));
            assertDoesNotThrow( () -> this.xenoHematology.setCompatible(j, j+1));
            //assertDoesNotThrow( () -> this.xenoHematology.setIncompatible(j, j+1));
        }

        for (int i = 2, j = i; i < 100; i++) {
            assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.areCompatible(j, j+1));
            assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.areIncompatible(j, j+1));
            assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.setCompatible(j, j+1));
            assertThrows(IllegalArgumentException.class, ()-> this.xenoHematology.setIncompatible(j, j+1));
        }
    }

    /**
     * To_oneself
     */
    @Test
    public void to_oneself_test_areCompatible () {
        this.xenoHematology = new XenoHematology(3);
        assertDoesNotThrow( () -> this.xenoHematology.areCompatible(1, 1));
    }

    @Test
    public void to_oneself_test_areIncompatible () {
        this.xenoHematology = new XenoHematology(3);
        assertDoesNotThrow( () -> this.xenoHematology.areIncompatible(1, 1));
    }

    @Test
    public void to_oneself_test_setCompatible () {
        this.xenoHematology = new XenoHematology(3);
        assertDoesNotThrow( () -> this.xenoHematology.setCompatible(1, 1));
    }

    @Test
    public void to_oneself_test_setIncompatible () {
        this.xenoHematology = new XenoHematology(3);
        assertDoesNotThrow( () -> this.xenoHematology.setIncompatible(1, 1));
    }

}

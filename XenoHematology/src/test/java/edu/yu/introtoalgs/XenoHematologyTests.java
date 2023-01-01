package edu.yu.introtoalgs;

import edu.yu.introtoalgs.XenoHematology;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XenoHematologyTests {
    private XenoHematology xenoHematology;

    /*
    @Before
    public void setup() {
        this.xenoHematology = new XenoHematology(3);
    }
     */

    @Test
    public void compbatibility_test_one () {
        XenoHematology xenoHematology = new XenoHematology(3);
        assertFalse(xenoHematology.areCompatible(1, 2));
        xenoHematology.setCompatible(1, 2);
        assertTrue(xenoHematology.areCompatible(1, 2));
    }

    @Test
    public void compbatibility_test_two () {
        XenoHematology xenoHematology = new XenoHematology(5);
        assertFalse(xenoHematology.areCompatible(1, 2));
        assertFalse(xenoHematology.areCompatible(1, 3));

        xenoHematology.setCompatible(1, 2);
        assertTrue(xenoHematology.areCompatible(1, 2));

        xenoHematology.setCompatible(2, 3);
        assertTrue(xenoHematology.areCompatible(2, 3));
        assertTrue(xenoHematology.areCompatible(1, 3));
    }

    @Test
    public void compbatibility_test_three () {
        XenoHematology xenoHematology = new XenoHematology(10000);
        for (int i = 1; i <= 1000; i++) { // up to 1000
            assertFalse(xenoHematology.areCompatible(i, i+1));
        }
        for (int i = 1; i <= 1000; i++) { // up to 1000
            xenoHematology.setCompatible(i, i+1);
        }
        for (int i = 1, j = 1001; i <= 501; i++, j--) { // up to 1000
            assertTrue(xenoHematology.areCompatible(i, j));
        }

        for (int i = 1, j = 3; j <= 1000; i++, j++) { // up to 1000
            assertTrue(xenoHematology.areCompatible(i, j));
        }
    }

    @Test
    public void incomCompbatibility_test_one () {
        XenoHematology xenoHematology = new XenoHematology(3);
        assertFalse(xenoHematology.areIncompatible(1, 2));
        xenoHematology.setIncompatible(1, 2);
        assertTrue(xenoHematology.areIncompatible(1, 2));
        //assertFalse(xenoHematology.areCompatible(1, 2));
    }

    @Test
    public void incomPompbatibility_test_two () {
        XenoHematology xenoHematology = new XenoHematology(4);
        assertFalse(xenoHematology.areIncompatible(1, 2));
        assertFalse(xenoHematology.areIncompatible(1, 3));

        xenoHematology.setIncompatible(2, 1);
        assertTrue(xenoHematology.areIncompatible(1, 2));
        assertTrue(xenoHematology.areIncompatible(2, 1));

        xenoHematology.setIncompatible(2, 3);
        assertTrue(xenoHematology.areIncompatible(2, 3));
        assertTrue(xenoHematology.areCompatible(1, 3));
        assertTrue(xenoHematology.areCompatible(3, 1));
    }

    @Test
    public void incomPompbatibility_test_three () {
        XenoHematology xenoHematology = new XenoHematology(4);
        assertFalse(xenoHematology.areIncompatible(1, 2));
        assertFalse(xenoHematology.areIncompatible(1, 3));

        xenoHematology.setIncompatible(2, 1);
        assertTrue(xenoHematology.areIncompatible(1, 2));
        assertTrue(xenoHematology.areIncompatible(2, 1));

        xenoHematology.setIncompatible(2, 3);
        assertTrue(xenoHematology.areIncompatible(2, 3));
        assertTrue(xenoHematology.areCompatible(1, 3));
        assertTrue(xenoHematology.areCompatible(3, 1));
    }

    /**
     * If x is incompatible with y, and y is incompatible with z, then x is
     * compatible with z. Because of the equivalence relation mentioned
     * above, this fact has implications beyond a single x, y, z triple.
     */
    @Test
    public void incomp_incomp_comp_test () {
        XenoHematology xenoHematology = new XenoHematology(3);
        xenoHematology.setIncompatible(0, 1);
        xenoHematology.setIncompatible(1, 2);
        assertTrue(xenoHematology.areCompatible(0, 2));
    }

    @Test
    public void incompatible_compatible_test_two () {
        XenoHematology xenoHematology = new XenoHematology(3);
        xenoHematology.setCompatible(1, 0);
        xenoHematology.setIncompatible(1, 2);
        assertTrue(xenoHematology.areIncompatible(0, 2));
    }

    /**
     * If x is compatible with y and y is incompatible with z, then x is incompatible with z.
     */
    @Test
    public void comp_incomp_incomp_test_one () {
        XenoHematology xenoHematology = new XenoHematology(3);
        xenoHematology.setCompatible(0, 1);
        xenoHematology.setIncompatible(1, 2);
        //assertTrue(xenoHematology.areIncompatible(1, 2));
        //assertTrue(xenoHematology.areCompatible(0, 1));
        assertTrue(xenoHematology.areIncompatible(0, 2));
    }

    @Test
    public void comp_incomp_incomp_test_one_inverse () {
        XenoHematology xenoHematology = new XenoHematology(3);
        xenoHematology.setCompatible(0, 1);
        xenoHematology.setIncompatible(1, 2);
        assertTrue(xenoHematology.areIncompatible(2, 0));
    }

    @Test
    public void comp_incomp_incomp_test_two () {
        XenoHematology xenoHematology = new XenoHematology(3);
        xenoHematology.setCompatible(1, 0);
        xenoHematology.setIncompatible(1, 2);
        assertTrue(xenoHematology.areIncompatible(0, 2));
    }

    @Test
    public void comp_incomp_incomp_test_two_inverse () {
        XenoHematology xenoHematology = new XenoHematology(3);
        xenoHematology.setCompatible(1, 0);
        xenoHematology.setIncompatible(1, 2);
        assertTrue(xenoHematology.areIncompatible(2, 0));
    }

    @Test
    public void comp_incomp_incomp_test_three () {
        XenoHematology xenoHematology = new XenoHematology(3);
        xenoHematology.setCompatible(1, 0);
        xenoHematology.setIncompatible(2, 1);
        assertTrue(xenoHematology.areIncompatible(0, 2));
    }

    @Test
    public void comp_incomp_incomp_test_three_inverse () {
        XenoHematology xenoHematology = new XenoHematology(3);
        xenoHematology.setCompatible(1, 0);
        xenoHematology.setIncompatible(2, 1);
        assertTrue(xenoHematology.areIncompatible(2, 0));
    }

    @Test
    public void comp_incomp_incomp_test_four () {
        XenoHematology xenoHematology = new XenoHematology(3);
        xenoHematology.setCompatible(0, 1);
        xenoHematology.setIncompatible(2, 1);
        assertTrue(xenoHematology.areIncompatible(0, 2));
    }

    @Test
    public void comp_incomp_incomp_test_four_inverse () {
        XenoHematology xenoHematology = new XenoHematology(4);
        xenoHematology.setIncompatible(0, 1);
        xenoHematology.setIncompatible(0, 3);
        assertTrue(xenoHematology.areCompatible(1, 3));
    }
    @Test
    public void yoni_test() {
        XenoHematology xenoHematology = new XenoHematology(5);
        xenoHematology.setCompatible(0, 1);
        assertTrue(xenoHematology.areCompatible(0,1));
        xenoHematology.setCompatible(2, 0);
        assertTrue(xenoHematology.areCompatible(0,2));
        assertTrue(xenoHematology.areCompatible(2,1));
        xenoHematology.setIncompatible(3, 1);
        xenoHematology.setIncompatible(4, 2);
        assertTrue(xenoHematology.areCompatible(3, 4));
    }
    @Test
    public void test () {
        XenoHematology xenoHematology = new XenoHematology(9);
        xenoHematology.setCompatible(0, 1);
        assertTrue(xenoHematology.areCompatible(0, 1));

        xenoHematology.setCompatible(2, 0);
        assertTrue(xenoHematology.areCompatible(0, 2));
        assertTrue(xenoHematology.areCompatible(2, 1));

        xenoHematology.setIncompatible(3, 1);
        xenoHematology.setIncompatible(4, 2);
        assertTrue(xenoHematology.areCompatible(3, 4));

        xenoHematology.setCompatible(5, 3);
        xenoHematology.setCompatible(6, 4);
        xenoHematology.setIncompatible(5, 7);
        xenoHematology.setIncompatible(6, 8);
        assertTrue(xenoHematology.areCompatible(7, 8));
    }

}

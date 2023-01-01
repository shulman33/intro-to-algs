package edu.yu.introtoalgs;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlienTests {

    @Test
    public void errorChecking(){
        XenoHematology xenos = new XenoHematology(10);
        assertThrows(IllegalArgumentException.class, () -> xenos.setCompatible(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> xenos.setCompatible(3, -23));
        assertThrows(IllegalArgumentException.class, () -> xenos.setCompatible(11, 3));
        assertThrows(IllegalArgumentException.class, () -> xenos.setCompatible(3, 23));

        assertThrows(IllegalArgumentException.class, () -> xenos.setIncompatible(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> xenos.setIncompatible(3, -23));
        assertThrows(IllegalArgumentException.class, () -> xenos.setIncompatible(11, 3));
        assertThrows(IllegalArgumentException.class, () -> xenos.setIncompatible(3, 23));

        assertThrows(IllegalArgumentException.class, () -> xenos.areCompatible(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> xenos.areCompatible(3, -23));
        assertThrows(IllegalArgumentException.class, () -> xenos.areCompatible(11, 3));
        assertThrows(IllegalArgumentException.class, () -> xenos.areCompatible(3, 23));

        assertThrows(IllegalArgumentException.class, () -> xenos.areIncompatible(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> xenos.areIncompatible(3, -23));
        assertThrows(IllegalArgumentException.class, () -> xenos.areIncompatible(11, 3));
        assertThrows(IllegalArgumentException.class, () -> xenos.areIncompatible(3, 23));
    }
    @Test
    public void compatibilityTest1() {
        XenoHematology xeno = new XenoHematology(10);
        xeno.setCompatible(0, 1);
        assertTrue(xeno.areCompatible(0, 1));
    }

    @Test
    public void compatibilityTest2() {
        XenoHematology xeno = new XenoHematology(10000);
        xeno.setCompatible(0, 1);
        xeno.setCompatible(1, 2);
        assertTrue(xeno.areCompatible(0, 2));
    }

    @Test
    public void incompatibilityTest1() {
        XenoHematology xeno = new XenoHematology(10000);
        xeno.setIncompatible(5, 6);
        xeno.setIncompatible(6, 45);
        assertTrue(xeno.areCompatible(5, 45));
    }

    @Test
    public void incompatibilityTest2() {
        XenoHematology xeno = new XenoHematology(10000);
        xeno.setCompatible(62, 89);
        xeno.setIncompatible(89, 91);
        assertTrue(xeno.areIncompatible(62, 91));
    }

    @Test
    public void incompatibilityTest3() {
        XenoHematology xeno = new XenoHematology(10000);
        xeno.setIncompatible(6, 45);
        assertTrue(xeno.areIncompatible(6, 45));
    }

    @Test
    public void noSwitching1() {
        XenoHematology xeno = new XenoHematology(10000);
        xeno.setCompatible(6, 45);
        assertFalse(xeno.areIncompatible(6, 45));
        xeno.setIncompatible(6, 45);
        assertFalse(xeno.areIncompatible(6, 45));
    }

//    @Test
//    public void noSwitching2() {
//        XenoHematology xeno = new XenoHematology(10000);
//        xeno.setIncompatible(6, 45);
//        assertFalse(xeno.areCompatible(6, 45));
//        xeno.setCompatible(6, 45);
//        assertFalse(xeno.areCompatible(6, 45));
//    }
}

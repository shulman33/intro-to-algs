package edu.yu.introtoalgs;

import java.util.*;
// import assertEquals;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BigOTests {
//    public static void main(String[] args) {
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = MysteryClass.class.getName();
//        double ratio = bigOIt.doublingRatio(bigOMeasurable, 40_000);
//
//    }
//
//    @Test
//    public void cubic(){
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = MysteryClass.class.getName();
//        double ratio = bigOIt.doublingRatio(bigOMeasurable, 40_000);
//        Assert.assertEquals(8.0, ratio, 0.4);
//    }
//
//    @Test
//    public void doubleSum(){
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = DoubleSum.class.getName();
//        double ratio = bigOIt.doublingRatio(bigOMeasurable, 40_000);
//        Assert.assertEquals(4.0, ratio, 0.4);
//    }
//    @Test
//    public void linear(){
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = LinearClazz.class.getName();
//        double ratio = bigOIt.doublingRatio(bigOMeasurable, 40_000);
//        Assert.assertEquals(2.0, ratio, 0.4);
//    }
//    @Test
//    public void binarySearch(){
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = BinarySearch.class.getName();
//        double ratio = bigOIt.doublingRatio(bigOMeasurable, 40_000);
//        Assert.assertEquals(1.3, ratio, 0.4);
//    }
//    @Test
//    public void returnNan(){
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = MysteryClass.class.getName();
//        double ratio = bigOIt.doublingRatio(bigOMeasurable, 2_000);
//        Assert.assertEquals(Double.NaN, ratio, 0.4);
//    }
//    @Test
//    public void nullBigOString(){
//        boolean caught = false;
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = null;
//        try {
//            double ratio = bigOIt.doublingRatio(bigOMeasurable, 40_000);
//        }
//        catch (IllegalArgumentException e){
//            caught = true;
//        }
//        assertTrue(caught);
//    }
//    @Test
//    public void emptyBigOString(){
//        boolean caught = false;
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = "";
//        try {
//            double ratio = bigOIt.doublingRatio(bigOMeasurable, 40_000);
//        }
//        catch (IllegalArgumentException e){
//            caught = true;
//        }
//        assertTrue(caught);
//    }
//
//    @Test
//    public void classDoesntExist(){
//        boolean caught = false;
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = "edu.yu.introtoalgs.DoesntExist";
//        try {
//            double ratio = bigOIt.doublingRatio(bigOMeasurable, 40_000);
//        }
//        catch (IllegalArgumentException e){
//            caught = true;
//        }
//        assertTrue(caught);
//    }
//    @Test
//    public void invalidTimeOut(){
//        boolean caught = false;
//        BigOIt bigOIt = new BigOIt();
//        final String bigOMeasurable = MysteryClass.class.getName();
//        try {
//            double ratio = bigOIt.doublingRatio(bigOMeasurable, 0);
//        }
//        catch (IllegalArgumentException e){
//            caught = true;
//        }
//        assertTrue(caught);
//    }

    @Test
    public void hakafosTimePerformance(){
        BigOIt bigOIt = new BigOIt();
        final String bigOMeasurable = Hakafos.class.getName();
        double ratio = bigOIt.doublingRatio(bigOMeasurable, 40_000);
        Assert.assertEquals(2.0, ratio, 0.4);
    }

}

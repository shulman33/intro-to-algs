package edu.yu.introtests;

import edu.yu.introtoalgs.BTKeysAtSameLevel2;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BT2Tests {
    @Test
    public void demo () {
        final String treeInStringRepresentation = "1(2)(3)" ;
        final List<List<Integer>> actual = new BTKeysAtSameLevel2().compute (treeInStringRepresentation);
        final List<List<Integer>> expected = new ArrayList<>();
        expected.add (new ArrayList <Integer>(List.of(1)));
        expected.add (new ArrayList <Integer>(List.of(2, 3)));
        assertEquals (expected , actual ,"incorrect ’binary tree keys at same depth’" ) ;
    }
    @Test
    public void demo2 () {
        final String treeInStringRepresentation = "1(2(4)(5))(3)" ;
        final List<List<Integer>> actual = new BTKeysAtSameLevel2().compute (treeInStringRepresentation);
        final List<List<Integer>> expected = new ArrayList<>() ;
        expected.add (new ArrayList <Integer>(List.of(1)));
        expected.add (new ArrayList <Integer>(List.of(2, 3)));
        expected.add (new ArrayList <Integer>(List.of(4, 5)));
        assertEquals (expected , actual ,"incorrect ’binary tree keys at same depth’" ) ;
    }
    @Test
    public void demo3 () {
        final String treeInStringRepresentation = "1(2(4)(5))(3(6)(7))" ;
        final List<List<Integer>> actual = new BTKeysAtSameLevel2().compute (treeInStringRepresentation);
        final List<List<Integer>> expected = new ArrayList<>() ;
        expected.add (new ArrayList <Integer>(List.of(1)));
        expected.add (new ArrayList <Integer>(List.of(2, 3)));
        expected.add (new ArrayList <Integer>(List.of(4, 5, 6, 7)));
        assertEquals (expected , actual ,"incorrect ’binary tree keys at same depth’" ) ;
    }
    @Test
    public void demo4 () {
        final String treeInStringRepresentation = "1(2(4)(5))(3(6(8)(9))(7))" ;
        final List<List<Integer>> actual = new BTKeysAtSameLevel2().compute (treeInStringRepresentation);
        final List<List<Integer>> expected = new ArrayList<>() ;
        expected.add (new ArrayList <Integer>(List.of(1 )));
        expected.add (new ArrayList <Integer>(List.of(2, 3)));
        expected.add (new ArrayList <Integer>(List.of(4,5,6,7)));
        expected.add (new ArrayList <Integer>(List.of(8,9)));
        assertEquals (expected , actual ,"incorrect ’binary tree keys at same depth’" ) ;
    }
    @Test
    public void emptyString(){
        final String treeInStringRepresentation = "" ;
        final List<List<Integer>> actual = new BTKeysAtSameLevel2().compute(treeInStringRepresentation);
        final List<List<Integer>> expected = new ArrayList<>() ;
        assertEquals (expected , actual ,"incorrect ’binary tree keys at same depth’" ) ;
    }
    @Test
    public void nullString(){
        final String treeInStringRepresentation = null ;
        assertThrows(IllegalArgumentException.class, () -> {
            new BTKeysAtSameLevel2().compute(treeInStringRepresentation);
        });
    }
    @Test
    public void unbalancedString(){
        final String treeInStringRepresentation = "1(2(4)(5))(3(6(8(9))(7))" ;
        assertThrows(IllegalArgumentException.class, () -> {
            new BTKeysAtSameLevel2().compute(treeInStringRepresentation);
        });
    }
    @Test
    public void greaterThanNine(){
        final String treeInStringRepresentation = "9(2(4)(5))(3(7(55)(9))(7))(9(9)(4))" ;
        assertThrows(IllegalArgumentException.class, () -> {
            new BTKeysAtSameLevel2().compute(treeInStringRepresentation);
        });
    }
    @Test
    public void negativeNumber(){
        final String treeInStringRepresentation = "9(2(4)(-2))(3(7(55)(9))(7))(9(9)(4))" ;
        assertThrows(IllegalArgumentException.class, () -> {
            new BTKeysAtSameLevel2().compute(treeInStringRepresentation);
        });
    }
    @Test
    public void notAnInt(){
        final String treeInStringRepresentation = "9(2(4)(k))(3(7(55)(9))(7))(9(9)(4))" ;
        assertThrows(IllegalArgumentException.class, () -> {
            new BTKeysAtSameLevel2().compute(treeInStringRepresentation);
        });
    }
    @Test
    public void justTheRoot () {
        final String treeInStringRepresentation = "4" ;
        final List<List<Integer>> actual = new BTKeysAtSameLevel2().compute (treeInStringRepresentation);
        final List<List<Integer>> expected = new ArrayList<>();
        expected.add (new ArrayList <Integer>(List.of(4)));
        assertEquals (expected , actual ,"incorrect ’binary tree keys at same depth’" ) ;
    }
}

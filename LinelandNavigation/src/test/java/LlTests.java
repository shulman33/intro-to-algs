import edu.yu.introtoalgs.LinelandNavigation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LlTests {

    @Test
    public void test1 () {
        LinelandNavigation ln = new LinelandNavigation(10, 1);
        int expected = 10;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    @Test
    public void test2 () {
        LinelandNavigation ln = new LinelandNavigation(11, 1);
        int expected = 11;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * 1) Move back to -1
     * 2) 9
     * 3) 19
     */
    @Test
    public void test3 () {
        LinelandNavigation ln = new LinelandNavigation(10, 10);
        ln.addMinedLineSegment(10, 10);
        int expected = 0;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * Options:
     * 1) T = 12
     * Backward 1 = -1
     * 11 Forward == 109
     * 2) T = 12
     * 4 Forward == 40
     * Backward 1 == 39
     * 7 Forward == 109
     */
    @Test
    public void LMtest1 () {
        LinelandNavigation ln = new LinelandNavigation(100, 10);
        ln.addMinedLineSegment(50, 50);
        int expected = 12;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * Options:
     * 1) T = 12
     * Backward 1 = -1
     * 11 Forward == 109
     * 2) T = 12
     * 4 Forward == 40
     * Backward 1 == 39
     * 7 Forward == 109
     */
    @Test
    public void LMtest2 () {
        LinelandNavigation ln = new LinelandNavigation(100, 10);
        ln.addMinedLineSegment(49, 50);
        int expected = 12;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     *
     */
    @Test
    public void LMtest3 () {
        LinelandNavigation ln = new LinelandNavigation(100, 10);
        ln.addMinedLineSegment(41, 50);
        int expected = 0;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * Impossible!
     * To hope 42-50: 41 is required and the only way to get ot 41 is from 31-41
     */
    @Test
    public void LMtest4 () {
        LinelandNavigation ln = new LinelandNavigation(100, 10);
        ln.addMinedLineSegment(42, 50);
        ln.addMinedLineSegment(31, 31);
        int expected = 0;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * 1) Try 10, go to -2
     * 11) 108
     */
    @Test
    public void LMtest5 () {
        LinelandNavigation ln = new LinelandNavigation(100, 10);
        ln.addMinedLineSegment(29, 29);
        ln.addMinedLineSegment(30, 30);
        int expected = 12;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * 1) Try 10, go to -3
     * 12) 107
     */
    @Test
    public void LMtest6a () {
        LinelandNavigation ln = new LinelandNavigation(100, 10);
        ln.addMinedLineSegment(28, 28);
        ln.addMinedLineSegment(29, 29);
        ln.addMinedLineSegment(30, 30);
        int expected = 12;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * 0, 2, 4, 6, 8, 10
     */
    @Test
    public void Test2s () {
        final int moves = 2;
        final int goal = 10;
        LinelandNavigation ln = new LinelandNavigation(goal, moves);
        int expected = 5;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * 1) 2
     * 2) To 1
     * 3) 3
     * 4) 5
     * 5) 7
     * 6) 6 (Mine == 9)
     * 7) 8
     * 8) 10
     */
    @Test
    public void Test2sA () {
        final int moves = 2;
        final int goal = 10;
        LinelandNavigation ln = new LinelandNavigation(goal, moves);
        ln.addMinedLineSegment(4, 4);
        ln.addMinedLineSegment(9, 9);
        int expected = 8;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * My Solution
     * 1) 9 (Mine == 10)
     * 2) 18 (Mine == 19)
     * 3) 27 (Mine == 28)
     * 4) 36 (Mine == 37)
     * 5) 45 (Mine == 46)
     * 6) 54 (Mine == 55)
     * 7) 63 (Mine == 64)
     * 8) 72 (Mine == 73)
     * 9) 81 (Mine == 82)
     * 10) 90 (Mine == 91)
     * 11) 100
     * 13) Total backward moves == 10
     *
     * Optimal Solution
     * 1) MOVE BACK 9, to -9
     * 2) 1
     * 3) 11
     * 4) 21
     * 5) 31
     * 6) 41
     * 7) 51
     * 8) 61
     * 9) 71 (Mine == 73)
     * 10) 81 (Mine == 82)
     * 11) MOVE BACK 1, to 80 bc Mine == 91
     * 12) 90 (Mine == 91)
     * 13) 100
     */
    @Test
    public void LMtest7 () {
        LinelandNavigation ln = new LinelandNavigation(100, 10);
        ln.addMinedLineSegment(20, 20);
        ln.addMinedLineSegment(29, 29);
        ln.addMinedLineSegment(38, 38);
        ln.addMinedLineSegment(47, 47);
        ln.addMinedLineSegment(56, 56);
        ln.addMinedLineSegment(65, 65);
        ln.addMinedLineSegment(74, 74);
        ln.addMinedLineSegment(83, 83);
        ln.addMinedLineSegment(92, 92);
        ln.addMinedLineSegment(101, 101);
        int expected = 13;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * Optimal Solution
     * 1) MOVE BACK 9, to -9
     * 2) 1 (Mine == 10)
     * 3) 11 (Mine == 19)
     * 4) 21 (Mine == 28)
     * 5) 31 (Mine == 37)
     * 6) 41 (Mine == 46)
     * 7) 51 (Mine == 55)
     * 8) 61 (Mine == 64)
     * 9) 71 (Mine == 73)
     * 10) 81 (Mine == 82)
     *
     * 11) MOVE BACK 7, to 74 bc Mine == 91 & Mine == 73
     * 12) 84 (Mine == 82)
     * 13) 94 (Mine == 91)
     * 14) 104 (Mine == 100 & 109)
     * 15) 114 (Mine == 118)
     * 16) 124 (Mine == 127)
     * 17) 134 (Mine == 136)
     * 18) 144 (Mine == 145)
     * 19) MOVE BACK 7, to 137 bc Mine == 136
     * 20) 147 (Mine == 145)
     *
     * 21) 157 (Mine == 154)
     * 22) 167 (Mine == 163)
     * 23) 177 (Mine == 172)
     * 24) 187 (Mine == 181)
     * 25) 197 (Mine == 190)
     * 26) 207 (Mine == 200)
     */
    @Test
    public void AutoTest2 () {
        final int moves = 10;
        final int goal = 200;
        int limit = goal + moves;
        LinelandNavigation ln = new LinelandNavigation(goal, moves);
        for (int i = (2 * moves), c = 0; i <= limit; i += moves, c++) {
            ln.addMinedLineSegment(i-c, i-c);
        }
        int expected = 25;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    /**
     * Optimal Solution
     * 1) MOVE BACK 9, to -9
     * 2) 1 (Mine == 10)
     * 3) 11 (Mine == 19)
     * 4) 21 (Mine == 28)
     * 5) 31 (Mine == 37)
     * 6) 41 (Mine == 46)
     * 7) 51 (Mine == 55)
     * 8) 61 (Mine == 64)
     * 9) 71 (Mine == 73)
     * 10) 81 (Mine == 82)
     *
     * 11) MOVE BACK 7, to 74 bc Mine == 91 & Mine == 73
     * 12) 84 (Mine == 82)
     * 13) 94 (Mine == 91)
     * 14) 104 (Mine == 100)
     */
    @Test
    public void AutoTest100 () {
        final int moves = 10;
        final int goal = 100;
        int limit = goal + moves;
        LinelandNavigation ln = new LinelandNavigation(goal, moves);
        for (int i = (2 * moves), c = 0; i <= limit; i += moves, c++) {
            ln.addMinedLineSegment(i-c, i-c);
            System.out.println(i-c);
        }
        int expected = 13;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }

    @Test
    public void AutoTest2b () {
        for (int j = 1; j <= 20; j++) {
            final int moves = 10;
            final int goal = 10 * j;
            int limit = goal + moves;
            LinelandNavigation ln = new LinelandNavigation(goal, moves);
            for (int i = (moves * 2), c = 0; i <= limit; i += moves, c++) {
                ln.addMinedLineSegment(i - c, i - c);
                //System.out.println(i - c);
            }
            int expected;
            if (goal <= 10) {
                expected = j;
            } else if (goal <= 90) {
                expected = j + 2;
            } else if (goal == 100) {
                expected = j + 3;
            } else if (goal >= 110 && goal < 170) {
                expected = j + 4;
            } else { // if (goal >= 170 && goal <= 200)
                expected = j + 5;
            }
            final int actual = ln.solveIt();
            System.out.println("goal: " + goal + ". Expecting: " + expected);
            assertEquals(expected, actual);
        }
    }

    /**
     * 4) 40
     * 1) 31
     * 1) 41
     * 1) 51
     *
     */
    @Test
    public void LMtest8 () {
        LinelandNavigation ln = new LinelandNavigation(100, 10);
        ln.addMinedLineSegment(41, 50);
        ln.addMinedLineSegment(61, 61);
        int expected = 0;
        int actual = ln.solveIt();
        assertEquals(expected, actual);
    }
}

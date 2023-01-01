import edu.yu.introtoalgs.LinelandNavigation;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class RunTimeTests {
    // Create a test for the run time of the solveIt() method

    static class StopWatch {
        private final long start;

        public StopWatch() {
            start = System.currentTimeMillis();
        }

        public double elapsedTime() {
            long now = System.currentTimeMillis();
            return (now - start) / 1000.0;
        }
    }

    private static void warmup() {
        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*          Warming up the JVM             *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");
        try{
            int [] array = new int[1000];
            for (int i = 0; i < 1000; i++) {
                array[i] = i;
            }
            System.out.println("*******************************************");
            System.out.println("*                                         *");
            System.out.println("*          All Warmed up 🔥               *");
            System.out.println("*                                         *");
            System.out.println("*******************************************");
        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }

    private static double timeTrial(int g, int m) {
        StopWatch timer = new StopWatch();
        LinelandNavigation nav = new LinelandNavigation(g, m);
        for (int i = 1; i < g; i *= 4) {
            nav.addMinedLineSegment(i , i + 1);
        }
        nav.solveIt();
        return timer.elapsedTime();
    }

    @Test
    public void runTimeTest(){
        warmup();
        double prev = timeTrial(100, 3);
        for (int n = 200; n < 1_000_000; n += n) {
            double time = timeTrial(n, 3);
            System.out.printf("%6d %7.1f ", n, time);
            System.out.printf("%5.1f\n", time / prev);
            prev = time;
        }

    }
}

package edu.yu.introtoalgs;

import edu.yu.introtoalgs.XenoHematology;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class RuntimeTests {
    Stack<Double> stack;
    private final int ran = 3;
    private static double time;
    private int size;

    @Test
    public void RatioTest () {
        size = (int)Math.pow(2, 20);
        stack = new Stack<>();
        for (int i = 0; i < ran; i++) new Ratios();
        while (!stack.isEmpty()) time += stack.pop();
        time /= ran;
        System.out.println("Final Runtime: " + time);
    }

    public class Ratios {
        public Ratios () {
            warmup();
            createScenarios(size);
            System.out.println(time);
            stack.push(time);
        }

        private void createScenarios(int size) {
            XenoHematology xenoHematology = new XenoHematology(size);
            double prev = 1.0;
            double cpu;
            for (int i = 2; i < (size); i++) {
                cpu = System.nanoTime();
                xenoHematology.setCompatible(i, i+1);
                //assertTrue(xenoHematology.areCompatible(i, i+1));
                cpu = (System.nanoTime() - cpu);
                time = (cpu / prev);
                prev = cpu;
            }
        }

        private void warmup() {
            int [] array = new int[1000];
            for (int i = 0; i < 1000; i++) {
                array[i] = i;
            }
        }
    }
}

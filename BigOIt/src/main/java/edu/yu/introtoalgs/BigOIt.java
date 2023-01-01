package edu.yu.introtoalgs;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;

public class BigOIt extends BigOItBase{
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

    @Override
    public double doublingRatio(String bigOMeasurable, long timeOutInMs) {
        if (bigOMeasurable == null || bigOMeasurable.isEmpty() || timeOutInMs <= 0) {
            throw new IllegalArgumentException("invalid input");
        }
        List<Double> times = new ArrayList<Double>();
        final StopWatch[] timer = new StopWatch[1];
       try {
           Class<?> c = Class.forName(bigOMeasurable);
           Constructor<?> constructor = c.getConstructor();
           Object instance = constructor.newInstance();
           Method setup = c.getMethod("setup", int.class);
           setup.invoke(instance, 125);
           timer[0] = new StopWatch();
           Method execute = c.getMethod("execute");
           execute.invoke(instance);
       } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
           throw new IllegalArgumentException(e);
       }
        final double[] previous = {timer[0].elapsedTime()};
        ExecutorService service = Executors.newSingleThreadExecutor();
        try{
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        Class<?> c = Class.forName(bigOMeasurable);
                        Constructor<?> constructor = c.getConstructor();
                        Object instance = constructor.newInstance();
                        Method setup = c.getMethod("setup", int.class);
                        for (int n = 250; n < 16_384; n += n) {
                            setup.invoke(instance, n);
                            timer[0] = new StopWatch();
                            Method execute = c.getMethod("execute");
                            execute.invoke(instance);
                            double current = timer[0].elapsedTime();
//                            StdOut.printf("%7d %7.1f %5.1f\n", n, current, current/ previous[0]);
                            times.add(current / previous[0]);
                            previous[0] = current;
                        }
                    } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException |IllegalAccessException  e) {
                        throw new IllegalArgumentException(e);
                    }

                }
            };
            Future<?> f = service.submit(r);
            f.get(timeOutInMs - 1000, TimeUnit.MILLISECONDS);
        }catch (final TimeoutException | ExecutionException | InterruptedException e){
            removeGarbage(times);
        }

        removeGarbage(times);
        if (times.size() > 1){
            times.remove(0);
        }
        if (times.size() > 3){
            times.remove(0);
        }
//        System.out.print("///////////////////////// ELEMENTS IN TIMES /////////////////////////\n");
//        for (double time : times) {
//            StdOut.println(time);
//        }

        return times.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(Double.NaN);
    }

    private void removeGarbage(List<Double> times){
        times.removeAll(Collections.singleton(0.0));
        times.removeAll(Collections.singleton(Double.NaN));
        times.removeAll(Collections.singleton(Double.POSITIVE_INFINITY));
        times.removeAll(Collections.singleton(Double.NEGATIVE_INFINITY));

    }

}

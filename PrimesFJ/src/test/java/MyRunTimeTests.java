import edu.yu.introtoalgs.PrimesFJ;
import edu.yu.introtoalgs.SerialPrimes;
import edu.yu.introtoalgs.TwoThreadPrimes;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.charts.*;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.*;
//import org.apache.poi.xssf.usermodel.charts.XSSFCategoryAxis;
//import org.apache.poi.xssf.usermodel.charts.XSSFChartLegend;
//import org.apache.poi.xssf.usermodel.charts.XSSFValueAxis;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// When opening the Excel file all three graphs are stacked on top of each other.
public class MyRunTimeTests {

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

    public static double primeFjTimeTrial(int high){
        StopWatch timer = new StopWatch();
        PrimesFJ primesFJ = new PrimesFJ();
        primesFJ.nPrimesInRange(2, high);
        return timer.elapsedTime();
    }

    public static double twoThreadTimeTrial(int high){
        StopWatch timer = new StopWatch();
        TwoThreadPrimes twoThreadPrimes = new TwoThreadPrimes();
        twoThreadPrimes.nPrimesInRange(2, high);
        return timer.elapsedTime();
    }

    public static double serialTimeTrial(int high){
        StopWatch timer = new StopWatch();
        SerialPrimes serialPrimes = new SerialPrimes();
        serialPrimes.nPrimesInRange(2, high);
        return timer.elapsedTime();
    }

    // TODO: Make sure the Apache Poi Maven dependency is in the pom.xml file
    public static void main(String[] args) throws IOException {

        warmup();

//        XSSFWorkbook workbook = new XSSFWorkbook();

        BufferedWriter bf = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/PrimesFj_data6.txt"));

        BufferedWriter twoThreadWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/TwoThread_data6.txt"));

        BufferedWriter serialWriter = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/serial_data6.txt"));

//        XSSFSheet spreadsheet = workbook.createSheet(" PrimesFj Data 6 ");
//
//        XSSFRow row;

        Map<String, Object[]> primesFjData = new TreeMap<String, Object[]>();

        List<Double> serialList = new ArrayList<>();
        List<Double> twoThreadList = new ArrayList<>();
        List<Double> primesFjlList = new ArrayList<>();


        primesFjData.put("1",new Object[] { "End Param", "serial", "2 thread", "primesfj" });


        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*          Running PrimesFj               *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");

        double prev = primeFjTimeTrial(100_000);
        for (int n = 200_000; n < 100_000_000; n += n){
            double time = primeFjTimeTrial(n);
            StdOut.printf("%7d %7.1f %5.1f\n", n, time, time/prev);
//            primesFjlList.add(Double.toString(time));
            primesFjlList.add(time);
            bf.write(String.format("End Param: " + "%1$s time in seconds: %2$.2f Ratio: %3$.2f\n\n", n, time, time/prev));
            prev = time;
        }
        bf.close();

        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*          End of PrimesFj Data           *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");

        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*          Running TwoThreadPrimes        *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");

        double prev1 = twoThreadTimeTrial(100_000);
        for (int n = 200_000; n < 100_000_000; n += n){
            double time = twoThreadTimeTrial(n);
            StdOut.printf("%7d %7.1f %5.1f\n", n, time, time/prev);
//            twoThreadList.add(Double.toString(time));
            twoThreadList.add(time);
            twoThreadWriter.write(String.format("End Param: " + "%1$s time in seconds: %2$.2f Ratio: %3$.2f\n\n", n, time, time/prev1));
            prev1 = time;
        }
        twoThreadWriter.close();

        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*          End of TwoThread Data          *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");

        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*          Running SerialPrimes           *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");

        double prev2 = serialTimeTrial(100_000);
        for (int n = 200_000; n < 100_000_000; n += n){
            double time = serialTimeTrial(n);
            StdOut.printf("%7d %7.1f %5.1f\n", n, time, time/prev);
//            serialList.add(Double.toString(time));
            serialList.add(time);
            serialWriter.write(String.format("End Param: " + "%1$s time in seconds: %2$.2f Ratio: %3$.2f\n\n", n, time, time/prev2));
            prev2 = time;
        }
        serialWriter.close();

        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*          End of Serial Data             *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");


        double j = 200_000;
        int x = 2;

        for (int i = 0; i < serialList.size(); i++) {
            primesFjData.put(Integer.toString(x), new Object[]{j, serialList.get(i), twoThreadList.get(i), primesFjlList.get(i)});
            x++;
            j += j;
        }

        Set<String> keyid = primesFjData.keySet();

        int rowid = 0;

//        for (String key : keyid) {
//
//            row = spreadsheet.createRow(rowid++);
//            Object[] objectArr = primesFjData.get(key);
//            int cellid = 0;
//
//            for (Object obj : objectArr) {
//                Cell cell = row.createCell(cellid++);
//                try{
//                    cell.setCellValue((String)obj);
//                }catch (ClassCastException e){
//                    cell.setCellValue((double) obj);
//                }
//
//            }
//        }

//        makeGraph(spreadsheet, x, 1, "SerialPrimes Data");
//        makeGraph(spreadsheet, x, 2, "TwoThreadPrimes Data");
//        makeGraph(spreadsheet, x, 3, "PrimesFj Data");


        //FileOutputStream out = new FileOutputStream("/Users/samshulman/Desktop/PrimesFj_Data/data6.xlsx");
//        FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "/data6.xlsx");
//
//        workbook.write(out);
//
//        out.close();

    }
//    private static void makeGraph(XSSFSheet spreadsheet, int x, int col, String chartName){
//        XSSFDrawing drawing = spreadsheet.createDrawingPatriarch();
//
//        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 5, 10, 15);
//
//        XSSFChart chart = drawing.createChart(anchor);
//
//        XSSFChartLegend legend = chart.getOrCreateLegend();
//
//        legend.setPosition(LegendPosition.TOP_RIGHT);
//
//        LineChartData data = chart.getChartDataFactory().createLineChartData();
//
//        XSSFCategoryAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
//
//        XSSFValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
//
//        leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
//
//        ChartDataSource<Number> xs = DataSources.fromNumericCellRange(spreadsheet, new CellRangeAddress(1, x-2, 0, 0));
//
//        ChartDataSource<Number> ys1 = DataSources.fromNumericCellRange(spreadsheet, new CellRangeAddress(1, x-2, col, col));
//
//        data.addSeries(xs, ys1).setTitle(chartName);
//
//        chart.plot(data, bottomAxis, leftAxis);
//    }
}

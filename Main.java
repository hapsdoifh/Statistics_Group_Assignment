import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Statistic stat = new Statistic();

        double[] input_array = new double[10];

        //get user data
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter a number: ");
            double num = input.nextDouble();
            input_array[i] = num;
        }

        //set array to user data
        stat.setArray(input_array);

        //display user data
        System.out.println("The elements in this array are: ");
        for (double element: stat.getArray()) {
            System.out.print(element + " ");
        }

        //calculate and display mean from user's data values
        System.out.println("\nThe mean is: " + stat.getMean());

        //calculate and display median from user's data values
        System.out.println("\nThe median is: " + stat.getMedian());


        //calculate and display mode from user's data values
        System.out.println("\nThe mode is: " + stat.getMode());

        //calculate and display max value from user's data values
        System.out.println("\nThe largest value is: " + stat.getMax());

        //calculate and display min value from user's data values
        System.out.println("\nThe smallest value is: " + stat.getMin());

        //calculate and display range from user's data values
        System.out.println("\nThe smallest value is: " + stat.getRange());

        //calculate and display quartiles from user's data values
        System.out.println("\nThe quartiles for this set of numbers are: " + stat.getQuartiles());

        //calculate and display standard deviation from user's data values
        System.out.println(String.format("\n\nThe Standard Deviation is: %.6f", stat.getSD(stat.getArray(), stat.getMean())));

        //display box and whiskers plot of user's data values
        final BoxPlot demo = new BoxPlot("Box and Whiskers Plot", input_array);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

        //display normal distribution graph from user's data values
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new NormalDistribution(stat.getMean(), stat.getSD(stat.getArray(), stat.getMean())).setVisible(true);
                } catch (Exception exp) {
                    System.out.println("Could not display distribution graph.");
                }
            }
        });
    }

}
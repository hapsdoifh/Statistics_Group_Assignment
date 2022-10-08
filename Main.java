import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Statistic stat = new Statistic();
        StandardDeviation SD = new StandardDeviation();
        medianMeanMode averages = new medianMeanMode();

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

        stat.setMean();
        //calculate and display mean from user's data values
        System.out.println("\nThe mean is: " + stat.getMean());

        stat.setSD();
        //calculate and display standard deviation from user's data values
        System.out.println(String.format("\n\nThe Standard Deviation is: %.6f", stat.getSD()));

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
                    new NormalDistribution(stat.getMean(), stat.getSD()).setVisible(true);
                } catch (Exception exp) {
                    System.out.println("Could not display distribution graph.");
                }
            }
        });
    }

}

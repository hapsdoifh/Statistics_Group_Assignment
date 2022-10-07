import org.jfree.ui.RefineryUtilities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] input_array = new double[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter a number: ");
            double num = input.nextDouble();
            input_array[i] = num;
        }

        System.out.println("The elements in this array are: ");
        for (double element: input_array) {
            System.out.print(element + " ");
        }

        StandardDeviation SD = new StandardDeviation();
        System.out.format("\n\nThe Standard Deviation is: %.6f", StandardDeviation.calculateSD(input_array));

        final BoxPlot demo = new BoxPlot("Box and Whiskers Plot", input_array);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}

import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        displayInstructions();

        //asks user if they want to play
        askUser();
    }

    public static void displayInstructions() {
        System.out.println("\n\nWELCOME TO THE STATISTICS PROGRAM!!!" + "\n-------------------------------------" +
                "\n\n     1. Enter how many numbers you would like to input" + "\n     2. Enter your values"
                + "\n     3. Select a statistical operation to perform!" + "\n\nTo quit anytime, enter '0'." + "\n\n-------------------------------------");
    }

    public static void askUser() {

        System.out.println("Would you like to play? ('y' or 'n')");
        String user_choice = checkInput(input.nextLine());

        if (user_choice.equals("y")) {
            runProgram();
        } else {
            System.out.println("Goodbye!");
        }

    }

    public static String checkInput(String userInput){

        while (true) {

            if (userInput.equals("y") || userInput.equals("n")) {
                return userInput;
            } else {
                System.out.println("Please enter 'y' or 'n'.");
                userInput = input.next();
            }
        }
    }

    public static int validIntegerInput() {

        while(true) {
            try {
                int inNum = input.nextInt();
                return inNum;
            } catch (Exception e) {
                System.out.println("Please enter an integer number.");
                input.next();
            }

        }

    }

    public static double validDoubleInput() {

        while(true) {
            try {
                double inNum = input.nextDouble();
                return inNum;
            } catch (Exception e) {
                System.out.println("Please enter a double number.");
                input.next();
            }

        }

    }

    public static void displayChoices(Statistic stat) {

        while (true) {
            System.out.println("\nWhat statistical operation would you like to see?" + "\n1. Mean" + "\n2. Median" + "\n3. Mode" +
                    "\n4. Find Maximum" + "\n5. Find Minimum" + "\n6. Generate Polynomial Equation" + "\n7. Range" + "\n8. Determine Quartiles"
                    + "\n9. Determine Standard Deviation" + "\n10. View Box Plot" + "\n11. View Distribution Graph");

            int user_choice = validIntegerInput();

            if (user_choice==0) {
                break;
            } else {
                displayStats(user_choice, stat);
            }
        }

    }

    public static void displayStats(int user_choice, Statistic stat) {

        switch(user_choice) {
            case 1:
                // calculate and display mean from user's data values
                System.out.println("\nThe mean is: " + stat.getMean());
                break;
            case 2:
                // calculate and display median from user's data values
                System.out.println("\nThe median is: " + stat.getMedian());
                break;
            case 3:
                // calculate and display mode from user's data values
                System.out.println("\nThe mode is: " + stat.getMode());
                break;
            case 4:
                // calculate and display max value from user's data values
                System.out.println("\nThe largest value is: " + stat.getMax());
                break;
            case 5:
                // calculate and display min value from user's data values
                System.out.println("\nThe smallest value is: " + stat.getMin());
                break;
            case 6:
                // calculate and display min value from user's data values
                System.out.println("\nA polynomial built from this set of numbers could look like: " + stat.getPolynomial());
                break;
            case 7:
                // calculate and display range from user's data values
                System.out.println("\nThe range of this array is: " + stat.getRange());
                break;
            case 8:
                // calculate and display quartiles from user's data values
                System.out.println("\nThe quartiles for this set of numbers are: " + Arrays.toString(stat.getQuartiles()));
                break;
            case 9:
                // calculate and display standard deviation from user's data values
                System.out.println(String.format("\nThe Standard Deviation is: %.6f", stat.getSD()));
                break;
            case 10:
                // display box and whiskers plot of user's data values
                final BoxPlot demo = new BoxPlot("Box and Whiskers Plot", stat.getArray());
                demo.pack();
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);
                break;
            case 11:
                // display normal distribution graph from user's data values
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
                break;
        }

    }
    public static void runProgram() {
        Statistic stat = new Statistic();

        int inNum;
        double[] input_array;

        System.out.println("How many numbers do you want to enter? :");
        inNum = validIntegerInput();
        input_array = new double[inNum];

        // get user data
        for (int i = 0; i < inNum; i++) {
            System.out.println("Enter a number: ");
            double num = validDoubleInput();

            if (num==0) {
                break;
            } else {
                input_array[i] = num;
            }
        }

        // set array to user data
        stat.setArray(input_array);

        // display user data
        System.out.println("\nThe elements in this array are: ");
        for (double element : stat.getArray()) {
            System.out.print(element + " ");
        }

        // sorts list of values
        stat.SortList();

        displayChoices(stat);
        }


}
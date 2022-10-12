public class StandardDeviation {

    //calculates standard deviation from user's data values
    public double calculateSD(double[] userArray, double mean) {

        double standard_deviation = 0.0;
        int array_length = userArray.length;

        for(double temp: userArray) {
            standard_deviation += Math.pow(temp - mean, 2);
        }
        return Math.sqrt(standard_deviation/array_length);
    }
}


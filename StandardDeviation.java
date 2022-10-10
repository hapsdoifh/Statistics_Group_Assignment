public class StandardDeviation {
    double[] userArray;
    public static double calculateSD(double[] userArray) {
        double sum = 0.0, standard_deviation = 0.0;
        int array_length = userArray.length;
        for(double temp : userArray) {
            sum += temp;
        }

        double mean = sum/array_length;
        for(double temp: userArray) {
            standard_deviation += Math.pow(temp - mean, 2);
        }
        return Math.sqrt(standard_deviation/array_length);
    }
}


import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

interface Stats{
    public double[] getArray();
    public double getMax();
    public double getMin();
    public double getMean();
    public double getMedian();
    public ArrayList<Double> getMode();
    public String getPolynomial();
    public double getRange();
    public double[] getQuartiles();
    public double[] SortList();
    public double getSD();
}

public class Statistic implements Stats{
    private double[] statsArray;

    //setter for array of values
    public void setArray(double[] inputArr){
        statsArray = inputArr;
    }
    //getter for array of values
    public double[] getArray(){
        return statsArray;
    }


    public int arrayLength(){
        return statsArray.length;
    }

    public double[] getQuartiles(){
        double[] results = new double[3];
        double[] Qpos = new double [3];
        Qpos[1] = (0+statsArray.length-1)/2.0;
        Qpos[0] = (0+Qpos[1])/2.0;
        Qpos[2] = (Qpos[1]+statsArray.length-1)/2.0;
        for(int i = 0; i<3;i++){ //finding quartiles
            //System.out.println(Qpos[i]);
            results[i] = (double)statsArray[(int)Math.floor(Qpos[i])] + (double)(Qpos[i]-Math.floor(Qpos[i])) * (statsArray[(int)Math.ceil(Qpos[i])] - statsArray[(int)Math.floor(Qpos[i])]);
        }
        //System.out.println(Arrays.toString(results));
        return results;
    }
    public double[] SortList(){
        Arrays.sort(statsArray);
        return statsArray;
    }


    //getters

    public double getMean(){
        double mean=0;
        for (int i= 0; i< statsArray.length; i++){
            mean += statsArray[i];
        }
        return mean/statsArray.length;
    }

    public double getMedian(){
        double median;
        if (statsArray.length%2 != 0){
            median = statsArray[statsArray.length/2];
        }
        else {
            median = (statsArray[(statsArray.length-1)/2]+statsArray[statsArray.length/2])/2;
        }
        return median;
    }

    public ArrayList<Double> getMode(){
        HashMap<Double, Integer> hash_map = new HashMap<Double, Integer>();
        for (double element:statsArray) {
            if(hash_map.containsKey(element)) {
                hash_map.put(element, hash_map.get(element) + 1);
            } else {
                hash_map.put(element, 1);
            }
        }

        int maxMode=0;

        for (Map.Entry<Double,Integer> entry : hash_map.entrySet()) {
            int freq = entry.getValue();
            if (freq > maxMode) {
                maxMode = freq;
            }
        }
        ArrayList<Double> mode_list = new ArrayList<Double>();
        for (Double key : hash_map.keySet()) {
            if(hash_map.get(key) == maxMode){
                mode_list.add(key);
            }
        }
        return mode_list;
    }

    public double getMax(){
        double highest = 0;

        for (int i = 0; i < statsArray.length; i++){
            double listOrder = statsArray[i];

            if (listOrder > highest){
                highest = listOrder;
            }
            else if (listOrder <= highest){
                highest = Math.max(listOrder, highest);
            }
        } // loop bracket

        return highest;
    } // getter end bracket

    public double getMin(){
        double lowest = statsArray[0];
        double listOrder;
        for (int i = 0; i < statsArray.length; i++){
            listOrder = statsArray[i];

            if (listOrder < lowest){
                lowest = listOrder;
            }

            else if (listOrder >= lowest){
                lowest = Math.min(listOrder, lowest);
            }
        } // for loop bracket

        return lowest;
    } // getter end bracket

    public String getPolynomial() {
        String polynomial = "";
        for (int i = 0; i < statsArray.length; i++) {
            if (i <= statsArray.length - 2) {
                polynomial = polynomial + statsArray[i] + "x^" + (statsArray.length - (i + 1)) + " + ";
            } else {
                polynomial = polynomial + statsArray[i] + "x^" + (statsArray.length - (i + 1));
            }
        }
        return polynomial;
    }

    public double getRange(){
        // use new variables to make code less messy (less brackets)
        double highest = getMax();
        double lowest = getMin();
        return highest-lowest;
        //return Math.round((highest - lowest) *100.0) / 100.0;
    } // getter end bracket


    //calculates standard deviation from user's data values
    public double getSD() {
        double mean = this.getMean();
        double standard_deviation = 0.0;
        int array_length = statsArray.length;

        for(double temp: statsArray) {
            standard_deviation += Math.pow(temp - mean, 2);
        }
        return Math.sqrt(standard_deviation/array_length);

    }

}
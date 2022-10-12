import java.lang.Math;
import java.util.Arrays;
interface Stats{
    public double getMax();
    public double getMin();
    public double getMean();
    public double getMedian();
    public double getMode();
    public double getRange();
    public String getPolynomial();
    public int arrayLength();
    public double[] Quartiles();
    public double[] SortList();
}

public class Statistic implements Stats{
    private double[] statsArray;

    public void setArray(double[] inputArr){
        statsArray = inputArr;
    }
  
    public int arrayLength(double[] statsArray){
        
    }
  
    public double[] getArray(){
        return statsArray;
    }

    //getters

    public String getPolynomial() {
        public String polynomial = "";
        for (int i; i<arrayLength(statsArray); i++) {
        polynomial = polynomial + statsArray[i] + "x"
        
        }
        return ("A polynomial function with your array of numbers as coefficients would be: " + polynomial);
  }
}

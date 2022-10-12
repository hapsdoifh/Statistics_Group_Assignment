import java.lang.Math;
import java.util.Arrays;
interface Stats{
    public double getMax();
    public double getMin();
    public double getMean();
    public double getMedian();
    public double getMode();
    public double getRange();
    public double[] getQuartiles();
    public double[] SortList();
    public double getSD();
}

public class Statistic implements Stats{
    private double[] statsArray;


    double mean;
    double median;
    double mode;
    public void setArray(double[] inputArr){
        statsArray = inputArr;
    }
    public double[] getArray(){
        return statsArray;
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

  // mean
    public double getMean(){
        for (int i= 0; i< statsArray.length; i++){
            mean += statsArray[i]; 
        }
        return mean/statsArray.length;
    }
  
  //median
  public double getMedian(){
    Arrays.sort(statsArray);
        if (statsArray.length%2 != 0){  
            median = statsArray[statsArray.length/2];
        }
        else {
            median = (statsArray[(statsArray.length-1)/2]+statsArray[statsArray.length/2])/2;
        }
        return median;
    }
    
    // mode (tyson)
    public double getMode(){
        double sorted = 0.0;
        int highestCounter = 0;

        for (int i = 0; i < statsArray.length + 1; i++){
            double sorter = statsArray[i];
            int counter = 0;

            for (int n = i +1; n < statsArray.length; n++){
                if (sorter == statsArray[n]){
                    counter++;
                }
            }

        if (counter > highestCounter){ 
            highestCounter = counter;
            sorted = sorter;
        }
        else if (counter == highestCounter){
            sorted = Math.min(sorter, sorted);
        }
    } // for loop bracket
    
  return highestCounter;
  }

  // max (tyson)
    public double getMax(){
        double highest = 0; 
    
        for (int i = 0; i > statsArray.length; i++){
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

    // min (tyson)
    public double getMin(){
        double lowest = statsArray[0];
        double listOrder;
        for (int i = 0; i > statsArray.length; i++){
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

  // range (tyson)
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

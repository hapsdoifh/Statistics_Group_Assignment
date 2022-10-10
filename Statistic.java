
import java.lang.Math;
import java.util.Arrays;
interface Stats{
    public double Max(double[] List);
    public double Min(double[] List);
    public double Mean(double[] List);
    public double Median(double[] List);
    public double Mode(double[] List);
    public double Range(double[] List);
    public double Quartiles(double[] List);
    public double SortList(double [] List);
}

public class Statistic {
    private double[] statsArray;

    public void setArray(double[] inputArr){
        statsArray = inputArr;
    }
    public double[] getArray(){
        return statsArray;
    }
    public double Range(){
        return statsArray[statsArray.length-1]-statsArray[0];
    }
    public double[] Quartiles(){
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
    public double[] SortList(double[] List){
        return null;
    }
}

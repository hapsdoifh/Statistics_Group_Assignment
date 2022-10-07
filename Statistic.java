interface Stats{
    public double max(double[] List);
    public double min(double[] List);
    public double Mean(double[] List);
    public double Median(double[] List);
    public double Mode(Double[] List);
    public double Range(Double[] Mode);
}

public class Statistic {
    private double[] statsArray;

    public void setArray(double[] inputArr){
        statsArray = inputArr;
    }
    public double[] getArray(){
        return statsArray;
    }
}

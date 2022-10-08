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
    private double mean;
    private double sd;

    public void setArray(double[] inputArr){
        statsArray = inputArr;
    }
    public double[] getArray(){
        return statsArray;
    }

    public void setMean() {
        medianMeanMode averages = new medianMeanMode();
        mean = averages.getMean(statsArray);
    }

    public double getMean() {
        return mean;
    }

    public void setSD() {
        StandardDeviation sd = new StandardDeviation();
        this.sd = sd.calculateSD(statsArray, mean);
    }

    public double getSD() {
        return sd;
    }



}

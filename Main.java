import java.util.*;

public class Main{
    public static void main(String[] args){
        double[] temp = {10,12,15,30,35,36,38,60,65,76,90,120};
        Statistic myStat = new Statistic();
        myStat.setArray(temp);
        myStat.Quartiles();
        outputGUI.outputGraph(myStat);
    }
}
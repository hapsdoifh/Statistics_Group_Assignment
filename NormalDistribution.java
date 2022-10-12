import com.mindfusion.charting.FunctionSeries;
import com.mindfusion.charting.GridType;
import com.mindfusion.charting.swing.LineChart;
import com.mindfusion.drawing.DashStyle;
import com.mindfusion.drawing.SolidBrush;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;


public class NormalDistribution extends JFrame {

    private static final long serialVersionUID = 1L;

    //creates frame and initializes chart for graph
    protected NormalDistribution(double mean, double sd) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650, 400);
        setTitle("Java Swing Library for Charts and Gauges: FunctionSeries");

        getContentPane().add(initializeChart(mean, sd), BorderLayout.CENTER);
    }

    //returns equation with the calculated mean
    private String NDEquation(double mean, double sd){
        return "Pow(2.71828, -1*(((x-"+ mean + ")/" + sd + ")*((x-" + mean + ")/" + sd + ")/2)) / Sqrt(6.28)*" + sd;
    }

    //creates chart
    private LineChart initializeChart(double mean, double sd) {
        LineChart lineChart = new LineChart();

        //specifying color and stroke for the axis
        lineChart.getTheme().setAxisStroke(new SolidBrush(new Color(167, 245, 255)));
        lineChart.getTheme().setAxisStrokeThickness(1.0);

        //styling the legend
        lineChart.getLegendRenderer().setShowTitle(false);
        lineChart.getTheme().setDataLabelsFontSize(12);

        //styling the grid
        lineChart.setGridType(GridType.Horizontal);
        lineChart.getTheme().setGridLineColor(new Color(167, 245, 255));
        lineChart.getTheme().setGridLineStyle(DashStyle.Dash);

        //setting the chart colors
        lineChart.getTheme().setHighlightStroke(new SolidBrush(new Color(255, 147, 66)));
        lineChart.getTheme().setCommonSeriesStrokes(Arrays.asList(
                new SolidBrush(new Color(151, 140, 234))));
        lineChart.getTheme().setCommonSeriesFills(Arrays.asList(
                new SolidBrush(new Color(151, 140, 234))
        ));
        lineChart.getTheme().setCommonSeriesStrokeThicknesses(Arrays.asList(3.0));

        FunctionSeries series1;

        try {
            series1 = new FunctionSeries(NDEquation(mean, sd), 1000, -100, 100);
            series1.setTitle("Standard normal distribution with mean");
            lineChart.getSeries().add(series1);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineChart;
    }
}
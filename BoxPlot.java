import java.awt.*;

import java.util.List;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;

public class BoxPlot extends ApplicationFrame {
    public BoxPlot(String title, double[] array) {
        super(title);

        Color color = new Color(167, 245, 255);

        final DefaultBoxAndWhiskerCategoryDataset dataset = createDataset(array); //gets user's dataset
        final CategoryPlot boxPlot = renderBoxPlot(dataset); //uses dataset to create box plot
        final JFreeChart chart = createChart(boxPlot); //creates chart for box plot
        final ChartPanel chartPanel = new ChartPanel(chart);//uses chartpanel to display box plot
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
        chart.getPlot().setBackgroundPaint(color);
        setContentPane(chartPanel);
    }

    //specifies colors, styles, and axis for box plot chart
    private CategoryPlot renderBoxPlot(DefaultBoxAndWhiskerCategoryDataset dataset) {

        BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
        Color color = new Color(151, 140, 234);

        renderer.setFillBox(true);
        renderer.setSeriesPaint(0, color);
        renderer.setSeriesPaint(1, Color.LIGHT_GRAY);
        renderer.setSeriesOutlinePaint(1, Color.BLACK);
        renderer.setUseOutlinePaintForWhiskers(true);
        renderer.setMedianVisible(true);
        renderer.setMeanVisible(false);

        CategoryAxis xAxis = new CategoryAxis("Dataset");
        NumberAxis yAxis = new NumberAxis("Values");
        yAxis.setAutoRangeIncludesZero(false);
        LineAndShapeRenderer lineRenderer = new LineAndShapeRenderer();

        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
        plot.setDataset(1, dataset);
        plot.setRenderer(1, lineRenderer);

        return plot;
    }

    //creates and returns a dataset for the box plot
    private DefaultBoxAndWhiskerCategoryDataset createDataset(double [] userArray) {

        DefaultBoxAndWhiskerCategoryDataset dataset = new
                DefaultBoxAndWhiskerCategoryDataset();

            List values = new ArrayList();
            for (double num: userArray) {
                values.add(num);
            }
            dataset.add(
                    BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(values),1,1);

        return dataset;
    }

    //creates chart for box plot
    private JFreeChart createChart(
            final CategoryPlot boxPlot) {

        JFreeChart chart = new JFreeChart("Box and Whiskers Chart", JFreeChart.DEFAULT_TITLE_FONT, boxPlot, false);

        return chart;
    }
}
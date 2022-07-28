package com.erenuygur.chart;

import com.erenuygur.model.Policy;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class BarChart {
    public void barchart(HashMap<String,Double> policyAmounts) throws IOException {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for (String str: policyAmounts.keySet()){
            dataset.addValue(policyAmounts.get(str), str,"Amount");
        }


        JFreeChart barChart = ChartFactory.createBarChart(
                "Total Amounts By Year ",
                "Year", "Amount",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        //saving chart as image
        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File BarChart = new File( "Total Policy Amount BarChart.jpeg" );
        ChartUtilities.saveChartAsJPEG( BarChart , barChart , width , height );

        ChartPanel cp = new ChartPanel(barChart);
        JFrame frame = new JFrame();

        frame.add(cp);
        frame.setSize(850, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);

    }

}

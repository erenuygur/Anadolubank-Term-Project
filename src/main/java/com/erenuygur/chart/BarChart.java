package com.erenuygur.chart;

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
    public static void barChart(HashMap<String, Double> data) throws IOException {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for (String str: data.keySet()){
            dataset.addValue(data.get(str), str,"Amount");
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

    public static void barChartInt(HashMap<String, Integer> data) throws IOException {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for (String str: data.keySet()){
            dataset.addValue(data.get(str), str,"Policy Types");
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Policy Count by Policy Type",
                "Policy Type", "Policy Count",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        //saving chart as image
        int width = 640;    /* Width of the image */
        int height = 480;   /* Height of the image */
        File BarChart = new File( "Policy Count by Policy Type BarChart.jpeg" );
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

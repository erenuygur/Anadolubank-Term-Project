package com.erenuygur.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.LinkedHashMap;

public class LineChart {
    public static void lineChartForByYear( LinkedHashMap<String,Double> data) throws Exception {
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

        for (String p:data.keySet()){
            line_chart_dataset.addValue(data.get(p),"Amount",p);
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "Total Amounts By Year ",
                "Year", "Amount",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel cp = new ChartPanel(lineChartObject);
        JFrame frame = new JFrame();
        frame.add(cp);
        frame.setSize(850, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);

    }

}

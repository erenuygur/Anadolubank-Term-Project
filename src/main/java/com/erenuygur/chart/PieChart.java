package com.erenuygur.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.util.LinkedHashMap;

public class PieChart {
    public static void pieChart(LinkedHashMap<String, Integer> policyCountByPolicyType) throws Exception {
        DefaultPieDataset pie_char_dataset = new DefaultPieDataset( );
        for (String p:policyCountByPolicyType.keySet()){
            pie_char_dataset.setValue(p,policyCountByPolicyType.get(p));
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Policy Count by Policy Type",
                pie_char_dataset,
                true,
                true,
                false);

        String pathName="Policy Count by Policy Type PieChart.jpeg";
        ChartPanel cp = new ChartPanel(pieChart);
        JFrame frame = new JFrame();

        frame.add(cp);
        frame.setSize(850, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
    }

}

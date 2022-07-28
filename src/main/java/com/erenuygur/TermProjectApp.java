package com.erenuygur;

import com.erenuygur.chart.BarChart;
import com.erenuygur.model.Agency;
import com.erenuygur.model.CustomerPolicy;
import com.erenuygur.model.Policy;
import com.erenuygur.service.AgencyService;
import com.erenuygur.service.CustomerPolicyService;
import com.erenuygur.service.PolicyService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TermProjectApp {
    private static AbstractApplicationContext ctx = null;
    private static final Scanner KEYBOARD_INPUT = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run() throws IOException {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PolicyService policyService = ctx.getBean(PolicyService.class);

        List<Policy> policyList = policyService.listPolicy();
        for (Policy p : policyList) {
            System.out.println(p);
        }

        CustomerPolicyService customerPolicyService = ctx.getBean(CustomerPolicyService.class);

        List<CustomerPolicy> customerPolicyList = customerPolicyService.listCustomerPolicy();
        for (CustomerPolicy customerPolicy : customerPolicyList)
            System.out.println(customerPolicy);


        AgencyService agencyService = ctx.getBean(AgencyService.class);

        List<Agency> agencyList = agencyService.listAgency();
        for (Agency agency : agencyList)
            System.out.println(agency);

        BarChart barChart = new BarChart();
        barChart.barchart(customerPolicyService.getReportByYear());

    }

}

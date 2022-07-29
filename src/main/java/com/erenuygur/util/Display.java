package com.erenuygur.util;

import com.erenuygur.service.CustomerPolicyService;
import com.erenuygur.service.PolicyService;

public class Display {
    public static void run(String input) throws Exception {
        if (input.equals("1")) {
            CustomerPolicyService customerPolicyService = new CustomerPolicyService();
            customerPolicyService.createBarChart();
        }else if (input.equals("2")) {
            PolicyService policyService = new PolicyService();
            policyService.createBarChart();
        }else if (input.equals("3")) {
            PolicyService policyService = new PolicyService();
            policyService.createPieChart();
        }else if (input.equals("4")) {
            PolicyService policyService = new PolicyService();
            policyService.createBarChart();
        }else if (input.equals("5")) {
            PolicyService policyService = new PolicyService();
            policyService.createBarChart();
        } else {
            System.out.println("--------------------------");
            System.out.println("Please make a valid choice");
            System.out.println("--------------------------");
        }
    }
}

package com.erenuygur.util;

import com.erenuygur.model.Agency;
import com.erenuygur.service.AgencyService;
import com.erenuygur.service.CustomerPolicyService;
import com.erenuygur.service.PolicyService;

public class Display {
    public static void run(String input) throws Exception {
        switch (input) {
            case "1" -> {
                CustomerPolicyService customerPolicyService = new CustomerPolicyService();
                customerPolicyService.createBarChart();
            }
            case "2" -> {
                CustomerPolicyService customerPolicyService = new CustomerPolicyService();
                customerPolicyService.createLineChart();
                break;
            }
            case "3" -> {
                PolicyService policyService = new PolicyService();
                policyService.createPieChart();
                break;
            }
            case "4" -> {
                PolicyService policyService = new PolicyService();
                policyService.createBarChart();
                break;
            }
            case "5" -> {
                AgencyService agencyService = new AgencyService();
                agencyService.createBarChart();
                break;
            }
            default -> {
                System.out.println("--------------------------");
                System.out.println("Please make a valid choice");
                System.out.println("--------------------------");
            }
        }
    }
}

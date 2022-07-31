package com.erenuygur.service;

import com.erenuygur.chart.BarChart;
import com.erenuygur.chart.PieChart;
import com.erenuygur.model.Policy;
import com.erenuygur.repository.PolicyRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@NoArgsConstructor
@Data
public class PolicyService {
    private PolicyRepository policyRepository;

    public Policy createPolicy(Policy policy) {
        return policyRepository.create(policy);
    }

    public Policy getPolicy(int id) throws Exception {
        return policyRepository.getPolicy(id);
    }

    public List<Policy> listPolicy() {
        return policyRepository.getAllPolicy();
    }

    public LinkedHashMap<String, Integer> getReportByPolicyType() {
        return policyRepository.getPolicyName();
    }

    public boolean createBarChart() throws IOException {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            PolicyService policyService = ctx.getBean(PolicyService.class);

            BarChart.barChartForPolicyType(policyService.getReportByPolicyType());
            return true;
        } catch (BeansException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createPieChart() throws Exception {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            PolicyService policyService = ctx.getBean(PolicyService.class);

            PieChart.pieChart(policyService.getReportByPolicyType());
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

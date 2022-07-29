package com.erenuygur.service;

import com.erenuygur.chart.BarChart;
import com.erenuygur.chart.PieChart;
import com.erenuygur.model.Policy;
import com.erenuygur.repository.PolicyRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    public void createBarChart() throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PolicyService policyService = ctx.getBean(PolicyService.class);

        BarChart.barChartInt(policyService.getReportByPolicyType());
    }

    public void createPieChart() throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PolicyService policyService = ctx.getBean(PolicyService.class);

        PieChart.pieChart(policyService.getReportByPolicyType());
    }

}

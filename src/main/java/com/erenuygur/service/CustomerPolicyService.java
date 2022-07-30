package com.erenuygur.service;

import com.erenuygur.chart.BarChart;
import com.erenuygur.chart.LineChart;
import com.erenuygur.chart.PieChart;
import com.erenuygur.model.CustomerPolicy;
import com.erenuygur.repository.CustomerPolicyRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@NoArgsConstructor
@Data
public class CustomerPolicyService {
    CustomerPolicyRepository customerPolicyRepository;

    public CustomerPolicy getCustomerPolicy(int id) throws Exception {
        return customerPolicyRepository.getCustomerPolicy(id);
    }

    public List<CustomerPolicy> listCustomerPolicy() {
        return customerPolicyRepository.getAllCustomerPolicy();
    }

    public LinkedHashMap<String, Double> getReportByYear() {
        return this.customerPolicyRepository.getTotalAmountByYear();
    }

    public void createBarChart() throws IOException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPolicyService customerPolicyService = ctx.getBean(CustomerPolicyService.class);

        BarChart.barChartForByYear(customerPolicyService.getReportByYear());
    }

    public void createLineChart() throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerPolicyService customerPolicyService = ctx.getBean(CustomerPolicyService.class);

        LineChart.lineChartForByYear(customerPolicyService.getReportByYear());
    }
}

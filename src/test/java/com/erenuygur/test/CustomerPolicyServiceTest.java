package com.erenuygur.test;

import com.erenuygur.model.CustomerPolicy;
import com.erenuygur.service.CustomerPolicyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerPolicyServiceTest {
    private CustomerPolicyService customerPolicyService;

    @Before
    public void setup() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        customerPolicyService = ctx.getBean(CustomerPolicyService.class);
    }

    @Test
    public void testListCustomerPolicyTest() throws Exception {
        List<CustomerPolicy> customerPolicyList = customerPolicyService.listCustomerPolicy();
        assertThat(customerPolicyList.size()).isNotEqualTo(0);
    }

    @Test
    public void testCreateBarChartTest() throws Exception {
        String actualResult = "" + customerPolicyService.createBarChart();
        boolean expectedResult = true;
        Assert.assertTrue(actualResult, expectedResult);
    }

    @Test
    public void testCreateLineChartTest() throws Exception {
        String actualResult = "" + customerPolicyService.createLineChart();
        boolean expectedResult = true;
        Assert.assertTrue(actualResult, expectedResult);
    }
}
